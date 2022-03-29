package com.ers.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ers.models.Travel;
import com.ers.util.ConnectionFactory;

public class TravelDAO {
	public List<Travel> getTravel() { 
		try(Connection conn = ConnectionFactory.getConnection()){ 
			ResultSet rs = null;
			String travel = "SELECT * FROM travel;";
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(travel);			
			List<Travel> travelList = new ArrayList<>();
			
			while(rs.next()) {
				Travel t = new Travel(
					rs.getInt("employee_id"),
					rs.getInt("travel_id"),
					rs.getString("travel_cost"),
					rs.getString("travel_info"),	
					rs.getInt("status")
					);
			travelList.add(t);
			}
			return travelList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Travel");
		}
		return null; 
	}
	public List<Travel> getSingleTravel() {
		try(Connection conn = ConnectionFactory.getConnection()){ 
			ResultSet rs = null;
			String travel = "SELECT * FROM travel WHERE status IS NULL LIMIT 1;";
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(travel);
			List<Travel> travelList = new ArrayList<>();
			
			while(rs.next()) {
				Travel t = new Travel(
					rs.getInt("employee_id"),
					rs.getInt("travel_id"),
					rs.getString("travel_cost"),
					rs.getString("travel_info"),
					rs.getInt("status")				
					);
				travelList.add(t);
			}
			return travelList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Travel");
		}
		return null; 			
	}
	public List<Travel> getEmployeeTravel(int e_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			String travel = "SELECT * FROM travel WHERE employee_id = ?;";
			PreparedStatement ps = conn.prepareStatement(travel);
			ps.setInt(1, e_id);
			rs = ps.executeQuery();
			List<Travel> travelList = new ArrayList<>();
				
			while(rs.next()) {
				Travel t = new Travel(
					rs.getInt("employee_id"),
					rs.getInt("travel_id"),
					rs.getString("travel_cost"),
					rs.getString("travel_info"),
					rs.getInt("status")				
					);
				travelList.add(t);
			}
			return travelList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Travel");
		}
		return null; 
	}
	public int submitTravel(Travel newTravel) {
		try(Connection conn = ConnectionFactory.getConnection()) {
			String travel = "INSERT INTO travel (employee_id, travel_cost, travel_info) " 
						+ "VALUES (?,?,?); ";
			PreparedStatement ps = conn.prepareStatement(travel);
			ps.setInt(1, newTravel.getE_id());
			ps.setString(2, newTravel.getTravel_cost());
			ps.setString(3, newTravel.getTravel_info());
			ps.executeUpdate();
			System.out.println("Travel Information Sucessfully Inputted");
			return 1;
		}
		catch(SQLException e) {
			System.out.println("There was an error while attempting to input Travel information");
			return 0;
		}
	}
	public int updateTravelStatus(Travel Travel) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String travel = "UPDATE travel SET status = ? WHERE travel_id = ?;";
			PreparedStatement ps = conn.prepareStatement(travel);
			ps.setInt(1, Travel.getStatus());
			ps.setInt(2, Travel.getTravel_id());
			ps.executeUpdate();
			System.out.println("The status of this request has been set to: " + Travel.getStatus());
			return 1;
		}
		catch (SQLException e) {
			System.out.println("Something went wrong during the update");
			return 0;
		}
	}
	public int updateTravelStatus(int decision, int travel_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
					String travel = "UPDATE travel SET status = ? WHERE travel_id = ?;";
					PreparedStatement ps = conn.prepareStatement(travel);
					ps.setInt(1, decision);
					ps.setInt(2, travel_id);
					ps.executeUpdate();
					System.out.println("The status of this request has been set to: " + decision);
					return 1;
		} 
		catch (SQLException e) {
					System.out.println("Something went wrong during the update");
					return 0;
		}
	}
}
