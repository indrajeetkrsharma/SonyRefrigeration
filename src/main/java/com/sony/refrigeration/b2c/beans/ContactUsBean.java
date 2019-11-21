package com.sony.refrigeration.b2c.beans;

public class ContactUsBean 
{
	private String name;
	
	private String email;
	
	private String mobileNo;
	
	private String subject;
	
	private String messages;
	
	private boolean isFormSubmitted;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public boolean isFormSubmitted() {
		return isFormSubmitted;
	}

	public void setFormSubmitted(boolean isFormSubmitted) {
		this.isFormSubmitted = isFormSubmitted;
	}
	
	
}
