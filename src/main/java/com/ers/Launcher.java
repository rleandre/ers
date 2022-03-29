package com.ers;


import java.sql.Connection;
import java.sql.SQLException;

import com.ers.Controllers.AuthController;
import com.ers.Controllers.EmployeeController;
import com.ers.Controllers.FoodController;
import com.ers.Controllers.LodgingController;
import com.ers.Controllers.MiscController;
import com.ers.Controllers.TravelController;
import com.ers.models.Menu_Employee;
import com.ers.models.Menu_Manager;
import com.ers.services.AuthService;
import com.ers.util.ConnectionFactory;

import io.javalin.Javalin;

@SuppressWarnings("unused")
public class Launcher {

	public static void main(String[] args) throws Exception {
		EmployeeController ec = new EmployeeController();
		AuthController ac = new AuthController();
		LodgingController lc = new LodgingController();
		TravelController tc = new TravelController();
		FoodController fc = new FoodController();
		MiscController mc = new MiscController();
		AuthService as = new AuthService();
		
		try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful! :)");
		}
		catch(SQLException e) {
			System.out.println("Connection Unsuccessful! :(");
			e.printStackTrace();
		}
		

		//Instantiate a employee menu object
//		Menu_Employee e_menu = new Menu_Employee();
//		//Instantiate a manager upgrade menu object
//		Menu_Manager m_menu = new Menu_Manager();	
//		
//		
//		//Here is the actual functionality of our application---------------------------------------------
//		Boolean Starter = false;
//	
//		if (Starter) {
//		e_menu.displayMenu();
//		}
//		else {		
//		m_menu.displayMenu();
//		}

		
		
		
	
		
		
		
		
		
		
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere	
				}
			).start(3000);
	
		app.get("/", ctx -> ctx.req.getSession());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Get Requests)");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Get Reimbursement Requests)");
		app.get("/lodging", lc.getLodgingHandler);
		app.get("/travel", tc.getTravelHandler);
		app.get("/food", fc.getFoodHandler);
		app.get("/misc", mc.getMiscHandler);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Get Single Reimbursement Request)");
		app.get("/lodging_status", lc.getSingleLodgingHandler);
		app.get("/travel_status", tc.getSingleTravelHandler);
		app.get("/food_status", fc.getSingleFoodHandler);
		app.get("/misc_status", mc.getSingleMiscHandler);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~(Get Reimbursement Requests by Employee ID)");
		app.get("/employee/{e_id}", ec.getEmployeeRequestsHandler);
		app.get("/lodging/{e_id}", lc.getEmployeeLodgingHandler);
		app.get("/travel/{e_id}", tc.getEmployeeTravelHandler);
		app.get("/food/{e_id}", fc.getEmployeeFoodHandler);
		app.get("/misc/{e_id}", mc.getEmployeeMiscHandler);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Post Requests)");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Create new Reimbursement Requests)");
		app.post("/lodging", lc.submitLodgingHandler);
		app.post("/travel", tc.submitTravelHandler);
		app.post("/food", fc.submitFoodHandler);
		app.post("/misc", mc.submitMiscHandler);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Create a new employee)");
		app.post("/employee", ec.submitEmployeeHandler);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Login Request)");
		app.post("/login", ac.loginHandler);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	
		
		
		
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Put Requests)");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~(Update Status of Reimbursement Requests)");
		app.put("/lodging", lc.updateLodgingStatusHandler);
		app.put("/travel", tc.updateTravelStatusHandler);
		app.put("/food", fc.updateFoodStatusHandler);
		app.put("/misc", mc.updateMiscStatusHandler);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	
	
	}

}
