package com.tavant.controller;

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

import com.tavant.domain.Transaction;
import com.tavant.domain.User;
import com.tavant.services.TransactionService;

@Controller
public class TransactionController {
	private TransactionService transactionService;

	@Autowired
	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@RequestMapping("transactions-list")
	public ModelAndView showTransactions(HttpServletRequest request) {
		// if user session is empty, return to master page
		if (request.getSession().getAttribute("currentUser") == null) {
			return new ModelAndView("redirect:login.html");
		}
		Transaction transaction = new Transaction();
		ModelMap model = new ModelMap();
		model.addAttribute(transaction);
		
		return new ModelAndView("transactionsList", model);
	}

	@RequestMapping(value = "transaction-add", method = RequestMethod.GET)
	public ModelAndView addTransaction(HttpServletRequest request) {

		if (request.getSession().getAttribute("currentUser") == null) {
			return new ModelAndView("redirect:login.html");
		}

		ModelMap model = new ModelMap();
		Transaction transaction = new Transaction();
		model.addAttribute(transaction);
		return new ModelAndView("addTransaction",model);
	}
	
	@RequestMapping(value = "transaction-add", method = RequestMethod.POST)
	public ModelAndView onAddTransactionSubmit(@ModelAttribute("transaction") Transaction transaction,
			BindingResult result, SessionStatus status){
		ModelMap model = new ModelMap();
		
		return new ModelAndView("redirect:transactions-list.html", model);
	}
}
