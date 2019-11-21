package com.sony.refrigeration.b2c.exceptions;

public class SonyRefrigerationException extends Exception
{

	private static final long serialVersionUID = 8416449539694162530L;

    /** Error key. */
    private String errorKey;
	
	public SonyRefrigerationException() 
	{
		super();
	}

	public SonyRefrigerationException(String message) 
	{
		super(message);
	}
    /**
     * Constructor with errorKey and exception.
     *
     * @param errorKey the error key
     * @param cause the cause
     */
    public SonyRefrigerationException(String errorKey, Throwable cause)
    {
        super(errorKey, cause);
        this.errorKey = errorKey;
    }

    /**
     * Message with key and string message.
     *
     * @param errorKey the error key
     * @param strMessage the str message
     */
    public SonyRefrigerationException(String errorKey, String strMessage)
    {
        super(strMessage);
        setErrorKey(errorKey);
    }

    /**
     * Message with key,string message and clause.
     *
     * @param errorKey the error key
     * @param strMessage the str message
     * @param e the e
     */
    public SonyRefrigerationException(String errorKey, String strMessage, Throwable e)
    {
        super(strMessage, e);
        setErrorKey(errorKey);
    }

    /**
     * return the error code.
     *
     * @return the error key
     */
    public String getErrorKey()
    {
        return this.errorKey;
    }

    /**
     * set the error code.
     *
     * @param errorKey the new error key
     */
    public void setErrorKey(String errorKey)
    {
        this.errorKey = errorKey;
    }
}
