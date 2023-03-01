package com.rohim.consoleapp;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MyDriverManagerDataSource extends DriverManagerDataSource {
    @Override
    public String getPassword() {
        String password = super.getPassword();
        return decode(password);
    }

    private String decode(String password) {
        // your own decoding logic
        return password;
    }
}
