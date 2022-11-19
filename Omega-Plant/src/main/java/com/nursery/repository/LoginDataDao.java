package com.nursery.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.nursery.model.LogInData;

public interface LoginDataDao  extends JpaRepository<LogInData, Integer>{

}