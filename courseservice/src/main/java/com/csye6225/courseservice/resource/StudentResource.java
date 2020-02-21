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

import com.csye6225.courseservice.service.Student;
import com.csye6225.courseservice.service.StudentService;

@Path("students")
public class StudentResource {
	
	StudentService studentService = new StudentService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@Path("student")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudent(Student student) {
		Response response = null;
		boolean status = studentService.addStudent(student);
		if(status) {
			response = Response.status(Status.OK).entity("Student with ID " + student.getStudentId() + " has been added successfully").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Student could not be added").build();
		}
		return response;
	}
	
	@Path("student/{studentId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentById(@PathParam("studentId") String studentId) {
		return StudentService.getStudentById(studentId);
	}
	
	
	@Path("student/{studentId}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStudent(@PathParam("studentId") String studentId, Student student) {
		Response response = null;
		boolean status = studentService.updateStudent(studentId, student);
		if(status) {
			response = Response.status(Status.OK).entity("Student with ID " + studentId + " has been updated successfully").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Student could not be updated").build();
		}
		return response;
	}
	
	
	@Path("student/{studentId}")
	@DELETE
	public Response deleteStudent(@PathParam("studentId") String studentId) {
		Response response = null;
		boolean status = studentService.deleteStudent(studentId);
		if(status) {
			response = Response.status(Status.OK).entity("Student with ID " + studentId + " has been deleted successfully").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Student could not be deleted").build();
		}
		return response;
	}
	
	@Path("student/{studentId}/selectProgram/{programId}")
	@GET
	public Response selectProgram(@PathParam("studentId") String studentId, @PathParam("programId") String programId) {
		boolean status = studentService.selectProgram(studentId, programId);
		Response response = null;
		if(status) {
			response = Response.status(Status.OK).entity("Student with ID " + studentId + " has selected the program " + programId + " successfully").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Student could not select the requested program").build();
		}
		return response;
	}
	
	@Path("student/{studentId}/registerCourse/{courseId}")
	@GET
	public Response registerCourse(@PathParam("studentId") String studentId , @PathParam("courseId") String courseId) {
		boolean status =  studentService.registerCourse(studentId, courseId);
		Response response = null;
		if(status) {
			response = Response.status(Status.OK).entity("Student with ID " + studentId + " has selected the course " + courseId + " successfully").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Student could not select the requested course").build();
		}
		return response;
	}
}
