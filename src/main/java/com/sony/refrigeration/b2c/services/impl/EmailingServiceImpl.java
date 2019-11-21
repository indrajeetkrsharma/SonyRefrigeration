package com.sony.refrigeration.b2c.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.sony.refrigeration.b2c.beans.ContactUsBean;
import com.sony.refrigeration.b2c.services.api.EmailingService;

@Service("mailService")
public class EmailingServiceImpl implements EmailingService
{
	
//    @Autowired
//    private MailSender mailSender;
    
    @Autowired
    private JavaMailSender javaMailSender;
     
    @Autowired
    private SimpleMailMessage preConfiguredMessage;
    
    @Autowired
    private VelocityEngine velocityEngine;
    
	@Override
	public void sendMail(String to, String subject, String body) {
		// TODO Auto-generated method stub
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
//        mailSender.send(message);
	}

	@Override
	public void sendPreConfiguredMail(String message) {
		// TODO Auto-generated method stub
		SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
        mailMessage.setText(message);
//        mailSender.send(mailMessage);
	}
	
	public void sendEmailAsVM(final ContactUsBean contactUsBean) {
	      MimeMessagePreparator preparator = new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception {
		             MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
		             message.setTo("indrajeet.kr.sharma@gmail.com");
		             message.setBcc("adrianmatei@gmail.com");
//		             message.setFrom(new InternetAddress(suggestedPodcast.getEmail()) );
		             message.setFrom("sony.refrigeration.bokaro@gmail.com" );
		             message.setSubject("New suggested podcast");
		             message.setSentDate(new Date());
		             Map model = new HashMap();
		             model.put("newMessage", contactUsBean);

		             String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/messagetemplates/test.vm", "UTF-8", model);
		             message.setText(text, true);
		          }
		       };
		       javaMailSender.send(preparator);
	}
}
