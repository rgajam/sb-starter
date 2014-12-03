package com.smart.starter.web.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smart.starter.data.model.City;
import com.smart.starter.data.service.CityRepo;

/**
 * 
 * @author Rishi
 *
 */
@RestController
@RequestMapping("/rest/city")
public class CityRestCtrl {
CityRepo cityRepository;
	
	@Autowired
	CityRestCtrl(CityRepo cityRepository){
		this.cityRepository = cityRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<City> list() {
		return this.cityRepository.findAll();
	}
	
	@RequestMapping(value="page/{size}/{page}", method=RequestMethod.GET)
	public Page<City> listPage(@PathVariable int size, @PathVariable int page) {
		return this.cityRepository.findAll(new PageRequest(page, size));
	}
}
