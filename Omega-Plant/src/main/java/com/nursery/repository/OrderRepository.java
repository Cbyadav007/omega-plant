package com.nursery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nursery.model.*;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
	

	
}