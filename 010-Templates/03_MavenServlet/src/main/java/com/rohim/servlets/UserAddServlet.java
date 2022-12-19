package com.rohim.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rohim.FakeDb;
import com.rohim.models.User;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String userId = req.getParameter("uid");
        String userName = req.getParameter("uname");
     
        User u = new User();
        u.setUid(Integer.parseInt(userId));
        u.setUname(userName);
        FakeDb.Users.add(u);

        resp.sendRedirect("users");
    }
}
