package com.nursery.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.nursery.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.csrf()
			.disable()
			.cors()
			.disable()
			.authorizeRequests()
			.antMatchers("/token").permitAll()
			.antMatchers("/admin/signUp").permitAll()
			.antMatchers("/admin/allcustomers").permitAll()
			.antMatchers("/user/create_order").permitAll()
			.antMatchers("/admin/login").permitAll()
			.antMatchers("/admin/logout").permitAll()
			.antMatchers("/customer/signUp").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/logout").permitAll()
			.antMatchers("/payment").permitAll()
			.anyRequest().authenticated()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
			
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPaswordEncoder());
	
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPaswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}
	
}
