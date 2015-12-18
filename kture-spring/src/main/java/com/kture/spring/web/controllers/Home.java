package com.kture.spring.web.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Home {

	// private static final Logger logger = LoggerFactory.getLogger(Home.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping(value = "/signin-failure", method = RequestMethod.GET)
	public String signInError(Model model) {
		model.addAttribute("error", "Sorry, that user doesn't exist!");
		return "home";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		model.addAttribute("error", "Sorry, that user doesn't exist!");
		return "home";
	}

}
