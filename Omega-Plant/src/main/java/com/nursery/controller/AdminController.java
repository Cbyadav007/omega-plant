package com.nursery.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nursery.exception.CustomerException;
import com.nursery.exception.LogInException;
import com.nursery.exception.OrderException;
import com.nursery.exception.PlantException;
import com.nursery.exception.PlanterException;
import com.nursery.exception.SeedException;
import com.nursery.model.AdminLoginData;
import com.nursery.model.AdminSignUp;
import com.nursery.model.LogInData;
import com.nursery.model.Orders;
import com.nursery.model.Plant;
import com.nursery.model.Planter;
import com.nursery.model.Seed;
import com.nursery.model.SignUpData;
import com.nursery.service.AdminLogInService;
import com.nursery.service.AdminSignUpService;
import com.nursery.service.OrderService;
import com.nursery.service.PlantServices;
import com.nursery.service.PlanterService;
import com.nursery.service.SeedServices;
import com.nursery.service.SignUpService;



@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private AdminSignUpService adminSignUpService;
	
	@Autowired
	private AdminLogInService adminLoginService;
	
	
	@Autowired
	private SignUpService signupservice;
	@Autowired
	private SeedServices seedservice;
	@Autowired
	private OrderService orderservice;
	
	
	@Autowired
	private PlantServices plantServices;
	
	@Autowired
	private PlanterService planterService;
	
	
////////////////////////////			Amdin - SignUp			///////////////////////////////////////////////////////	
	
	@JsonIgnore
	@PostMapping("/signUp")
	public ResponseEntity<AdminSignUp> createNewSignUpHandler(@Valid @RequestBody AdminSignUp newSignUp) throws LogInException {
		
		AdminSignUp newSignedUp =adminSignUpService.createNewSignUp(newSignUp);
		return new ResponseEntity<AdminSignUp>(newSignedUp,HttpStatus.CREATED);

	}
	
	@PutMapping("/updateSignUp")
	public ResponseEntity<AdminSignUp> updateSignUpDetailsHandler(@RequestBody AdminSignUp signUp, @RequestParam String key) throws LogInException
	{
		AdminSignUp newUpdatedSignUp = adminSignUpService.updateSignUpDetails(signUp,key);
		
		return new ResponseEntity<AdminSignUp>(newUpdatedSignUp,HttpStatus.ACCEPTED);
		
	}
	
////////////////////////////			Amdin - SignUp			///////////////////////////////////////////////////////
	
////////////////////////////			Amdin - Login			///////////////////////////////////////////////////////	
	
	
	@PostMapping("/login")
	public String loginHandler( @Valid @RequestBody AdminLoginData loginData) throws LogInException {
		return adminLoginService.logInAccount(loginData);
	}
	
	@PatchMapping("/logout")
	public String logOutFromAccount(@RequestParam String key) throws LogInException
	{
		return adminLoginService.logOutFromAccount(key);
	}	
	
		
	
////////////////////////////				Amdin - Login			///////////////////////////////////////////////////////	
	
   @GetMapping("/allcustomers")
	public ResponseEntity<List<SignUpData>>  showallcustomers() throws CustomerException{
		
	   
	 
			List<SignUpData> customers = signupservice.showallcustomers();
			return new ResponseEntity<List<SignUpData>>(customers, HttpStatus.OK);
		}
	   
	
	@DeleteMapping("/delete/{id}")
public ResponseEntity<SignUpData>  deletecustomer(@PathVariable Integer id) throws CustomerException{

	SignUpData customers = signupservice.deletecustomer(id);
	return new ResponseEntity<SignUpData>(customers, HttpStatus.OK);
}
	
	
	
	@PostMapping("/add/seeds")
	public ResponseEntity<Seed> addSeedHandler(@RequestBody Seed seed) throws SeedException{
		
		 Seed s= seedservice.addSeed(seed);
		
		return new ResponseEntity<Seed>(s,HttpStatus.OK);
		
		
	}
	
	
	
	@PutMapping("/update/seeds")
	public ResponseEntity<Seed> updateSeedHandler(@RequestBody Seed seed) throws SeedException{
		
		Seed p= seedservice.updateSeed(seed);
		
		return new ResponseEntity<Seed>(p,HttpStatus.OK);
		
		
	}
	
	
	@DeleteMapping("/delete/seeds")
	public ResponseEntity<Seed> deleteSeedHandler(@RequestBody Seed seed) throws SeedException{
		
		Seed s= seedservice.deleteSeed(seed);
		
		return new ResponseEntity<Seed>(s,HttpStatus.OK);
		
		
	}
	
	
	


	@PostMapping("/add/plants")
	public ResponseEntity<Plant> addPlantHandler(@RequestBody Plant plant) throws PlantException{
		
		Plant p= plantServices.addPlant(plant);
		
		return new ResponseEntity<Plant>(p,HttpStatus.OK);
		
		
	}
	
	
	
	@PutMapping("/update/plants")
	public ResponseEntity<Plant> updatePlantHandler(@RequestBody Plant plant) throws PlantException{
		
		Plant p= plantServices.updatePlant(plant);
		
		return new ResponseEntity<Plant>(p,HttpStatus.OK);
		
		
	}
	
	
	@DeleteMapping("/delete/plants")
	public ResponseEntity<Plant> deletePlantHandler(@RequestBody Plant plant) throws PlantException{
		
		Plant p= plantServices.deletePlant(plant);
		
		return new ResponseEntity<Plant>(p,HttpStatus.OK);
		
		
	}
	

	
	
		@PostMapping("/add/planter")
		public ResponseEntity<Planter> addPlanter(@Valid @RequestBody Planter planter) {
			Planter plant = planterService.addPlanter(planter);
					
			return new ResponseEntity<Planter>(plant, HttpStatus.CREATED);
		}
		
		
		@PutMapping("/update/planter")
		public ResponseEntity<Planter> updatePlanter(@Valid @RequestBody Planter planter) throws PlanterException {
			
			Planter updatedPlant = planterService.updatePlanter(planter);
					
			return new ResponseEntity<Planter>(updatedPlant, HttpStatus.OK);
		}
		
		
		@DeleteMapping("/delete/planter")
		public ResponseEntity<Planter> deletePlanterHandler(@Valid @RequestBody Planter planter) throws PlanterException {
			
			Planter deletedPlanter = planterService.deletePlanter(planter);
					
			return new ResponseEntity<Planter>(deletedPlanter, HttpStatus.OK);
		}
		
		@GetMapping("/showorders")
		public List<Orders>viewAllOrders() throws OrderException{
			return orderservice.viewAllOrders();
			
		}
	
}
