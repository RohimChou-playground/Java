package com.rohim.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmpServlet extends HttpServlet {
    
    private String currentEnv;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Try init param");
        currentEnv = servletConfig.getInitParameter("currentEnv");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Current Env: " + currentEnv + ", Employee 123!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empName = req.getParameter("empName");
        resp.getWriter().write("Hello Emp " + empName);
    }
}