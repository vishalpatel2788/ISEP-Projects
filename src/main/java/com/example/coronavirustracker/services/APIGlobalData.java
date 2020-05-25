package com.example.coronavirustracker.services;

import java.io.FileReader;

import org.springframework.stereotype.Service;

import com.example.coronavirustracker.models.Country;
import com.example.coronavirustracker.models.CountryDTO;
import com.example.coronavirustracker.models.Global;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class APIGlobalData {

	private final static String APIurl = "https://api.covid19api.com/summary";
    
    public Global getGlobalData() {

    	Global global = new Global();

    	Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = null;
		try {
			response = Unirest.get(APIurl).asString();
			System.out.println(response.getStatus() + "\n" + response.getStatusText());
			//Check if request was successful and only then retrieve data.
			if(response.getStatus() == 200) {
				
				JsonParser jp = new JsonParser();
				JsonElement je = jp.parse(response.getBody().toString());
				JsonObject jo =	je.getAsJsonObject();
				
				//Extract only Global object
				JsonObject jsonObj = jo.getAsJsonObject("Global");
				
				//System.out.println(jsonObj.toString() + "\n");
				
				//Save details to Java bean using setters
				global.setNewConfirmed(jsonObj.get("NewConfirmed").toString());
				global.setNewDeaths(jsonObj.get("NewDeaths").toString());
				global.setNewRecovered(jsonObj.get("NewRecovered").toString());
				global.setTotalConfirmed(jsonObj.get("TotalConfirmed").toString());
				global.setTotalDeaths(jsonObj.get("TotalDeaths").toString());
				global.setTotalRecovered(jsonObj.get("TotalRecovered").toString());
			
			//System.out.println(global.toString());
				
				//If API request fails prints error
			}else
				System.out.println(response.getStatus() + "\n" + response.getStatusText());
			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return global;
    }

    public static CountryDTO getCountryData() {
    	
    	CountryDTO cDTO = new CountryDTO();
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
	 
				//Retrieve only the data under the 'Countries' object
				je = jsonObject.get("Countries");
				
				//Save data as a Json Array
				JsonArray list = je.getAsJsonArray();
				
				for(int i = 0; i< list.size(); i++) {
					JsonObject temp = list.get(i).getAsJsonObject();
					Country country = new Country();
					
					country.setCountry(temp.get("Country").toString().replace('"',  ' '));
					country.setCountryCode(temp.get("CountryCode").toString().replace('"',  ' '));
					country.setNewConfirmed(temp.get("NewConfirmed").toString());
					country.setNewDeaths(temp.get("NewDeaths").toString());
					country.setNewRecovered(temp.get("NewRecovered").toString());
					country.setTotalConfirmed(temp.get("TotalConfirmed").toString());
					country.setTotalDeaths(temp.get("TotalDeaths").toString());
					country.setTotalRecovered(temp.get("TotalRecovered").toString());
					cDTO.addCountry(country);
					//System.out.println(temp.get("Country"));
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cDTO;
	}
    
	public static void main(String[] args) {
	
		
	}


/*
	public static Country old() {

		Country country = new Country();
    	
    	Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = null;
		//Check if request was successful and only then retrieve data.
		//if(response.getStatus() == 200) {
		if(true) {	
			//JsonParser jp = new JsonParser();
			//JsonElement je = jp.parse(response.getBody().toString());
			JsonElement je = TestAPI.getJSONFile();
			JsonObject jo =	je.getAsJsonObject();
			JsonElement obj = parser.parse(new FileReader("E:\\Coding\\Java\\Java EE workspace\\ISEP-Project\\src\\main\\resources\\static\\summary.json"));
			 
			JsonObject jsonObject = obj.getAsJsonObject();
			
			obj = jsonObject.get("Countries");
			
			JsonArray list = obj.getAsJsonArray();
			
			for(int i = 0; i< list.size(); i++) {
				JsonObject temp = list.get(i).getAsJsonObject();
				
				country.setCountry(temp.get("Country").toString());
				country.setNewConfirmed(temp.get("NewConfirmed").toString());
				country.setNewDeaths(temp.get("NewDeaths").toString());
				country.setNewRecovered(temp.get("NewRecovered").toString());
				country.setTotalConfirmed(temp.get("TotalConfirmed").toString());
				country.setTotalDeaths(temp.get("TotalDeaths").toString());
				country.setTotalRecovered(temp.get("TotalRecovered").toString());
				
				System.out.println(country.toString());
			}
			
			
			//If API request fails prints error
		} else
			System.out.println(response.getStatus() + "\n" + response.getStatusText());
    	
    	
		return country;
	}
*/
}
