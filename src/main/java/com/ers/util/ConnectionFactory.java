package com.ers.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class ConnectionFactory {
	
	 private static ConnectionFactory instance;
	 
	 private ConnectionFactory() {
	        super();
	        
	    }
	 
	 
	 /**
	     * This method follows the Singleton Design Pattern
	     * to restrict this class to only having 1 instance
	     * It is invoked via:
	     *
	     * ConnectionFactory.getInstance()
	     */
	 
	 public static ConnectionFactory getInstance() {
	        if(instance == null) {
	            instance = new ConnectionFactory();
	        }

	        return instance;
	    }
	 
	 /**
	     * The {@link ConnectionFactory#getConnection()} method is responsible for 
	     * leveraging a specific Database Driver to obtain an instance of the {@link java.sql.Connection} interface
	     * 
	     * Typically, this is accomplished via the use of the {@link java.sql.DriverManager} class.</p>
	     * @throws SQLException 
	     */
	    public static Connection getConnection() throws SQLException {
	       
	    	//For compatibility with other technologies, w need to register our PostgreSQL Driver 
	    	//This process makes the application aware of what database Driver (SQL dialect) we're using
	    	try {
	    		Class.forName("org.postgresql.Driver");//try to find and return PostgreSQL Driver class
	    	}
	    	catch (ClassNotFoundException e) {
	    		System.out.println("CLASS WASN'T FOUND");
	    		e.printStackTrace();//this will print the exception message to the console
	    	}
	    	
	    	//we need to provide our database credentials
	    	//well hard code them for now, but ill show a way to hide the credentials in environment variables 
	    	
	    	//the url to my database schema
	    	String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=project1";
	    	
	    	
	    	//My Postgres user name
	    	String username = "postgres";
	    	
	    	
	    	//My Postgres password
	    	String password = "password";
	    	
	    	
	    	//this is what actually returns our Connection Object (note how this method has a return type of connection)
	    	return DriverManager.getConnection(url, username, password);
	    	
	    }
}
