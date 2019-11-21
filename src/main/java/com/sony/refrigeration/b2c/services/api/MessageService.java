package com.sony.refrigeration.b2c.services.api;

import com.sony.refrigeration.b2c.beans.MessageDetails;
import com.sony.refrigeration.b2c.exceptions.SonyRefrigerationException;
/**
 * Message service Interface deals with sending mails and sms to registered users.
 *
 */
public interface MessageService
{

    /**
     * Method to send an Email with the data populated in the given messageDetails.
     * <code>messageDetails</code> contains the email addresses, message content etc.
     * @param messageDetails Object containing Email Addresses, subject, message contents.
     * @throws Exception In case any issues in sending mail.
     */
    public void sendEMail(MessageDetails messageDetails) throws SonyRefrigerationException;

    /**
     * Method to send an SMS with the data populated in the given messageDetails.
     * <code>messageDetails</code> contains the email addresses, message content etc.
     * @param messageDetails Object containing mobile number, message contents.
     * @throws Exception In case any issues in sending SMS.
     */
    public void sendSMS(MessageDetails messageDetails) throws SonyRefrigerationException;

    /**
     * @param messageDetails
     * @return
     * @throws EbreezeException
     */
    public String getMessageContent(MessageDetails messageDetails) throws SonyRefrigerationException;
}
