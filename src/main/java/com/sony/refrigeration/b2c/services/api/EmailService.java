package com.sony.refrigeration.b2c.services.api;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.mail.EmailException;

import com.sony.refrigeration.b2c.util.MailDetails;

/**
 * The Interface EmailService deals with sending mails to registered users.
 */
public interface EmailService
{

    /**
     * Sets the mail details.
     *
     * @param mailDetails the new mail details
     */
    void setMailDetails(MailDetails mailDetails);

    /**
     * Send simple e mail.
     *
     * @throws EmailException the email exception
     */
    public void sendSimpleEMail() throws EmailException;

    /**
     * Send html e mail.
     *
     * @throws EmailException the email exception
     */
    public void sendHtmlEMail() throws EmailException;
    
    /**
     * Sets the email properties.
     *
     * @param mailDetails the new mail details
     */
    void setEmailProps(Properties emailProps);
    
    /**
     * Send PDF e mail.
     *
     * @throws EmailException the email exception
     * @throws IOException 
     */
    public void sendPDFEmail() throws EmailException, IOException;

}
