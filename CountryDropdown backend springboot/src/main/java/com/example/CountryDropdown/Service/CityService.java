package com.example.CountryDropdown.Service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CountryDropdown.Entity.City;
import com.example.CountryDropdown.Entity.State;
import com.example.CountryDropdown.Repository.CityRepository;
import com.example.CountryDropdown.Repository.StateRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository city_repo;
	
	@Autowired
	private StateRepository state_repo;
	
	public List<City> getAllCities() {
        return city_repo.findAll();
    }

    public City getCityByName(String cityName) {
        return city_repo.findByName(cityName);
    }

    public List<City> getCitiesByStateName(String stateName) {
        State state = state_repo.findByName(stateName);
        if (state != null) {
            return city_repo.findByStateId(state.getId());
        }
        return Collections.emptyList();
    }
    }
