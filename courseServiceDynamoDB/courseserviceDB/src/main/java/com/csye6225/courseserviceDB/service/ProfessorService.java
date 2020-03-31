package com.csye6225.courseserviceDB.service;

import java.util.*;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedList;

public class ProfessorService extends BaseService {
	
	public List<Professor> getAllProfessors(){
		List<Professor> profList = new ArrayList<>();
		PaginatedList<Professor> profScannedList = dbMapper.scan(Professor.class, new DynamoDBScanExpression());
		for(Professor prof :  profScannedList) {
			profList.add(prof);
		}
		return profList;
	}
	
	public boolean addProfessor(Professor prof) {
		prof.setProfessorId(prof.getFirstName() + prof.getLastName());
		String id = prof.getProfessorId();
		if(id == null || id.contentEquals("")) {
			return false;
		}
		Professor prof2 = isValidProfessor(id);
		if(prof2 != null) {
			return false;
		}
		prof = new Professor(prof.getFirstName(), prof.getLastName(), id, prof.getDepartment());
		dbMapper.save(prof);
		return true;	
	}
	
	public Professor getProfessorById(String profId) {
		Professor prof = isValidProfessor(profId);
		return prof;
	}
	
	public boolean updateProfessor(String id, Professor prof) {
		Professor professor = isValidProfessor(id);
		if(professor != null) {
			professor.setDepartment(prof.getDepartment());
			professor.setFirstName(prof.getFirstName());
			professor.setLastName(prof.getLastName());
			professor.setProfessorId(id);
			dbMapper.save(professor);
			return true;
		}
		return false;
	}
	
	public boolean deleteProfessor(String id) {
		Professor prof = isValidProfessor(id);
		if(prof != null) {
			dbMapper.delete(prof);
			return true;
		}
		return false;
	}

	public Professor isValidProfessor(String profId) {
		Professor prof = dbMapper.load(Professor.class, profId);
		if(prof != null) {
			return prof;
		}
		return null;
	}
}
