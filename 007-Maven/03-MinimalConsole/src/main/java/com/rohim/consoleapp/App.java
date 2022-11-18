package com.rohim.consoleapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class App {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = App.class.getClassLoader().getResourceAsStream("aaa.txt");
        
        Properties properties = new Properties();
        properties.load(inputStream);

        // {abcd=AABBCCDD, 1234=12345678}
        System.out.println(properties);

        // AABBCCDD
        System.out.println(properties.getProperty("abcd"));


        // default value set by program
        System.out.println(properties.getProperty("zzzzzzzzzzzz", "default value set by program"));
    }
}
