package com.sony.refrigeration.b2c.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="VISITOR_HIT_AUDIT")
public class VisitorHitAudit implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="HIT_COUNT")
	private Long hitCount;
    
    @Column(name="IP_ADDRESS")
	private String ipAddress;
    
    @Column(name="INSERTED_DATE")
	private Date insertedDate;
    
    @Column(name="REMOTE_PORT")
    private int remotePort;
    
    @Column(name="REMOTE_HOST")
    private String remoteHost;
    
    @Column(name="REMOTE_USER")
    private String remoteUSER;
    
    @Column(name="USER_DIVICE")
    private String userDivice;
    
	public Long getHitCount() {
		return hitCount;
	}
	public void setHitCount(Long hitCount) {
		this.hitCount = hitCount;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Date getInsertedDate() {
		return insertedDate;
	}
	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}
	public int getRemotePort() {
		return remotePort;
	}
	public void setRemotePort(int remotePort) {
		this.remotePort = remotePort;
	}
	public String getRemoteHost() {
		return remoteHost;
	}
	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}
	public String getRemoteUSER() {
		return remoteUSER;
	}
	public void setRemoteUSER(String remoteUSER) {
		this.remoteUSER = remoteUSER;
	}
	public String getUserDivice() {
		return userDivice;
	}
	public void setUserDivice(String userDivice) {
		this.userDivice = userDivice;
	}
}
