package com.smart.starter.data.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.smart.starter.data.model.City;

/**
 * 
 * @author Rishi
 *
 */
public interface CityRepo extends PagingAndSortingRepository<City, Integer>{
	List<City> findAll();
	
	Page<City> findAll(Pageable pageable);
}