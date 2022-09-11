package com.rohimchou.consoleapp1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface YamlSerializable {
	boolean genHeader3Dashes() default false;
	int indentSpaces() default 2;
	String rootObjName(); // if no 'default' specified, then is mandatory attribute
}
