package com.csye6225.courseserviceDB.service;

import java.util.ArrayList;
import java.util.List;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedList;

public class ProgramService extends BaseService {
	
	public List<Program> getAllPrograms() {
		ArrayList<Program> list = new ArrayList<>();
		PaginatedList<Program> progScannedList = dbMapper.scan(Program.class, new DynamoDBScanExpression());
		for(Program prog : progScannedList) {
			list.add(prog);
		}
		return list;
	}
	
	public boolean addProgram(Program prog) {
		String id = prog.getProgramId();
		if(id== null ||  id.equals("")) {
			return false;
		}
		Program program = isValidProgram(id);
		if(program != null) {
			return false;
		}
		prog = new Program(prog.getProgramId());
		dbMapper.save(prog);
		return true;
	}
	
	public Program getProgramById(String id) {
		Program program = isValidProgram(id);
		return program;
	}
	
	public boolean updateProgramById(String id, Program prog) {
		Program program = isValidProgram(id);
		if(program != null) {
			program.setProgramId(id);
			List<String> courseList = prog.getCourseList();
			if(courseList == null) {
				courseList = new ArrayList<>();
			}
			program.setCourseList(courseList);
			dbMapper.save(program);
			return true;
		}
		return false;
	}
	
	public boolean deleteProgram(String id) {
		Program program = isValidProgram(id);
		if(program != null) {
			dbMapper.delete(program);
			return true;
		}
		return false;
	}

	public boolean addCoursesToProgram(String programId, String courseName) {
		Program program = isValidProgram(programId);
		Course course = ServiceFactory.getServiceFactory().getCourseService().isValidCourse(courseName);
		if(program != null && course != null) {
			program.getCourseList().add(courseName);
			dbMapper.save(program);
			return true;
		}
		return false;
	}
	
	public Program isValidProgram(String programId) {
		Program program = dbMapper.load(Program.class, programId);
		if(program != null) {
			return program;
		}
		return null;
	}

}
