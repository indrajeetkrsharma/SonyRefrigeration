package com.sony.refrigeration.b2c.converter;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.maxmind.geoip.regionName;
import com.sony.refrigeration.b2c.persistance.VisitorHitAuditGeoLoaction;



public class IpToGetLocationConverter 
{
	
	public VisitorHitAuditGeoLoaction getLocation(String ipAddress) {
		System.out.println("IP Address : "+ipAddress);
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		File file = new File(classLoader.getResource("GeoDB/GeoLiteCity.dat").getFile());
		System.out.println("File getAbsolutePath : "+file.getAbsolutePath());
		VisitorHitAuditGeoLoaction visitorHitAuditGeoLoaction = null;

		try {

			visitorHitAuditGeoLoaction = new VisitorHitAuditGeoLoaction();

		LookupService lookup = new LookupService(file,LookupService.GEOIP_MEMORY_CACHE);
		Location locationServices = lookup.getLocation(ipAddress);
		visitorHitAuditGeoLoaction.setIpAddress(ipAddress);
		visitorHitAuditGeoLoaction.setInsertedDate(new Date());
		visitorHitAuditGeoLoaction.setCountryCode(locationServices.countryCode);
		visitorHitAuditGeoLoaction.setCountryName(locationServices.countryName);
		visitorHitAuditGeoLoaction.setRegion(locationServices.region);
		visitorHitAuditGeoLoaction.setRegionName(regionName.regionNameByCode(
	             locationServices.countryCode, locationServices.region));
		visitorHitAuditGeoLoaction.setCity(locationServices.city);
		visitorHitAuditGeoLoaction.setPostalCode(locationServices.postalCode);
		visitorHitAuditGeoLoaction.setLatitude(String.valueOf(locationServices.latitude));
		visitorHitAuditGeoLoaction.setLongitude(String.valueOf(locationServices.longitude));

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		return visitorHitAuditGeoLoaction;

	  }
}
