package com.csye6225.courseservice.model;

import java.util.HashMap;

import com.csye6225.courseservice.service.Course;

public class CourseMap {
	
	private static HashMap<String, Course> courseMap = new HashMap<>();

	public static HashMap<String, Course> getCourseMap() {
		return courseMap;
	}
	

}
