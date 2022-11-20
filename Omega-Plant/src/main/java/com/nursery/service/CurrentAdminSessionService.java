package com.nursery.service;

import com.nursery.exception.LogInException;
import com.nursery.model.AdminSignUp;
import com.nursery.model.CurrentAdminSession;
import com.nursery.model.CurrentUserSession;
import com.nursery.model.SignUpData;

public interface CurrentAdminSessionService {

	
	public CurrentAdminSession getCurrentAdminSession(String key) throws LogInException;;
	public Integer getCurrentAdminSessionId(String key) throws LogInException;
	
	public AdminSignUp getSignUpDetails(String key) throws LogInException;
	
}
