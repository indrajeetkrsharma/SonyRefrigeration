package com.sony.refrigeration.b2c.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Trainings 
{
	@RequestMapping("/trainings.html")
	public ModelAndView loadLoginPage()
	{
		System.out.println("called");
		ModelAndView modelAndView = new ModelAndView("trainings");
		return modelAndView;
	}
}
