package com.csye6225.courseservice.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Professor {
	private String firstName;
	private String lastName;
	private String professorId;
	private String department;
		
	public Professor(){
	}
	
	public Professor(String firstName, String lastName,String professorId, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.professorId = professorId;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Professor [firstName=" + firstName + ", lastName=" + lastName + ", professorId=" + professorId
				+ ", department=" + department + "]";
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

	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
