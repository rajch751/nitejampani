package com.rollout.masking.dataApplication.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollout.masking.dataApplication.dto.JsonClassDTO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@RestController
public class RolloutController {
	
	
	 @RequestMapping(value="/getMaskedOutput", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public  <T> ResponseEntity<Object> getHeaders(@RequestHeader(value="Accept") String acceptType,@RequestBody JsonClassDTO<T> jobject) {
		 
		 Object obj=jobject.getJsonData();
		 
		 Gson gson = new Gson();
		 String json = gson.toJson(obj);

		
		 
		 com.google.gson.JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
		
		 
	//	 JSONObject jsonData = (JSONObject) jobject.getJsonData(); 
         
		 String dataMasked=jobject.getJsonDataMasked();
		 
		 String dataUnmasked=jobject.getJsonArrayDataMasked();
		 
		 String[] maskedDataSplit=dataMasked.split(",");
		 
		 for(int i=0;i<maskedDataSplit.length;i++)
		 
		 jsonObject.addProperty(maskedDataSplit[i], "********");
		 
		 	
		 System.out.println("updated json"+jsonObject);
		 
		 String jsonupdated = gson.toJson(jsonObject);
		
		 
		return new ResponseEntity<>(jsonupdated, HttpStatus.OK);
	    
	  
	  }

}
