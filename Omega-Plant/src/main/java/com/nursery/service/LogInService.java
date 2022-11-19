package com.nursery.service;


import com.nursery.exception.LogInException;
import com.nursery.model.LogInData;

public interface LogInService {
	
	

	public String logInAccount(LogInData loginData)throws LogInException ;
	public String logOutFromAccount(String key) throws LogInException;


}