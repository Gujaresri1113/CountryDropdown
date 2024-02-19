package com.example.CountryDropdown.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CountryDropdown.Entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{
	Country findByName(String name);
}
