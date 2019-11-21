package com.sony.refrigeration.b2c.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sony.refrigeration.b2c.dao.api.MasterDataDAO;
import com.sony.refrigeration.b2c.persistance.Cities;
import com.sony.refrigeration.b2c.persistance.Countries;
import com.sony.refrigeration.b2c.persistance.MessageConfiguration;
import com.sony.refrigeration.b2c.persistance.States;

@Repository
@Transactional
public class MasterDataDAOImpl implements MasterDataDAO 
{
    @PersistenceContext
    private EntityManager manager;
    
    public MessageConfiguration getMessageConfiguration(String messageType)
    {
        MessageConfiguration gmMessageConfig = null;
/*        List<MessageConfiguration> messageConfigList =
                getTemplate().findByNamedQueryAndNamedParam("getMessageConfiguration",
                        "messageType", messageType);

        if (CollectionUtils.isNotEmpty(messageConfigList))
        {
            gmMessageConfig = (MessageConfiguration) messageConfigList.get(0);
            // log.debug("gmMessageConfig(((...."+ gmMessageConfig);
        }*/
        return gmMessageConfig;
    }

	@Override
	public List<Countries> getCountries() 
	{
		manager.createQuery("FROM COUNTRIES");
		return null;
	}

	@Override
	public List<States> getStates(Long countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cities> getCities(Long stateId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
