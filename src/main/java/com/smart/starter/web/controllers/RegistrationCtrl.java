package com.smart.starter.web.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.starter.data.model.User;
import com.smart.starter.data.service.UsersRepo;

/**
 * 
 * @author Rishikesh Gajam
 *
 */
@Controller
public class RegistrationCtrl {
	
	UsersRepo usersRepository;

	@Autowired
	RegistrationCtrl(UsersRepo usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	@RequestMapping("/register")
	public String register(Locale locale, Model model) {	
		return "registration";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registera(Locale locale, 
			@RequestParam(value="username", required=false) String username,
			@RequestParam(value="password", required=false) String password,
			@RequestParam(value="firstName", required=false) String firstName,
			@RequestParam(value="lastName", required=false) String lastName,
			@RequestParam(value="email", required=false) String email,
			Model model) {	
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		User user = new User();
		user.setUsername(username);
		user.setPassword(encoder.encode(password));
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
//		user.setStatus(status);
//		List<Roles> roles = new ArrayList<>();
//		user.setRoles(roles);
		usersRepository.save(user);
		return "login";
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
