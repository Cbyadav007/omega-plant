package com.nursery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminSignUp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@Pattern(regexp="[a-z]{3,12}", message = "Username must be between 3 to 12 characters. Must only contain lowercase characters.")
	private String adminUserName;
	
	@Size(min=3, max=500)
	private String adminPassword;
}
