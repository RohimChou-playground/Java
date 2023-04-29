package com.rohim.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rohim.repositories.StudentsRepository;

public class StudentServlet extends HttpServlet {

  private StudentsRepository studentRepo = new StudentsRepository();

  private String userName;
  private String sessionId;
  private int sessionExpiredInterval;

  @Override
  public void init(ServletConfig servletConfig) throws ServletException {
      System.out.println("===== StudentServlet init =====");
      String currentEnv = servletConfig.getInitParameter("currentEnv");
      System.out.println("currentEnv: " + currentEnv);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    validateLogin(req, resp);

    resp.setContentType("text/html; charset=utf-8");
    resp.getWriter().print("<h1>Hello World From Student Servlet</h1>");

    // list current users
    List<String> students = this.studentRepo.getStudents();
    resp.getWriter().print("<h2>Students:</h2><ul>");
    for (String stu : students) {
      resp.getWriter().print("<li>" + stu + "</li>");
    }
    resp.getWriter().print("</ul>");

    // show session info
    resp.getWriter().print("<h2>Session Info:</h2><ul>");
    resp.getWriter().printf("<li>userName: %s</li>", this.userName);
    resp.getWriter().printf("<li>sessionId: %s</li>", this.sessionId);
    resp.getWriter().printf("<li>sessionExpiredInterval: %s sec</li>", this.sessionExpiredInterval);
    resp.getWriter().print("</ul>");

    resp.getWriter().print("<p><a href='./'>home</a></p>");
  }

  private void validateLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    // session
    HttpSession session = req.getSession(true);
    String userInSession = (String)session.getAttribute("userName");
    if (userInSession == null) {
      resp.sendRedirect("login.html");
    } else {
      this.userName = userInSession;
      this.sessionId = session.getId();
      this.sessionExpiredInterval = session.getMaxInactiveInterval();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String newStudent = req.getParameter("studentName");
    
    if (newStudent.equals("BBBB")) {
      // if student name is BBBB, then failed it
      req.setAttribute("errMsg", "BBBB is not a valid name!");
    } else {
      this.studentRepo.createStudent(newStudent);
      resp.sendRedirect("students");
    }
  }
}
