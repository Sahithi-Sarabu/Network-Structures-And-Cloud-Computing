package com.csye6225.courseserviceDB.datamodel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Professor")
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
	
	@DynamoDBIgnore
	@Override
	public String toString() {
		return "Professor [firstName=" + firstName + ", lastName=" + lastName + ", professorId=" + professorId
				+ ", department=" + department + "]";
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
	
	@DynamoDBHashKey(attributeName="professorId")
	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}
	
	@DynamoDBAttribute(attributeName="department")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}