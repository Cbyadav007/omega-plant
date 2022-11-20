package com.nursery.service;

import com.nursery.exception.LogInException;
import com.nursery.model.AdminLoginData;


public interface AdminLogInService {

	
	public String logInAccount(AdminLoginData adminLoginData)throws LogInException ;
	public String logOutFromAccount(String key) throws LogInException;
	
}
