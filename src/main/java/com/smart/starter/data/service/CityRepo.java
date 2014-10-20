package com.smart.starter.data.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.smart.starter.data.model.City;

public interface CityRepo extends CrudRepository<City, Integer>{
	List<City> findAll();
}
