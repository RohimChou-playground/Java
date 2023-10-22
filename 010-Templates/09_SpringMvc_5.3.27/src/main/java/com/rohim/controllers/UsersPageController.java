package com.rohim.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersPageController {

	// return static .html
	@RequestMapping(value = "/page/addUser", method = RequestMethod.GET)
	public String addUserPage() {
		return "addUser";
	}

	// return users.jsp view with model
	@RequestMapping(value = "/page/users", method = RequestMethod.GET)
	public ModelAndView getUsersPage() {
		ModelAndView mav = new ModelAndView("users");
		mav.addObject("users", new String[]{"John", "Jane", "Adam", "Emily"});
		return mav;
	}
}
