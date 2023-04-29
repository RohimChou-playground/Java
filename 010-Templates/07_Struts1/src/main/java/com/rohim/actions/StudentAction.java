package com.rohim.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rohim.repositories.StudentsRepository;

public class StudentAction extends Action {

    private StudentsRepository studentRepo = new StudentsRepository();

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req,
            HttpServletResponse resp)
            throws Exception {

        resp.getWriter().print("<p>Hello World From Student Action</p>");
        resp.setContentType("text/html; charset=utf-8");
        
        List<String> students = this.studentRepo.getStudents();
        for (String stu : students) {
            resp.getWriter().print("<p>" + stu + "</p>");
        }

        resp.getWriter().print("<p>" + "<a href='./'>home</a>" + "</p>");

        String methodName = req.getMethod();
        System.out.println(methodName);

        return null;
    }

}
