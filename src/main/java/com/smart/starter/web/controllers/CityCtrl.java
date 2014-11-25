package com.smart.starter.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.starter.data.model.City;
import com.smart.starter.data.service.CityRepo;

/**
 * Handles requests for City
 * 
 * @author Rishi
 *
 */
@Controller
public class CityCtrl {

	CityRepo cityRepository;

	@Autowired
	CityCtrl(CityRepo cityRepository) {
		this.cityRepository = cityRepository;
	}

	@ModelAttribute("citiesCount")
	public long getCount() {
		return cityRepository.count();
	}

	@ModelAttribute("cities")
	public List<City> getCities() {
		return cityRepository.findAll();
	}

	@RequestMapping("/cities")
	public String showCities() {
		return "city/show-cities";
	}
	
	@RequestMapping("/citiesPage")
	public String showCitiesPage(@RequestParam(value= "page", defaultValue="0") int page, @RequestParam(value= "size", defaultValue="20") int size,  Model model) {
		model.addAttribute("citiesPage", cityRepository.findAll(new PageRequest(page, size)));
		return "city/show-cities-page";
	}
}
