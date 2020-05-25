package com.example.coronavirustracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class State {

	private String state, active,confirmed,deaths,recovered,lastupdatedtime;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

	public String getDeaths() {
		return deaths;
	}

	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}

	public String getRecovered() {
		return recovered;
	}

	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}

	public String getLastupdatedtime() {
		return lastupdatedtime;
	}

	public void setLastupdatedtime(String lastupdatedtime) {
		this.lastupdatedtime = lastupdatedtime;
	}
	
	@Override
	public String toString() {
		return "state=" + state + ", active=" + active + ", confirmed=" + confirmed
				+ ", deaths=" + deaths + ", recovered=" + recovered + ", lastupdatedtime=" + lastupdatedtime
				+ "\n";
	}
}
