package com.ers.Controllers;

import com.google.gson.Gson;
import com.ers.models.Employee;
import com.ers.services.AuthService;
import io.javalin.http.Handler;

public class AuthController {
	
	AuthService as = new AuthService();
	
	public Handler loginHandler = (ctx) -> {
		String body = ctx.body();
		Gson gson = new Gson();
		Employee Employee = gson.fromJson(body, Employee.class);
		if(as.login(Employee.getEmployee_username(),Employee.getEmployee_password()) == 2) {
			ctx.req.getSession();
			ctx.status(202);
			ctx.result("Login Successful!" );
		}
		else if(as.login(Employee.getEmployee_username(),Employee.getEmployee_password()) == 1) {		
			ctx.req.getSession();
			ctx.status(201);
			ctx.result("Login Successful!" );
		}
		else {
			ctx.status(401);
			ctx.result("Login Failed");
		}
	};
}
