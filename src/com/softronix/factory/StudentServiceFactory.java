package com.softronix.factory;

import com.softronix.service.StudentService;
import com.softronix.service.StudentServiceImp;

public class StudentServiceFactory {
	private static StudentService stdService;
	
	static
	{
		stdService = new StudentServiceImp();
	}
	
	public static StudentService getStudentService()
	{
		return stdService;
	}

}
