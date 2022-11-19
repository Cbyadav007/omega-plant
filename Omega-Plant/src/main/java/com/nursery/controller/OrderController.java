package com.nursery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nursery.exception.OrderException;
import com.nursery.model.OrderDTO;
import com.nursery.model.OrderDTO2;
import com.nursery.model.Orders;

import com.nursery.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	
	@PostMapping("/addorder")
	public ResponseEntity<OrderDTO2> addOrder(@Valid @RequestBody OrderDTO order) throws OrderException{
		OrderDTO2 od=orderService.addOrder(order);
		
		return new ResponseEntity<OrderDTO2>(od,HttpStatus.CREATED);
		
	}
	
	//Updating Order
	@PutMapping("/updateorder")
	public ResponseEntity<Orders>updateOrder(@RequestBody Orders order) throws OrderException{
		Orders od=orderService.updateOrder(order);
		return new ResponseEntity<Orders>(od,HttpStatus.OK);
		
	}
	
	//Deleting Order
	
	@DeleteMapping("/deleteorder/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String>deleteOrder(@Valid @PathVariable("id") Integer orderid) throws OrderException{
		Orders od=orderService.deleteOrder(orderid);
		if(od!=null) {
			return new ResponseEntity<String>("Deleted Succesfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Please check order id is registered",HttpStatus.BAD_REQUEST);
		}
	}
	
		
}