/**
 * Copyright (C)2011 Ebreez Software Pvt. Ltd.
 * 
 * Ebreez Software Pvt. Ltd. Al Rabiea Tower, P.O.Box 69140, Riyadh 11547, Kingdom of Saudi Arabia
 * Telephone: +966 112246333
 * 
 * 
 * All rights reserved - The copyright notice above does not evidence any actual or intended
 * publication of this source code.
 * 
 * History: 1. Changes Done By GIVE_YOUR_NAME, On GIVE_THE_MODIFIED_DATE, Remarks -
 * GIVE_BRIEF_DESCRIPTION_ABOUT_THE_CHANGES
 */
package com.sony.refrigeration.b2c.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageDetails is used to get email addresses of users.
 */
public class MessageDetails
{

    /**
     * Represents the contentType name of the Template.
     */
    String contentType;

    /**
     * Represents the recipient's mail address.
     */
    String recipientEmail;

    /** Represents recipient's name. */
    String recipientName;

    /**
     * Represents the message type E.g: M(for Mail) S(for SMS).
     */
    String messageType;

    /**
     * Represents the Mail MIME type E.g: Text or HTML.
     */
    String mailMimeType;

    /**
     * Represents the from Mail address.
     */
    String fromMail;

    /**
     * Represents the Message subject.
     */
    String subject;

    /**
     * Represents the recipients mobile number to send SMS.
     */
    String recipientsMobileNumber;

    /**
     * Represents the sender name.
     */
    String messageSenderName;

    /**
     * Represents the base URL of the web context.
     */
    String baseURL;

    /**
     * Represents the dynamic message content data.
     */
    Map<String, Object> messageContent;

    /** Represents the list of attachment (as file) to mail. */
    List<String> emailAttachments;

    /**
     * Represents the list of attachment (as string content) to mail
     * Map should contain the name of the attachment and the String content to be attached.
     */
    Map<String, String> stringAttachment;

    /**
     * Represents recipients name.
     */
    String bccRecipientAddress;
    
    /**
     * The value holder for emailProps.
     */
    Properties emailProps;
    
    /**
     * Represents the pdf name of the e_ticket.
     */
    String pdfName;
    
    /** This will contains the pdf data in ByteStream */ 
    byte[]  blobByteArray;

    /**
     * Gets the bcc recipient address.
     *
     * @return the bcc recipient address
     */
    public String getBccRecipientAddress()
    {
        return bccRecipientAddress;
    }

    /**
     * Sets the bcc recipient address.
     *
     * @param bccRecipientAddress the new bcc recipient address
     */
    public void setBccRecipientAddress(String bccRecipientAddress)
    {
        this.bccRecipientAddress = bccRecipientAddress;
    }

    /**
     * Gets the string attachment.
     *
     * @return the string attachment
     */
    public Map<String, String> getStringAttachment()
    {
        return stringAttachment;
    }

    /**
     * Sets the string attachment.
     *
     * @param stringAttachment the string attachment
     */
    public void setStringAttachment(Map<String, String> stringAttachment)
    {
        this.stringAttachment = stringAttachment;
    }

    /**
     * Gets the content type (e.g: Name of the velocity macro.).
     * @return Name of the velocity macro.
     */
    public String getContentType()
    {
        return contentType;
    }

    /**
     * Sets the content type (e.g: Name of the velocity macro.).
     * @param contentType Name of the velocity macro.
     */
    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    /**
     * Gets the recipients email id.
     * @return Recipients email id.
     */
    public String getRecipientEmail()
    {
        return recipientEmail;
    }

    /**
     * Sets the recipients email id.
     * @param recipientEmail Recipients email id.
     */
    public void setRecipientEmail(String recipientEmail)
    {
        this.recipientEmail = recipientEmail;
    }

    /**
     * Gets the name of the recipient.
     * @return Name of the recipient
     */
    public String getRecipientName()
    {
        return recipientName;
    }

