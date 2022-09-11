package com.rohimchou.consoleapp1;

@YamlSerializable(indentSpaces=4, rootObjName="sysuser")
public class User {
	
	@YamlSerializableField
	private Integer id;
	
	@YamlSerializableField
	private String name;
	private String password;
	
	public User(Integer id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
}
