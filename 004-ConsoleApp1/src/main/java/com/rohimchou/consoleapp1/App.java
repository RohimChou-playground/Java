package com.rohimchou.consoleapp1;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ReflectionLab r = new ReflectionLab();
		r.run();
		
		ScanClassLab s = new ScanClassLab();
		s.run();
	}
}
