package com.rohim.springboot1.models;

public class Student {
	int id;
	String Name;
	int Chinese;
	int Math;
	int English;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getChinese() {
		return Chinese;
	}
	public void setChinese(int chinese) {
		Chinese = chinese;
	}
	public int getMath() {
		return Math;
	}
	public void setMath(int math) {
		Math = math;
	}
	public int getEnglish() {
		return English;
	}
	public void setEnglish(int english) {
		English = english;
	}
}