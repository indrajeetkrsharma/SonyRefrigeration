package com.sony.refrigeration.b2c.services.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.mail.util.ByteArrayDataSource;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.sony.refrigeration.b2c.constant.MailConstants;
import com.sony.refrigeration.b2c.enums.EMailType;
import com.sony.refrigeration.b2c.services.api.EmailService;
import com.sony.refrigeration.b2c.util.MailDetails;
import com.sony.refrigeration.b2c.util.PropertyUtils;

@Service
public class EmailServiceImpl implements EmailService
{

    /** The log. */
    private static Logger log = Logger.getLogger(EmailServiceImpl.class);

    /** The mail details. */
    private MailDetails mailDetails;
    
    /**
     * The value holder for emailProps.
     */
    private Properties emailProps;

    /* (non-Javadoc)
     * @see com.ebreez.email.EmailService#setMailDetails(com.ebreez.email.utilities.MailDetails)
     */

    /**
     * set MailDetails.
     * @param  mailDetails - mailDetails
     */
    public void setMailDetails(MailDetails mailDetails)
    {
        this.mailDetails = mailDetails;
    }

    /* (non-Javadoc)
     * @see com.ebreez.email.EmailService#sendSimpleEMail()
     */
    /**
     * sendSimpleEMail.
     */
    public void sendSimpleEMail() throws EmailException
    {
        log.info("sendSimpleEMail: Entered");
        SimpleEmail simpleEmail =
                (SimpleEmail) getConfiguredEmail(mailDetails, getEMail(EMailType.SimpleEmail));

        simpleEmail.setMsg(mailDetails.getMessageBody());
        simpleEmail.send();
        log.info("Leaving: sendSimpleEMail");
    }

    /* (non-Javadoc)
     * @see com.ebreez.email.EmailService#sendHtmlEMail()
     */
    public void sendHtmlEMail() throws EmailException
    {
        log.debug("sendHtmlEMail: Entered");

        HtmlEmail htmlEmail =
                (HtmlEmail) getConfiguredEmail(mailDetails, getEMail(EMailType.HtmlEmail));

        // set the message
        String htmlMessageContent = mailDetails.getMessageBody();
        htmlEmail.setHtmlMsg(htmlMessageContent);
        
        htmlEmail.setCharset("utf-8");

        // some clients may not be capable of reading html email,
        // so set a text version of the html message (html tags tsripped off)
        // for them
        htmlEmail.setTextMsg(stripHTML(htmlMessageContent));
        if (!CollectionUtils.isEmpty(mailDetails.getAttachments()))
        {
            ByteArrayDataSource bds = null;
            for (Map.Entry<String, byte[]> attachment : mailDetails.getAttachments().entrySet())
            {
                bds = new ByteArrayDataSource(attachment.getValue(),
				                MailConstants.EMAIL_MIME_TYPE_UTF_8);
				//the attachment's content as byte array
				//the attachment's content type.
				htmlEmail.attach(bds, attachment.getKey(), null);
            }
        }
        // send the email.
        htmlEmail.send();
        log.info("Leaving: sendHtmlEMail");
    }
    
