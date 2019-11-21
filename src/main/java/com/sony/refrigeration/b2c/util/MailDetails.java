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
package com.sony.refrigeration.b2c.util;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class MailDetails holds uesr details for mailing purpose.
 */
public class MailDetails
{

    /**
     * Represents recipients email address.
     */
    String recipientAddress;

    /**
     * Represents sender Email address.
     */
    String senderAddress;

    /**
     * Represents recipients name.
     */
    String recipientName;

    /**
     * Represents recipients name.
     */
    String bccRecipientAddress;

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
     * Represents sender name.
     */
    String senderName;

    /**
     * Represents the subject of the email.
     */
    String subject;

    /**
     * Represents the actual message of the email.
     */
    String messageBody;

    /**
     * Represents the list of attachments if any.(holds the complete
     * path with file name to be attached).
     */
    Map<String, byte[]> attachments;
    
    /**
     * Eticket PDF name.
     */
    String pdfName;
    
    
    byte[]  blobByteArray;

    /**
     * Gets the attachments.
     *
     * @return the attachments
     */
    public Map<String, byte[]> getAttachments()
    {
        return attachments;
    }

    /**
     * Sets the attachments.
     *
     * @param attachments the attachments
     */
    public void setAttachments(Map<String, byte[]> attachments)
    {
        this.attachments = attachments;
    }

    /**
        * Utility method to check if the MailDetailsBean
        * object is valid. We can define the semantics of
        * what constitutes 'valid' in here.
        * Returns true if (and only if) to, from subject
        * and message fields are ALL non blank, false
        * if one (or more) of them are blank.
        *
        * @return whether or not this object is valid.
        */
    public final boolean validate()
    {
        return StringUtils.isNotBlank(recipientAddress) && StringUtils.isNotBlank(senderAddress)
                && StringUtils.isNotBlank(subject) && StringUtils.isNotBlank(messageBody);
    }

    /**
     * Gets the recipient address.
     *
     * @return the recipient address
     */
    public String getRecipientAddress()
    {
        return recipientAddress;
    }

    /**
     * Sets the recipient address.
     *
     * @param recipientAddress the new recipient address
     */
    public void setRecipientAddress(String recipientAddress)
    {
        this.recipientAddress = recipientAddress;
    }

    /**
     * Gets the sender address.
     *
     * @return the sender address
     */
    public String getSenderAddress()
    {
        return senderAddress;
    }

    /**
     * Sets the sender address.
     *
     * @param senderAddress the new sender address
     */
    public void setSenderAddress(String senderAddress)
    {
        this.senderAddress = senderAddress;
    }

    /**
     * Gets the recipient name.
     *
     * @return the recipient name
     */
    public String getRecipientName()
    {
        return recipientName;
    }

    /**
     * Sets the recipient name.
     *
     * @param recipientName the new recipient name
     */
    public void setRecipientName(String recipientName)
    {
        this.recipientName = recipientName;
    }

    /**
     * Gets the sender name.
     *
     * @return the sender name
     */
    public String getSenderName()
    {
        return senderName;
    }

    /**
     * Sets the sender name.
     *
     * @param senderName the new sender name
     */
    public void setSenderName(String senderName)
    {
        this.senderName = senderName;
    }

    /**
     * Gets the subject.
     *
     * @return the subject
     */
    public String getSubject()
    {
        return subject;
    }

    /**
     * Sets the subject.
     *
     * @param subject the new subject
     */
    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    /**
     * Gets the message body.
     *
     * @return the message body
     */
    public String getMessageBody()
    {
        return messageBody;
    }

    /**
     * Sets the message body.
     *
     * @param messageBody the new message body
     */
    public void setMessageBody(String messageBody)
    {
        this.messageBody = messageBody;
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

}
