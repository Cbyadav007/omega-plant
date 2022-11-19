package com.nursery.service;


import com.nursery.exception.LogInException;
import com.nursery.model.CurrentUserSession;
import com.nursery.model.SignUpData;

public interface CurrentUserSessionService {
	
	

	
		
		public CurrentUserSession getCurrentUserSession(String key) throws LogInException;;
		public Integer getCurrentUserSessionId(String key) throws LogInException;
		
		public SignUpData getSignUpDetails(String key) throws LogInException;
		

	

}