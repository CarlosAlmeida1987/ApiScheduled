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

import com.api.estado.exceptions.ResourceNotFoundException;
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
	    	boolean isNumeric = verifyExists(id);
	    	if(isNumeric) {
	    		throw new ResourceNotFoundException("Não encontrou a variável Valida: " + id);
	    	}
	        return ResponseEntity.status(HttpStatus.OK).body(updatesService.findById(id));
	    }
	    
	    @PostMapping
	    public ResponseEntity<Value> create(@RequestBody Value updates){
	    	if(updates == null) 
	    		throw new ResourceNotFoundException("Não encontrou a variável um Objeto Updates para Inserir");
	        return ResponseEntity.status(HttpStatus.CREATED).body(updatesService.save(updates));
	    }
	    
	    @PutMapping
	    public ResponseEntity<Value> update(@RequestBody Value updates){
	    	if(updates == null) 
	    		throw new ResourceNotFoundException("Não encontrou a variável um Objeto Updates para Atualizar");
	        return ResponseEntity.status(HttpStatus.OK).body(updatesService.update(updates));
	    }
	    
	    @CrossOrigin
	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> delete(@PathVariable String id){
	    	if(id == null) 
	    		throw new ResourceNotFoundException("Não encontrou a variável ID para DELETA");
	    	updatesService.deleteById(id);
	        return ResponseEntity.status(HttpStatus.OK).build();
	    }
	    
	    private boolean verifyExists(String id) {
	    	boolean isNumeric = true;
	        for (int i = 0; i < id.length(); i++) {
	            if (!Character.isDigit(id.charAt(i))) {
	                isNumeric = false;
	            }
	        }
	        return isNumeric;
	    }

}
