package com.sony.refrigeration.b2c.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee 
{
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}
