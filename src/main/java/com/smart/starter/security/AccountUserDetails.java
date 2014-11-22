package com.smart.starter.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smart.starter.data.model.Role;
import com.smart.starter.data.model.User;

public class AccountUserDetails implements UserDetails {

	private static final long serialVersionUID = -3435994195239211157L;
	
	private final User account;
	
	public AccountUserDetails(User account) {
		this.account = account;
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		  if (authorities != null) {
		    for (Role role : account.getRoles()) {
		    	authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		    }
		  }
		  return authorities;
//		GrantedAuthority authority = new GrantedAuthorityImpl{return "USER";};
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		return account.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * @return the account
	 */
	public User getAccount() {
		return account;
	}

}
