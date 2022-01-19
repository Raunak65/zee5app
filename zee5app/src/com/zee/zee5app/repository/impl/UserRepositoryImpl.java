package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository2;

public class UserRepositoryImpl implements UserRepository2 {
	
	private Register[] registers = new Register[10];
	
	private UserRepositoryImpl() {
		
	}
	
	private static UserRepository2 repository;
	
	public static UserRepository2 getInstance() {
		if(repository==null)
		{
			repository = new UserRepositoryImpl();
		}
		return repository;
	}

	private static int count = -1;
	@Override
	public String addUser(Register register) {
		if(count == registers.length-1) {
			Register temp[] = new Register[2*registers.length];
			System.arraycopy(registers, 0, temp,0, registers.length);
			registers = temp;
			registers[++count] = register;
			return "Successfully added User";
		}
		registers[++count] = register;
		return "Successfully added User";
	}

	@Override
	public String updateUser(String id, Register register) {
		for (Register currRegister : registers) {
			if (currRegister!=null) {
				if (currRegister.getId().equals(id)) {
					currRegister.setEmail(register.getEmail());
					currRegister.setFirstName(register.getFirstName());
					currRegister.setLastName(register.getLastName());
					currRegister.setPassword(register.getPassword());
					return "updated";
				}
			}	
		}
		return null;
	}

	@Override
	public Register getUserById(String id) {
		for (Register register : registers) {
			if(register!=null) {
				
				if(register.getId().equals(id)) {
					return register;
				}
			}
		}
		return null;
	}

	@Override
	public Register[] getAllUsers() {
		return registers;
	}

	@Override
	public String deleteUserById(String id) {
		Register temp[] = new Register[registers.length];
		int i = 0;
		int j = 0;
		for (Register currRegister : registers) {
			if (currRegister!=null) {
				if (currRegister.getId().equals(id)) {
					j++;
				}
				else {
					temp[i] = registers[j];
					i++;
					j++;
				}
			}	
		}
		registers = temp;
		return "success";
	}

}
