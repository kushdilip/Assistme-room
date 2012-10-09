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

import com.tavant.domain.Contact;
import com.tavant.domain.User;
import com.tavant.services.ContactService;
import com.tavant.validator.ContactValidator;

@Controller
public class ContactController {

	private ContactService contactService;
	private ContactValidator contactValidator;

	@Autowired
	public ContactController(ContactService contactService,
			ContactValidator contactValidator) {
		this.contactService = contactService;
		this.contactValidator = contactValidator;
	}

	@RequestMapping(value = "/addContact", method = RequestMethod.GET)
	public ModelAndView addContactForm(HttpServletRequest request,
			ModelMap model) {

		// if user session is empty, return to master page
		if (request.getSession().getAttribute("currentUser") == null) {
			return new ModelAndView("redirect:login.html");
		}

		Contact contact = new Contact();
		model.addAttribute(contact);
		return new ModelAndView("contactAddForm");
	}

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("contact") Contact contact,
			BindingResult result, SessionStatus status,
			HttpServletRequest request) throws Exception {

		ModelMap model = new ModelMap();

		contactValidator.validate(contact, result);
		if (result.hasErrors()) {
			return new ModelAndView("contactAddForm");
		} else {
			User user = (User) request.getSession().getAttribute("currentUser");
			contact.setUserId(user.getUserId());
			contactService.addContact(contact);
			model.addAttribute(contact);
			return new ModelAndView("redirect:showContacts.html",model);
		}
	}

	@RequestMapping("/showContacts")
	public ModelAndView showContactList(HttpServletRequest request)
			throws Exception {

		// if user session is empty, return to master page
		if (request.getSession().getAttribute("currentUser") == null) {
			return new ModelAndView("redirect:login.html");
		}

		ModelMap model = new ModelMap();

		int currentUserId = ((User) request.getSession().getAttribute(
				"currentUser")).getUserId();
		List<Contact> contactsList = contactService
				.selectAllContacts(currentUserId);
		model.addAttribute(contactsList);

		return new ModelAndView("listOfContacts", model);
	}

	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContactForm(HttpServletRequest request,
			ModelMap model) {
		// if user session is empty, return to master page
		if (request.getSession().getAttribute("currentUser") == null) {
			return new ModelAndView("redirect:login.html");
		}

		Contact contact = contactService.selectById(Integer.parseInt(request
				.getParameter("contactId")));
		model.addAttribute(contact);
		System.out.println("from get method " + contact);
		return new ModelAndView("editContactForm", model);
	}

	@RequestMapping(value = "/editContact", method = RequestMethod.POST)
	public ModelAndView onEdit(@ModelAttribute("contact") Contact contact,
			BindingResult result, SessionStatus status,
			HttpServletRequest request) throws Exception {

		System.out.println("from post method " + contact);

		contactService.updateContact(contact);

		return showContactList(request);
	}

	@RequestMapping("/deleteContact")
	public ModelAndView deleteContact(HttpServletRequest request)
			throws Exception {
		// if user session is empty, return to master page
		if (request.getSession().getAttribute("currentUser") == null) {
			return new ModelAndView("redirect:login.html");
		}

		int id = Integer.parseInt(request.getParameter("contactId"));

		contactService.deleteContact(id);
		System.out.println("Deleted Contact: "
				+ request.getParameter("contactName"));
		return showContactList(request);
	}

}
