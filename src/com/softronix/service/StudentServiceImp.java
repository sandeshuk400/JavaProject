package com.softronix.service;

import com.softronix.bean.Student;
import com.softronix.dao.StudentDao;
import com.softronix.factory.StudentDaoFactory;

public class StudentServiceImp implements StudentService {
	
	StudentDao stdDao = StudentDaoFactory.getStudentDao();

	@Override
	public String addStudent(Student std){
		
		String status = stdDao.add(std);
		return status;
	}

	@Override
	public Student searchStudent(String sid) {
		
		Student std = stdDao.search(sid);
		return std;
	}

	@Override
	public String updateStudent(Student std) {
		
		String status = stdDao.update(std);
		return status;
	}

	@Override
	public String deleteStudent(String sid) {
		
		String status = stdDao.delete(sid);
		return status;
	}

}

//package->class->add->
