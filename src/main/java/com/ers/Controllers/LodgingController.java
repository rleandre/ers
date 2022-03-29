package com.ers.Controllers;

import java.util.List;
import com.google.gson.Gson;
import com.ers.models.Lodging;
import com.ers.services.LodgingService;
import io.javalin.http.Handler;

public class LodgingController {
	LodgingService ls = new LodgingService();

	public Handler getLodgingHandler = ctx ->{
		if(ctx.req.getSession(true) != null) {
			try {
				List<Lodging> Lodging = ls.getLodging();
				Gson gson = new Gson();
				String JSONLodging = gson.toJson(Lodging);	
				ctx.result(JSONLodging);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching Lodging Requests");
				ctx.status(404);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(401);	
		}	
	};
	public Handler getSingleLodgingHandler = ctx ->{
		if(ctx.req.getSession(true) != null) {
			try { //checks if the session exists
				List<Lodging> Lodging = ls.getSingleLodging();
				Gson gson = new Gson();
				String JSONLodging = gson.toJson(Lodging);
				ctx.result(JSONLodging);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching Lodging Request");
				ctx.status(404);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(401);	
		}	
	};
	public Handler getEmployeeLodgingHandler = ctx -> {
		if(ctx.req.getSession(true) != null) {
			try{ 
				int e_id = Integer.parseInt(ctx.pathParam("e_id"));
				List<Lodging> Lodging = ls.getEmployeeLodging(e_id);
				Gson gson = new Gson();
				String JSONLodgings = gson.toJson(Lodging);
				ctx.result(JSONLodgings);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching Lodging Requests");
				ctx.status(404);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(401);	
		}	
	};
	public Handler submitLodgingHandler = (ctx) -> {
		if(ctx.req.getSession(true) != null) {
			try {
				String body = ctx.body();
				Gson gson = new Gson();
				Lodging Lodging = gson.fromJson(body, Lodging.class);
				ls.submitLodging(Lodging);
				ctx.result("Lodging was sucessfully added!");
				ctx.status(201);
			}
			catch(Exception e) {
				ctx.result("Failed to insert Lodging request");
				ctx.status(406);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(401);	
		}	
	};
	public Handler updateLodgingStatusHandler = ctx ->{
		if(ctx.req.getSession(true) != null) {
			try {
				String body = ctx.body();
				Gson gson = new Gson();
				Lodging Lodging = gson.fromJson(body, Lodging.class);			
				ls.updateLodgingStatus(Lodging);
				ctx.result("Lodging Status was sucessfully updated!");
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while updating Lodging Status");
				ctx.status(406);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(401);	
		}	
	};
}
	


	

