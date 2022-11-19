package com.nursery.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nursery.model.Planter;

@Repository
public interface PlanterDao extends JpaRepository<Planter, Integer> {
	
	/* Add Queries here! - NOT PROVIDED SO FAR */
	
	@Query("select p from Planter p where p.planterShape =?1 ")
	Planter findByPlanterShape(String planterShape);

	@Query("select p from Planter p where p.planterCost between ?1 and ?2")
	List<Planter> findAllByPlanterCostRange(Integer minCost, Integer maxCost);
	
	
}