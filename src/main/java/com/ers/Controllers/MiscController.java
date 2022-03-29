package com.ers.Controllers;

import java.util.List;

import com.google.gson.Gson;
import com.ers.models.Misc;
import com.ers.services.MiscService;
import io.javalin.http.Handler;

public class MiscController {
	MiscService ms = new MiscService();
	

	public Handler getMiscHandler = ctx ->{
		if(ctx.req.getSession(true) != null) {
			try {
				List<Misc> Misc = ms.getMisc();
				Gson gson = new Gson();
				String JSONMisc = gson.toJson(Misc);
				ctx.result(JSONMisc);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching Misc Requests");
				ctx.status(404);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}	
	};
	public Handler getSingleMiscHandler = ctx ->{
		if(ctx.req.getSession(true) != null) {
			try {
				List<Misc> Misc = ms.getSingleMisc();
				Gson gson = new Gson();
				String JSONMisc = gson.toJson(Misc);
				ctx.result(JSONMisc);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching Misc Request");
				ctx.status(404);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}	
	};
	public Handler getEmployeeMiscHandler = ctx ->{
		if(ctx.req.getSession(true) != null) {
			try {
				int e_id = Integer.parseInt(ctx.pathParam("e_id"));
				List<Misc> Misc = ms.getEmployeeMisc(e_id);
				Gson gson = new Gson();
				String JSONMiscs = gson.toJson(Misc);
				ctx.result(JSONMiscs);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching Misc Requests");
				ctx.status(404);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}	
	};
	public Handler submitMiscHandler = (ctx) -> {
		if(ctx.req.getSession(true) != null) {
			try{
				String body = ctx.body();
				Gson gson = new Gson();
				Misc Misc = gson.fromJson(body, Misc.class);
				ms.submitMisc(Misc);
				ctx.result("Misc was sucessfully added!");
				ctx.status(201);
			}
			catch(Exception e) {
				ctx.result("Failed to insert Misc request");
				ctx.status(406);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}		
	};
	public Handler updateMiscStatusHandler = ctx ->{
		if(ctx.req.getSession(true) != null) {
			try{
				String body = ctx.body();
				Gson gson = new Gson();
				Misc Misc = gson.fromJson(body, Misc.class);
				ms.updateMiscStatus(Misc);
				ctx.result("Misc Status was sucessfully updated!");
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while updating Misc Status");
				ctx.status(406);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}	
	};
}
