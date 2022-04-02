package com.example.practices.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

	@NotEmpty
	@Size(min = 2, message = "name should have at least 2 characters")
	private   String name;

	@Email(message = "please give proper emil")
	@NotEmpty
	@Size(min = 2, message = "email should have at least 2 characters")
	private String email;
	private String fullName;

	@NotEmpty
	@Size(min = 10,max = 10,message = "mobileNumber should have at least 2 characters")
	private String mobileNumber;

	  
	  
}
