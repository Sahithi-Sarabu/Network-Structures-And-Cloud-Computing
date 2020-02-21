package com.csye6225.courseservice.service;

import java.util.*;
import com.csye6225.courseservice.model.ProfessorMap;

public class ProfessorService {
	
	public static HashMap<String, Professor> profMapDB = ProfessorMap.getProfMap();
	
	public List<Professor> getAllProfessors(){
		ArrayList<Professor> profList = new ArrayList<>();
		for(Professor prof :  profMapDB.values()) {
			profList.add(prof);
		}
		return profList;
	}
	
	public boolean addProfessor(Professor prof) {
		prof.setProfessorId(prof.getFirstName() + prof.getLastName());
		String id = prof.getProfessorId();
		if(id == null || id.contentEquals("") || isValidProfessor(id)) {
			return false;
		}
		prof = new Professor(prof.getFirstName(), prof.getLastName(), prof.getProfessorId(), prof.getDepartment());
		profMapDB.put(prof.getProfessorId(), prof);
		return true;	
	}
	
	public static Professor getProfessorById(String profId) {
		if(isValidProfessor(profId)) {
			return profMapDB.get(profId);
		}
		return null;
	}
	
	public boolean updateProfessor(String id, Professor prof) {
		if(isValidProfessor(id)) {
			prof.setProfessorId(id);
			profMapDB.put(id, prof);
			return true;
		}
		return false;
	}
	
	public boolean deleteProfessor(String id) {
		if(isValidProfessor(id)) {
			profMapDB.remove(id);
			return true;
		}
		return false;
	}

	public static boolean isValidProfessor(String profId) {
		return profMapDB.containsKey(profId);
	}
}
