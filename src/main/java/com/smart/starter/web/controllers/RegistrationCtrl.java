package com.smart.starter.web.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Rishikesh Gajam
 *
 */
@Controller
public class RegistrationCtrl {
	
	@RequestMapping("/register")
	public String register(Locale locale, Model model) {	
		return "registration";
	}
	
	@RequestMapping("/login")
	public String login(Locale locale, Model model) {	
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(Locale locale, Model model) {	
		return "logout";
	}
}
