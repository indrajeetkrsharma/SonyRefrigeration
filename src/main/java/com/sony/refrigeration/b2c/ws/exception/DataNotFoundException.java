package com.sony.refrigeration.b2c.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Ip Address not found in Geo Location DB...")
public class DataNotFoundException extends RuntimeException 
{
	public DataNotFoundException(String ip) 
	{
		super("The Ip not found : "+ip);
	}
}
