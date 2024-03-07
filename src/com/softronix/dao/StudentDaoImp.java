package com.softronix.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;

import com.softronix.bean.Student;
import com.softronix.factory.ConnectionFactory;

public class StudentDaoImp implements StudentDao {

	@Override
	public String add(Student std) {
		String status ="";
		try 
		{
			Connection con =ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from student where sid = '"+std.getSid()+"'");
			boolean b = rs.next();
			
			if(b == true)
			{
				status ="Student already Existed";
			}
			else
			{
				int rowCount=st.executeUpdate("insert into student values('"+std.getSid()+"','"+std.getSname()+"','"+std.getSaddr()+"')");
				if(rowCount == 1)
				{
					status="Student Record inserted succesfully";
					
				}
				else
				{
					status="Student Record insertion get failure";
					
				}
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public Student search(String sid) {
		Student std =null;
		try 
		{
			Connection con =ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from student where sid = '"+sid+"'");
			boolean b = rs.next();
			
			
			if(b == true)
			{
				std = new Student();
				std.setSid(rs.getString("SID"));
				std.setSname(rs.getString("SNAME"));
				std.setSaddr(rs.getString("SADDR"));
				
			}
			else
			{
				std=null;
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return std;
	}

	@Override
	public String update(Student std) {
		String status = "";
		try 
		{
			Connection con =ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			
			int rowCount = st.executeUpdate("update student set sname = '"+std.getSname()+"', saddr = '"+std.getSaddr()+"' where sid = '"+std.getSid()+"'");
			if(rowCount == 1)
			{
				status = "Student Record Succesfully Updated";
			}
			else
			{
				status = "Student Record Failure";
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public String delete(String sid) {
		String status = "";
		try
		{
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pst =con.prepareStatement("delete from student where sid = ?");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter id to be delete: ");
			int sidd = Integer.parseInt(br.readLine());
			
			pst.setInt(1, sidd);
			
			int rowCount = pst.executeUpdate();
			
		    if(rowCount == 1)
		    {
		    	status = "Student Data deletion Succesfully";
		    }
		    else
		    {
		    	status = "Student Data deletion Failure";
		    }
			
		    
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
		
	}

	//packagedao ==> class==>class name written--->click add button--->search select implemented class studentdao
}
