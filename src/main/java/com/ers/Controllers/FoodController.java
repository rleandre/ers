package com.ers.Controllers;

import java.util.List;

import com.google.gson.Gson;
import com.ers.models.Food;
import com.ers.services.FoodService;
import io.javalin.http.Handler;

public class FoodController {
	FoodService fs = new FoodService();
	
	public Handler getFoodHandler = ctx ->{
		if(ctx.req.getSession(true) != null) {
			try{ 
				List<Food> Food = fs.getFood();
				Gson gson = new Gson();
				String JSONFood = gson.toJson(Food);
				ctx.result(JSONFood);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching Food Requests");
				ctx.status(404);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}
	};
	public Handler getSingleFoodHandler = ctx ->{
		if(ctx.req.getSession(true) != null) {
			try{
				List<Food> Food = fs.getSingleFood();
				Gson gson = new Gson();
				String JSONFood = gson.toJson(Food);
				ctx.result(JSONFood);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching Food Request");
				ctx.status(404);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}
	};
	public Handler getEmployeeFoodHandler = ctx ->{
		if(ctx.req.getSession(true) != null) {
			try {
				int e_id = Integer.parseInt(ctx.pathParam("e_id"));
				List<Food> Food = fs.getEmployeeFood(e_id);
				Gson gson = new Gson();
				String JSONFoods = gson.toJson(Food);
				ctx.result(JSONFoods);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching Food Requests");
				ctx.status(404);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}
	};
	public Handler submitFoodHandler = (ctx) -> {
		if(ctx.req.getSession(true) != null) {
			try {
				String body = ctx.body();
				Gson gson = new Gson();
				Food Food = gson.fromJson(body, Food.class);
				fs.submitFood(Food);
				ctx.result("Food was sucessfully added!");
				ctx.status(201);
			}
			catch(Exception e) {
				ctx.result("Failed to insert Food request");
				ctx.status(406);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}
	};
	public Handler updateFoodStatusHandler = ctx ->{
		if(ctx.req.getSession(true) != null) {
			try{
				String body = ctx.body();
				Gson gson = new Gson();
				Food Food = gson.fromJson(body, Food.class);
				fs.updateFoodStatus(Food);
				ctx.result("Food Status was sucessfully updated!");
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while updating Food Status");
				ctx.status(406);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}
	};
}
