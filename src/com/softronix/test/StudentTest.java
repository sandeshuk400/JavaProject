package com.softronix.test;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import com.softronix.bean.Student;
import com.softronix.factory.StudentServiceFactory;
import com.softronix.service.StudentService;

public class StudentTest {

	public static void main(String[] args) {
		
		try 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true)
			{
				System.out.println("*****Perform a CRUD Operations*****");
				System.out.println("-----------------------------------");
				System.out.println(" 1.ADD ");
				System.out.println(" 2.SEARCH ");
				System.out.println(" 3.UPDATE ");
				System.out.println(" 4.DELETE ");
				System.out.println(" 5.EXIT ");
				System.out.println();
				
				System.out.println("Enter CRUD Choice[1,2,3,4,5] : ");
				int option = Integer.parseInt(br.readLine());
				
				String sid, sname,saddr,status;
				StudentService studentService = StudentServiceFactory.getStudentService();
				
				Student std = null;
				
				switch(option) 
				{
				case 1:
					System.out.println("Student ID       :");
					 sid = br.readLine();
					
					System.out.println("Student Name     :");
					 sname = br.readLine();
					
					System.out.println("Student Address  :");
				     saddr = br.readLine();
					
					
				     
				     std = new Student();//bean class object
					
					std.setSid(sid);
					std.setSname(sname);
					std.setSaddr(saddr);
					
					
					status = studentService.addStudent(std);
					System.out.println("Student Status: "+status);
					break;
				case 2:
					System.out.println("Student Id: ");
					sid = br.readLine();
					
					std=studentService.searchStudent(sid);
					
					if(std==null)
					{
						System.out.println("Student not Exist");
					}
					else
					{
						System.out.println("****Student Details****");
						System.out.println("-----------------------");
						System.out.println("Student Id     : "+std.getSid());
						System.out.println("Student Name   : "+std.getSname());
						System.out.println("Student Address: "+std.getSaddr());
						System.out.println();
					}
						
					break;
				case 3:
					System.out.println("Student ID: ");
					sid = br.readLine();
					std = studentService.searchStudent(sid);
					if(std==null)
					{
						System.out.println("Student not Exist");
					}
					else
					{
						System.out.println("Student name: [Old Name: '"+std.getSname()+"'] new: ");
						String new_sname = br.readLine();
						if(new_sname==null || new_sname.equals(""))
						{
							new_sname = std.getSname();
						}
						
						System.out.println("Student name: [Old Address: '"+std.getSaddr()+"'] new: ");
						String new_saddr = br.readLine();
						if(new_saddr==null || new_saddr.equals(""))
						{
							new_saddr = std.getSaddr();
						}
						
						Student new_std = new Student();
						new_std.setSid(sid);
						new_std.setSname(new_sname);
						new_std.setSaddr(new_saddr);
						
						status = studentService.updateStudent(new_std);
						System.out.println("Update Status: "+status);
						
						
						
					}
						
					break;
				case 4:
					System.out.println("Student ID: ");
					sid = br.readLine();
					std = studentService.searchStudent(sid);
					
					if(std==null)
					{
						System.out.println("Status: Student Not Exist");
					}
					else
					{
						status = studentService.deleteStudent(sid);
						System.out.println("Status : "+status);
					}
						
					break;
				case 5:
					
					System.out.println("Thank You Please Visit Again");
					System.exit(0);
						
					break;
                                    
					
				default:
					
					System.out.println("||---Please Provide a choice from[1,2,3,4,5]---||");
					break;
				}
				
				
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
