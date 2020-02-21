package com.csye6225.courseservice.service;

import java.util.*;
import com.csye6225.courseservice.model.LectureMap;

public class LectureService {
	
	public static HashMap <String, Lecture> lectureDB = LectureMap.getLectureMap();

	public List<Lecture> getAllLectures() {
		ArrayList<Lecture> list = new ArrayList<>();
		for(Lecture lecture : lectureDB.values()) {
			list.add(lecture);
		}
		return list;
	}
	
	public boolean addLecture(Lecture lecture) {
		String id = lecture.getLectureId();
		if(id == null || id.equals("") || isValidLecture(id)) {
			return false;
		}
		lecture = new Lecture(id);
		lectureDB.put(id,  lecture);
		return true;
	}

	public static Lecture getLectureById(String lectureId) {
		if(isValidLecture(lectureId)) {
			return lectureDB.get(lectureId);
		}
		return null;
	}

	public boolean updateLecture(String lectureId, Lecture lecture) {
		if(isValidLecture(lectureId)) {
			lecture.setLectureId(lectureId);
			lectureDB.put(lectureId, lecture);
			return true;
		}
		return false;
	}

	public boolean deleteLecture(String lectureId) {
		if(isValidLecture(lectureId)) {
			lectureDB.remove(lectureId);
			return true;
		}
		return false;
	}

	public boolean addNotes(String lectureId, String notes) {
		if(isValidLecture(lectureId)) {
			Lecture lecture = lectureDB.get(lectureId);
			lecture.getNotesAssociated().add(notes);
			return true;
		}
		return false;
	}
	
	public static boolean isValidLecture(String lectureId) {
		return lectureDB.containsKey(lectureId);
	}

}
