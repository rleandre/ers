package com.ers.services;

import java.util.List;
import java.util.Optional;

import com.ers.models.AbstractUser;
import com.ers.models.Role;
import com.ers.models.User;
import com.ers.repositories.UserDAO;


public class UserService {

	UserDAO ud = new UserDAO();


	public Optional<User> getByUsername(String username) {
		  User GENERIC_EMPLOYEE_1 = new User(1, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
	        Optional<User> optional = Optional.of(GENERIC_EMPLOYEE_1);
		return optional;
	}
	
	
  }

