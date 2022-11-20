package com.nursery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nursery.exception.AdminException;
import com.nursery.exception.LogInException;
import com.nursery.model.AdminSignUp;
import com.nursery.model.SignUpData;
import com.nursery.repository.AdminSignUpDao;
import com.nursery.repository.SignUpDao;

@Service
public class AdminSignUpServiceImpl implements AdminSignUpService {

	
	@Autowired
	private AdminSignUpDao adminSignUpDAO;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private CurrentAdminSessionService getCurrentLoginAdminSession;
	
	
	
	@Override
	public AdminSignUp createNewSignUp(AdminSignUp newSignUp) throws LogInException  {
		System.out.println(newSignUp);
		
		Optional<AdminSignUp> opt = adminSignUpDAO.findByAdminUserName(newSignUp.getAdminUserName());
		System.out.println(newSignUp.getAdminUserName());
		if(opt.isPresent())
		{
			throw new LogInException("User Already Exist!");
		}
		
//		System.out.println(newSignUp);
		
		AdminSignUp sud = new AdminSignUp();
		
		sud.setAdminUserName(newSignUp.getAdminUserName());
		sud.setAdminPassword(this.bCryptPasswordEncoder.encode(newSignUp.getAdminPassword()));
		
		return adminSignUpDAO.save(sud);
//		return sud;
		
	}

	@Override
	public AdminSignUp updateSignUpDetails(AdminSignUp signUp, String key) throws LogInException  {
		
		AdminSignUp signUpDetails = getCurrentLoginAdminSession.getSignUpDetails(key);
		
		if(signUpDetails == null)
		{
			throw new LogInException("UnAuthorized!!! No User Found....Try To login first!");
		}
		
		if(signUpDetails.getAdminId() == signUp.getAdminId())
			{
			adminSignUpDAO.save(signUp);
			return signUp;
			}
		else
			throw new LogInException("Can't change UserId!!");
	}

	@Override
	public List<AdminSignUp> showalladmin() throws AdminException {
		// TODO Auto-generated method stub
		List<AdminSignUp> admins=adminSignUpDAO.findAll();
		if(admins.size()==0) {
			throw new AdminException("No Admin available !!");
		}
		return admins; 
		
	}

	@Override
	public AdminSignUp deleteadmin(Integer adminId) throws AdminException {
		// TODO Auto-generated method stub
		
		Optional<AdminSignUp> opt= adminSignUpDAO.findById(adminId);
		
		if(opt.isPresent()) {
			AdminSignUp existadmin = opt.get();
			adminSignUpDAO.delete(existadmin);
			return existadmin;
		}
		else
			throw new AdminException("No Admin found !!");
		
		
	}

	
}
