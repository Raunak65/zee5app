package com.zee.zee5app.dto;

import lombok.Data;
@Data
public class Register {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public Register() {
//		In case of any customization during the initialization 
//		of object we can use explicit constructor i.e EDC
//		System.out.println("Hello there ! Explicit Constructor");
	}
}
