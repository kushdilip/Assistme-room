package com.tavant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.tavant.domain.User;
import com.tavant.services.UserService;
import com.tavant.validator.LoginValidator;
import com.tavant.validator.RegistrationValidator;

@Controller
@SessionAttributes("currentUser")
public class UserController {
	private UserService userService;
	private LoginValidator loginValidator;
	private RegistrationValidator regisValidator;

	@Autowired
	public UserController(UserService userService,
			LoginValidator loginValidator, RegistrationValidator regisValidator) {
		this.userService = userService;
		this.loginValidator = loginValidator;
		this.regisValidator = regisValidator;

	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
	public String addContactForm(ModelMap model) {
		User user = new User();
		model.addAttribute(user);
		return "userRegistrationForm";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("user") User user,
			BindingResult result, SessionStatus status) {
		ModelMap model = new ModelMap();
		regisValidator.validate(user, result);
		
		if(result.hasErrors()){
			return new ModelAndView("userRegistrationForm");
		}
		
		userService.addUser(user);
		model.addAttribute(user);

		return new ModelAndView("userAddSuccess", model);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPageLoad(HttpServletRequest request) {
		User user = new User();
		ModelMap model = new ModelMap();
		model.addAttribute(user);

		return new ModelAndView("master", model);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView onLogin(@ModelAttribute("user") User user,
			BindingResult result, HttpServletRequest request) {

		loginValidator.validate(user, result);

		if (result.hasErrors()) {
			return new ModelAndView("master");
		}

		// System.out.println("i'm from login controller " + user);
		// User currentUser = userService.selectByEmailId(user.getemailId());
		User currentUser = loginValidator.getValidUser();
		// System.out.println("from login controller, valid user: " +
		// currentUser);

		request.getSession().setAttribute("currentUser", currentUser);
		return new ModelAndView("redirect:home.html");

		// if (currentUser != null
		// && currentUser.getPassword().equals(user.getPassword())) {
		// request.getSession().setAttribute("currentUser", currentUser);
		// return new ModelAndView("redirect:home.html");
		//
		// } else {
		// return new ModelAndView("master");
		// }
	}

	@RequestMapping("/logout")
	public String logOut(HttpServletRequest request) {
		request.getSession().removeAttribute("currentUser");
		return "redirect:login.html";
	}

}
