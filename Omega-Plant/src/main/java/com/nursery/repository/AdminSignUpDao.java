package com.nursery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nursery.model.AdminSignUp;


public interface AdminSignUpDao extends JpaRepository<AdminSignUp, Integer>{

	public Optional<AdminSignUp> findByAdminUserName(String adminUserName);
}
