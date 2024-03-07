package com.softronix.factory;


import com.softronix.dao.StudentDao;

import com.softronix.dao.StudentDaoImp;

public class StudentDaoFactory {
	
	private static StudentDao stdDao;
	
	static
	{
		stdDao = new StudentDaoImp();
			
	}
	public static StudentDao getStudentDao()
	{
		return stdDao;
	}

}
