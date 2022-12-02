package com.rohim.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rohim.forms.StudentForm;
import com.rohim.repositories.StudentsRepository;

public class StudentCreateAction extends Action {

    private StudentsRepository studentRepo = new StudentsRepository();

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req,
            HttpServletResponse resp)
            throws Exception {

        // traditional "servlet" way to handle form post request
        // String newStudent = req.getParameter("studentName");
        // studentRepo.createStudent(newStudent);
        // resp.sendRedirect("students.do");
        // return null;

        // the struts1 way
        StudentForm studentForm = (StudentForm)form;
        String newStudent = studentForm.getStudentName();

        if (newStudent.equals("BBBB")) {
            // if student name is BBBB, then failed it
            req.setAttribute("errMsg", "BBBB is not a valid name!");
            return mapping.findForward("createdFailed");
        } else {
            studentRepo.createStudent(newStudent);
            return mapping.findForward("createdSuccessfully");
        }
    }

}
