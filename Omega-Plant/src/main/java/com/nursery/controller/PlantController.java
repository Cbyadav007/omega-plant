package com.nursery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nursery.exception.PlantException;
import com.nursery.model.Plant;
import com.nursery.service.PlantServices;



@RestController
public class PlantController {

	@Autowired
	private PlantServices plantServices;

	
	
	
	@GetMapping("/showplants")
	public ResponseEntity<List<Plant>> getAllPlantsHandler() throws PlantException{
		
		 List<Plant> plants= plantServices.getAllPlants();
		
		return new ResponseEntity<List<Plant>>(plants,HttpStatus.OK);
		
		
	}

	
	@GetMapping("/showplant/{pid}")
	public ResponseEntity<Plant> getPlantByIdHandler(@PathVariable("pid") Integer id) throws PlantException{
		
		
		Plant plant= plantServices.getPlantById(id);
		
		return new ResponseEntity<Plant>(plant,HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/showplants/{name}")
	public ResponseEntity<List<Plant>> getPlantByNameHandler(@PathVariable("name") String Name) throws PlantException{
		
		
		List<Plant> plant= plantServices.getPlantBycommonName(Name);
		
		return new ResponseEntity<List<Plant>>(plant,HttpStatus.OK);
		
	}
	
	

	@GetMapping("/showplantsList/{type}")
	public ResponseEntity<List<Plant>> getPlantBytypeOfPlantHandler(@PathVariable("type") String type) throws PlantException{
		
		
		List<Plant> plant= plantServices.getplantByTypeOfPlant(type);
		
		return new ResponseEntity<List<Plant>>(plant,HttpStatus.OK);
		
	}
	
	
}