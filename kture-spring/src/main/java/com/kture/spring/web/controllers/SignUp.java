package com.kture.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kture.spring.entity.User;
import com.kture.spring.market.MarketFactory;

@Controller
public class SignUp {

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp(Model model) {
		return "signUp";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String addNewUser(@RequestParam String login,
			@RequestParam String name, @RequestParam String email,
			@RequestParam String password, @RequestParam String telephone,
			Model model) {
		User user = new User();
		user.setName(name);
		user.setUserName(login);
		user.setPassword(password);
		user.setPhoneNumber(telephone);
		user.setEmail(email);
		if (MarketFactory.getMarket().createUser(user) != null) {
			model.addAttribute("signUpSuccess",
					"You are successfully sign up! Please log in.");
		} else {
			model.addAttribute("signUpError", "Something goes wrong.");
		}
		return "/home";
	}

}