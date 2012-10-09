package com.tavant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.tavant.domain.Anniversary;
import com.tavant.domain.User;
import com.tavant.services.AnniversaryService;
import com.tavant.validator.AnniversaryValidator;

@Controller
public class ImportantDatesController {

	private AnniversaryService anniversaryService;
	private AnniversaryValidator anniversaryValidator;

	@Autowired
	public void setAnniversaryValidator(
			AnniversaryValidator anniversaryValidator) {
		this.anniversaryValidator = anniversaryValidator;
	}

	@Autowired
	public void setAnniversaryService(AnniversaryService anniversaryService) {
		this.anniversaryService = anniversaryService;
	}

	@RequestMapping("/importantDates")
	public ModelAndView showImportantDates(HttpServletRequest request,
			ModelMap model) {

		if (request.getSession().getAttribute("currentUser") == null) {
			return new ModelAndView("redirect:login.html");
		}

		int currentUserId = ((User) request.getSession().getAttribute(
				"currentUser")).getUserId();

		List<Anniversary> anniversaryList = anniversaryService
				.selectAllAnniversaries(currentUserId);
		model.addAttribute(anniversaryList);
		return new ModelAndView("myImportantDates", model);

	}

	@RequestMapping(value = "/addAnniversary", method = RequestMethod.GET)
	public ModelAndView addAnniversaryForm(HttpServletRequest request,
			ModelMap model) {
		if (request.getSession().getAttribute("currentUser") == null) {
			return new ModelAndView("redirect:login.html");
		}
		Anniversary anniversary = new Anniversary();
		model.addAttribute(anniversary);
		return new ModelAndView("addAnniversaryForm");

	}

	@RequestMapping(value = "/addAnniversary", method = RequestMethod.POST)
	public ModelAndView onSubmit(
			@ModelAttribute("anniversary") Anniversary anniversary,
			BindingResult result, SessionStatus status,
			HttpServletRequest request) throws Exception {

		ModelMap model = new ModelMap();
		anniversaryValidator.validate(anniversary, result);
		if (result.hasErrors()) {
			return new ModelAndView("addAnniversaryForm");
		}

		int userId = ((User) request.getSession().getAttribute("currentUser"))
				.getUserId();
		anniversary.setUserId(userId);
		anniversaryService.addAnniversary(anniversary);

		model.addAttribute(anniversary);

		return new ModelAndView("redirect:importantDates.html", model);

	}

	@RequestMapping("/deleteAnniversary")
	public ModelAndView deleteAnniversary(HttpServletRequest request,
			ModelMap model) throws Exception {
		// if user session is empty, return to master page
		if (request.getSession().getAttribute("currentUser") == null) {
			return new ModelAndView("redirect:login.html");
		}

		int anniversaryId = Integer.parseInt(request
				.getParameter("anniversaryId"));
		int userId = ((User) request.getSession().getAttribute("currentUser"))
				.getUserId();

		anniversaryService.deleteAnniversary(new Anniversary(anniversaryId,
				userId));

		return showImportantDates(request, model);
	}

}
