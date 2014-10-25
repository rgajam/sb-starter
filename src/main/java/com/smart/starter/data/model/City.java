package com.smart.starter.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author Rishi
 *
 */
@Entity
@Table(name="CITY")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City {
	
	@Id 
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="COUNTRYCODE")
	private String country;
	
	@Column(name="DISTRICT")
	private String district;
	
	@Column(name="POPULATION")
	private int population;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", country=" + country
				+ ", district=" + district + ", population=" + population + "]";
	}
	
}
