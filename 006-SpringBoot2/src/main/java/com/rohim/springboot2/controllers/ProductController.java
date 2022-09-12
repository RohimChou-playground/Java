package com.rohim.springboot2.controllers;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rohim.springboot2.models.Product;
import com.rohim.springboot2.services.ProductService;
import com.rohim.springboot2.utils.HttpUtils;

@Controller
@RequestMapping(path="/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index(@RequestParam(required = false) Integer id, HttpServletRequest request) {
		
		String queryStr = "";
		if (request.getQueryString() != null) {
			queryStr += "?" + request.getQueryString();
		}
		System.out.println();
		System.out.println(request.getMethod() + " " 
				+ request.getRequestURL() + queryStr);
		System.out.println(request.getUserPrincipal().getName() + " " 
				+ HttpUtils.getRequestIP(request) + " " 
				+ request.getSession().getId());
		// print all headers
		Enumeration<String> headerNames = request.getHeaderNames();
	    if (headerNames != null) {
	        while (headerNames.hasMoreElements()) {
	        	String headerName = headerNames.nextElement();
	            System.out.println(headerName + ":" + request.getHeader(headerName));
            }
	    }

		
		List<Product> products = new ArrayList<Product>();
		if (id == null) {
			products = this.productService.findAll();
		} else {
			Product p = this.productService.findById(id);
			if (p != null) {
				products.add(p);
			}
		}
		
		ModelAndView mw = new ModelAndView();
		mw.setViewName("products.html");
		mw.addObject("products", products);
		
		return mw;
	}
	
	@RequestMapping(path="/add", method=RequestMethod.GET)
	public ModelAndView add() {
		
		ModelAndView mw = new ModelAndView();
		mw.setViewName("products-add.html");
		mw.addObject("product", new Product());
		
		return mw;
	}
	
	@RequestMapping(path="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute Product product) {
		int idFromClient = product.getId();
		Product existingProduct = this.productService.findById(idFromClient);
		if (existingProduct == null) {
			this.productService.insert(product);
		} else	{
			this.productService.update(product);
		}
		
		return "redirect:/products";
	}
}
