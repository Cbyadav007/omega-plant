package com.nursery.service;

import java.util.List;

import com.nursery.exception.AdminException;
import com.nursery.exception.CustomerException;
import com.nursery.exception.LogInException;
import com.nursery.model.AdminSignUp;
import com.nursery.model.SignUpData;

public interface AdminSignUpService {

	public AdminSignUp createNewSignUp(AdminSignUp adminSignUp) throws LogInException;
	
	public AdminSignUp updateSignUpDetails(AdminSignUp signUp,String key) throws LogInException;
	
	public List<AdminSignUp> showalladmin()throws AdminException;
	
	public AdminSignUp deleteadmin(Integer adminId)throws AdminException;
	
}
