package com.example.CountryDropdown.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CountryDropdown.Entity.City;
import com.example.CountryDropdown.Service.CityService;

@RestController
@RequestMapping("/api/country")
@CrossOrigin(origins = "http://localhost:5173")
public class CityController {
	
	@Autowired
	private CityService city_service;
	
	
	@GetMapping("/{stateName}")
	public List<City> getCitiesByStateName(@PathVariable String stateName){
		return city_service.getCitiesByStateName(stateName);
	}
	
}
