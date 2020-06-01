package com.example.coronavirustracker.services;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

//import Model
import com.example.coronavirustracker.models.Message;

@Service
public class MessageService {
	public boolean insertMessage(Message msg) {
		
		boolean flag = false;
		
		String url = "jdbc:mysql://localhost:3306/coronadb";
		String username = "root";
		String password = "";


		try (java.sql.Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		    
		    try{
				PreparedStatement ps=connection.
				prepareStatement("INSERT INTO details(name,mobile,email,message) VALUES(?,?,?,?)");
				ps.setString(1,msg.getName());
				ps.setString(2,msg.getMobile());
				ps.setString(3,msg.getEmail());
				ps.setString(4,msg.getMessage());
				int check = ps.executeUpdate();
				
				if(check == 1) {
					System.out.println("Insertion successful!\n");
					flag = true;
				}
				else {
					System.out.println("Insertion Failed!\n");
					flag = false;
				}
			}catch(Exception e){
				flag = false;
				System.out.println(e);
			}
		    
		    
		} catch (SQLException e) {
			flag = false;
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		
		return flag;
	}
	
	public static void main(String[] args) {
		
		//Testing Function
		
		Message msg = new Message();
		msg.setName("Ani");
		msg.setEmail("ani@email.com");
		msg.setMobile("98765432");
		msg.setMessage("TESTING");
		
		MessageService msgSer = new MessageService();
		msgSer.insertMessage(msg);
	}
}
