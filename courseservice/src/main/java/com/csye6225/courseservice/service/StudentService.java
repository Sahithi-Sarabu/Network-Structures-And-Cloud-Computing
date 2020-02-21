package com.csye6225.courseservice.service;

import java.util.*;
import com.csye6225.courseservice.model.StudentMap;

public class StudentService {
	
	public static HashMap<String, Student> studentDB = StudentMap.getStudentMap();
	
	public List<Student> getAllStudents() {
		ArrayList<Student> list = new ArrayList<>();
		for(Student stud : studentDB.values()) {
			list.add(stud);
		}
		return list;
	}

	public boolean addStudent(Student student) {
		student.setStudentId(student.getFirstName() + student.getLastName());
		String id = student.getStudentId();
		if(id == null || id.equals("") || isValidStudent(id)) {
			return false;
		}
		student = new Student(student.getStudentId(), student.getFirstName(), student.getLastName());
		studentDB.put(student.getStudentId(), student);
		return true;
	}

	public static Student getStudentById(String studentId) {
		if(isValidStudent(studentId)) {
			return studentDB.get(studentId);
		}
		return null;
	}

	public boolean updateStudent(String studentId, Student student) {
		if(isValidStudent(studentId)) {
			student.setStudentId(studentId);
			studentDB.put(studentId, student);
			return true;
		}
		return false;
	}

	public boolean deleteStudent(String studentId) {
		if(isValidStudent(studentId)) {
			studentDB.remove(studentId);
			return true;
		}
		return false;
	}

	public boolean selectProgram(String studentId, String programId) {
		if(isValidStudent(studentId) && ProgramService.isValidProgram(programId)) {
			Student student = studentDB.get(studentId);
			Program prog = ProgramService.getProgramById(programId);
			student.setProgramTaken(prog);
			return true;
		}
		return false;
	}

	public boolean registerCourse(String studentId, String courseId) {
		if(isValidStudent(studentId) && CourseService.isValidCourse(courseId)) {
			Student student = studentDB.get(studentId);
			Program taken = student.getProgramTaken();
			Course  choosen = CourseService.getCourseById(courseId);
			if(taken.getCourseList().contains(courseId)) {
				student.getCoursesEnrolled().add(courseId);
				choosen.getStudentsEnrolled().add(studentId);
				return true;
			}
		}
		return false;
	}
	
	public static boolean isValidStudent(String studentId) {
		return studentDB.containsKey(studentId);
	}
}
