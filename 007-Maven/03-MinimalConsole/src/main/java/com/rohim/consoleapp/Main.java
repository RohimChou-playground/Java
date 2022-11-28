package com.rohim.consoleapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String args[]) {
        ApplicationContext springAppContext = new ClassPathXmlApplicationContext("springApplicationContext.xml");

        Application app = springAppContext.getBean(Application.class);
        app.Start();

        ((ClassPathXmlApplicationContext)springAppContext).close();
    }   
}
