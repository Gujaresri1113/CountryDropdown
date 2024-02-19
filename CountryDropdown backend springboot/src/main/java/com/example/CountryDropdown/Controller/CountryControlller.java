package com.example.CountryDropdown.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CountryDropdown.Entity.Country;
import com.example.CountryDropdown.Entity.State;
import com.example.CountryDropdown.Service.CountryService;

@RestController
@RequestMapping("/api/country")
@CrossOrigin(origins = "http://localhost:5173")
public class CountryControlller {
		
	@Autowired
	private CountryService count_service;
	
	@GetMapping
	public List<Country> getAllCountries(){
		
		return count_service.getAllCountries();
	}
	
	@GetMapping("/{countryName}/states")
	public List<State> getStateByCountryName(@PathVariable String countryName){
		return count_service.getStatesByCountryName(countryName);
	}
	
}
