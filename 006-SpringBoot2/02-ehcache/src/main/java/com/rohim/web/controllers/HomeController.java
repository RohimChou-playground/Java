package com.rohim.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping(path="/")
public class HomeController {

    @RequestMapping(path="/", method=RequestMethod.GET)
    public String index(
        HttpServletRequest request, 
        HttpServletResponse response, 
        HttpSession session) {
        
		return "index.html";
	}

    @RequestMapping(path="/numbers", method=RequestMethod.GET)
    @ResponseBody
	public int[] numbers() {
		return new int[] {1, 2, 3, 4, 6};
	}
}