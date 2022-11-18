package com.rohim.consoleapp;

import org.springframework.beans.factory.annotation.Autowired;

public class UserModel {
    private int id;
    private String name;
    private int age;

    @Autowired
    private RoleModel role1;
    
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public RoleModel getRole() {
        return role1;
    }
    public void setRole(RoleModel role) {
        this.role1 = role;
    }
}
