package com.csye6225.courseserviceDB.service;

import java.util.ArrayList;
import java.util.List;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedList;

public class StudentService extends BaseService {
	
	public List<Student> getAllStudents() {
		ArrayList<Student> list = new ArrayList<>();
		PaginatedList<Student> studentScannedList = dbMapper.scan(Student.class, new DynamoDBScanExpression());
		for(Student student : studentScannedList) {
			list.add(student);
		}
		return list;
	}

	public boolean addStudent(Student student) {
		student.setStudentId(student.getFirstName() + student.getLastName());
		String id = student.getStudentId();
		if(id == null || id.equals("")) {
			return false;
		}
		Student s = isValidStudent(id);
		if(s != null) {
			return false;
		}
		student = new Student(student.getStudentId(), student.getFirstName(), student.getLastName());
		dbMapper.save(student);
		return true;
	}

	public Student getStudentById(String studentId) {
		Student student = isValidStudent(studentId);
		return student;
	}

	public boolean updateStudent(String studentId, Student student) {
		Student student1 = isValidStudent(studentId);
		if(student1 != null) {
			student1.setStudentId(studentId);
			List<String> courseList = student.getCoursesEnrolled();
			if(courseList == null) {
				courseList = new ArrayList<>();
			}
			student1.setCoursesEnrolled(courseList);
			student1.setFirstName(student.getFirstName());
			student1.setLastName(student.getLastName());
			student1.setProgramTaken(student.getProgramTaken());
			dbMapper.save(student1);
			return true;
		}
		return false;
	}

	public boolean deleteStudent(String studentId) {
		Student student = isValidStudent(studentId);
		if(student != null) {
			dbMapper.delete(student);
			return true;
		}
		return false;
	}

	public boolean selectProgram(String studentId, String programId) {
		Student student = isValidStudent(studentId);
		Program prog = ServiceFactory.getServiceFactory().getProgramService().isValidProgram(programId);
		if(student != null  && prog != null) {
			student.setProgramTaken(prog);
			dbMapper.save(student);
			return true;
		}
		return false;
	}

	public boolean registerCourse(String studentId, String courseId) {
		Student student = isValidStudent(studentId);
		Course choosen = ServiceFactory.getServiceFactory().getCourseService().isValidCourse(courseId);
		if(student != null && choosen != null) {
			Program taken = student.getProgramTaken();
			List<String> courses = ServiceFactory.getServiceFactory().getProgramService().getProgramById(taken.getProgramId()).getCourseList();
			if(courses.contains(courseId)) {
				student.getCoursesEnrolled().add(courseId);
				choosen.getStudentsEnrolled().add(studentId);
				
				dbMapper.save(student);
				ServiceFactory.getServiceFactory().getCourseService().getDbMapper().save(choosen);
				return true;
			}
		}
		return false;
	}
	
	public Student isValidStudent(String studentId) {
		Student student = dbMapper.load(Student.class, studentId);
		if(student != null) {
			return student;
		}
		return null;
	}
}
