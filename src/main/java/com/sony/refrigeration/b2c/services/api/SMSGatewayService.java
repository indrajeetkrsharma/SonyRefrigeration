package com.sony.refrigeration.b2c.services.api;

import com.sony.refrigeration.b2c.beans.MessageDetails;
import com.sony.refrigeration.b2c.exceptions.SonyRefrigerationException;

public interface SMSGatewayService {

	/**
	 * Gets the smsapi.
	 *
	 * @param messageDetails the message details
	 * @return the smsapi
	 */
	public String getSMSAPI(MessageDetails messageDetails) throws SonyRefrigerationException;
}