    /**
     * Sets the name of the recipient.
     * @param recipientName Recipient name
     */
    public void setRecipientName(String recipientName)
    {
        this.recipientName = recipientName;
    }

    /**
     * Gets the Message type (E.g Email or SMS).
     * @return Message type.
     */
    public String getMessageType()
    {
        return messageType;
    }

    /**
     * Sets the Message type (E.g Email or SMS).
     * @param messageType Message type.
     */
    public void setMessageType(String messageType)
    {
        this.messageType = messageType;
    }

    /**
     * Gets the email mime type (e.g html or text.).
     * @return Email mime type.
     */
    public String getMailMimeType()
    {
        return mailMimeType;
    }

    /**
     * Sets the email mime type (e.g html or text.).
     * @param mailMimeType Email mime type
     */
    public void setMailMimeType(String mailMimeType)
    {
        this.mailMimeType = mailMimeType;
    }

    /**
     * Gets the sender email address.
     * @return Sender Email address
     */
    public String getFromMail()
    {
        return fromMail;
    }

    /**
     * Sets the sender email address.
     * @param fromMail Sender email address
     */
    public void setFromMail(String fromMail)
    {
        this.fromMail = fromMail;
    }

    /**
     * Gets the email subject.
     * @return Subject of the email
     */
    public String getSubject()
    {
        return subject;
    }

    /**
     * Sets the email subject.
     * @param subject Subject of the email
     */
    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    /**
     * Gets the recipients mobile number.
     *
     * @return the recipients mobile number
     */
    public String getRecipientsMobileNumber()
    {
        return recipientsMobileNumber;
    }

    /**
     * Sets the recipients mobile number.
     *
     * @param recipientsMobileNumber the new recipients mobile number
     */
    public void setRecipientsMobileNumber(String recipientsMobileNumber)
    {
        this.recipientsMobileNumber = recipientsMobileNumber;
    }

    /**
     * Gets the message sender name.
     *
     * @return the message sender name
     */
    public String getMessageSenderName()
    {
        return messageSenderName;
    }

    /**
     * Sets the message sender name.
     *
     * @param messageSenderName the new message sender name
     */
    public void setMessageSenderName(String messageSenderName)
    {
        this.messageSenderName = messageSenderName;
    }

    /**
     * Gets the dynamic message content for the message to be sent.
     * @return Map of dynamic attributes for the message.
     */
    public Map<String, Object> getMessageContent()
    {
        return messageContent;
    }

    /**
     * Sets the dynamic message content for the message to be sent.
     * @param mssageContent Map of dynamic attributes for the message.
     */
    public void setMessageContent(Map<String, Object> mssageContent)
    {
        this.messageContent = mssageContent;
    }

    /**
     * Gets the base URL.
     * @return Base URL
     */
    public String getBaseURL()
    {
        return baseURL;
    }

    /**
     * Sets the Base URL.
     * @param baseURL Base URL.
     */
    public void setBaseURL(String baseURL)
    {
        this.baseURL = baseURL;
    }

    /**
     * Gets the path with file name of the attachments for the email.
     * @return COllection of attachments (path with file name)
     */
    public List<String> getEmailAttachments()
    {
        return emailAttachments;
    }

    /**
     * Sets the path with file name of the attachments for the email.
     * @param emailAttachments Collection of attachments (path with file name)
     */
    public void setEmailAttachments(List<String> emailAttachments)
    {
        this.emailAttachments = emailAttachments;
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

	/**
	 * @return the blobByteArray
	 */
	public byte[] getBlobByteArray() {
		return blobByteArray;
	}

	/**
	 * @param blobByteArray the blobByteArray to set
	 */
	public void setBlobByteArray(byte[] blobByteArray) {
		this.blobByteArray = blobByteArray;
	}

	/**
	 * @return the pdfName
	 */
	public String getPdfName() {
		return pdfName;
	}

	/**
	 * @param pdfName the pdfName to set
	 */
	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}
}
