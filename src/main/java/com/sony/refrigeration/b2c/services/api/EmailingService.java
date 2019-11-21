package com.sony.refrigeration.b2c.services.api;

import com.sony.refrigeration.b2c.beans.ContactUsBean;

public interface EmailingService 
{
	public void sendMail(String to, String subject, String body);
	
	public void sendPreConfiguredMail(String message);
	
	public void sendEmailAsVM(final ContactUsBean contactUsBean);
}
