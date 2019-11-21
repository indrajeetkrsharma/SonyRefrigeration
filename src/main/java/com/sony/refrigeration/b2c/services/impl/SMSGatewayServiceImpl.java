package com.sony.refrigeration.b2c.services.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.VelocityContext;
import org.springframework.stereotype.Service;

import com.sony.refrigeration.b2c.beans.MessageDetails;
import com.sony.refrigeration.b2c.constant.MessageConstants;
import com.sony.refrigeration.b2c.exceptions.SonyRefrigerationException;
import com.sony.refrigeration.b2c.services.api.SMSGatewayService;
import com.sony.refrigeration.b2c.util.MessageContent;
import com.sony.refrigeration.b2c.util.PropertyUtils;

@Service
public class SMSGatewayServiceImpl implements SMSGatewayService {
	
	/** The log. */
	private static Log log = LogFactory.getLog(SMSGatewayServiceImpl.class);
	
	

	/**
	 * @param messageDetails
	 * @return
	 * @see com.ebreez.message.SMSGatewayService#getSMSAPI(com.ebreez.message.utilities.MessageDetails)
	 */
	@Override
	public String getSMSAPI(MessageDetails messageDetails) throws SonyRefrigerationException {
		log.debug("ENTERING into getSMSAPI");
		String smsApi = null;
		VelocityContext vc = new VelocityContext();
		String templateName=null;
		String messageBody="";
		Properties smsProps = messageDetails.getEmailProps(); 
		if (smsProps == null){
			try {
				smsProps = loadSMSProperties();
			} catch (SonyRefrigerationException e) {
				log.error(e.getMessage(),e);
			}
		}
		String gatewaySMSName=smsProps.getProperty("DEFAULT_SMS_GATEWAY");
		messageBody = getMessageContent(messageDetails);
//		if(MessageConstants.SMS_GATEWAY_RESALTY.equalsIgnoreCase(gatewaySMSName))
		if("BULKSMS".equalsIgnoreCase(gatewaySMSName))
		
		{
			log.info("getSmsApi(): Entered");
			/*vc.put(MessageConstants.STR_USERNAME, smsProps.getProperty(MessageConstants.RESALTY_USER_NAME));
			vc.put(MessageConstants.STR_PASSWORD, smsProps.getProperty(MessageConstants.RESALTY_PASSWORD));
			vc.put(MessageConstants.STR_MESSAGE, messageBody);
			vc.put(MessageConstants.STR_MOBILENUMBER, messageDetails.getRecipientsMobileNumber());
			vc.put(MessageConstants.STR_SENDERNAME,smsProps.getProperty(MessageConstants.RESALTY_SENDER));
	        // get the TEMPLATE NAME which is used for specific gateway
	        templateName= MessageConstants.RESALTY_SMS_API_TEMPLATE;*/
			
			vc.put("user", smsProps.getProperty("username"));
			vc.put(MessageConstants.STR_PASSWORD, smsProps.getProperty("password"));
			vc.put(MessageConstants.STR_MESSAGE, messageBody);
			vc.put(MessageConstants.STR_MOBILENUMBER, messageDetails.getRecipientsMobileNumber());
			vc.put("sender","SONYJH");
			vc.put("type", "3");
			templateName= MessageConstants.RESALTY_SMS_API_TEMPLATE;
	        // get the TEMPLATE NAME which is used for specific gateway
//	        templateName= "sms.vm";
	        log.info("Leaving: getSMSAPI()");
		}
		else if(MessageConstants.SMS_GATEWAY_ROUTESMS.equalsIgnoreCase(gatewaySMSName)){
			/*url http://smpp5.routesms.com:8080/bulksms/sendsms?username=<username>&password=<password>&source=
				<sender>&destination=<cell-number>&dlr=<dlr-request>&type=<type-of-message>&message=<message>*/
			vc.put(MessageConstants.STR_USERNAME, smsProps.getProperty(MessageConstants.ROUTESMS_USER_NAME));
			vc.put(MessageConstants.STR_PASSWORD, smsProps.getProperty(MessageConstants.ROUTESMS_PASSWORD));
			vc.put(MessageConstants.STR_MESSAGE, messageBody);
			vc.put(MessageConstants.STR_MOBILENUMBER, messageDetails.getRecipientsMobileNumber());
			vc.put(MessageConstants.STR_SENDERNAME,smsProps.getProperty(MessageConstants.ROUTESMS_SENDER));
			  // get the TEMPLATE NAME which is used for specific gateway
			  templateName= MessageConstants.ROUTE_SMS_API_TEMPLATE;
			  vc.put(MessageConstants.MESSAGE_TYPE,smsProps.getProperty(MessageConstants.ROUTESMS_MESSAGE_TYPE));
			  vc.put(MessageConstants.MESSAGE_DELIVERY, smsProps.getProperty(MessageConstants.ROUTESMS_MESSAGE_DELIVERY));
		 }
		 smsApi = MessageContent.getContentData(templateName, vc);
		 log.debug("EXITING into getSMSAPI");
		 return smsApi;
	}
	
	
	 /**
 	 * Gets the message content.
 	 *
 	 * @param messageDetails the message details
 	 * @return the message content
 	 * @throws EbreezeException the ebreeze exception
 	 */
 	public String getMessageContent(MessageDetails messageDetails) throws SonyRefrigerationException
	    {
	        log.info("getMessageBody(): Entered");
	        // load the content data to Velocity Context to get the Message Content.
	        VelocityContext context = populateVelocityContext(messageDetails.getMessageContent());
	        String messageBody =
	                MessageContent.getContentData(
	                        MessageConstants.TEMPLATE_PATH + messageDetails.getContentType(), context);
	        log.info("Leaving: getMessageBody()");
	        return messageBody;
	    }
	 
	 /**
 	 * Populate velocity context.
 	 *
 	 * @param messageContent the message content
 	 * @return the velocity context
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
	 
	 /**
 	 * Load sms properties.
 	 *
 	 * @return the properties
 	 * @throws EbreezeException the ebreeze exception
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
}
