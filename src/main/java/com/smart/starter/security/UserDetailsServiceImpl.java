package com.smart.starter.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smart.starter.data.model.User;
import com.smart.starter.data.service.UsersRepo;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsersRepo usersRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = usersRepo.findUserByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("No User found!");
		return new AccountUserDetails(user);
	}

}
