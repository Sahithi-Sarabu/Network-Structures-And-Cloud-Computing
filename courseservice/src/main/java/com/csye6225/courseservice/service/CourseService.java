package com.csye6225.courseservice.service;

import java.util.*;
import com.csye6225.courseservice.model.CourseMap;

public class CourseService {
	
	public static HashMap<String, Course> courseDB = CourseMap.getCourseMap();
	
	
	public List<Course> getAllCourses() {
		ArrayList<Course> list = new ArrayList<>();
		for(Course c : courseDB.values()) {
			list.add(c);
		}
		return list;
	}

	public static Course getCourseById(String id) {
		if(isValidCourse(id)) {
			return courseDB.get(id);
		}
		return null;
	}

	public boolean addCourse(Course course) {
		String courseId = course.getCourseName();
		if(courseId == null || courseId.equals("") || isValidCourse(courseId)) {
			return false;
		}
		course = new Course(course.getCourseName());
		courseDB.put(course.getCourseName(), course);
		return true;
	}
	

	public boolean updateCourse(String id, Course course) {
		if(isValidCourse(id)) {
			course.setCourseName(id);
			courseDB.put(id, course);
			return true;
		}
		return false;
	}

	public boolean deleteCourse(String id) {
		if(isValidCourse(id)) {
			courseDB.remove(id);
			return true;
		}
		return false;
	}

	public boolean assignProfessor(String courseId, String profId) {
		if(isValidCourse(courseId) && ProfessorService.isValidProfessor(profId)) {
			Professor prof = ProfessorService.getProfessorById(profId);
			Course course = getCourseById(courseId);
			course.setProfTeaching(prof);
			return true;
		}
		return false;
	}

	public boolean assignTA(String courseId, String studentId) {
		if(isValidCourse(courseId) && StudentService.isValidStudent(studentId)) {
			Student TA = StudentService.getStudentById(studentId);
			Course course = getCourseById(courseId);
			course.setTA(TA);
			return true;
		}
		return false;
	}

	public boolean addLecture(String courseId, String lectureId) {
		if(isValidCourse(courseId) && LectureService.isValidLecture(lectureId)) {
			Course course = getCourseById(courseId);
			course.getLectures().add(lectureId);
			return true;
		}
		return false;
	}
	
	public static boolean isValidCourse(String courseName) {
		return courseDB.containsKey(courseName);
	}
}
