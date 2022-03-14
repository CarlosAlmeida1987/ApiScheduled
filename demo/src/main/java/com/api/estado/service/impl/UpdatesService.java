package com.api.estado.service.impl;

import java.util.List;
import java.util.Optional;

import com.api.estado.model.Value;

public interface UpdatesService {
	
	Value save(Value updates);
		
	List<Value> findAll();
	
	Value update(Value updates);
	
	void deleteById(String id);

	Optional<Value> findById(String id);
	
	

}
