package com.csye6225.courseserviceDB.service;

import java.util.ArrayList;
import java.util.List;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedList;


public class CourseService extends BaseService { 
	
	public List<Course> getAllCourses() {
		ArrayList<Course> list = new ArrayList<>();
		PaginatedList<Course> courseScannedList = dbMapper.scan(Course.class, new DynamoDBScanExpression());
		for(Course c : courseScannedList) {
			list.add(c);
		}
		return list;
	}

	public Course getCourseById(String name) {
		Course course = isValidCourse(name);
		return course;
	}

	public boolean addCourse(Course course) {
		String name = course.getCourseName();
		if(name == null || name.equals("")) {
			return false;
		}
		Course course2 = isValidCourse(name);
		if(course2 != null) {
			return false;
		}
		course = new Course(course.getCourseName());
		dbMapper.save(course);
		return true;
	}
	

	public boolean updateCourse(String id, Course course) {
		Course c = isValidCourse(id);
		if(c != null){
			c.setCourseName(id);
			List<String> lectureList = course.getLectures();
			if(lectureList == null) {
				lectureList = new ArrayList<>();
			}
			c.setLectures(lectureList);
			c.setProfTeaching(course.getProfTeaching());
			List<String> studentsList = course.getStudentsEnrolled();
			if(studentsList == null) {
				studentsList = new ArrayList<>();
			}
			c.setStudentsEnrolled(studentsList);
			c.setTA(course.getTA());
			dbMapper.save(c);
			return true;
		}
		return false;
	}

	public boolean deleteCourse(String id) {
		Course course = isValidCourse(id);
		if(course != null) {
			dbMapper.delete(course);
			return true;
		}
		return false;
	}

	public boolean assignProfessor(String courseId, String profId) {
		Course course = isValidCourse(courseId);
		Professor professor = ServiceFactory.getServiceFactory().getProfessorService().isValidProfessor(profId);
		if(course != null && professor != null) {
			course.setProfTeaching(professor);
			dbMapper.save(course);
			return true;
		}
		return false;
	}

	public boolean assignTA(String courseId, String studentId) {
		Student TA = ServiceFactory.getServiceFactory().getStudentService().isValidStudent(studentId);
		Course course = getCourseById(courseId);
		if(TA != null && course != null) {
			course.setTA(TA);
			dbMapper.save(course);
			return true;
		}
		return false;
	}

	public boolean addLecture(String courseId, String lectureId) {
		Course course = isValidCourse(courseId);
		Lecture lecture = ServiceFactory.getServiceFactory().getLectureService().isValidLecture(lectureId);
		if(course != null && lecture != null) {
			course.getLectures().add(lectureId);
			dbMapper.save(course);
			return true;
		}
		return false;
	}
	
	public Course isValidCourse(String courseName) {
		Course course = dbMapper.load(Course.class, courseName);
		if(course != null) {
			return course;
		}
		return null;
	}
}
