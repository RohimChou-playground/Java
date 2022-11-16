package com.rohim.consoleapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    public static void main(String[] args) throws JsonProcessingException {
        Employee john = new Employee(1, "John", 29);
        String json = new ObjectMapper().writeValueAsString(john);

        System.out.println(json);
    }
}
