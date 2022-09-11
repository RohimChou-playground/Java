package com.rohimchou.consoleapp1;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.scanners.SubTypesScanner;

public class ScanClassLab {

	public void run() {
		try {
			
			System.out.println("\nFind classes by classloader");
			List<Class> packageClasses1 = this.findClassesByClassLoader("com.rohimchou.consoleapp1");
			for (Class class1 : packageClasses1) {
				System.out.println(class1.getName());
			}
			
			System.out.println("\nFind classes by Reflections library");
			List<Class> packageClasses2 = this.findClassesByReflectionsLib("com.rohimchou.consoleapp1");
			for (Class class1 : packageClasses2) {
				System.out.println(class1.getName());
			}
			
		} catch (ClassNotFoundException | IOException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Class> findClassesByClassLoader(String packageName) 
			throws IOException, URISyntaxException, ClassNotFoundException  {
		
		List<Class> classes = new ArrayList<Class>();
		// will be AppClassLoader
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    Enumeration<URL> resourcesEnum = classLoader.getResources(packageName.replace('.', '/'));
	    
        // in this demo, will only contain one element
        // which .getPath() is D:/Github/Java/004-ConsoleApp1/target/classes/com/rohimchou/consoleapp1
	    List<URL> urls = Collections.list(resourcesEnum);
	    for (URL url : urls) {
	    	File f = new File(url.getFile());
	    	System.out.println(url.toURI());
	    	
	        // get the short file names under target/classes/com/rohimchou/consoleapp1 directorise
	        // 		App.class
	        //  	ReflectionLab.class
	        //  	ScanClassLab.class
	        //  	User.class
	    	List<String> classesFiles = Files.walk(Paths.get(url.toURI()))
	    		.filter(path -> path.toString().endsWith(".class"))
	    		.map(path -> path.getFileName().toString())
	    		.collect(Collectors.toList());
	    	
	    	for (String classFileName : classesFiles) {
	    		String classShortName = classFileName.substring(0, classFileName.lastIndexOf('.'));
	    		String className = packageName + "." + classShortName;
	    		classes.add(Class.forName(className));
			}
		}
		
		return classes;
	}
	
	public List<Class> findClassesByReflectionsLib(String packageName) throws ClassNotFoundException {
	    Reflections reflections = new Reflections(packageName, Scanners.SubTypes.filterResultsBy(v -> true));
	    List<Class> classes = reflections
	    		.getSubTypesOf(Object.class)
	    		.stream()
	    		.collect(Collectors.toList());

	    return classes;
	}

}
