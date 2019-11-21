package com.sony.refrigeration.b2c.dao.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sony.refrigeration.b2c.dao.api.CommonDAO;
import com.sony.refrigeration.b2c.persistance.ContactUs;
import com.sony.refrigeration.b2c.persistance.VisitorHitAudit;
import com.sony.refrigeration.b2c.persistance.VisitorHitAuditGeoLoaction;

@Repository
@Transactional
public class CommonDAOImpl implements CommonDAO 
{
    @PersistenceContext
    private EntityManager manager;
    
	public void getVisitiorHit() 
	{

	}
	
	@Override
	public void addVisitor(VisitorHitAudit object) 
	{
		manager.persist(object);
	}

	@Override
	public void addVisitorGeoLocation(VisitorHitAuditGeoLoaction object) 
	{
		manager.persist(object);
	}
	
	@Override
	public void insertContactUsDetails(ContactUs contactUs) 
	{
		manager.persist(contactUs);
	}


}
