package com.rohim.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyAppServletContextListener 
               implements ServletContextListener{
	
	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		System.out.println(" ================= ServletContextListener destroyed ================= ");
	}

        //Run this before web application is started
	@Override
	public void contextInitialized(ServletContextEvent evt) {
		System.out.println(" ================= ServletContextListener started ================= ");	
	}
}
