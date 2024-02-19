package com.example.CountryDropdown.Service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CountryDropdown.Entity.City;
import com.example.CountryDropdown.Entity.Country;
import com.example.CountryDropdown.Entity.State;
import com.example.CountryDropdown.Repository.CityRepository;
import com.example.CountryDropdown.Repository.CountryRepository;
import com.example.CountryDropdown.Repository.StateRepository;


@Service
public class CountryService {
	
	@Autowired
	private CountryRepository country_repo;
	
	@Autowired
	private StateRepository state_repo;
	
	@Autowired
	private CityRepository city_repo;
	
	
	public List<Country> getAllCountries(){
		return country_repo.findAll();
	}
	
	public Country getCountryName(String countryName) {
		return country_repo.findByName(countryName);
	}
	
	public List<State> getStatesByCountryName(String countryName){
		Country country = country_repo.findByName(countryName);
		if(country != null) {
			return state_repo.findByCountryId(country.getId());
		}
		return Collections.emptyList();
	}
	
	public List<City> getCitiesWithState(String stateName){
		State state = state_repo.findByName(stateName);
		if(state != null) {
			return city_repo.findByStateId(state.getId());
		}
		return Collections.emptyList();
	}
	
}
