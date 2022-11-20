package com.nursery.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nursery.exception.LogInException;
import com.nursery.model.AdminLoginData;
import com.nursery.model.AdminSignUp;
import com.nursery.model.CurrentAdminSession;
import com.nursery.model.CurrentUserSession;
import com.nursery.model.LogInData;
import com.nursery.model.SignUpData;
import com.nursery.repository.AdminLoginDataDao;
import com.nursery.repository.AdminSignUpDao;
import com.nursery.repository.CurrentAdminSessionDao;






@Service
public class AdminLogInServiceimpl implements AdminLogInService{

	
	@Autowired
	private AdminSignUpDao adminSignUpDAO;
	
	@Autowired
	private CurrentAdminSessionDao currentAdminSessionDAO;
	
	@Autowired
	private CurrentAdminSessionService getCurrentLoginAdminSession;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AdminLoginDataDao adminLoginDataDAO;

	
	@Override
	public String logInAccount(AdminLoginData loginData) throws LogInException  {
		
		System.out.println("lpass = " + loginData.getAdminPassword());
		
Optional<AdminSignUp> opt = adminSignUpDAO.findById(loginData.getAdminId());
		
		if(!opt.isPresent())
		{
			throw new LogInException("Invalid Login UserId");
		}
		
		AdminSignUp newSignUp = opt.get();
		
//		System.out.println("nsp = " + newSignUp.getAdminPassword());
		
//		System.out.println("ldp = "+ this.bCryptPasswordEncoder.encode(loginData.getPassword()));
		
		Integer newSignUpId = newSignUp.getAdminId();
		Optional<CurrentAdminSession> currentUserOptional = currentAdminSessionDAO.findByAdminId(newSignUpId);
		
		if(currentUserOptional.isPresent()) {
			throw new LogInException("User Already login with this UserId");
		}
		
//		if((newSignUp.getUserId() == loginData.getUserId()) && (newSignUp.getPassword().equals(loginData.getPassword())))
if((newSignUp.getAdminId() == loginData.getAdminId()) && (this.bCryptPasswordEncoder.matches(loginData.getAdminPassword(), newSignUp.getAdminPassword())))
		{
			String key = RandomString.getRandomNumberString();
			
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(newSignUp.getAdminId(),key,LocalDateTime.now());
			currentAdminSessionDAO.save(currentAdminSession);
			adminLoginDataDAO.save(loginData);
			System.out.println(currentAdminSession.toString());
			return currentAdminSession.toString();
			
		}
		else
			throw new LogInException("Invalid UserName or Password!");
			
			
		
	}

	@Override
	public String logOutFromAccount(String key) throws LogInException  {
		
		Optional<CurrentAdminSession> currentAdminOptional = currentAdminSessionDAO.findByAuid(key);
		if(!currentAdminOptional.isPresent())
		{
			throw new LogInException("User has not logged in with this UserId");
		}
		CurrentAdminSession currentUserSession = getCurrentLoginAdminSession.getCurrentAdminSession(key);
		
		currentAdminSessionDAO.delete(currentUserSession);
		
		Optional<AdminLoginData> loginData = adminLoginDataDAO.findById(currentAdminOptional.get().getAdminId());
		System.out.println(loginData);
		adminLoginDataDAO.delete(loginData.get());
		
		
		return "Admin Logged Out......";
	
	}
	
	
	
	
}
