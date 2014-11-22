package com.smart.starter.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * @author Rishi, created on Nov 5, 2014
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthSuccess authSuccess;
	
	@Autowired
	private AuthFailure authFailure;
	
	@Autowired
	private EntryPointUnauthorizedHandler unauthorizedHandler;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception{
//		builder.inMemoryAuthentication()
//			.withUser("user")
//			.password("password")
//			.roles("USER");
		builder.userDetailsService(userDetailsService).passwordEncoder(new StandardPasswordEncoder());
	}
	
	@Bean  
	public ShaPasswordEncoder passwordEncoder() throws Exception {  
	  return new ShaPasswordEncoder(256);  
	} 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/css/**","/js/**","/register").permitAll()
                .anyRequest().authenticated()
            .and()
//			.exceptionHandling()
//				.authenticationEntryPoint(unauthorizedHandler)
//				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.permitAll()
//				.successHandler(authSuccess) //for HTTP 200 OK response when dealing with RESTful services
//				.failureHandler(authFailure) //for HTTP 401 UNAUTHORIZED response when dealing with RESTful services
			.and()
			.logout()
				.permitAll();
			
			
	}		
	
}
