package com.csye6225.courseserviceDB.service;

import java.util.ArrayList;
import java.util.List;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;

@DynamoDBTable(tableName="Lecture")
public class Lecture {
	
	private String lectureId;
	private List<String> notesAssociated;
	
	public Lecture(){
		
	}
	
	public Lecture(String lectureId) {
		this.lectureId = lectureId;
		notesAssociated = new ArrayList<>();
	}
	
	@DynamoDBHashKey(attributeName="lectureId")
	public String getLectureId() {
		return lectureId;
	}

	public void setLectureId(String lectureId) {
		this.lectureId = lectureId;
	}
	
	@DynamoDBTyped(DynamoDBAttributeType.L)
	@DynamoDBAttribute(attributeName="notesAssociated")
	public List<String> getNotesAssociated() {
		return notesAssociated;
	}

	public void setNotesAssociated(List<String> notesAssociated) {
		this.notesAssociated = notesAssociated;
	}
	
	
}
