package com.rohim.controllers;

import com.rohim.repositories.EmpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpsController {

	@Autowired
	private EmpsRepository empsRepository;

	@RequestMapping("/emps")
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("emps");
		mv.addObject("emps", this.empsRepository.getAll());
		return mv;
	}
}
