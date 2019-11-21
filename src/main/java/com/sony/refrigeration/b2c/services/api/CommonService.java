package com.sony.refrigeration.b2c.services.api;

import com.sony.refrigeration.b2c.beans.ContactUsBean;
import com.sony.refrigeration.b2c.persistance.VisitorHitAudit;
import com.sony.refrigeration.b2c.persistance.VisitorHitAuditGeoLoaction;

public interface CommonService 
{
	public void addVisitor(VisitorHitAudit object);
	
	public void addVisitorGeoLocation(VisitorHitAuditGeoLoaction object);
	
	public void insertContactUsDetails(ContactUsBean contactUsBean);
}
