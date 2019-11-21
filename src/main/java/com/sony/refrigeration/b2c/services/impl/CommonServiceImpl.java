package com.sony.refrigeration.b2c.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.refrigeration.b2c.beans.ContactUsBean;
import com.sony.refrigeration.b2c.dao.api.CommonDAO;
import com.sony.refrigeration.b2c.persistance.ContactUs;
import com.sony.refrigeration.b2c.persistance.VisitorHitAudit;
import com.sony.refrigeration.b2c.persistance.VisitorHitAuditGeoLoaction;
import com.sony.refrigeration.b2c.services.api.CommonService;

@Service
public class CommonServiceImpl implements CommonService
{
	@Autowired
	CommonDAO commonDAO;
	
	@Override
	public void addVisitor(VisitorHitAudit object) 
	{
		commonDAO.addVisitor(object);
	}
	
	@Override
	public void addVisitorGeoLocation(VisitorHitAuditGeoLoaction object) 
	{
		commonDAO.addVisitorGeoLocation(object);
	}
	
	@Override
	public void insertContactUsDetails(ContactUsBean contactUsBean) 
	{
		ContactUs contactUs = new ContactUs();
		contactUs.setName(contactUsBean.getName());
		contactUs.setEmailId(contactUsBean.getEmail());
		contactUs.setContactNumber(contactUsBean.getMobileNo());
		contactUs.setSubject(contactUsBean.getSubject());
		contactUs.setDiscription(contactUsBean.getMessages());
		contactUs.setInsertedDate(new Date());
		commonDAO.insertContactUsDetails(contactUs);
	}

}
