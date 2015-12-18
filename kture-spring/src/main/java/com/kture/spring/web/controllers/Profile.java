package com.kture.spring.web.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kture.spring.market.MarketFactory;

@Controller
public class Profile {

	@RequestMapping(value = "/profile/{login}", method = RequestMethod.GET)
	public String signUp(@PathVariable("login") String login, Model model) {
		model.addAttribute("login", login);
		return "profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String signUp(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("funds", MarketFactory.getMarket()
					.getUserAccountByUserName(userDetail.getUsername()));

		}
		return "profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String updateFunds(@RequestParam String funds, Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			int d = Integer.parseInt(funds);
			MarketFactory.getMarket().updateFunds(userDetail.getUsername(), d);
			model.addAttribute("funds", MarketFactory.getMarket()
					.getUserAccountByUserName(userDetail.getUsername()));

		}
		return "profile";

	}

}