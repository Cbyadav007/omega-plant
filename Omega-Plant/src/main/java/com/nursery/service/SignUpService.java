package com.nursery.service;

import java.util.List;

import com.nursery.exception.CustomerException;
import com.nursery.exception.LogInException;
import com.nursery.model.SignUpData;

public interface SignUpService {
	
public SignUpData createNewSignUp(SignUpData signUp) throws LogInException;
	
	public SignUpData updateSignUpDetails(SignUpData signUp,String key) throws LogInException;
	
	public List<SignUpData> showallcustomers()throws CustomerException;
	
	public SignUpData deletecustomer(Integer userId)throws CustomerException;
	
	
	

}