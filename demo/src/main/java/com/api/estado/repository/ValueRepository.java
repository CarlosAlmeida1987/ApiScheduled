package com.api.estado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.estado.model.Value;

public interface ValueRepository extends JpaRepository<Value, String>{

}
