package com.nursery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nursery.exception.OrderException;
import com.nursery.model.OrderDTO;
import com.nursery.model.OrderDTO2;
import com.nursery.model.Orders;


@Service
public interface OrderService {
	public OrderDTO2 addOrder(OrderDTO order) throws OrderException;
	public Orders updateOrder(Orders order) throws OrderException;
	public Orders deleteOrder(Integer orderId) throws OrderException;
	public Orders viewOrder(Integer orderId) throws OrderException;
	public List<Orders>viewAllOrders() throws OrderException;
	
	
}