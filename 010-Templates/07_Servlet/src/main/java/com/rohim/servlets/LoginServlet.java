package com.rohim.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userName = req.getParameter("userName");
    if (userName == null || userName.equals("")) {
      RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= resp.getWriter();
			out.println("<font color=red>User Name should not be empty.</font>");
			rd.include(req, resp);
    }
    
    if (userName.equals("BBBB")) {
      // if username is BBBB, then login fail
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= resp.getWriter();
			out.println("<font color=red>User Name is wrong.</font>");
			rd.include(req, resp);
    } else {
			HttpSession session = req.getSession(true);
      if (session.getAttribute("userName") == null) {
        // if not login yet, set session
        session.setAttribute("userName", userName);
        session.setMaxInactiveInterval(30 * 60); // setting session to expiry in 30 mins, which is also the default session timeout interval
      } else {
        // if new username entered, refresh session
        String userInSession = (String)session.getAttribute("userName");
        if (!userName.equals(userInSession)) {
          session.invalidate();
          session = req.getSession(true);
          session.setAttribute("userName", userName);
          session.setMaxInactiveInterval(30 * 60); // setting session to expiry in 30 mins, which is also the default session timeout interval
        } 
      }

			resp.sendRedirect("students");
    }
  }
}
