package com.rohim.consoleapp;

import org.springframework.stereotype.Component;

@Component("role2")
public class RoleModel {
    private int id = 2;
    private String name = "regional manager";

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
