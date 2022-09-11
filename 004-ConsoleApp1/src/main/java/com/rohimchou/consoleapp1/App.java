package com.rohimchou.consoleapp1;

public class App {
	public static void main(String[] args) {
		
		User user = new User(1, "Amy", "abc123");
		
		YamlConverter yamlConverter = new YamlConverter();
		String yamlResult = yamlConverter.serialize(user);
		
		System.out.println(yamlResult);
	}
}
