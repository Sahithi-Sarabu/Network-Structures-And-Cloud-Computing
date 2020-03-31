package com.csye6225.courseserviceDB.service;

import java.util.ArrayList;
import java.util.List;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedList;

public class LectureService extends BaseService {
	
	public List<Lecture> getAllLectures() {
		ArrayList<Lecture> list = new ArrayList<>();
		PaginatedList<Lecture> lectureScannedList = dbMapper.scan(Lecture.class, new DynamoDBScanExpression());
		for(Lecture lecture : lectureScannedList) {
			list.add(lecture);
		}
		return list;
	}
	
	public boolean addLecture(Lecture lecture) {
		String id = lecture.getLectureId();
		if(id == null || id.equals("")) {
			return false;
		}
		Lecture lect = isValidLecture(id);
		if(lect != null) {
			return false;
		}
		lecture = new Lecture(id);
		dbMapper.save(lecture);
		return true;
	}

	public Lecture getLectureById(String lectureId) {
		Lecture lecture = isValidLecture(lectureId);
		return lecture;
	}

	public boolean updateLecture(String lectureId, Lecture lecture) {
		Lecture lect = isValidLecture(lectureId);
		if(lect != null) {
			lect.setLectureId(lectureId);
			List<String> notes = lecture.getNotesAssociated();
			if(notes == null) {
				notes = new ArrayList<>();
			}
			lect.setNotesAssociated(notes);
			dbMapper.save(lect);
			return true;
		}
		return false;
	}

	public boolean deleteLecture(String lectureId) {
		Lecture lecture = isValidLecture(lectureId);
		if(lecture != null) {
			dbMapper.delete(lecture);
			return true;
		}
		return false;
	}

	public boolean addNotes(String lectureId, String notes) {
		Lecture lecture = isValidLecture(lectureId);
		if(lectureId  != null) {
			lecture.getNotesAssociated().add(notes);
			dbMapper.save(lecture);
			return true;
		}
		return false;
	}
	
	public Lecture isValidLecture(String lectureId) {
		Lecture lecture = dbMapper.load(Lecture.class, lectureId);
		if(lecture != null) {
			return lecture;
		}
		return null;
	}
}
