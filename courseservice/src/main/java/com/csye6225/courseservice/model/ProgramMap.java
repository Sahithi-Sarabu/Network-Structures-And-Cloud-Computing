package com.csye6225.courseservice.model;

import java.util.HashMap;

import com.csye6225.courseservice.service.Program;

public class ProgramMap {
	
	private static HashMap<String, Program> programMap = new HashMap<>();

	public static HashMap<String, Program> getProgramMap() {
		return programMap;
	}

}
