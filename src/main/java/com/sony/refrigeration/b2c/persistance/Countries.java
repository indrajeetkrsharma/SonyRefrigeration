package com.sony.refrigeration.b2c.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRIES")
public class Countries {
	
	@Id
    @GeneratedValue
    @Column(name="ID")
	private Long id;
	
	@Column(name="SORTNAME")
	private String sortname;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PHONECODE")
	private Integer phonecode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhonecode() {
		return phonecode;
	}

	public void setPhonecode(Integer phonecode) {
		this.phonecode = phonecode;
	}

}
