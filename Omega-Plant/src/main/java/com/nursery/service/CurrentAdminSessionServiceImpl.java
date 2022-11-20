package com.nursery.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.exception.LogInException;
import com.nursery.model.AdminSignUp;
import com.nursery.model.CurrentAdminSession;
import com.nursery.model.CurrentUserSession;
import com.nursery.model.SignUpData;
import com.nursery.repository.AdminSignUpDao;
import com.nursery.repository.CurrentAdminSessionDao;




@Service
public class CurrentAdminSessionServiceImpl implements CurrentAdminSessionService{

	
	@Autowired
	private CurrentAdminSessionDao currentAdminSessionDAO;
	
	@Autowired
	private AdminSignUpDao signUpDao;
	
	
	@Override
	public CurrentAdminSession getCurrentAdminSession(String key) throws LogInException   {
		
		Optional<CurrentAdminSession> currentAdmin = currentAdminSessionDAO.findByAuid(key);
		if(!currentAdmin.isPresent())
		{
			throw new LogInException("UnAuthorized!!!");
		}
		return currentAdmin.get();
	}

	@Override
	public Integer getCurrentAdminSessionId(String key) throws LogInException  {
		
		Optional<CurrentAdminSession> currentAdmin = currentAdminSessionDAO.findByAuid(key);
		if(!currentAdmin.isPresent())
		{
			throw new LogInException("UnAuthorized!!!");
		}
		return currentAdmin.get().getId();
		
	}


	@Override
	public AdminSignUp getSignUpDetails(String key) {
		
		Optional<CurrentAdminSession> currentAdmin = currentAdminSessionDAO.findByAuid(key);
		if(!currentAdmin.isPresent())
		{
			return null;
		}
		Integer SignUpAdminId = currentAdmin.get().getAdminId();
		System.out.println(SignUpAdminId );
		
		return (signUpDao.findById(SignUpAdminId)).get();
	}

	
}
