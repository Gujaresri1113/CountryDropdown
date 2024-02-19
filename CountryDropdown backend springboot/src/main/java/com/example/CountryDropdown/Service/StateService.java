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
public class StateService {
	
	@Autowired
	private StateRepository state_repo;
	
	@Autowired
	private CityRepository city_repo;
	
	
	public List<State> getAllStates() {
        return state_repo.findAll();
    }

    public State getStateByName(String stateName) {
        return state_repo.findByName(stateName);
    }

    public List<City> getCitiesByStateName(String stateName) {
        State state = state_repo.findByName(stateName);
        if (state != null) {
            return city_repo.findByStateId(state.getId());
        }
        return Collections.emptyList();
    }
}
