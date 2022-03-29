package com.ers.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ers.models.Lodging;
import com.ers.util.ConnectionFactory;

public class LodgingDAO {
	public List<Lodging> getLodging() { 
		try(Connection conn = ConnectionFactory.getConnection()){ 
			ResultSet rs = null;
			String lod = "SELECT * FROM lodging;";
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(lod);
			List<Lodging> lodgingList = new ArrayList<>();
			
			while(rs.next()) {
				Lodging l = new Lodging(
					rs.getInt("employee_id"),
					rs.getInt("lodging_id"),
					rs.getString("lodging_cost"),
					rs.getString("lodging_info"),
					rs.getInt("status")						
				);
				lodgingList.add(l);
			}
			return lodgingList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Lodging");
		}
		return null; 
	}
public List<Lodging> getSingleLodging() { 
	try(Connection conn = ConnectionFactory.getConnection()){ 
		ResultSet rs = null;
		String lod = "SELECT * FROM lodging WHERE status IS NULL LIMIT 1;";
		Statement statement = conn.createStatement();
		rs = statement.executeQuery(lod);
		List<Lodging> lodgingList = new ArrayList<>();
		
		while(rs.next()) {
			Lodging l = new Lodging(
				rs.getInt("employee_id"),
				rs.getInt("lodging_id"),
				rs.getString("lodging_cost"),
				rs.getString("lodging_info"),
				rs.getInt("status")				
			);
			lodgingList.add(l);
		}
		return lodgingList;
	}
	catch(SQLException e){
		System.out.println("There was an error in selecting Lodging");
	}
	return null; 
}
public List<Lodging> getEmployeeLodging(int e_id) { 
	try(Connection conn = ConnectionFactory.getConnection()){ 
		ResultSet rs = null;
		String lod = "SELECT * FROM lodging WHERE employee_id = ?;";
		PreparedStatement ps = conn.prepareStatement(lod);
		ps.setInt(1, e_id);
		rs = ps.executeQuery();
		List<Lodging> lodgingList = new ArrayList<>();
		
		while(rs.next()) {
			Lodging l = new Lodging(
				rs.getInt("employee_id"),
				rs.getInt("lodging_id"),
				rs.getString("lodging_cost"),
				rs.getString("lodging_info"),
				rs.getInt("status")										
			);				
			lodgingList.add(l);
		}
		return lodgingList;
	}
	catch(SQLException e){
		System.out.println("There was an error in selecting Lodging");
	}
	return null; 
}
public int submitLodging(Lodging newLodging) {
	try(Connection conn = ConnectionFactory.getConnection()){
		String lodging = "INSERT INTO lodging (lodging_id, employee_id, lodging_cost, lodging_info) " 
					+ "VALUES (Default,?,?,?); "; 			
		PreparedStatement ps = conn.prepareStatement(lodging);
		ps.setInt(1, newLodging.getE_id());
		ps.setString(2, newLodging.getLodging_cost());
		ps.setString(3, newLodging.getLodging_info());
		ps.executeUpdate();
		System.out.println("Lodging Information Sucessfully Inputted");	
		return 1;
	}
	catch(SQLException e) {
		System.out.println("There was an error while attempting to input Lodging information");
		return 0;
	}
}
public int updateLodgingStatus(Lodging Lodging) {
	try(Connection conn = ConnectionFactory.getConnection()){
		String lodging = "UPDATE lodging SET status = ? WHERE lodging_id = ?;";
		PreparedStatement ps = conn.prepareStatement(lodging);
		ps.setInt(1, Lodging.getStatus());
		ps.setInt(2, Lodging.getLodging_id());
		ps.executeUpdate();
		System.out.println("The status of this request has been set to: " + Lodging.getStatus());
		return 1;
	} catch (SQLException e) {
		System.out.println("Something went wrong during the update");
		e.printStackTrace();
		return 0;
	}	
}
public int updateLodgingStatus(int decision, int lodging_id) {
	try(Connection conn = ConnectionFactory.getConnection()){
		String lodging = "UPDATE lodging SET status = ? WHERE lodging_id = ?;";
		PreparedStatement ps = conn.prepareStatement(lodging);
		ps.setInt(1, decision);
		ps.setInt(2, lodging_id);
		ps.executeUpdate();
		System.out.println("The status of this request has been set to: " + decision);
		return 1;
	} catch (SQLException e) {
		System.out.println("Something went wrong during the update");
		return 0;
	}
}
}
