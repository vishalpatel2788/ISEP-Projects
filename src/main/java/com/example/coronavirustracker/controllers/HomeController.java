package com.example.coronavirustracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.coronavirustracker.models.CountryDTO;
import com.example.coronavirustracker.models.Global;
import com.example.coronavirustracker.models.Message;
import com.example.coronavirustracker.models.StateDTO;
import com.example.coronavirustracker.services.APIGlobalData;
import com.example.coronavirustracker.services.IndiaAPIData;
import com.example.coronavirustracker.services.MessageService;


@Controller
public class HomeController {


    @Autowired
    private MessageService msgService;
    
    @Autowired
    private APIGlobalData apiGlobalData;

    
    @GetMapping("/countries")
    public String countries(Model model) {
    	
    	CountryDTO cDTO = APIGlobalData.getCountryData();
    	model.addAttribute("countries", cDTO.getCountries());
    	//System.out.println("\n\n" + cDTO.getCountries().get(0).toString());
        return "countries";
    }
    
    @GetMapping({"/" , "/index"})
     public String index(Model model){
    	Global global = apiGlobalData.getGlobalData();
        model.addAttribute("NewConfirmed", global.getNewConfirmed());
        model.addAttribute("NewDeaths", global.getNewDeaths());
        model.addAttribute("NewRecovered", global.getNewRecovered());
        model.addAttribute("TotalConfirmed", global.getTotalConfirmed());
        model.addAttribute("TotalDeaths", global.getTotalDeaths());
        model.addAttribute("TotalRecovered", global.getTotalRecovered());
    	//System.out.println("\n\n\n\n\n"+ global.toString());
    	return "index" ;
     } 
    
    @GetMapping("/about")
    public String about(){
   	 return "about" ;
    } 
    
    @GetMapping("/symptoms")
    public String symptoms(){
   	 return "symptoms" ;
    } 
    
    @GetMapping("/prevention")
    public String prevention(){
   	 return "prevention" ;
    } 
    
    @GetMapping("/indiacoronalive")
    public String indiacoronalive(Model model){
    	StateDTO sDTO = IndiaAPIData.getStateData();
    	model.addAttribute("statewise", sDTO.getstatewise());
   	 return "indiacoronalive" ;
    }        
    
    @GetMapping("/contact")
    public String contact(Model model){
   	 	model.addAttribute("message", new Message());
    	return "contact" ;
    } 
    
    @PostMapping("/contact")
    public String processForm(@ModelAttribute Message message) {
    	//System.out.println("\nForm Data Received\n" + message.getName());
    	if(msgService.insertMessage(message)) {
    		System.out.println("\n\n\nSuccessful");
    	}
    	
        return "contact";
    }
   
    
}
