package com.rohim.consoleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpService {
    
    @Autowired
    private IEmpMapper empMapper;

    public void doService() {
        EmpModel emp = empMapper.findByCn("Z00014054");
        System.out.println(emp.getFull_name());
    }
}
