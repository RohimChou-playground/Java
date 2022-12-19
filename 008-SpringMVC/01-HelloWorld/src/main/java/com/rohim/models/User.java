package com.rohim.models;

public class User {
    private Integer userId;
    private String userName;
    
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer id) {
        this.userId = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String name) {
        this.userName = name;
    }

    @Override
    public String toString() {
        return "{ \"id\":" + userId + ", \"name\":\"" + userName + "\" }";
    }
}
