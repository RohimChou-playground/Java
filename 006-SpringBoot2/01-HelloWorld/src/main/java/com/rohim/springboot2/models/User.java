package com.rohim.springboot2.models;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private String password;
	private Integer points;
	private Date createdon;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Date getCreatedOn() {
		return createdon;
	}
	public void setCreatedOn(Date cretaedon) {
		this.createdon = cretaedon;
	}
}
