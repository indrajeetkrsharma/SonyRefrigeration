package com.sony.refrigeration.b2c.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="CONTACT_US")
public class ContactUs implements Serializable 
{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="CONTACT_NUMBER")
	private String contactNumber;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="SUBJECT")
	private String subject;
	
	@Column(name="DISCRIPTION")
	private String discription;
	
	@Column(name="INSERTED_DATE")
	private Date insertedDate;
	
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;
	
	@Column(name="IS_REPLIED")
	private boolean isReplied;
	
	@Column(name="IS_RESOLVED")
	private boolean isResolved;
	
	@Column(name="IS_EXISTING_USER")
	private boolean isExsitingUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean isReplied() {
		return isReplied;
	}

	public void setReplied(boolean isReplied) {
		this.isReplied = isReplied;
	}

	public boolean isResolved() {
		return isResolved;
	}

	public void setResolved(boolean isResolved) {
		this.isResolved = isResolved;
	}

	public boolean isExsitingUser() {
		return isExsitingUser;
	}

	public void setExsitingUser(boolean isExsitingUser) {
		this.isExsitingUser = isExsitingUser;
	}
	
}
