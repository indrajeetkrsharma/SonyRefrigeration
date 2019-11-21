package com.sony.refrigeration.b2c.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.refrigeration.b2c.beans.MessageDetails;
import com.sony.refrigeration.b2c.dao.api.MasterDataDAO;
import com.sony.refrigeration.b2c.persistance.Cities;
import com.sony.refrigeration.b2c.persistance.Countries;
import com.sony.refrigeration.b2c.persistance.MessageConfiguration;
import com.sony.refrigeration.b2c.persistance.States;
import com.sony.refrigeration.b2c.services.api.MasterDataService;

@Service
public class MasterDataServiceImpl implements MasterDataService 
{

	@Autowired
	private MasterDataDAO masterDataDAO;
	
    @Override
    public MessageDetails getMessageConfiguration(String messageType)
    {
        MessageDetails messgDetail = new MessageDetails();
        MessageConfiguration messageConfig = masterDataDAO.getMessageConfiguration(messageType);

        if (messageConfig != null)
        {
            messgDetail.setContentType(messageConfig.getMsgContent());
            messgDetail.setSubject(messageConfig.getMsgSubject());
            messgDetail.setFromMail(messageConfig.getMsgFromAddress());
            messgDetail.setMailMimeType(messageConfig.getMsgEmailMimeType());
        }
        return messgDetail;
    }

	@Override
	public List<Countries> getCountries() 
	{
		return masterDataDAO.getCountries();
	}

	@Override
	public List<States> getStates(Long countryId) 
	{
		List<States> states = null;
		if(null != countryId && !countryId.equals(""))
		{
			states = masterDataDAO.getStates(countryId);
		}
		return states;
	}

	@Override
	public List<Cities> getCities(Long stateId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
