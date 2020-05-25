package com.example.coronavirustracker.controllers;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@ComponentScan({"com.example.coronavirustracker"})
@RequestMapping("/contact")
public class ContactUsController {
	
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://http://127.0.0.1:3306//coronadb","root","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	
	
	/*
	public static int save(Details u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.
			prepareStatement("INSERT INTO details(name,mobile,email,message) VALUES(?,?,?,?)");
			ps.setString(1,u.getName());
			ps.setString(2,u.getMobile());
			ps.setString(4,u.getEmail());
			ps.setString(5,u.getMessage());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static List<Details> getAllRecords(){
		List<Details> list=new ArrayList<Details>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from details");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Details u=new Details();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setMobile(rs.getString("mobile"));
				u.setMessage(rs.getString("message"));
				u.setEmail(rs.getString("email"));
				list.add(u);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	
	*/
	
}
