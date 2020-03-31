package com.csye6225.courseserviceDB.service;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;

@DynamoDBTable(tableName="Program")
public class Program {
	
	private String programId;
	private List<String> courseList;
	
	public Program() {
	}
	
	public Program(String programId) {
		this.programId = programId;
		setCourseList(new ArrayList<>());
	}
	
	@DynamoDBHashKey(attributeName="programId")
	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}
	
	@DynamoDBTyped(DynamoDBAttributeType.L)
	@DynamoDBAttribute(attributeName="courseList")
	public List<String> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<String> courseList) {
		this.courseList = courseList;
	}
}
