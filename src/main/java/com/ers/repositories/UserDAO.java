package com.ers.repositories;
import com.ers.exceptions.RegistrationUnsuccessfulException;
import com.ers.models.Role;
import com.ers.models.User;

import java.util.Optional;

public class UserDAO {

    public Optional<User> getByUsername(String username) {
        User GENERIC_EMPLOYEE_1 = new User(1, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
        Optional<User> optional = Optional.of(GENERIC_EMPLOYEE_1);
    	try {
    	   return optional;
       }
       catch (Exception e) {
    	   return null;
       }
    }

   
    public User create(User userToBeRegistered) {
    	 try {
    		 return userToBeRegistered;
         }
         catch (Exception e) {
      	   return null;
         }
    }
    public User create1(User userToBeRegistered) {
   	 throw new RegistrationUnsuccessfulException();
   }

    

}