package com.api.estado.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.estado.DTO.ValueDTO;
import com.api.estado.model.Value;
import com.api.estado.repository.ValueRepository;

@Service
public class UpdatesServiceImpl implements UpdatesService {
	
	@Autowired
	private ValueRepository updatesRepository;
	
	@Override
	public Value save(Value updates) {
		return updatesRepository.save(updates);
	}

	@Override
	public List<Value> findAll() {
		
		return updatesRepository.findAll();
	}

	@Override
	public Optional<Value> findById(String id) {
		
		return updatesRepository.findById(id);
	}

	@Override
	public Value update(Value updates) {
		return updatesRepository.save(updates);
	}

	@Override
	public void deleteById(String id) {
		updatesRepository.deleteById(id);
		
	}


}
