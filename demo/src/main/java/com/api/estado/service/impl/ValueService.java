package com.api.estado.service.impl;

import com.api.estado.DTO.ValueDTO;
import com.api.estado.model.Updates;

public interface ValueService {

	void save(Updates updates);
	
	ValueDTO findAll();

}
