package com.csye6225.courseservice.service;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	
	private String studentId;
	private String firstName;
	private String lastName;
	private List<String> coursesEnrolled;
	private Program programTaken;
	
	public Student(){
	}
	
	public Student(String id, String fname, String lname) {
		studentId = id;
		firstName = fname;
		lastName = lname;
		coursesEnrolled = new ArrayList<>();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/*public List<Course> getCoursesEnrolled() {
		return coursesEnrolled;
	}
	
	public void setCoursesEnrolled(List<Course> coursesEnrolled) {
		this.coursesEnrolled = coursesEnrolled;
	}*/

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Program getProgramTaken() {
		return programTaken;
	}

	public void setProgramTaken(Program programTaken) {
		this.programTaken = programTaken;
	}

	public List<String> getCoursesEnrolled() {
		return coursesEnrolled;
	}

	public void setCoursesEnrolled(List<String> coursesEnrolled) {
		this.coursesEnrolled = coursesEnrolled;
	}
	

}
