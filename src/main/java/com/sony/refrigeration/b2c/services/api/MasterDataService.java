package com.sony.refrigeration.b2c.services.api;

import java.util.List;

import com.sony.refrigeration.b2c.beans.MessageDetails;
import com.sony.refrigeration.b2c.persistance.Cities;
import com.sony.refrigeration.b2c.persistance.Countries;
import com.sony.refrigeration.b2c.persistance.States;

public interface MasterDataService 
{

	public MessageDetails getMessageConfiguration(String messageType);
	
	public List<Countries> getCountries();
	
	public List<States> getStates(Long countryId);
	
	public List<Cities> getCities(Long stateId);
	
}
