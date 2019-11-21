package com.sony.refrigeration.b2c.email;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sony.refrigeration.b2c.beans.ContactUsBean;
import com.sony.refrigeration.b2c.beans.MessageDetails;
import com.sony.refrigeration.b2c.constant.MailConstants;
import com.sony.refrigeration.b2c.constant.MessageConstants;
import com.sony.refrigeration.b2c.exceptions.SonyRefrigerationException;
import com.sony.refrigeration.b2c.services.api.MasterDataService;
import com.sony.refrigeration.b2c.services.api.MessageService;

@Component
public class MessageSender 
{
	private Properties properties;
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private MasterDataService masterDataService;
	
	@PostConstruct
	public void init()
	{
		properties = loadPropertiesFromClassPath();
	}
	
	
	public void emailReplyContactUs(ContactUsBean contactUsBean)
	{
		
		String fromEmailId = properties.getProperty(MailConstants.SMTP_USERNEME);
		MessageDetails details = new MessageDetails();
		details = masterDataService.getMessageConfiguration("");
		Map<String, Object> content = new HashMap<String, Object>();
		content.put(MessageConstants.STR_NAME, "Indrajeet");
        content.put(MessageConstants.STR_TITLE, "Sharma");
        details.setMessageContent(content);
        details.setRecipientEmail(contactUsBean.getEmail());
        details.setContentType(MailConstants.CONTACT_US_EMAIL_VM);
        details.setSubject(MailConstants.EMAIL_SUBJECT_FOR_CONTACT_US);
        details.setFromMail(fromEmailId);
        details.setMailMimeType("html");
        try
        {
            messageService.sendEMail(details);
        }
        catch (SonyRefrigerationException e)
        {
           e.printStackTrace();
        }
	}
	
//    @RequestMapping("/emailSend.html")
	public ModelAndView loadContactUsPage(HttpServletRequest request) throws SonyRefrigerationException
	{
		ModelAndView modelAndView = new ModelAndView("contactUs");
//		emailingService.sendMail("indrajeet.kr.sharma@gmail.com", "Test Email", "Testing");
/*		ContactUsBean contactUsBean = new ContactUsBean();
		contactUsBean.setName("Indrajeet Kumar Sharma");
		contactUsBean.setEmail("indrajeet.kr.sharma@gmail.com");
		messageService.sendEmailAsVM(contactUsBean);*/
		
		Properties properties = loadPropertiesFromClassPath();
		System.out.println(properties.getProperty("email.credential.username"));
		MessageDetails details = new MessageDetails();
		details = masterDataService.getMessageConfiguration("");
		Map<String, Object> content = new HashMap<String, Object>();
		content.put(MessageConstants.STR_NAME, "Indrajeet");
        content.put(MessageConstants.STR_TITLE, "Sharma");
        details.setMessageContent(content);
        details.setRecipientEmail("indrajeet.kr.sharma@gmail.com");
        details.setContentType("test.vm");
        details.setSubject("Test Email");
        details.setFromMail("sony.refrigeration.bokaro@gmail.com");
        details.setMailMimeType("html");
        try
        {
            messageService.sendEMail(details);
        }
        catch (SonyRefrigerationException e)
        {
            throw e;
        }
		
		return modelAndView;
	}
    
    
    public Properties loadPropertiesFromClassPath()
    {
        Properties properties = new Properties();
		InputStream in = this.getClass().getResourceAsStream("/email.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return properties;
    }
    
//    @RequestMapping("/sendSMS.html")
    public ModelAndView sendSMS(HttpServletRequest request) throws SonyRefrigerationException
    {
    	ModelAndView modelAndView = new ModelAndView("contactUs");
    	Properties properties = loadPropertiesFromClassPath();
        MessageDetails details = new MessageDetails();
        details.setContentType("sms.vm");
        details.setSubject("Test");
        details.setMessageSenderName("INVITE");
        details.setFromMail("SONYJH");
        details.setMailMimeType("text");
        Map<String, Object> content = new HashMap<String, Object>();
        details.setMessageContent(content);
        details.setRecipientsMobileNumber("7416293171");
        try
        {
//            messageService.sendSMS(details);
        	System.out.println("Tomcat User Directory : "+ System.getProperty( "user.dir" ));
        	System.out.println("Tomcat Home Directory : "+ System.getProperty( "user.home" ));
        	System.out.println("Tomcat Catlina Base Directory : "+ System.getProperty( "catalina.base" ));
        	System.out.println("Tomcat Config Location Directory : "+ System.getProperty( "config.location" ));
        	
        }
        catch (Exception e)
        {
        }

    	
    	return modelAndView;
    }
    
	
}
