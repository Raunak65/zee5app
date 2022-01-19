package com.zee.zee5app;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService;

public class Main {

	public static void main(String[] args) {
// 		Register
		Register register = new Register();
		register.setFirstName("Raunak");
		register.setLastName("Chandak");
		register.setId("raunak12345");
		register.setEmail("raunakchandak65@gmail.com");
		register.setPassword("rc@raunak12345");
		
		System.out.println(register);
		
		// same as line 16
		System.out.println(register.toString());
		
		//accessing email from register class / dto package 
		System.out.println(register.getEmail());
		
		
//		Class Login
		Login login = new Login();

//		Class UserService	
		UserService  service = UserService.getInstance();
		
		for(int i = 1; i <= 11; i++) {
			Register register2 = new Register();
			register2.setFirstName("Raunak");
			register2.setLastName("Chandak");
			register2.setId("raunak12345");
			register2.setEmail("raunakchandak@gmail.com");
			register2.setPassword("rc@raunak12345");
			String result = service.addUser(register);	
			System.out.println(result+" "+i);			
		}
		Register register2 = service.getUserById("raunak134");
		System.out.println(register2!=null);
//		delete user by Id
		System.out.println(service.deleteUser("raunak1234"));
//	get all users
		for (Register register3 : service.getUsers()) {
			if(register3!=null) System.out.println(register3);
		};
	}

}
