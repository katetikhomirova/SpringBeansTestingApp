package com.kture.spring.web.controllers;


import java.util.Locale;



//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class ForgotPassword {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPasPage(Locale locale, Model model) {		
		return "forgotPassword";
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public @ResponseBody String sendPas(Locale locale, Model model) {	
		//ObjectMapper mapper = new ObjectMapper();		
		return "success";
	}	
}