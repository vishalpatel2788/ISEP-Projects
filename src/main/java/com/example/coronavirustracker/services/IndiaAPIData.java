package com.example.coronavirustracker.services;

import com.example.coronavirustracker.models.State;
import com.example.coronavirustracker.models.StateDTO;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class IndiaAPIData {

	private final static String APIurl = "https://api.covid19india.org/data.json";
    
    public static StateDTO getStateData() {
 	
 	StateDTO sDTO = new StateDTO();
		JsonParser jParser = new JsonParser();
		
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = null;
		try {
			response = Unirest.get(APIurl).asString();
			System.out.println(response.getStatus() + "\n" + response.getStatusText());
			
			//Check if request was successful and only then retrieve data.
			if(response.getStatus() == 200) {
				
				JsonElement je = jParser.parse(response.getBody().toString());
		
				JsonObject jsonObject = je.getAsJsonObject();
	 
				//Retrieve only the data under the 'statewise' object
				je = jsonObject.get("statewise");
				
				//Save data as a Json Array
				JsonArray list = je.getAsJsonArray();
				
				for(int i = 0; i< list.size(); i++) {
					JsonObject temp = list.get(i).getAsJsonObject();
					State state = new State();
					
					state.setState(temp.get("state").toString().replace('"',  ' '));
					state.setActive(temp.get("active").toString().replace('"',  ' '));
					state.setConfirmed(temp.get("confirmed").toString().replace('"',  ' '));
					state.setDeaths(temp.get("deaths").toString().replace('"',  ' '));
					state.setRecovered(temp.get("recovered").toString().replace('"',  ' '));
					state.setLastupdatedtime(temp.get("lastupdatedtime").toString().replace('"',  ' '));
					sDTO.addStatewise(state);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sDTO;
	}
}
