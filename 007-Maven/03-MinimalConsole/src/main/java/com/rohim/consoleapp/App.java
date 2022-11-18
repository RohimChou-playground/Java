package com.rohim.consoleapp;

import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("bbb.xml");

        // 看一下ApplicationContext從bbb.xml讀到什麼
        // DriverManagerDataSource dataSourcce = context.getBean(DriverManagerDataSource.class);
        // System.out.println("\n========== ping ==========\n");
        // System.out.println(dataSourcce.getUsername());
        // System.out.println(dataSourcce.getPassword());

        EmpService empService = context.getBean(EmpService.class);
        empService.doService();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
