package com.rohim.forms;

import org.apache.struts.action.ActionForm;

// serve like model
public class StudentForm extends ActionForm {
    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
