package com.csye6225.courseserviceDB.service;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;

@DynamoDBTable(tableName="Student")
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
	
	@DynamoDBAttribute(attributeName="firstName")
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@DynamoDBAttribute(attributeName="lastName")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@DynamoDBHashKey(attributeName="studentId")
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	@DynamoDBTyped(DynamoDBAttributeType.M)
	@DynamoDBAttribute(attributeName="programTaken")
	public Program getProgramTaken() {
		return programTaken;
	}

	public void setProgramTaken(Program programTaken) {
		this.programTaken = programTaken;
	}
	
	@DynamoDBTyped(DynamoDBAttributeType.L)
	@DynamoDBAttribute(attributeName="coursesEnrolled")
	public List<String> getCoursesEnrolled() {
		return coursesEnrolled;
	}

	public void setCoursesEnrolled(List<String> coursesEnrolled) {
		this.coursesEnrolled = coursesEnrolled;
	}
}
