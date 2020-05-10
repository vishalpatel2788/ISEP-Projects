package com.example.coronavirustracker.controllers;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.coronavirustracker.models.Details;

@Controller
@ComponentScan({"com.example.coronavirustracker"})
@RequestMapping("/index")
public class ContactUsController {
	
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://http://127.0.0.1:9090//coronadb","root","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Details u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into details(name,mobile,remark,email,s1,s2,s3,s4) values(?,?,?,?,?,?,?,?)");
			ps.setString(1,u.getName());
			ps.setString(2,u.getMobile());
			ps.setString(3,u.getRemark());
			ps.setString(4,u.getEmail());
			ps.setString(5,u.getS1());
			ps.setString(6,u.getS2());
			ps.setString(7,u.getS3());
			ps.setString(8,u.getS4());
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
				u.setRemark(rs.getString("remark"));
				u.setEmail(rs.getString("email"));
				u.setS1(rs.getString("s1"));
				u.setS2(rs.getString("s2"));
				u.setS3(rs.getString("s3"));
				u.setS4(rs.getString("s4"));
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	
}
