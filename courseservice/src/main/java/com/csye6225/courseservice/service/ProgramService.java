package com.csye6225.courseservice.service;

import java.util.*;
import com.csye6225.courseservice.model.ProgramMap;

public class ProgramService {
	
	static HashMap<String, Program> progDB = ProgramMap.getProgramMap();
	
	public List<Program> getAllPrograms() {
		ArrayList<Program> list = new ArrayList<>();
		for(Program prog : progDB.values()) {
			list.add(prog);
		}
		return list;
	}
	
	public boolean addProgram(Program prog) {
		String id = prog.getProgramId();
		if(id== null ||  id.equals("") || isValidProgram(id)) {
			return false;
		}
		prog = new Program(prog.getProgramId());
		progDB.put(prog.getProgramId(), prog);
		return true;
	}
	
	public static Program getProgramById(String id) {
		if(isValidProgram(id)) {
			return progDB.get(id);
		}
		return null;
	}
	
	public boolean updateProgramById(String id, Program prog) {
		if(isValidProgram(id)) {
			prog.setProgramId(id);
			progDB.put(id, prog);
			return true;
		}
		return false;
	}
	
	public boolean deleteProgram(String id) {
		if(isValidProgram(id)) {
			progDB.remove(id);
			return true;
		}
		return false;
	}

	public boolean addCoursesToProgram(String programId, String courseName) {
		if(isValidProgram(programId) && CourseService.isValidCourse(courseName)) {
			progDB.get(programId).getCourseList().add(courseName);
			return true;
		}
		return false;
	}
	
	public static boolean isValidProgram(String programId) {
		return progDB.containsKey(programId);
	}

}
