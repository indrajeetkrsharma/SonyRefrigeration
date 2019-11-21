package com.sony.refrigeration.b2c.ws;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sony.refrigeration.b2c.beans.Employee;
import com.sony.refrigeration.b2c.converter.IpToGetLocationConverter;
import com.sony.refrigeration.b2c.persistance.VisitorHitAuditGeoLoaction;
import com.sony.refrigeration.b2c.services.api.CommonService;
import com.sony.refrigeration.b2c.ws.beans.GeoLoaction;

@RestController
@RequestMapping(value="/iks")
public class B2cWebServices 
{
	@Autowired
	CommonService commonService;
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET, headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployees()
	{
		Employee emp1 = new Employee();
		emp1.setName("Indrajeet");
		emp1.setAge("30");
		return new ResponseEntity<Employee>(emp1, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/b2cws/{ipAddress}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GeoLoaction> getGeoLocationFromIp(@PathVariable("ipAddress") String ipAddress)
	{
		ResponseEntity<GeoLoaction> responseEntity = null;
		GeoLoaction geoLoaction = null;
		try 
		{
			IpToGetLocationConverter ipToGetLocationConverter = new IpToGetLocationConverter(); 
			VisitorHitAuditGeoLoaction location = ipToGetLocationConverter.getLocation(ipAddress);
			geoLoaction = new GeoLoaction();
			geoLoaction.setIpAddress(ipAddress);
			geoLoaction.setCity(location.getCity());
//			geoLoaction.setCountryCode(location.getCountryCode());
			geoLoaction.setCountryName(location.getCountryName());
			geoLoaction.setLatitude(location.getLatitude());
			geoLoaction.setLongitude(location.getLongitude());
			geoLoaction.setPostalCode(location.getPostalCode());
			geoLoaction.setRegion(location.getRegion());
			geoLoaction.setRegionName(location.getRegionName());
			responseEntity = new ResponseEntity<GeoLoaction>(geoLoaction, HttpStatus.OK);
		} catch (Exception e) 
		{
			responseEntity = new ResponseEntity<GeoLoaction>(geoLoaction, HttpStatus.NOT_FOUND);
		}
		return responseEntity;
//		return geoLoaction;
	}
	
	@RequestMapping(value="/testClient", method=RequestMethod.GET)
	public static void getIpDetails()
	{
	    final String uri = "http://localhost:8089/b2c/iks/b2cws/183.82.196.46";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println("Rest Client using RestTemplate : "+result);
	}
}
