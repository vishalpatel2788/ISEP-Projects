package com.example.coronavirustracker.models;

import java.util.ArrayList;
import java.util.List;

public class CountryDTO {

    private List<Country> countries;

    public CountryDTO() {
    	this.countries = new ArrayList<>();
    }
    
    public CountryDTO(List<Country> countries) {
    	this.countries = countries;
    }

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
    
	public void addCountry(Country country) {
		this.countries.add(country);
	}
    
}
