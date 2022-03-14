package com.api.estado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.api.estado.DTO.ValueDTO;
import com.api.estado.model.Updates;
import com.api.estado.service.impl.ValueService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@SpringBootApplication
@EnableScheduling
public class ApiController {
	
	@Autowired
	private ValueService valueService;
	
	@Scheduled(fixedDelay = 300000L)
	public void getUpdates() {
	
	String url = "https://api.msrc.microsoft.com/cvrf/v2.0/updates";
	RestTemplate restTemplate = new RestTemplate();
	String jsons = restTemplate.getForObject(url, String.class, 200);
	Gson gson = new Gson();
	
    java.lang.reflect.Type tipo = new TypeToken<Updates>(){}.getType();
	
    Updates updates = gson.fromJson(jsons, tipo);
    
    valueService.save(updates);
    
	System.out.println("Atualizando dados na Base PostgreSQL.");
	}
	
	@CrossOrigin
	 @GetMapping("/Sys")
	    public ResponseEntity<ValueDTO> findAll(){
	        return ResponseEntity.status(HttpStatus.OK).body(valueService.findAll());
	    }
	

}
