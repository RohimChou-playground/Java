package com.rohim.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rohim.web.models.User;
import com.rohim.web.services.UserService;
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

    @Autowired
    private UserService userService;

    @RequestMapping(path = "insert", method = RequestMethod.GET)
    @ResponseBody
    public Object t1() {
        this.userService.insertUser(new User(1, "John"));
        return "Hello World1";
    }


    @RequestMapping(path = "getByCacheAnno/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object t2(@PathVariable Integer id) {
        User user = this.userService.findUserById(id);
        return user;
    }

    @RequestMapping(path = "getByCacheManager/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object t5(@PathVariable Integer id) {
        User user = this.userService.findUserById_WithCacheManager(id);
        return user;
    }

    @RequestMapping(path = "getall", method = RequestMethod.GET)
    @ResponseBody
    public Object t4() {
        List<User> users = this.userService.findAll();
        return users;
    }

    @RequestMapping(path = "update/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object t3(@PathVariable Integer id, @RequestParam(required=false) String name) {
        User user = this.userService.udpateUser(new User(id, name));
        return user;
    }
}