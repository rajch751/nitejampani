package com.rollout.masking.dataApplication.dto;

import java.awt.List;
import java.util.ArrayList;

public class JsonClassDTO <T>{
	
	T jsonData;
	
	String jsonDataMasked;
	
	String jsonArrayDataMasked;

	public T getJsonData() {
		return jsonData;
	}

	public void setJsonData(T jsonData) {
		this.jsonData = jsonData;
	}

	public String getJsonDataMasked() {
		return jsonDataMasked;
	}

	public void setJsonDataMasked(String jsonDataMasked) {
		this.jsonDataMasked = jsonDataMasked;
	}

	public String getJsonArrayDataMasked() {
		return jsonArrayDataMasked;
	}

	public void setJsonArrayDataMasked(String jsonArrayDataMasked) {
		this.jsonArrayDataMasked = jsonArrayDataMasked;
	}
	
	
	
}

	
	
	


