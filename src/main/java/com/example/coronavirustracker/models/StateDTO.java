package com.example.coronavirustracker.models;

import java.util.ArrayList;
import java.util.List;

public class StateDTO {
	
	private List<State> states;

    public StateDTO() {
    	this.states = new ArrayList<>();
    }
    
    public StateDTO(List<State> statewise) {
    	this.states = statewise;
    }

	public List<State> getstatewise() {
		return states;
	}

	public void setStatewise(List<State> statewise) {
		this.states = statewise;
	}
    
	public void addStatewise(State state) {
		this.states.add(state);
	}
}
