package com.ers.models;

import java.util.List;
import java.util.Scanner;

import com.ers.repositories.EmployeeDAO;
import com.ers.repositories.FoodDAO;
import com.ers.repositories.LodgingDAO;
import com.ers.repositories.TravelDAO;
import com.ers.services.EmployeeService;
import com.ers.services.FoodService;
import com.ers.services.LodgingService;
import com.ers.services.MiscService;
import com.ers.services.TravelService;
import com.ers.util.ClearConsole;
import com.ers.repositories.MiscDAO;



@SuppressWarnings("unused")
public class Menu_Manager{


	
	Menu_Employee e_menu = new Menu_Employee();
	Scanner scan = new Scanner(System.in);
	Case1 c1 = new Case1();
	Case2 c2 = new Case2();
	Case3 c3 = new Case3();
	Case4 c4 = new Case4();
	
	public void displayMenu() throws Exception {
		
		boolean displayMenu = true;//We are going to use this to toggle whether the menu continues after user input
		while(displayMenu) {
			
			//ClearConsole.clearConsole();
			System.out.println();
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~  Welcome to the Employee Reinbursement Review System  ~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~  What would you like to do?  ~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("1: Approve/Deny Reinbursement Requests");
			System.out.println("2: View Request History by Category");
			System.out.println("3: View Request History by Employee");
			System.out.println("4: Enter New Employee into the System");
			System.out.println("5: Input a Reinbursement Request");
			System.out.println("6: Exit the Program");
			System.out.println();
			String input = scan.nextLine();//user input			
			switch(input) {
				case "1": {
					c1.case1();
					break;
				}
				case "2": { //This case statement only SHOWs the requests to the user
					c2.case2();
					break;
					}	
				case "3": {
					c3.case3();	
					break;
				}
				case "4":{
					c4.case4();
					break;
				}
				case "5":{
					e_menu.displayMenu();
				}	
				case "6": {
					System.out.println();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~  Have a wonderful day!  ~~~~~~~~~~~~~~~~~~~~~~~~~"); 
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();
					displayMenu = false;
					break;
				}
				default: {
					System.out.println();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~  That was not a valid input!  ~~~~~~~~~~~~~~~~~~~~~~"); 
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();
				}
			}
		}
	}
}		

