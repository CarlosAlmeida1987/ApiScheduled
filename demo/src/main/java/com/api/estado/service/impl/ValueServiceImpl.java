package com.api.estado.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.estado.DTO.ValueDTO;
import com.api.estado.model.Updates;
import com.api.estado.model.Value;
import com.api.estado.repository.ValueRepository;

@Service
public class ValueServiceImpl implements ValueService {

	@Autowired
	private ValueRepository valueRepository;
	
	@Override
	public void save(Updates value) {
		
		for(Value update : value.getValue()) {
			valueRepository.save(update);	
		}

	}
	
	@Override
	public ValueDTO findAll() {
		List<Value> value = valueRepository.findAll();
		ValueDTO valueDto = new ValueDTO();
		
		valueDto.setUpdates(value);
		
		return valueDto;
	}
}
