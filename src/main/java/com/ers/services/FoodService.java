package com.ers.services;

import java.util.List;

import com.ers.models.Food;
import com.ers.repositories.FoodDAO;

public class FoodService {
	FoodDAO fDAO = new FoodDAO();//So that I can use the method sform the employeeDAO

	public List<Food> getFood() throws Exception {
		List<Food> result = fDAO.getFood();
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public List<Food> getSingleFood() throws Exception {
		List<Food> result = fDAO.getSingleFood();
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public List<Food> getEmployeeFood(int e_id) throws Exception {
		List<Food> result = fDAO.getEmployeeFood(e_id);
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public void submitFood(Food newFood) throws Exception {
		int result = fDAO.submitFood(newFood);	
		if(result == 0) {
			throw new Exception();
		}
	}	
	public void updateFoodStatus(Food Food) throws Exception {
		int result = fDAO.updateFoodStatus(Food);
		if(result == 0) {
			throw new Exception();
		}
	}
	public void updateFoodStatus(int decision, int food_id) throws Exception {
		int result = fDAO.updateFoodStatus(decision, food_id);
		if(result == 0) {
			throw new Exception();
		}
	}

}
