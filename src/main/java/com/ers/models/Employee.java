package com.ers.models;

import java.util.Objects;


//This Class represents the employees table in our database
public class Employee {

	//fields for the employee class - must match those in your database
	private int e_id;
	private String company_email;
	private String f_name;
	private String l_name;
	private String employee_username;
	private String employee_password;
	private int role_id;
	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int e_id, String company_email, String f_name, String l_name, String employee_username,
			String employee_password, int role_id) {
		super();
		this.e_id = e_id;
		this.company_email = company_email;
		this.f_name = f_name;
		this.l_name = l_name;
		this.employee_username = employee_username;
		this.employee_password = employee_password;
		this.role_id = role_id;
	}

	public Employee(String company_email, String f_name, String l_name, String employee_username,
			String employee_password, int role_id) {
		super();
		this.company_email = company_email;
		this.f_name = f_name;
		this.l_name = l_name;
		this.employee_username = employee_username;
		this.employee_password = employee_password;
		this.role_id = role_id;
	}

	public Employee(int e_id, String employee_username, String employee_password, int role_id) {
		super();
		this.e_id = e_id;
		this.employee_username = employee_username;
		this.employee_password = employee_password;
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", company_email=" + company_email + ", f_name=" + f_name + ", l_name="
				+ l_name + ", employee_username=" + employee_username + ", employee_password=" + employee_password
				+ ", role_id=" + role_id + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	
	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getCompany_email() {
		return company_email;
	}

	public void setCompany_email(String company_email) {
		this.company_email = company_email;
	}

	public String getEmployee_username() {
		return employee_username;
	}

	public void setEmployee_username(String employee_username) {
		this.employee_username = employee_username;
	}

	public String getEmployee_password() {
		return employee_password;
	}

	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(company_email, e_id, employee_password, employee_username, f_name, l_name, role_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(company_email, other.company_email) && e_id == other.e_id
				&& Objects.equals(employee_password, other.employee_password)
				&& Objects.equals(employee_username, other.employee_username) && Objects.equals(f_name, other.f_name)
				&& Objects.equals(l_name, other.l_name) && role_id == other.role_id;
	}

}
