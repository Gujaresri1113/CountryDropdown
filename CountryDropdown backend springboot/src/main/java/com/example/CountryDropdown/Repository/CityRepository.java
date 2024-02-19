package com.example.CountryDropdown.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CountryDropdown.Entity.City;

public interface CityRepository extends JpaRepository<City, Long>{
	City findByName(String name);
	
	List<City> findByStateId(Long state_id);
}
