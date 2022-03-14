package com.api.estado.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.estado.model.Value;
import com.api.estado.service.impl.UpdatesService;

@RestController
@RequestMapping("api/v1/updates")
public class UpdatesController {
	
	 @Autowired
	 private UpdatesService updatesService;
	 @CrossOrigin
	 @GetMapping
	    public ResponseEntity<List<Value>> findAll(){
	        return ResponseEntity.status(HttpStatus.OK).body(updatesService.findAll());
	    }
	 
	    @CrossOrigin
	    @GetMapping("/{id}")
	    public ResponseEntity<Optional<Value>> findById(@PathVariable String id){
	        return ResponseEntity.status(HttpStatus.OK).body(updatesService.findById(id));
	    }
	    
	    @PostMapping
	    public ResponseEntity<Value> create(@RequestBody Value updates){
	        return ResponseEntity.status(HttpStatus.CREATED).body(updatesService.save(updates));
	    }
	    
	    @PutMapping
	    public ResponseEntity<Value> update(@RequestBody Value updates){
	        return ResponseEntity.status(HttpStatus.OK).body(updatesService.update(updates));
	    }
	    
	    @CrossOrigin
	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> delete(@PathVariable String id){
	    	updatesService.deleteById(id);
	        return ResponseEntity.status(HttpStatus.OK).build();
	    }

}
