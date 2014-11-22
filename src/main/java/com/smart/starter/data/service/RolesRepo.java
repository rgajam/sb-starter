package com.smart.starter.data.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.smart.starter.data.model.Role;

public interface RolesRepo extends CrudRepository<Role, Integer>{
	List<Role> findAll();
}
