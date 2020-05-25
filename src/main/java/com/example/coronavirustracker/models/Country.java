package com.example.coronavirustracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Country {

	private String Country, CountryCode, newConfirmed, totalConfirmed;
	private String newDeaths, totalDeaths, newRecovered, totalRecovered;
	
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getNewConfirmed() {
		return newConfirmed;
	}
	public void setNewConfirmed(String newConfirmed) {
		this.newConfirmed = newConfirmed;
	}
	public String getTotalConfirmed() {
		return totalConfirmed;
	}
	public void setTotalConfirmed(String totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}
	public String getNewDeaths() {
		return newDeaths;
	}
	public void setNewDeaths(String newDeaths) {
		this.newDeaths = newDeaths;
	}
	public String getTotalDeaths() {
		return totalDeaths;
	}
	public void setTotalDeaths(String totalDeaths) {
		this.totalDeaths = totalDeaths;
	}
	public String getNewRecovered() {
		return newRecovered;
	}
	public void setNewRecovered(String newRecovered) {
		this.newRecovered = newRecovered;
	}
	public String getTotalRecovered() {
		return totalRecovered;
	}
	public void setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
	}
	@Override
	public String toString() {
		return "Country=" + Country + ", CountryCode=" + CountryCode + ", newConfirmed=" + newConfirmed
				+ ", totalConfirmed=" + totalConfirmed + ", newDeaths=" + newDeaths + ", totalDeaths=" + totalDeaths
				+ ", newRecovered=" + newRecovered + ", totalRecovered=" + totalRecovered + "\n";
	}
	
	
}
