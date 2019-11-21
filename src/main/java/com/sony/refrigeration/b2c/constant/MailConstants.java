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
package com.sony.refrigeration.b2c.constant;

// TODO: Auto-generated Javadoc
/**
 * The Class MailConstants holds mail constants.
 */
public class MailConstants
{

    /** The Constant SMTP_PROPERTIES_FILE. */
    public final static String SMTP_PROPERTIES_FILE = "/email.properties";

    /** The Constant SMTP_PROPERTY. */
    public final static String SMTP_PROPERTY = "email.host.name";
    
    /** The Constant SMTP_PORT. */
	public final static String SMTP_PORT = "email.host.port";

    /** The Constant EMAIL_MIME_TYPE. */
    public final static String EMAIL_MIME_TYPE = "text/html";
    
    /** The Constant EMAIL_MIME_TYPE.For UTF-8 */
	 public final static String EMAIL_MIME_TYPE_UTF_8="text/html; charset=UTF-8";
    
    /** The Constant EMAIL_SERVER_VENDOR. */
	public final static String EMAIL_SERVER_VENDOR = "email.server.vendor";

    /** The Constant SMTP_USERNEME. */
    public final static String SMTP_USERNEME = "email.credential.username";

    /** The Constant SMTP_PASSWORD. */
    public final static String SMTP_PASSWORD = "email.credential.password";

    /** The Constant EBREEZ_ADMIN. */
    public final static String EBREEZ_ADMIN = "ebreez.admin.emailid";

    /** The Constant EBREEZ_ADMIN_CONTACT. */
    public final static String EBREEZ_ADMIN_CONTACT = "ebreez.admin.contact";

    /** The Constant EBREEZ_ADMIN_CONTACT1. */
    public final static String EBREEZ_ADMIN_CONTACT1 = "ebreez.admin.contact1";

    /** The Constant EBREEZ_ADMIN_CONTACT2. */
    public final static String EBREEZ_ADMIN_CONTACT2 = "ebreez.admin.contact2";

    /** The Constant CMS_URL. */
    public final static String CMS_URL = "baseurl.cms";

    /** The Constant B2CCONFIG_PATH. */
    public final static String B2CCONFIG_PATH = "b2capplication_config_path";
    
    /** The Constant CAPTURE_FAILURE_MAIL_RECEPIENTS. */
    public final static String CAPTURE_FAILURE_MAIL_RECEPIENTS = "capture.failure.mail.recepients";
    
    /** The Constant CAPTURE_FAILURE_SMS_RECEPIENTS. */
    public final static String CAPTURE_FAILURE_SMS_RECEPIENTS = "capture.failure.sms.recepients";
    
    /** The Constant START_TLS_ENABLED. */
    public final static String START_TLS_ENABLED = "mail.smtp.starttls.enable";
    
    public final static String EMAIL_SUBJECT_FOR_CONTACT_US = "We Received your message and will get back to you soon!!!";
    
    public final static String CONTACT_US_EMAIL_VM = "contactUs.vm";

}
