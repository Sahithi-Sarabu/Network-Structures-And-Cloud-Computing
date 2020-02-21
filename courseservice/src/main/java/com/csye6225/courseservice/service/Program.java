package com.csye6225.courseservice.service;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Program {
	
	private String programId;
	private List<String> courseList;
	
	public Program() {
	}
	
	public Program(String programId) {
		this.programId = programId;
		setCourseList(new ArrayList<>());
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public List<String> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<String> courseList) {
		this.courseList = courseList;
	}
}
