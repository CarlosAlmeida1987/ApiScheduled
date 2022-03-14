package com.api.estado.model;

import java.util.ArrayList;
import java.util.List;

public class Updates{
	
	List<Value> value= new ArrayList<Value>();

	public List<Value> getValue() {
		return value;
	}

	public void setValue(List<Value> value) {
		this.value = value;
	}

}
