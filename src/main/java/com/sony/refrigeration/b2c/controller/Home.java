package com.sony.refrigeration.b2c.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sony.refrigeration.b2c.beans.TestBean;
import com.sony.refrigeration.b2c.converter.IpToGetLocationConverter;
import com.sony.refrigeration.b2c.persistance.VisitorHitAudit;
import com.sony.refrigeration.b2c.services.api.CommonService;

@Controller
public class Home 
{
	final static Logger logger = Logger.getLogger(Home.class);
	@Autowired
	CommonService visitorHitService;
	
	@Autowired
	@Qualifier("A")
	TestBean testBeanA;
	
	@Autowired
	@Qualifier("B")
	TestBean testBeanB;
	
	@RequestMapping("/home.html")
	public ModelAndView loadLoginPage(HttpServletRequest request)
	{
		logger.info("Remote Address is  : "+request.getRemoteAddr());
		String ipAddress = "183.82.196.46";
		
		if (request != null) {
			ipAddress = request.getHeader("X-FORWARDED-FOR");
            if (ipAddress == null || "".equals(ipAddress)) {
            	ipAddress = request.getRemoteAddr();
            	logger.info("X-Forward Remote Address is  : "+request.getRemoteAddr());
            }
        }
		
		if(!"127.0.0.1".equals(request.getRemoteAddr()))
			ipAddress = request.getRemoteAddr().toString();
		ipAddress = "183.82.196.46";
		ModelAndView modelAndView = new ModelAndView("index");
		VisitorHitAudit ob = new VisitorHitAudit();
		ob.setIpAddress(request.getRemoteAddr().toString());
		ob.setRemoteHost(request.getRemoteHost());
//		ob.setRemotePort(request.getRemotePort());
		ob.setRemoteUSER(request.getRemoteUser());
		Date date = new Date();
		ob.setInsertedDate(date);
		visitorHitService.addVisitor(ob);
		IpToGetLocationConverter ipToGetLocationConverter = new IpToGetLocationConverter(); 
		visitorHitService.addVisitorGeoLocation(ipToGetLocationConverter.getLocation(ipAddress));
		return modelAndView;
	}
}
