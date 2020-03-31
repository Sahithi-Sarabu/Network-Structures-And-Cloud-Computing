package com.csye6225.courseserviceDB.service;

import java.util.ArrayList;
import java.util.List;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;

@DynamoDBTable(tableName="Course")
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
	
	@DynamoDBHashKey(attributeName="courseName")
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	@DynamoDBTyped(DynamoDBAttributeType.M)
	@DynamoDBAttribute(attributeName="profTeaching")
	public Professor getProfTeaching() {
		return profTeaching;
	}

	public void setProfTeaching(Professor profTeaching) {
		this.profTeaching = profTeaching;
	}
	
	@DynamoDBTyped(DynamoDBAttributeType.M)
	@DynamoDBAttribute(attributeName="TA")
	public Student getTA() {
		return TA;
	}

	public void setTA(Student tA) {
		TA = tA;
	}
	
	@DynamoDBTyped(DynamoDBAttributeType.L)
	@DynamoDBAttribute(attributeName="studentsEnrolled")
	public List<String> getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(List<String> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}
	
	@DynamoDBTyped(DynamoDBAttributeType.L)
	@DynamoDBAttribute(attributeName="lectures")
	public List<String> getLectures() {
		return lectures;
	}

	public void setLectures(List<String> lectures) {
		this.lectures = lectures;
	}
	
}
