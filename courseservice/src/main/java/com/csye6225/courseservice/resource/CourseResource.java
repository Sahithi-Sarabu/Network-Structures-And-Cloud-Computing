package com.csye6225.courseservice.resource;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.csye6225.courseservice.service.Course;
import com.csye6225.courseservice.service.CourseService;

@Path("courses")
public class CourseResource {
	
	CourseService courseServ = new CourseService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getAllCourses(){
		return courseServ.getAllCourses();
	}
	
	@Path("course/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Course getCourseById(@PathParam("id") String id) {
		return CourseService.getCourseById(id);
	}
	
	@Path("course")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCourse(Course course) {
		Response response = null;
		boolean status = courseServ.addCourse(course);
		if(status) {
			response = Response.status(Status.OK).entity("Course " + course.getCourseName() + " has been added successfully").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Course could not be added").build();
		}
		return response;
	}
	
	@Path("course/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCourse(@PathParam("id") String id, Course course) {
		Response response = null;
		boolean status = courseServ.updateCourse(id, course);
		if(status) {
			response = Response.status(Status.OK).entity("Course " + id + " has been updated successfully").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Course could not be updated").build();
		}
		return response;
	}
	
	@Path("course/{id}")
	@DELETE
	public Response deleteCourse(@PathParam("id") String id) {
		Response response = null;
		boolean status = courseServ.deleteCourse(id);
		if(status) {
			response = Response.status(Status.OK).entity("Course " + id + " has been deleted successfully").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Course could not be deleted").build();
		}
		return response;
	}
	
	@Path("course/{courseId}/assignProf/{profId}")
	@GET
	public Response assignProfessor(@PathParam("courseId") String courseId, @PathParam("profId") String profId) {
		boolean status = courseServ.assignProfessor(courseId, profId);
		Response response = null;
		if(status) {
			response = Response.status(Status.OK).entity("Course " + courseId + " has been assigned with professor " + profId ).build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Professor could not be assigned to the given course").build();
		}
		return response;
	}
	
	@Path("course/{courseId}/assignTA/{studentId}")
	@GET
	public Response assignTA(@PathParam("courseId") String courseId, @PathParam("studentId") String studentId) {
		boolean status = courseServ.assignTA(courseId, studentId);
		Response response = null; 
		if(status) {
			response = Response.status(Status.OK).entity("Course " + courseId + " has been assigned with student " + studentId + " as TA").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Student could not be assigned to given course as TA").build();
		}
		return response;
	}
	
	@Path("course/{courseId}/addLectures/{lectureId}")
	@GET
	public Response  addLectures(@PathParam("courseId") String courseId, @PathParam("lectureId") String lectureId ) {
		boolean status = courseServ.addLecture(courseId, lectureId);
		Response response = null;
		if(status) {
			response = Response.status(Status.OK).entity("Course " + courseId + " has been added with lecture " + lectureId +" successfully").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Specified lecture cannot be added to the given course").build();
		}
		return response;
	}
	
}