    /* (non-Javadoc)
     * @see com.ebreez.email.EmailService#sendHtmlEMail()
     */
    public void sendPDFEmail() throws EmailException
    {
    	 log.info("sendPDFEmail PDF mail (): Entered!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    	 log.debug("sendPDFEmail PDF mail (): Entered!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        //MultiPartEmail multiPartEmail =(MultiPartEmail) getConfiguredEmail(mailDetails, getEMail(EMailType.MultiPartEmail));

        /*EmailAttachment attachment = new EmailAttachment();
       // attachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Ebreez logo");
        attachment.setName("Ebreez logo");*/
        log.info("sendPDFEmail PDF mail (): PreMiddle!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        // Create the email message
        MultiPartEmail email = (MultiPartEmail) getConfiguredEmail(mailDetails, getEMail(EMailType.MultiPartEmail));
        //email.setHostName("smtp.mandrillapp.com"); 
        //email.addTo(mailDetails.getRecipientAddress());
      //email.setHostName("smtp.googlemail.com");
        //email.setSmtpPort(587);
        //email.setAuthenticator(new DefaultAuthenticator("rajeshs@ebreez.com", "-4Ygcyfi9ORaPsrPtH9Rog"));
        //email.setFrom(mailDetails.getSenderAddress());
        //email.setSubject(mailDetails.getSubject());
        email.addPart(mailDetails.getMessageBody(),"text/html");
        

        log.info("sendPDFEmail PDF mail (): Middle!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        
        //String s = "test hello string";
        //byte[] b = s.getBytes();
        //byte[] b = null;
        
        byte[] b = mailDetails.getBlobByteArray();
    	if(mailDetails.getBlobByteArray() ==  null){
    		 b = mailDetails.getMessageBody().getBytes();
        	log.info(" i am null !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        
        log.info("sendPDFEmail PDF mail (): Middle 1  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		email.attach(new ByteArrayDataSource(b, "application/pdf"),
				mailDetails.getPdfName()+".pdf", "Document description",
			       EmailAttachment.ATTACHMENT);
		

		log.info("sendPDFEmail PDF mail (): Middle 2 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        log.info("sendPDFEmail PDF mail (): Middle 3  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        // send the email
        email.send();
          
       
        log.info("Leaving: sendPDFEmail");
        log.debug("sendPDFEmail PDF mail (): Leaving!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    /**
    * Simple helper method to set the email details like
    * to, from, subject, message, etc.
    * This method is clever, so you can actually pass a comma-separated
    * list of recipients, instead of a single recipient
    *
    * @param mailDetails the MailDetailsBean which encapsulates the email details.
    * @param email       the email object whose details are to be set.
    * @return the email object with the config details set.
    * @throws EmailException if there is a problem sending the email.
    */
    private static Email getConfiguredEmail(MailDetails mailDetails, Email email)
            throws EmailException
    {
        if (mailDetails == null || !mailDetails.validate())
        {
            log.error("getConfiguredEmail: Email Validation problem");
            // All details required to send the email are not present
            // throw a wobbly
            throw new EmailException("There was a problem while getting the email details. "
                    + " Either the maildetails  object was blank, or it failed validation. "
                    + "The following values"
                    + " Have to be not null/not blank in order for validation to succeed:"
                    + "1.sender, " + "2.recepient, " + "3.subject " + "4.message body. "
                    + "The current mail details are: " + mailDetails);
        }
        // get the email details from the bean
        //can be null/blank
        String fromName = mailDetails.getSenderName();
        String fromEmail = mailDetails.getSenderAddress();
        //can be null/blank
        String toEmail = mailDetails.getRecipientAddress();
        String bccEmail = mailDetails.getBccRecipientAddress();
        String subject = mailDetails.getSubject();

        if (StringUtils.isBlank(toEmail))
        {
            log.error("getConfiguredEmail: Email Validation problem");
            throw new EmailException("Cannot send email to null or blank recepients !!");
        }
        // set from
        email.setFrom(fromEmail, fromName);

        // add recepient
        if (toEmail.indexOf(',') != -1)
        {
            // comma separated recepient list
            StringTokenizer st = new StringTokenizer(toEmail, ",");
            while (st.hasMoreTokens())
            {
                String toEmailId = st.nextToken();
                if (toEmailId != null && !"".equals(toEmailId))
                {
                    // add To
                    email.addTo(toEmailId);
                }
            }
        }
        else
        {
            // single recipient.
            email.addTo(toEmail, mailDetails.getRecipientName());
        }

        if (bccEmail != null)
        {
            if (bccEmail.indexOf(',') != -1)
            {
                // comma separated recepient list
                StringTokenizer st = new StringTokenizer(bccEmail, ",");
                while (st.hasMoreTokens())
                {
                    String bccEmailId = st.nextToken();
                    if (bccEmailId != null && !"".equals(bccEmailId))
                    {
                        // add To
                        email.addBcc(bccEmailId);
                    }
                }
            }
            else
            {
                // single recipient.
                email.addBcc(bccEmail);
            }

        }

        // set subject
        email.setSubject(subject);

        log.debug("getConfiguredEmail: End of the method.");
        return email;
    }

    /**
     * Gets the e mail.
     *
     * @param emailType the email type
     * @return the e mail
     * @throws EmailException the email exception
     */
    private Email getEMail(EMailType emailType) throws EmailException
    {
        Email email = null;
        if (emailType.equals(EMailType.SimpleEmail))
        {
            email = new SimpleEmail();
        }
        else if (emailType.equals(EMailType.HtmlEmail))
        {
            email = new HtmlEmail();
        }else if (emailType.equals(EMailType.MultiPartEmail)) {
			email = new MultiPartEmail();
		}
        else
        {
            // invalid input, return SimpleEmail object.
            email = new SimpleEmail();
        }

        String emailHostName = null;
		String userName = null;
		String password = null;
        Properties emailProps = new Properties();
        try
        {
            emailProps = PropertyUtils.loadProperties();
        }
        catch (NullPointerException iox) {
			try {
				emailProps.load(EmailServiceImpl.class.getResourceAsStream(MailConstants.SMTP_PROPERTIES_FILE));
			} catch (IOException e) {
				throw new EmailException(iox.getMessage());
			}
		} 
        catch (IOException iox)
        {
            try
            {
                emailProps.load(EmailServiceImpl.class.getResourceAsStream(MailConstants.SMTP_PROPERTIES_FILE));
            }
            catch (IOException e)
            {
                throw new EmailException(iox.getMessage());
            }
        }
        catch (URISyntaxException e)
        {
            throw new EmailException(e.getMessage());
        }
        email.setCharset("utf-8");
        System.out.println("Indrajeet : "+emailProps.getProperty(MailConstants.SMTP_USERNEME));
        
		if (null != emailProps.getProperty(MailConstants.EMAIL_SERVER_VENDOR)
				&& (emailProps.getProperty(MailConstants.EMAIL_SERVER_VENDOR)
						.equals("GMAIL") || emailProps.getProperty(
						MailConstants.EMAIL_SERVER_VENDOR).equalsIgnoreCase(
						("TURBO")))) {
			emailHostName = emailProps.getProperty(MailConstants.SMTP_PROPERTY);
			userName = emailProps.getProperty(MailConstants.SMTP_USERNEME);
			password = emailProps.getProperty(MailConstants.SMTP_PASSWORD);
			String port = emailProps.getProperty(MailConstants.SMTP_PORT);
			String startTLSEnabled = emailProps.getProperty(MailConstants.START_TLS_ENABLED);
			// set the SMTP host
			email.setHostName(emailHostName);
			email.setAuthentication(userName, password);
			// thats it!
			email.setSmtpPort(Integer.valueOf(port));
			email.setStartTLSEnabled(Boolean.parseBoolean(startTLSEnabled));
		} else if (null != emailProps
				.getProperty(MailConstants.EMAIL_SERVER_VENDOR)
				&& (emailProps.getProperty(MailConstants.EMAIL_SERVER_VENDOR)
						.equals("GODADDY"))) {
			emailHostName = emailProps.getProperty(MailConstants.SMTP_PROPERTY);
			userName = emailProps.getProperty(MailConstants.SMTP_USERNEME);
			password = emailProps.getProperty(MailConstants.SMTP_PASSWORD);
			// set the SMTP host
			email.setHostName(emailHostName);
			email.setAuthentication(userName, password);

		} else {
			// we are taking to godady by default
			emailHostName = emailProps.getProperty(MailConstants.SMTP_PROPERTY);
			userName = emailProps.getProperty(MailConstants.SMTP_USERNEME);
			password = emailProps.getProperty(MailConstants.SMTP_PASSWORD);
			// set the SMTP host
			email.setHostName(emailHostName);
			email.setAuthentication(userName, password);
		}        
        log.info(" SMTP : email.host.name :" + emailHostName);

        if (StringUtils.isBlank(emailHostName))
        {
            log.error("getEMail: Error while reading SMTP host info.");
            throw new EmailException("No SMTP host configured to send email!");
        }
        
        // thats it!
        return email;
    }

    /**
     * Utility method to remove html tags from a string.
     * not that effective yet, as it will strip things like script tags but
     * leave the code contents of them etc, but should be sufficient for emails.
     *
     * @param htmlText A string of text containing html tags.
     * @return The same string, without the html.
     */
    private static String stripHTML(String htmlText)
    {
        return htmlText.replaceAll("(?s)<.+?>", " ");
    }

    /**
     * Gets the emailProps.
     * @return the emailProps
     */
    public Properties getEmailProps()
    {
        return emailProps;
    }

    /**
     * Sets the emailProps.
     * @param emailProps the emailProps to set
     */
    public void setEmailProps(Properties emailProps)
    {
        this.emailProps = emailProps;
    }

}
