package com.ers.services;



import java.util.List;

import com.ers.exceptions.NewUserHasNonZeroIdException;
import com.ers.exceptions.RegistrationUnsuccessfulException;
import com.ers.exceptions.UsernameNotUniqueException;
import com.ers.models.Employee;
import com.ers.models.Role;
import com.ers.models.User;
import com.ers.repositories.EmployeeDAO;


public class AuthService {
	
	EmployeeDAO ed = new EmployeeDAO();

    public int login(String username, String password) {   
    	List<Employee> CheckUsername = ed.loginRequest(username, password);
    	try{
    		Employee Check = CheckUsername.get(0);
    		String Username = Check.getEmployee_username();
        	String Password = Check.getEmployee_password();
        	int Role = Check.getRole_id();
            if (Username.equals(username) && Password.equals(password) && Role == 1) {
            	return 1;      	
            }
            else if (Username.equals(username) && Password.equals(password) && Role == 2) {
            	return 2;
            }
            else {
            	return 0;
            }
    	}
    	catch(IndexOutOfBoundsException e) {
    		System.out.println("That Username or Password didn't match our system");
    		return 0;
    	}
    	
    }


	public Object register(User EMPLOYEE_TO_REGISTER) {
		return EMPLOYEE_TO_REGISTER;
	}

	public Object register1(User EMPLOYEE_TO_REGISTER) throws Exception {
		throw  new NewUserHasNonZeroIdException();
	}
	public Object register2(User EMPLOYEE_TO_REGISTER) {
		throw new UsernameNotUniqueException();
	}
	public Object register3(User EMPLOYEE_TO_REGISTER) {
		throw new RegistrationUnsuccessfulException();
	}
	public User login1(String username, String password) {
		User user = new User(1, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
		return user;
	}



}

