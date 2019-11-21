package com.sony.refrigeration.b2c.beans;

import org.apache.log4j.Logger;

import com.sony.refrigeration.b2c.controller.Home;

public class TestBean 
{
	final static Logger logger = Logger.getLogger(Home.class);
	
	private String name;
	
	public TestBean() 
	{
		System.out.println("Hi I am Test Bean");
		System.out.println("Hash Code : "+this.hashCode());
		logger.debug("Hi I am Test Bean");
		logger.debug("Hash Code : "+this.hashCode());
	}
	
	{
		System.out.println("I am IIB Block of Test Bean");
		logger.debug("I am IIB Block of Test Bean");
	}
	
	static
	{
		System.out.println("I am SIB Block of Test Bean");
		logger.debug("I am SIB Block of Test Bean");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() 
	{
		logger.debug("Test Bean name attribute value : "+name);
		return "Test Bean name attribute value : "+name;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		boolean flag;

		if( obj != null && obj instanceof TestBean && this.name.equals(((TestBean) obj).name))
		{
			flag = true;
		}
		else
		{
			flag = false;
		}
			
		return flag;
	}
	
	@Override
	public int hashCode() 
	{
		return 30*2;
	}
}
