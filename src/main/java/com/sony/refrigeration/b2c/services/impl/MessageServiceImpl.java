package com.sony.refrigeration.b2c.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sony.refrigeration.b2c.beans.MessageDetails;
import com.sony.refrigeration.b2c.constant.MessageConstants;
import com.sony.refrigeration.b2c.exceptions.SonyRefrigerationException;
import com.sony.refrigeration.b2c.services.api.EmailService;
import com.sony.refrigeration.b2c.services.api.MessageService;
import com.sony.refrigeration.b2c.services.api.SMSGatewayService;
import com.sony.refrigeration.b2c.util.MailDetails;
import com.sony.refrigeration.b2c.util.MessageContent;
import com.sony.refrigeration.b2c.util.PropertyUtils;

@Service
public class MessageServiceImpl implements MessageService
{

    /** The log. */
    private static Logger log = Logger.getLogger(MessageServiceImpl.class);

    /** The mail service. */
    @Autowired
    private EmailService mailService;
    
    /** The Sms gateway service. */
    @Autowired
    private SMSGatewayService smsGatewayService;

    /**
     * Set the EmailService object.
     *
     * @param mailService the new mail service
     */
    public void setMailService(EmailService mailService)
    {
        this.mailService = mailService;
    }
    


	/**
	 * Sets the sms gateway service.
	 *
	 * @param smsGatewayService the new sms gateway service
	 */
	public void setSmsGatewayService(SMSGatewayService smsGatewayService) {
		this.smsGatewayService = smsGatewayService;
	}


    /* (non-Javadoc)
     * @see com.ebreez.message.MessageService#sendEMail(com.ebreez.message.utilities.MessageDetails)
     */

    /**
     * sendEMail.
     * @param messageDetails - messageDetails
     * @throws SonyRefrigerationException - Ebreeze Exception
     */

