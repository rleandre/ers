package com.ers.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ers.models.Employee;
import com.ers.util.ConnectionFactory;

public class EmployeeDAO {

	public List<Employee> getEmployees() { 
		try(Connection conn = ConnectionFactory.getConnection()){ 
			ResultSet rs = null;
			String sql = "SELECT * FROM employees;";
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			List<Employee> employeeList = new ArrayList<>();
			while(rs.next()) {
				Employee e = new Employee(
						rs.getInt("e_id"),
						rs.getString("company_email"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getString("employee_username"),
						rs.getString("employee_password"),
						rs.getInt("role_id")
						);				
				employeeList.add(e);
			}
			
			return employeeList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Employees");
		}
		return null; 
	}    	
	public static int submitEmployee(Employee newEmployee) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String employee = "INSERT INTO employee (employee_id, company_email, f_name, l_name, employee_username, employee_password, role_id) " //creating a line break for readability
						+ "VALUES (DEFAULT,?,?,?,?,?,?); "; 
			PreparedStatement ps = conn.prepareStatement(employee);
			ps.setString(1,newEmployee.getCompany_email());
			ps.setString(2, newEmployee.getF_name());
			ps.setString(3, newEmployee.getL_name());
			ps.setString(4, newEmployee.getEmployee_username());
			ps.setString(5,newEmployee.getEmployee_password());
			ps.setInt(6, newEmployee.getRole_id());
			ps.executeUpdate();
			System.out.println("Employee Information Sucessfully Inputted");
			return 1;
		}
		catch(SQLException e) {
			System.out.println("There was an error while attempting to input Employee information");
			return 0;
		}
	}
	public List<Employee> loginRequest(String username, String password) {
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			String employee = "SELECT * FROM employee WHERE employee_username = ? AND employee_password = ?;";
			PreparedStatement ps = conn.prepareStatement(employee);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			List<Employee> employeelist = new ArrayList<>();
			
			while(rs.next()) {
				Employee e = new Employee(
						rs.getInt("employee_id"),
						rs.getString("company_email"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getString("employee_username"),
						rs.getString("employee_password"),
						rs.getInt("role_id")
						);		
				employeelist.add(e);
			}
			return employeelist;
		}
		catch(SQLException e){
			System.out.println("There was an error while trying to login");
		}	
		return null;		
	}
	public Optional<Employee> getByUsername(String employee_username) {
		try(Connection conn = ConnectionFactory.getConnection()){ 
			Employee GENERIC_EMPLOYEE_1 = new Employee(1, "genericUsername", "genericPassword", 1);
			return Optional.of(GENERIC_EMPLOYEE_1);
		}
		catch(SQLException e){
			System.out.println("There was an error while trying to login");
		}	
		return null;		
	}	
}




