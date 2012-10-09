package com.tavant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

	@RequestMapping({"/", "/index" })
	public String goMaster(HttpServletRequest request) {
		return "redirect:login.html";
	}

	@RequestMapping("/home")
	public ModelAndView goHome(HttpServletRequest request) {
		return new ModelAndView("home");
	}


}
