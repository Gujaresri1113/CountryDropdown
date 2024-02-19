package com.example.CountryDropdown.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CountryDropdown.Entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{
	State findByName(String name);
	
	List<State> findByCountryId(Long countryId);
}
