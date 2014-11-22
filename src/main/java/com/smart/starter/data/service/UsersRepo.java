package com.smart.starter.data.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.smart.starter.data.model.User;

public interface UsersRepo extends CrudRepository<User, Integer>{
	List<User> findAll();
	
	User findUserByUsername(String username);
}
