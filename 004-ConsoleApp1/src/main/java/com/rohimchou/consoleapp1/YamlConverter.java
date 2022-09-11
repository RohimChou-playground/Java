package com.rohimchou.consoleapp1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

public class YamlConverter {
	public <T> String serialize(T obj) {
		
		Class<?> clazz = obj.getClass();
		if (!clazz.isAnnotationPresent(YamlSerializable.class)) {
			throw new RuntimeException(
					"Class '" + clazz.getSimpleName() + "' is not annotated with YamlSerializable");
		}
		
		YamlSerializable yamlConfig = obj.getClass().getAnnotation(YamlSerializable.class);
		
		StringBuilder sb = new StringBuilder();
		// print: ---
		if (yamlConfig.genHeader3Dashes()) {
			sb.append(String.format("---%n"));
		}
		
		// print: sysuser:
		sb.append(String.format("%s:%n", yamlConfig.rootObjName()));
		
		// print:   id: 1
		//			name: Amy 
		String indentSpaces = this.getSpaces(yamlConfig.indentSpaces());
		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			YamlSerializableField yamlField = f.getAnnotation(YamlSerializableField.class);
			if (yamlField != null) {
				f.setAccessible(true);
				try {
					sb.append(String.format("%s%s: %s%n", indentSpaces, f.getName(), f.get(obj)));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
		}
		
		return sb.toString();
	}
	
	private String getSpaces(int numOfSpaces) {
		String spaces = "";
		for (int i = 0; i < numOfSpaces; i++) {
			spaces += " ";
		}
		return spaces;
	}
}
