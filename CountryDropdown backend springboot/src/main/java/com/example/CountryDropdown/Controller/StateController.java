package com.example.CountryDropdown.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CountryDropdown.Entity.City;
import com.example.CountryDropdown.Service.StateService;

@RestController
@RequestMapping("/api/country")
@CrossOrigin(origins = "http://localhost:5173")
public class StateController {
	
	@Autowired
	private StateService state_service;
	
	@GetMapping("/{stateName}/cities")
	public List<City> getCitiesByStateName(@PathVariable String stateName){
		return state_service.getCitiesByStateName(stateName);
	}
}
