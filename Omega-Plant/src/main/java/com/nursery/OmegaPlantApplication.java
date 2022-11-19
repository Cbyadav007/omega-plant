package com.nursery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class OmegaPlantApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmegaPlantApplication.class, args);
	}

	
	@Bean
	public LocalValidatorFactoryBean validator(MessageSource ms)
	{
		LocalValidatorFactoryBean lvfb = new LocalValidatorFactoryBean();
		lvfb.setValidationMessageSource(ms);
		return lvfb;
	}
}
