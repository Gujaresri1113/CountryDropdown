package com.example.CountryDropdown.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="state")
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="state_id")
	private Long id;
	
	@Column(name="state_name")
	private String name;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="country_id")
	private Country country;
	
	
	@OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
	private List<City> cities;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	public List<City> getCities() {
		return cities;
	}


	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	
	
}
