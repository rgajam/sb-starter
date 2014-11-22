package com.smart.starter.web.controllers;

import java.util.Locale;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.starter.data.model.User;

/**
 * Handles requests for the application home page.
 * 
 * @author Rishi
 * 
 */
@Controller
public class HomeCtrl {
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
//		User activeUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		model.addAttribute("user", activeUser);
		return "index";
	}
	
}
