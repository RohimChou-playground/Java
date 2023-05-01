package com.rohim.repositories;

import java.util.ArrayList;
import java.util.List;

public class EmpsRepository {

	private static List<String> emps = new ArrayList<>();

	private String currentDataSource;

	// for applicationContext.xml bean property injection
	public void setCurrentDataSource(String currentDataSource) {
		this.currentDataSource = currentDataSource;
	}

	static {
		emps.add("John");
		emps.add("Amy");
		emps.add("Tom");
	}

	public List<String> getAll() {
		System.out.println(" ================== " + this.currentDataSource + " ================== ");
		return emps;
	}
}