    public void sendEMail(MessageDetails messageDetails) throws SonyRefrigerationException
    {
        log.debug("sendEMail(MessageDetails messageDetails=" + messageDetails + ") - start");

        // get the message content to be send as an email.
        String messageBody = getMessageContent(messageDetails);
        
        //Logging the email contents other than password emails as it will be helpful when the email relay count is expired
        try
        {
            if (StringUtils.isNotBlank(messageBody)
                    && !StringUtils.lowerCase(messageBody).contains("password"))
            {
                log.debug("Email Body Content is as below: " + messageBody);
            }
        }
        catch (Exception e)
        {
            // Ignore all exceptions
        }

        MailDetails mailDetails = getMailDetails(messageDetails);
        mailDetails.setMessageBody(messageBody);
        mailService.setMailDetails(mailDetails);
        mailService.setEmailProps(messageDetails.getEmailProps());
        try
        {
            if (MessageConstants.MAIL_MIMETYPE_HTML.equalsIgnoreCase(messageDetails
                    .getMailMimeType()))
            {
                mailService.sendHtmlEMail();
            }
            else if(MessageConstants.MAIL_MIMETYPE_PDF.equalsIgnoreCase(messageDetails
                    .getMailMimeType())){
            	 log.info("PDF mail (): Entered");
            	 log.debug("PDF mail (): Entered");
            	mailDetails.setBlobByteArray(messageDetails.getBlobByteArray());
            	mailDetails.setPdfName(messageDetails.getPdfName());
            	try {
					mailService.sendPDFEmail();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					 log.info("PDF mail (): Entered >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +e);
					 log.debug("PDF mail (): Entered >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +e);
					e.printStackTrace();
				}
            }
            else
            {
                mailService.sendSimpleEMail();
            }
        }
        catch (EmailException ee)
        {
            log.error("sendEMail(messageDetails=" + messageDetails + ")", ee);
            
            throw new SonyRefrigerationException(ee.getLocalizedMessage());
        }

        log.debug("sendEMail() - end");
    }

    /* (non-Javadoc)
     * @see com.ebreez.message.MessageService#sendSMS(com.ebreez.message.utilities.MessageDetails)
     */
    /**
     * sendSMS.
     *
     * @param messageDetails - messageDetails
     * @throws SonyRefrigerationException the ebreeze exception
     */

    public void sendSMS(MessageDetails messageDetails) throws SonyRefrigerationException
    {
        log.debug("sendSMS(MessageDetails messageDetails=" + messageDetails + ") - start");

        /*Properties props = messageDetails.getEmailProps(); 
        if (props == null){
            try
            {
                props = PropertyUtils.loadProperties();
            }
            catch (URISyntaxException e1)
            {
                log.error("sendSMS(messageDetails=" + messageDetails + ")", e1);
                emailProps.load(EmailServiceImpl.class.getResourceAsStream(MailConstants.SMTP_PROPERTIES_FILE));
            }
            catch (IOException e1)
            {
                log.error("sendSMS(messageDetails=" + messageDetails + ")", e1);
            }
        }
        if (props == null)
        {
            log.warn("couldn't load file..");

            log.debug("sendSMS() - end");
            return;
        }
        if (props.get("sms_enable") == null)
        {
            log.warn("The property 'sms_enable' from the external "
                    + "config file is null/the property is unavailable");

            log.debug("sendSMS() - end");
            return;
        }
        if (StringUtils.isBlank((String) props.get("sms_enable")))
        {
            log.warn("The value of the property 'sms_enable' "
                    + "from the external config file is blank");

            log.debug("sendSMS() - end");
            return;
        }
        if (props.get("sms_enable").toString().equalsIgnoreCase("false"))
        {
            log.warn("The value of the property 'sms_enable' from the"
                    + " external config file is 'false', hence exiting without sending sms");

            log.debug("sendSMS() - end");
            return;
        }*/
        sendSMSMandatorily(messageDetails);
        log.info("Leaving: sendSMS()");
    }

	/**
	 * Send sms mandatorily.
	 *
	 * @param messageDetails the message details
	 * @throws SonyRefrigerationException the ebreeze exception
	 */
	@SuppressWarnings("unused")
	public void sendSMSMandatorily(MessageDetails messageDetails)
			throws SonyRefrigerationException {
		InputStream urlInStream = null;
        try
        {
            // get the SMS APIs.
           // String smsAPI = getSmsApi(messageDetails);
        	String smsAPI=smsGatewayService.getSMSAPI(messageDetails);
            log.info("SMS API URL: " + smsAPI);
            URL url = new URL(smsAPI);
            //urlInStream = url.openStream();
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            URLConnection conn = url.openConnection();
//            conn.setDoOutput(true);
//            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
//            wr.write(smsAPI);
//            wr.flush();
//            conn.connect();
//            urlInStream = conn.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(urlInStream));
            String response = null;
            while ((response = br.readLine()) != null)
            {
                log.info("SMS Response...." + response);
                StringTokenizer token =
                        new StringTokenizer(response, MessageConstants.SMS_SUCCESS_RESPONSE_TOKEN);
                String value = token.nextToken();
                if (!MessageConstants.SMS_SUCCESS_RESPONSE_CODE.equals(value))
                {
                    log.error("Error sending SMS: '" + response + "'");
                    throw new SonyRefrigerationException(MessageConstants.MSG_ERR_KEY_SMS_001,
                            "Error in sending the SMS");
                }else if(value.startsWith(MessageConstants.SMS_INVALID_USER_OR_PASSWORD_CODE)){
                	log.error("Error sending SMS (unable to send due to invalid credentials) : '" + response + "'");
                    //We can send an email to admin to intimate the same
                }
            }
        }
        catch (IOException io)
        {
            log.error("sendSMS(messageDetails=" + messageDetails + ")", io);

            log.error("Error in Sending SMS : " + io.getMessage());
            throw new SonyRefrigerationException("Error Reading the API URL configuration.");
        }
        catch (Exception e)
        {
            log.error("sendSMS(messageDetails=" + messageDetails + ")", e);

            log.error("Error in Sending SMS : " + e.getMessage(), e);
            throw new SonyRefrigerationException(MessageConstants.MSG_ERR_KEY_SMS_001,
                    "Error in sending the SMS", e);
        }
        finally
        {
            try
            {
                urlInStream.close();
            }
            catch (Exception e)
            {
                log.error("sendSMS(messageDetails=" + messageDetails + ")", e);

                log.error("Error closing the urlInStream");
            }
        }

        log.debug("sendSMS() - end");
    }

    /**
     * This method reads the API template and construct the URL to send an SMS.
     * URL will be constructed using velocity framework with user name, password
     * configured in the property file and number that is populated in the messageDetails bean.
     *
     * @param messageDetails MessageDetails object contain the Mobile Number etc.
     * @return URL of the Resalty API for SMS.
     * @throws SonyRefrigerationException the ebreeze exception
     */
    private String getSmsApi(MessageDetails messageDetails) throws SonyRefrigerationException
    {
        log.info("getSmsApi(): Entered");
        String smsApi = null;
        // get the message content to be send as an SMS.
        String messageBody = getMessageContent(messageDetails);
        Properties smsProps = messageDetails.getEmailProps(); 
        if (smsProps == null){
            smsProps = loadSMSProperties();
        }
        VelocityContext vc = new VelocityContext();
        vc.put(MessageConstants.STR_USERNAME, smsProps.getProperty(MessageConstants.STR_USERNAME));
        vc.put(MessageConstants.STR_PASSWORD, smsProps.getProperty(MessageConstants.STR_PASSWORD));
        vc.put(MessageConstants.STR_MESSAGE, messageBody);
        vc.put(MessageConstants.STR_MOBILENUMBER, messageDetails.getRecipientsMobileNumber());
        vc.put(MessageConstants.STR_SENDERNAME,
                smsProps.getProperty(MessageConstants.STR_SENDERNAME));

        smsApi = MessageContent.getContentData(MessageConstants.SMS_API_TEMPLATE, vc);
        log.info("Leaving: getSmsApi()");
        return smsApi;
    }

    /**
     * Load sms properties.
     *
     * @return the properties
     * @throws SonyRefrigerationException the ebreeze exception
     */
    private Properties loadSMSProperties() throws SonyRefrigerationException
    {
        Properties smsProps = new Properties();
        try
        {
            smsProps = PropertyUtils.loadProperties();
        }
        catch (IOException iox)
        {
            try
            {
                smsProps.load(EmailServiceImpl.class
                        .getResourceAsStream(MessageConstants.SMS_PROPERTY_FILE));
            }
            catch (IOException e)
            {
                throw new SonyRefrigerationException(e.getMessage());
            }
        }
        catch (URISyntaxException e)
        {
            throw new SonyRefrigerationException(e.getMessage());
        }
        return smsProps;
    }

    /**
     * Method populates the MailDetails object from the given Message Details.
     *
     * @param messageDetails MessageDetails object contains email details
     * like email address, subject etc.
     * @return MailDetails object
     * @throws SonyRefrigerationException the ebreeze exception
     */
    private MailDetails getMailDetails(MessageDetails messageDetails) throws SonyRefrigerationException
    {
        log.info("getMailDetails(): Entered");
        MailDetails mailDetails = new MailDetails();

        mailDetails.setRecipientAddress(messageDetails.getRecipientEmail());
        mailDetails.setRecipientName(messageDetails.getRecipientName());
        if (messageDetails.getBccRecipientAddress() != null)
        {
            mailDetails.setBccRecipientAddress(messageDetails.getBccRecipientAddress());
        }

        mailDetails.setSenderAddress(messageDetails.getFromMail());
        mailDetails.setSenderName(messageDetails.getMessageSenderName());
        mailDetails.setSubject(messageDetails.getSubject());
        Map<String, byte[]> mailAttachments = new HashMap<String, byte[]>();
        // Attachments Details
        if (!CollectionUtils.isEmpty(messageDetails.getEmailAttachments()))
        {
            for (String attachment : messageDetails.getEmailAttachments())
            {
                String attachmentName = attachment.substring(0, attachment.indexOf('.'));
                String attachContent =
                        getAttachmentContent(messageDetails.getMessageContent(), attachment);
                mailAttachments.put(attachmentName + MessageConstants.ATTACHMENT_EXTENSION,
                        attachContent.getBytes());
            }
        }
        // When user wants to add the attachment as a string content this block will execute.
        // String content can be attached with file name and string content
        if (!CollectionUtils.isEmpty(messageDetails.getStringAttachment()))
        {
            for (Map.Entry<String, String> attachment : messageDetails.getStringAttachment()
                    .entrySet())
            {
                try
                {
                    mailAttachments.put(attachment.getKey() + MessageConstants.ATTACHMENT_EXTENSION,
                            attachment.getValue().getBytes("utf-8"));
                }
                catch (UnsupportedEncodingException e)
                {
                    log.error(e.getMessage(),e);
                    continue;
                }
            }
        }
        mailDetails.setAttachments(mailAttachments);
        //if (Collection.isNotEmpty(messageDetails.getStringAttachment()))
        log.info("Leaving: getMailDetails()");
        return mailDetails;
    }

    /**
     * Method constructs the message body using velocity context.
     * Method reads the velocity template from messageDetails object
     * and dynamic content form the messageDetails, using velocity framework
     * replaces the dynamic content in the velocity template and returns the message content
     * to be sent to recipients.
     *
     * @param messageDetails MessageDetails object.
     * @return Message body.
     * @throws SonyRefrigerationException the ebreeze exception
     */
    public String getMessageContent(MessageDetails messageDetails) throws SonyRefrigerationException
    {
        log.info("getMessageBody(): Entered");
        // load the content data to Velocity Context to get the Message Content.
        VelocityContext context = populateVelocityContext(messageDetails.getMessageContent());

        String messageBody =
                MessageContent.getContentData(
                        MessageConstants.TEMPLATE_PATH +messageDetails.getContentType(), context);
        log.info("Leaving: getMessageBody()");
        return messageBody;
    }

    /**
     * Method constructs the attachment content using velocity context.
     * Method reads the velocity template from messageDetails object
     * and dynamic content form the messageDetails, using velocity framework
     * replaces the dynamic content in the velocity template and returns the attachment
     * content to be sent to recipients.
     *
     * @param dynaContent Map holds the key value pair of dynamic content.
     * @param contentType Holds the name of the template to be attached.
     * @return Attachment content.
     * @throws SonyRefrigerationException the ebreeze exception
     */
    private String getAttachmentContent(Map<String, Object> dynaContent, String contentType)
            throws SonyRefrigerationException
    {
        log.info("getAttachmentContent(): Entered");
        // load the content data to Velocity Context to get the Message Content.
        VelocityContext context = populateVelocityContext(dynaContent);

        String messageBody =
                MessageContent
                        .getContentData(MessageConstants.TEMPLATE_PATH + contentType, context);
        log.info("Leaving: getAttachmentContent()");
        return messageBody;
    }

    /**
     * Method populates the VelocityContext with the given message content.
     * @param messageContent Message content
     * @return VelocityContext
     */
    private VelocityContext populateVelocityContext(Map<String, Object> messageContent)
    {
        log.info("populateVelocityContext(): Entered");
        VelocityContext context = new VelocityContext();
        for (Map.Entry<String, Object> content : messageContent.entrySet())
        {
            context.put(content.getKey(), content.getValue());
        }
        log.info("Leaving: populateVelocityContext()");
        return context;
    }

}
