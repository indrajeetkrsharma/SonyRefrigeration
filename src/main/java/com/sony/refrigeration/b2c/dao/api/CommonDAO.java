package com.sony.refrigeration.b2c.dao.api;

import java.util.Date;

import com.sony.refrigeration.b2c.persistance.ContactUs;
import com.sony.refrigeration.b2c.persistance.VisitorHitAudit;
import com.sony.refrigeration.b2c.persistance.VisitorHitAuditGeoLoaction;

public interface CommonDAO 
{
	public void getVisitiorHit();
	public void addVisitor(VisitorHitAudit object);
	
	public void addVisitorGeoLocation(VisitorHitAuditGeoLoaction object);
	
	public void insertContactUsDetails(ContactUs contactUs);
	
	
}
