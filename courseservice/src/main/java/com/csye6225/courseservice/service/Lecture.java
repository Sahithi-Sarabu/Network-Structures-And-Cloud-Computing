package com.csye6225.courseservice.service;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Lecture {
	
	private String lectureId;
	private List<String> notesAssociated;
	
	public Lecture(){
		
	}
	
	public Lecture(String lectureId) {
		this.lectureId = lectureId;
		notesAssociated = new ArrayList<>();
	}

	public String getLectureId() {
		return lectureId;
	}

	public void setLectureId(String lectureId) {
		this.lectureId = lectureId;
	}

	public List<String> getNotesAssociated() {
		return notesAssociated;
	}

	public void setNotesAssociated(List<String> notesAssociated) {
		this.notesAssociated = notesAssociated;
	}
	
	
}
