package com.nursery.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.exception.LogInException;
import com.nursery.model.CurrentUserSession;
import com.nursery.model.SignUpData;
import com.nursery.repository.CurrentUserSessionDao;
import com.nursery.repository.SignUpDao;


@Service
public class CurrentUserSessionServiceImpl implements CurrentUserSessionService {

	@Autowired
	private CurrentUserSessionDao currentUserSessionDAO;
	
	@Autowired
	private SignUpDao signUpDao;
	
	@Override
	public CurrentUserSession getCurrentUserSession(String key) throws LogInException   {
		
		Optional<CurrentUserSession> currentUser = currentUserSessionDAO.findByUuid(key);
		if(!currentUser.isPresent())
		{
			throw new LogInException("UnAuthorized!!!");
		}
		return currentUser.get();
	}

	@Override
	public Integer getCurrentUserSessionId(String key) throws LogInException  {
		
		Optional<CurrentUserSession> currentUser = currentUserSessionDAO.findByUuid(key);
		if(!currentUser.isPresent())
		{
			throw new LogInException("UnAuthorized!!!");
		}
		return currentUser.get().getId();
		
	}


	@Override
	public SignUpData getSignUpDetails(String key) {
		
		Optional<CurrentUserSession> currentUser = currentUserSessionDAO.findByUuid(key);
		if(!currentUser.isPresent())
		{
			return null;
		}
		Integer SignUpUserId = currentUser.get().getUserId();
		System.out.println(SignUpUserId );
		
		return (signUpDao.findById(SignUpUserId)).get();
	}

}