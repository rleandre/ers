package com.ers.Controllers;

import java.util.List;
import com.google.gson.Gson;
import com.ers.models.Employee;
import com.ers.models.Food;
import com.ers.models.Lodging;
import com.ers.models.Misc;
import com.ers.models.Travel;
import com.ers.services.EmployeeService;
import com.ers.services.FoodService;
import com.ers.services.LodgingService;
import com.ers.services.MiscService;
import com.ers.services.TravelService;
import io.javalin.http.Handler;

public class EmployeeController {
	EmployeeService es = new EmployeeService();
	FoodService fs = new FoodService();
	LodgingService ls = new LodgingService();
	MiscService ms = new MiscService();
	TravelService ts = new TravelService();
	
	public Handler getEmployeeRequestsHandler = (ctx) -> {
		if(ctx.req.getSession(true) != null) {
			try { 
				int e_id = Integer.parseInt(ctx.pathParam("e_id"));		
				//Lodging
				List<Lodging> Lodging = ls.getEmployeeLodging(e_id);
				Gson lgson = new Gson();
				String JSONLodgings = lgson.toJson(Lodging);
				//Travel
				List<Travel> Travel = ts.getEmployeeTravel(e_id);
				Gson tgson = new Gson();
				String JSONTravel = tgson.toJson(Travel);
				//Food
				List<Food> Food = fs.getEmployeeFood(e_id);
				Gson fgson = new Gson();
				String JSONFoods = fgson.toJson(Food);	
				//Misc
				List<Misc> Misc = ms.getEmployeeMisc(e_id);
				Gson mgson = new Gson();
				String JSONMisc = mgson.toJson(Misc);
				String JCC = JSONLodgings.concat(JSONTravel).concat(JSONFoods).concat(JSONMisc);
				ctx.result(JCC);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching this Employees Requests");
				ctx.status(404);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}	
	};
	public Handler submitEmployeeHandler = (ctx) -> {
		if(ctx.req.getSession(true) != null) {
			try {
				String body = ctx.body();
				Gson gson = new Gson();
				Employee employee = gson.fromJson(body, Employee.class);
				es.submitEmployee(employee);
				ctx.result("Employee was successfully added!");
				ctx.status(201);
			}
			catch(Exception e) {
				ctx.result("Failed to insert employees");
				ctx.status(406);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);
		}
	};
}
