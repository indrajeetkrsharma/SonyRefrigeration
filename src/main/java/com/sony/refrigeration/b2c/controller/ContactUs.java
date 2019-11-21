package com.sony.refrigeration.b2c.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sony.refrigeration.b2c.beans.ContactUsBean;
import com.sony.refrigeration.b2c.email.MessageSender;
import com.sony.refrigeration.b2c.services.api.CommonService;
import com.sony.refrigeration.b2c.validator.ContactUsValidator;

@Controller
public class ContactUs 
{
	final static Logger logger = Logger.getLogger(ContactUs.class);
	
	@Autowired(required=true)
	ContactUsValidator contactUsValidator;
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	MessageSender messageSender;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(contactUsValidator);
	}
	
	@RequestMapping(value = "/contactUs.html", method = RequestMethod.GET)
	public ModelAndView loadContactUsPage(@ModelAttribute("userForm") ContactUsBean contactUs)
	{
		ModelAndView modelAndView = new ModelAndView("contactUs");
		return modelAndView;
	}
	
	@RequestMapping(value = "/submitContactUsFormPage.html", method = RequestMethod.POST)
	public String submitContactUsForm(@ModelAttribute("userForm") @Validated ContactUsBean contactUs, BindingResult result, 
										Model model, final RedirectAttributes redirectAttributes)
	{
		if (result.hasErrors()) 
		{
			return "contactUs";
		} 
		else 
		{
			commonService.insertContactUsDetails(contactUs);
			messageSender.emailReplyContactUs(contactUs);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			return "redirect:/contactUs.html";
		}
	}
}
