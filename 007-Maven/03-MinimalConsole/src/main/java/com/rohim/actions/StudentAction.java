package com.rohim.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class StudentAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req,
            HttpServletResponse resp)
            throws Exception {

        resp.getWriter().print("<p>Hello World From Student Action</p>");
        resp.setContentType("text/html; charset=utf-8");

        String methodName = req.getMethod();
        System.out.println(methodName);

        return null;
    }

}
