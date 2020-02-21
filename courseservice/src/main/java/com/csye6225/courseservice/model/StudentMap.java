package com.csye6225.courseservice.model;

import java.util.HashMap;

import com.csye6225.courseservice.service.Student;

public class StudentMap {
	
	private static HashMap<String, Student> studentMap = new HashMap<>();

	public static HashMap<String, Student> getStudentMap() {
		return studentMap;
	}

}
