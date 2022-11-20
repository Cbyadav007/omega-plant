package com.nursery.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Entity
@Data
public class AdminLoginData {

	
	@Id
	@NotNull
	private Integer adminId;
	@NotNull(message="username shouldn't be empty")
	private String adminUserName;
	@NotNull(message="password shouldn't be empty")
	private String adminPassword;
	
}
