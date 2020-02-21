package com.csye6225.courseservice.model;

import java.util.HashMap;

import com.csye6225.courseservice.service.Professor;

public class ProfessorMap {
	
	private static HashMap<String, Professor> profMap = new HashMap<>();

	public static HashMap<String, Professor> getProfMap() {
		return profMap;
	}

}
