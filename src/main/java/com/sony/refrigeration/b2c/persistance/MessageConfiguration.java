package com.sony.refrigeration.b2c.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="MESSAGE_CONFIG")
public class MessageConfiguration implements Serializable
{
    private static final long serialVersionUID = 2751596455690813263L;
    
	@Id
    @GeneratedValue
    @Column(name="MSG_ID")
    private Short msgId;
	
	@Column(name="MSG_MESSAGE_TYPE")
	private String msgMessageType;
	
	@Column(name="MSG_EMAIL_SMS_TYPE")
	private String msgEmailSmsType;
	
	@Column(name="MSG_FROM_ADDRESS")
	private String msgFromAddress;
	
	@Column(name="MSG_SUBJECT")
	private String msgSubject;
	
	@Column(name="MSG_EMAIL_MIME_TYPE")
	private String msgEmailMimeType;
	
	@Column(name="MSG_CONTENT")
	private String msgContent;
	
	@Column(name="DELETE_STATE")
	private Integer deleteState;
	
	@Column(name="FK_USER_NAME")
	private String userId;
	
	@Column(name="TIMESTAMP")
	private Date insertedDate;

	public Short getMsgId() {
		return msgId;
	}

	public void setMsgId(Short msgId) {
		this.msgId = msgId;
	}

	public String getMsgMessageType() {
		return msgMessageType;
	}

	public void setMsgMessageType(String msgMessageType) {
		this.msgMessageType = msgMessageType;
	}

	public String getMsgEmailSmsType() {
		return msgEmailSmsType;
	}

	public void setMsgEmailSmsType(String msgEmailSmsType) {
		this.msgEmailSmsType = msgEmailSmsType;
	}

	public String getMsgFromAddress() {
		return msgFromAddress;
	}

	public void setMsgFromAddress(String msgFromAddress) {
		this.msgFromAddress = msgFromAddress;
	}

	public String getMsgSubject() {
		return msgSubject;
	}

	public void setMsgSubject(String msgSubject) {
		this.msgSubject = msgSubject;
	}

	public String getMsgEmailMimeType() {
		return msgEmailMimeType;
	}

	public void setMsgEmailMimeType(String msgEmailMimeType) {
		this.msgEmailMimeType = msgEmailMimeType;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}


	public Integer getDeleteState() {
		return deleteState;
	}

	public void setDeleteState(Integer deleteState) {
		this.deleteState = deleteState;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
    }
}
