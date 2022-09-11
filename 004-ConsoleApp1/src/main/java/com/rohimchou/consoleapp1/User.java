package com.rohimchou.consoleapp1;

import java.util.Date;

public class User {
	public Boolean isValid;
	final Date createdOn = new Date();
	protected static Integer lastId;
	private Integer id;
	private String name;
	
	public User(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
