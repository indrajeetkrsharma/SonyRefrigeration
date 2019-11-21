package com.sony.refrigeration.b2c.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="VISITOR_HIT_AUDIT_GEO_LOACTION")
public class VisitorHitAuditGeoLoaction implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="ID")
	private Long id;
	
    @Column(name="IP_ADDRESS")
	private String ipAddress;
	
    @Column(name="COUNTRY_CODE")
	private String countryCode;
    
    @Column(name="COUNTRY_NAME")
	private String countryName;
    
    @Column(name="REGION")
	private String region;
    
    @Column(name="REGION_NAME")
	private String regionName;
    
    @Column(name="CITY")
	private String city;
    
    @Column(name="POSTAL_CODE")
	private String postalCode;
    
    @Column(name="LATITUDE")
	private String latitude;
    
    @Column(name="LONGITUDE")
	private String longitude;
    
    @Column(name="INSERTED_DATE")
	private Date insertedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}
	
	
}
