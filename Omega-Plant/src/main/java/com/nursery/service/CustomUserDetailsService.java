package com.nursery.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nursery.exception.LogInException;
import com.nursery.model.SignUpData;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		
		if(userName.equals("Cbyadav"))
		{
			return new User("Cbyadav", "Cbyadav", new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("User not found !");
		}
	}

}
