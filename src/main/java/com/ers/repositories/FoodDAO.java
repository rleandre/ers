package com.ers.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ers.models.Food;
import com.ers.util.ConnectionFactory;

public class FoodDAO {
	
	public List<Food> getFood() { 
		try(Connection conn = ConnectionFactory.getConnection()){ 
			ResultSet rs = null;
			String food = "SELECT * FROM food;";
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(food);
			List<Food> foodList = new ArrayList<>();
			
			while(rs.next()) {
				Food f = new Food(
					rs.getInt("employee_id"),
					rs.getInt("food_id"),
					rs.getString("food_cost"),
					rs.getString("food_info"),
					rs.getInt("status")
					);
				foodList.add(f);
			}
			return foodList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Food");
		}
		return null; 
	}  
	public List<Food> getSingleFood() { 
		try(Connection conn = ConnectionFactory.getConnection()){ 
			ResultSet rs = null;
			String food = "SELECT * FROM food WHERE status IS NULL LIMIT 1;";
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(food);
			List<Food> foodList = new ArrayList<>();
			
			while(rs.next()) {
				Food f = new Food(
					rs.getInt("employee_id"),
					rs.getInt("food_id"),
					rs.getString("food_cost"),
					rs.getString("food_info"),
					rs.getInt("status")											
					);	
				foodList.add(f);
			}
			return foodList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Food");
		}
		return null;	
		}   
	public List<Food> getEmployeeFood(int e_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			String food = "SELECT * FROM food WHERE employee_id = ?;";
			PreparedStatement ps = conn.prepareStatement(food);
			ps.setInt(1, e_id);
			rs = ps.executeQuery();
			List<Food> foodList = new ArrayList<>();
			
			while(rs.next()) {
				Food f = new Food(
						rs.getInt("employee_id"),
						rs.getInt("food_id"),
						rs.getString("food_cost"),
						rs.getString("food_info"),
						rs.getInt("status")				
						);		
				foodList.add(f);
			}
			return foodList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Food");
		}
		return null; 
	}  
	public int submitFood(Food newFood) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String food = "INSERT INTO food (employee_id, food_cost, food_info) " 
						+ "VALUES (?,?,?); "; 
			PreparedStatement ps = conn.prepareStatement(food);
			ps.setInt(1, newFood.getE_id());
			ps.setString(2, newFood.getFood_cost());
			ps.setString(3, newFood.getFood_info());
			ps.executeUpdate();
			System.out.println("Food Information Sucessfully Inputted");
			return 1;
		}
		catch(SQLException e) {
			System.out.println("There was an error while attempting to input Food information");
			return 0;
		}
	}    	
	public int updateFoodStatus(Food Food) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String food = "UPDATE food SET status = ? WHERE food_id = ?;";
			PreparedStatement ps = conn.prepareStatement(food);
			ps.setInt(1, Food.getStatus());
			ps.setInt(2, Food.getFood_id());
			ps.executeUpdate();
			System.out.println("The status of this request has been set to: " + Food.getStatus());
			return 1;
		} catch (SQLException e) {
			System.out.println("Something went wrong during the update");
			return 0;
		}	
	}
	public int updateFoodStatus(int decision, int food_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String food = "UPDATE food SET status = ? WHERE food_id = ?;";
			PreparedStatement ps = conn.prepareStatement(food);
			ps.setInt(1, decision);
			ps.setInt(2, food_id);
			ps.executeUpdate();
			System.out.println("The status of this request has been set to: " + decision);
			return 1;
		} catch (SQLException e) {
			System.out.println("Something went wrong during the update");
			return 0;
		}
	}	    			
}
