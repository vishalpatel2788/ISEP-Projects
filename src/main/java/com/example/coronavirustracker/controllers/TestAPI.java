package com.example.coronavirustracker.controllers;

import java.io.FileReader;

import com.example.coronavirustracker.models.Country;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TestAPI {

	private final static String APIurl = "https://api.covid19api.com/summary";

	public void getData() {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = null;
		try {
			response = Unirest.get("https://api.covid19api.com/summary")
			  .asString();
			
			//Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonParser jp = new JsonParser();
			JsonElement je = jp.parse(response.getBody().toString());
			JsonObject jo =	je.getAsJsonObject();
			JsonObject jsonObj = jo.getAsJsonObject("Global");
			//String prettyJsonString = gson.toJson(je);
	        //JsonArray ja = je.getAsJsonArray();
			//Global global = new Gson().fromJson(jsonObj.toString(), Global.class);
			//jsonObj.get
			System.out.println(jsonObj.toString() + "\n" + jsonObj.get("NewConfirmed").toString());
			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static Country getCountryData() {

		Country country = new Country();
    	
    	Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = null;
		//Check if request was successful and only then retrieve data.
		//if(response.getStatus() == 200) {
		if(true) {	
			//JsonParser jp = new JsonParser();
			//JsonElement je = jp.parse(response.getBody().toString());
			JsonElement je = TestAPI.getJSONFile();
			JsonObject jsonObj =	je.getAsJsonObject();
			
			//Extract only Global object
			je = jsonObj.getAsJsonObject("Countries");

			JsonArray list = je.getAsJsonArray();
						
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
	
	public static JsonObject getJSONFile() {
		JsonParser parser = new JsonParser();
	
		try {
			JsonElement obj = parser.parse(new FileReader("E:\\Coding\\Java\\Java EE workspace\\ISEP-Project\\src\\main\\resources\\static\\summary.json"));
 
			JsonObject jsonObject = obj.getAsJsonObject();
 
			return jsonObject;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void test() {
		JsonParser parser = new JsonParser();
		Country country = new Country();
		try {
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	public Country getCountryData() {
    	Country country = new Country();
    	
    	Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = null;
		try {
			//response = Unirest.get(APIurl).asString();
			//System.out.println(response.getStatus() + "\n" + response.getStatusText());
			//Check if request was successful and only then retrieve data.
			//if(response.getStatus() == 200) {
				
			
			
			
				JsonParser jp = new JsonParser();
				JsonElement je = jp.parse(response.getBody().toString());
				JsonObject jo =	je.getAsJsonObject();
				
				//Extract only Global object
				JsonObject jsonObj = jo.getAsJsonObject("Countries");
				
				//System.out.println(jsonObj.toString() + "\n");
				
				//Save details to Java bean using setters
				
				
				
				country.setNewConfirmed(jsonObj.get("NewConfirmed").toString());
				country.setNewDeaths(jsonObj.get("NewDeaths").toString());
				country.setNewRecovered(jsonObj.get("NewRecovered").toString());
				country.setTotalConfirmed(jsonObj.get("TotalConfirmed").toString());
				country.setTotalDeaths(jsonObj.get("TotalDeaths").toString());
				country.setTotalRecovered(jsonObj.get("TotalRecovered").toString());
				JsonArray jsonArray = jo.getAsJsonArray("Global");
				
				System.out.println(jsonArray.get(0).toString() + "\n");
				for(int i = 0; i< jsonArray.size(); i++) {
					
					jsonArray.get(i).toString();
					//Save details to Java bean using setters
					country.setNewConfirmed(jsonObj.get("NewConfirmed").toString());
					country.setNewDeaths(jsonObj.get("NewDeaths").toString());
					country.setNewRecovered(jsonObj.get("NewRecovered").toString());
					country.setTotalConfirmed(jsonObj.get("TotalConfirmed").toString());
					country.setTotalDeaths(jsonObj.get("TotalDeaths").toString());
					country.setTotalRecovered(jsonObj.get("TotalRecovered").toString());
				}
			//System.out.println(global.toString());
				
				//If API request fails prints error
			//} else
				//System.out.println(response.getStatus() + "\n" + response.getStatusText());
			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
		return country;
    }
	
	*/
	public static void main(String[] args) {
		
		TestAPI api = new TestAPI();
		api.test();
		
	}

}
