package com.smart.starter.web.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
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
}
