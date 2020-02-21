package com.csye6225.courseservice.model;

import java.util.HashMap;

import com.csye6225.courseservice.service.Lecture;

public class LectureMap {
	
	private static HashMap<String, Lecture> LectureMap = new HashMap<>();

	public static HashMap<String, Lecture> getLectureMap() {
		return LectureMap;
	}

}
