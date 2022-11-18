package com.rohim.consoleapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aaa.xml");
        UserModel user = (UserModel) context.getBean("user1");
        System.out.println(user.getName());
        System.out.println(user.getRole().getName());
    }
}
