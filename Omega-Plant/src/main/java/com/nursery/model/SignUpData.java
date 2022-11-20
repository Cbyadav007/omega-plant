package com.nursery.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="users")
public class SignUpData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;


	@NotNull
	@Pattern(regexp="[a-z]{6,12}", message = "Username must be between 6 to 12 characters. Must only contain lowercase characters.")
	private String userName;

	@NotNull
//	@Pattern(regexp="[a-zA-Z0-9]{6,500}",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
	@Size(min=3, max=500)
	private String password;

	@NotNull
	@Pattern(regexp="[0-9]{10}", message = "Mobile number must have 10 digits")
	private String mobileNo;
	

	
	@Embedded
	private Address address;

	@Email
	@NotNull
	private String email;
	
}