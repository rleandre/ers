package com.ers.models;

import java.util.Objects;

//This Class represents the employees table in our database
public class Food {

	//fields for the employee class - must match those in your database
	private int e_id;
	private int food_id;
	private String food_cost;
	private String food_info;
	private int status;


	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Food() {
		super();
	}


	public Food(int e_id, String food_cost, String food_info) {
		super();
		this.e_id = e_id;
		this.food_cost = food_cost;
		this.food_info = food_info;
	}


	public Food(int e_id, int food_id, String food_cost, String food_info) {
		super();
		this.e_id = e_id;
		this.food_id = food_id;
		this.food_cost = food_cost;
		this.food_info = food_info;
	}

	

	public Food(int e_id, int food_id, String food_cost, String food_info, int status) {
		super();
		this.e_id = e_id;
		this.food_id = food_id;
		this.food_cost = food_cost;
		this.food_info = food_info;
		this.status = status;
	}


	@Override
	public String toString() {
		return "Food [e_id=" + e_id + ", food_id=" + food_id + ", food_cost=" + food_cost + ", food_info=" + food_info
				+ ", status=" + status + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	
	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	
	public String getFood_info() {
		return food_info;
	}


	public void setFood_info(String food_info) {
		this.food_info = food_info;
	}


	public String getFood_cost() {
		return food_cost;
	}


	public void setFood_cost(String food_cost) {
		this.food_cost = food_cost;
	}


	@Override
	public int hashCode() {
		return Objects.hash(e_id, food_cost, food_id, food_info, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		return e_id == other.e_id && Objects.equals(food_cost, other.food_cost) && food_id == other.food_id
				&& Objects.equals(food_info, other.food_info) && status == other.status;
	}
}
