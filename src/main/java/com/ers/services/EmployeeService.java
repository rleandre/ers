package com.ers.services;

import java.util.List;
import java.util.Optional;

import com.ers.models.Employee;
import com.ers.repositories.EmployeeDAO;

public class EmployeeService {

	EmployeeDAO eDAO = new EmployeeDAO();//So that I can use the method sform the employeeDAO

	public List<Employee> getEmployees() throws Exception {
		List<Employee> result = eDAO.getEmployees();
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public void submitEmployee(Employee newEmployee) throws Exception {
		int result = EmployeeDAO.submitEmployee(newEmployee);
		if(result == 0) {
			throw new Exception();
		}
	}
	public Optional<Employee> getByUsername(String employee_username) throws Exception {
		Employee GENERIC_EMPLOYEE_1 = new Employee(1, "genericUsername", "genericPassword", 1);
		return Optional.of(GENERIC_EMPLOYEE_1);
	}	

}