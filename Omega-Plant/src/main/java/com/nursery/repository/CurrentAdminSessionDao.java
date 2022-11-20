package com.nursery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nursery.model.CurrentAdminSession;


public interface CurrentAdminSessionDao extends JpaRepository<CurrentAdminSession, Integer>{

	
	public Optional<CurrentAdminSession> findByAdminId(Integer adminId);
	
	public Optional<CurrentAdminSession> findByAuid(String auid);
	
}
