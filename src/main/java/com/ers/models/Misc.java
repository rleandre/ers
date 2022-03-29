package com.ers.models;

import java.util.Objects;


public class Misc {

	//fields for the employee class - must match those in your database
	private int e_id;
	private int misc_id;
	private String misc_cost;
	private String misc_info;
	private int status;

	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Misc() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Misc(int e_id, String misc_cost, String misc_info) {
		super();
		this.e_id = e_id;
		this.misc_cost = misc_cost;
		this.misc_info = misc_info;
	}

	

	public Misc(int e_id, int misc_id, String misc_cost, String misc_info) {
		super();
		this.e_id = e_id;
		this.misc_id = misc_id;
		this.misc_cost = misc_cost;
		this.misc_info = misc_info;
	}


	public Misc(int e_id, int misc_id, String misc_cost, String misc_info, int status) {
		super();
		this.e_id = e_id;
		this.misc_id = misc_id;
		this.misc_cost = misc_cost;
		this.misc_info = misc_info;
		this.status = status;
	}


	@Override
	public String toString() {
		return "Misc [e_id=" + e_id + ", misc_id=" + misc_id + ", misc_cost=" + misc_cost + ", misc_info="
				+ misc_info + "]";
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
	
	public int getMisc_id() {
		return misc_id;
	}


	public void setMisc_id(int misc_id) {
		this.misc_id = misc_id;
	}


	public String getMisc_info() {
		return misc_info;
	}

	public void setMisc_info(String misc_info) {
		this.misc_info = misc_info;
	}

	public String getMisc_cost() {
		return misc_cost;
	}

	public void setMisc_cost(String misc_cost) {
		this.misc_cost = misc_cost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(e_id, misc_cost, misc_id, misc_info);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Misc other = (Misc) obj;
		return e_id == other.e_id && Objects.equals(misc_cost, other.misc_cost) && misc_id == other.misc_id
				&& Objects.equals(misc_info, other.misc_info);
	}

}
