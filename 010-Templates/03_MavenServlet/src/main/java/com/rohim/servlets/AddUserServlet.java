package com.rohim.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        // req.setCharacterEncoding("utf-8");
        System.out.println(req.getCharacterEncoding());
        String userId = req.getParameter("userId");
        String userName = req.getParameter("userName");
        
        System.out.println(" ============= AddUserServlet ============= ");
        System.out.println(userName);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("<h3>User Added</h3>");
        resp.getWriter().print("<p>name: " + userId + "</p>");
        resp.getWriter().print("<p>name: " + userName + "</p>");
    }
}
