package com.csye6225.courseservice.service;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Course {
	
	private String courseName;
	private Professor profTeaching;
	private Student TA;
	private List<String> studentsEnrolled;
	private List<String> lectures; 
	
	public Course() {
	}
	
	public Course(String courseName) {
		this.courseName = courseName;
		studentsEnrolled = new ArrayList<>();
		lectures = new ArrayList<>();
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Professor getProfTeaching() {
		return profTeaching;
	}

	public void setProfTeaching(Professor profTeaching) {
		this.profTeaching = profTeaching;
	}

	public Student getTA() {
		return TA;
	}

	public void setTA(Student tA) {
		TA = tA;
	}

	public List<String> getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(List<String> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}

	public List<String> getLectures() {
		return lectures;
	}

	public void setLectures(List<String> lectures) {
		this.lectures = lectures;
	}

	/*public List<Student> getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(List<Student> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}*/

	
}
