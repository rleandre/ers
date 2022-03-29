package com.ers.models;

import java.util.Objects;

//This Class represents the employees table in our database
public class Travel {

	//fields for the employee class - must match those in your database
	private int e_id;
	private int travel_id;
	private String travel_cost;
	private String travel_info;
	private int status;

	
	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Travel() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Travel(int e_id, String travel_cost, String travel_info) {
		super();
		this.e_id = e_id;
		this.travel_cost = travel_cost;
		this.travel_info = travel_info;
	}


	public Travel(int e_id, int travel_id, String travel_cost, String travel_info) {
		super();
		this.e_id = e_id;
		this.travel_id = travel_id;
		this.travel_cost = travel_cost;
		this.travel_info = travel_info;
	}



	public Travel(int e_id, int travel_id, String travel_cost, String travel_info, int status) {
		super();
		this.e_id = e_id;
		this.travel_id = travel_id;
		this.travel_cost = travel_cost;
		this.travel_info = travel_info;
		this.status = status;
	}



	@Override
	public String toString() {
		return "Travel [e_id=" + e_id + ", travel_id=" + travel_id + ", travel_cost=" + travel_cost + ", travel_info="
				+ travel_info + "]";
	}



	//getters and setters so that we can access and change the private variables up above 
	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getTravel_info() {
		return travel_info;
	}

	public void setTravel_info(String travel_info) {
		this.travel_info = travel_info;
	}

	public int getTravel_id() {
		return travel_id;
	}

	public void setTravel_id(int travel_id) {
		this.travel_id = travel_id;
	}

	public String getTravel_cost() {
		return travel_cost;
	}

	public void setTravel_cost(String travel_cost) {
		this.travel_cost = travel_cost;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(e_id, travel_cost, travel_id, travel_info);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Travel other = (Travel) obj;
		return e_id == other.e_id && Objects.equals(travel_cost, other.travel_cost) && travel_id == other.travel_id
				&& Objects.equals(travel_info, other.travel_info);
	}
}