package com.rohim.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent evt) {
        // TODO Auto-generated method stub
        System.out.println(" ================= Session Created ================= ");
    }

    public void sessionDestroyed(HttpSessionEvent evt) {
        // TODO Auto-generated method stub
    }
}
