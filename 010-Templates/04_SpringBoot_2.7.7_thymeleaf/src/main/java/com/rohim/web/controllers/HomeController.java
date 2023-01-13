package com.rohim.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/")
public class HomeController {

    @RequestMapping(path="/", method=RequestMethod.GET)
    public ModelAndView index(
        HttpServletRequest request, 
        HttpServletResponse response, 
        HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("userName", "John");
		return modelAndView;
	}

    @RequestMapping(path="/numbers", method=RequestMethod.GET)
    @ResponseBody
	public int[] numbers() {
		return new int[] {1, 2, 3, 4, 5};
	}
}
