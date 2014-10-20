package com.smart.starter.web.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String showCities(Locale locale, Model model) {
		return "city/showCities";
	}
}
