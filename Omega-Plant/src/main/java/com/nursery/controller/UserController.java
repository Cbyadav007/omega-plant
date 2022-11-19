package com.nursery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nursery.exception.PlantException;
import com.nursery.exception.PlanterException;
import com.nursery.exception.SeedException;
import com.nursery.model.Plant;
import com.nursery.model.Planter;
import com.nursery.model.Seed;
import com.nursery.service.PlantServices;
import com.nursery.service.PlanterService;
import com.nursery.service.SeedServices;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private SeedServices seedService;
	
	@Autowired
	private PlantServices plantService;
	
	@Autowired
	private PlanterService planterService;
	
	
	
//////////////////////////////////////////   Plant		///////////////////////////////////////////////////////////////	
	
	@GetMapping("/getAllPlant")
	public ResponseEntity<List<Plant>> getAllPlantsHandler() throws PlantException
	{
		List<Plant> plants = plantService.getAllPlants();
		
		return new ResponseEntity<List<Plant>>(plants,HttpStatus.OK);
	}
	
	
	@GetMapping("/getPlantById/{plantid}")
	public ResponseEntity<Plant> getPlantByIdHandler(@PathVariable("id") Integer plantId) throws PlantException
	{
		Plant plant = plantService.getPlantById(plantId);
		
		return new ResponseEntity<Plant>(plant,HttpStatus.OK);
	}
	
	@GetMapping("/searchPlant/{plantname}")
	public ResponseEntity<List<Plant>> searchPlantHandler(@PathVariable("plantname") String commonName) throws PlantException
	{
		List<Plant> plants = plantService.getPlantBycommonName(commonName);
		
		return new ResponseEntity<List<Plant>>(plants,HttpStatus.OK);
	}
	
	@GetMapping("/getPlantByType/{planttype}")
	public ResponseEntity<List<Plant>> getPlantByTypeHandler(@PathVariable("type") String typeOfPlant) throws PlantException
	{
		List<Plant> plants = plantService.getplantByTypeOfPlant(typeOfPlant);
		
		return new ResponseEntity<List<Plant>>(plants,HttpStatus.OK);
	}
	
//////////////////////////////////////////			Plant		///////////////////////////////////////////////////////////////	
	
	
//////////////////////////////////////////		Seed		///////////////////////////////////////////////////////////////		
	
	@GetMapping("/getAllSeed")
	public ResponseEntity<List<Seed>> getAllseedssHandler() throws SeedException
	{
		List<Seed> seeds = seedService.getAllSeeds();
		
		return new ResponseEntity<List<Seed>>(seeds,HttpStatus.OK);
	}
	
	
	@GetMapping("/getSeedById/{seedid}")
	public ResponseEntity<Seed> getSeedByIdHandler(@PathVariable("seedid") Integer seedId) throws SeedException
	{
		Seed seed = seedService.getSeedById(seedId);
		
		return new ResponseEntity<Seed>(seed,HttpStatus.OK);
	}
	
	@GetMapping("/getSeedByType/{seedtype}")
	public ResponseEntity<List<Seed>> getSeedByTypeHandler(@PathVariable("seedtype") String typeOfseeds) throws SeedException
	{
		List<Seed> seeds = seedService.getseedByTypeOfSeed(typeOfseeds);
		
		return new ResponseEntity<List<Seed>>(seeds,HttpStatus.OK);
	}
	
	@GetMapping("/searchSeed/{seedname}")
	public ResponseEntity<List<Seed>> searchSeedHandler(@PathVariable("seedname") String commonName) throws SeedException
	{
		List<Seed> seeds = seedService.getSeedBycommonName(commonName);
		
		return new ResponseEntity<List<Seed>>(seeds,HttpStatus.OK);
	}
	
	
//////////////////////////////////////////			Seed			///////////////////////////////////////////////////////////////	
	
	
//////////////////////////////////////////			Planter			///////////////////////////////////////////////////////////////	
	
	@GetMapping("/getAllPlanter")
	public ResponseEntity<List<Planter>> getAllPlanterHandler() throws PlanterException
	{
		List<Planter> planter = planterService.viewAllPlanters();
		
		return new ResponseEntity<List<Planter>>(planter,HttpStatus.OK);
	}
	
	@GetMapping("/getPlanterById/{planterid}")
	public ResponseEntity<Planter> getPlanterByIdHandler(@PathVariable("planterid") Integer planterId) throws PlanterException
	{
		Planter planter = planterService.viewPlanter(planterId);
		
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	
	@GetMapping("/getPlanterByShape/{plantershape}")
	public ResponseEntity<Planter> getPlanterByShapeHandler(@PathVariable("plantershape") String planterShape) throws PlanterException
	{
		Planter planter = planterService.viewPlanter(planterShape);
		
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	
	@GetMapping("/getPlanterBetweenPrice/{mincost}/{maxcost}")
	public ResponseEntity<List<Planter>> getPlanterBetweenPriceHandler(@PathVariable("mincost") Integer minCost, @PathVariable("maxcost") Integer maxCost ) throws PlanterException
	{
		List<Planter> planter = planterService.viewAllPlanters(minCost, maxCost);
		
		return new ResponseEntity<List<Planter>>(planter,HttpStatus.OK);
	}
	
	@GetMapping("/getPlanterCostById/{planterid}")
	public ResponseEntity<Integer> getPlanterCostByIdHandler(@PathVariable("planterid") Integer planterId) throws PlanterException
	{
				Integer cost = planterService.viewcost(planterId);
		
		return new ResponseEntity<Integer>(cost,HttpStatus.OK);
	}
	
		
	
//////////////////////////////////////////			Planter			///////////////////////////////////////////////////////////////	
}
