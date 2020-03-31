package com.csye6225.courseserviceDB.service;

public class ServiceFactory {

	private static ServiceFactory instance;
	private CourseService courseService;
	private LectureService lectureService;
	private ProfessorService professorService;
	private ProgramService programService;
	private StudentService studentService;
	
	private ServiceFactory() {}
	
	public static ServiceFactory getServiceFactory() {
		if(instance == null) {
			instance = new ServiceFactory();
		}
		
		return instance;
	}
	
	public CourseService getCourseService() {
		if(courseService == null) {
			courseService = new CourseService();
		}
		
		return courseService;
	}
	
	public LectureService getLectureService() {
		if(lectureService == null) {
			lectureService = new LectureService();
		}
		
		return lectureService;
	}
	
	public ProfessorService getProfessorService() {
		if(professorService == null) {
			professorService = new ProfessorService();
		}
		
		return professorService;
	}
	
	public ProgramService getProgramService() {
		if(programService == null) {
			programService = new ProgramService();
		}
		
		return programService;
	}
	
	public StudentService getStudentService() {
		if(studentService == null) {
			studentService = new StudentService();
		}
		
		return studentService;
	}
}
