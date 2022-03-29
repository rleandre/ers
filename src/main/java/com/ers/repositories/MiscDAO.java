package com.ers.repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ers.models.Misc;
import com.ers.util.ConnectionFactory;

public class MiscDAO {
	
	public List<Misc> getMisc() {
		try(Connection conn = ConnectionFactory.getConnection()){ 
			ResultSet rs = null;
			String misc = "SELECT * FROM misc;";
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(misc);
			List<Misc> miscList = new ArrayList<>();
	
			while(rs.next()) {
				Misc m = new Misc(
					rs.getInt("employee_id"),
					rs.getInt("misc_id"),
					rs.getString("misc_cost"),
					rs.getString("misc_info"),
					rs.getInt("status")
					);			
				miscList.add(m);
			}
			return miscList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Misc");
		}
		return null; 
	}   
	public List<Misc> getSingleMisc() {
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			String misc = "SELECT * FROM misc WHERE status IS NULL LIMIT 1;";
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(misc);			
			List<Misc> miscList = new ArrayList<>();
			
			while(rs.next()) {
				Misc m = new Misc(
					rs.getInt("employee_id"),
					rs.getInt("misc_id"),
					rs.getString("misc_cost"),
					rs.getString("misc_info"),
					rs.getInt("status")				
					);			
				miscList.add(m);
			}
			return miscList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Misc");
		}
		return null;
	}   	
	public List<Misc> getEmployeeMisc(int e_id) { 
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			String misc = "SELECT * FROM misc WHERE employee_id = ?;";
			PreparedStatement ps = conn.prepareStatement(misc);
			ps.setInt(1, e_id);
			rs = ps.executeQuery();
			List<Misc> miscList = new ArrayList<>();
			
			while(rs.next()) {
				Misc m = new Misc(
					rs.getInt("employee_id"),
					rs.getInt("misc_id"),
					rs.getString("misc_cost"),
					rs.getString("misc_info"),
					rs.getInt("status")				
					);
				miscList.add(m);
			}
			return miscList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Misc");
		}
		return null; 
	}   	
	public int submitMisc(Misc newMisc) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String misc = "INSERT INTO misc (employee_id, misc_cost,  misc_info ) " 
						+ "VALUES (?,?,?); "; 
			PreparedStatement ps = conn.prepareStatement(misc);
			ps.setInt(1, newMisc.getE_id());
			ps.setString(2, newMisc.getMisc_cost());
			ps.setString(3, newMisc.getMisc_info());
			ps.executeUpdate();
			System.out.println("Misc Information Sucessfully Inputted");
			return 1;
		}
		catch(SQLException e) {
			System.out.println("There was an error while attempting to input Misc information");
			return 0;
		}
	}
	public int updateMiscStatus(Misc Misc) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String misc = "UPDATE misc SET status = ? WHERE misc_id = ?;";
			PreparedStatement ps = conn.prepareStatement(misc);
			ps.setInt(1, Misc.getStatus());
			ps.setInt(2, Misc.getMisc_id());
			ps.executeUpdate();
			System.out.println("The status of this request has been set to: " + Misc.getStatus());
			return 1;
		} catch (SQLException e) {
			System.out.println("Something went wrong during the update");
			return 0;
		}
	}
	public int updateMiscStatus(int decision, int misc_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String misc = "UPDATE misc SET status = ? WHERE misc_id = ?;";
			PreparedStatement ps = conn.prepareStatement(misc);
			ps.setInt(1, decision);
			ps.setInt(2, misc_id);
			ps.executeUpdate();
			System.out.println("The status of this request has been set to: " + decision);
			return 1;
		} catch (SQLException e) {
			System.out.println("Something went wrong during the update");
			return 0;
		}
	}
}
