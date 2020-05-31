package com.example.coronavirustracker.controllers;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/coronadb";
		String username = "root";
		String password = "";

		System.out.println("Connecting database...");

		try (java.sql.Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		    
		    Statement statement = connection.createStatement();
			boolean res = statement.execute( "INSERT INTO details(name, mobile, email, message) VALUES('John Snow', '987654321', 'john@email.com', 'This is an insertion test')" );
		    
		    statement = connection.createStatement();
			ResultSet result = statement.executeQuery( "SELECT * FROM details" );
			while ( result.next() ) {
			    System.out.println("Statement executed!");
				String name = result.getString( "name");
				String email = result.getString( "email" );
				String mobile = result.getString( "mobile" );
				String message = result.getString( "message" );
				System.out.println("Name: " + name + "\nEmail: " 
						+ email + "\nMobile: " + mobile + "\nMessage:\n" +message);
			}
			result.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}

}
