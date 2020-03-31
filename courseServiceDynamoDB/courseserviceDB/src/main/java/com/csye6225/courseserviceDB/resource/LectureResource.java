package com.csye6225.courseserviceDB.resource;

import java.util.List;

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

import com.csye6225.courseserviceDB.service.Lecture;
import com.csye6225.courseserviceDB.service.LectureService;
import com.csye6225.courseserviceDB.service.ServiceFactory;

@Path("lectures")
public class LectureResource {
	
	LectureService lectureServ = ServiceFactory.getServiceFactory().getLectureService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lecture> getAllLectures(){
		return lectureServ.getAllLectures();
	}
	
	
	@Path("lecture")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addLecture(Lecture lecture) {
		Response response = null;
		boolean status = lectureServ.addLecture(lecture);
		if(status) {
			response = Response.status(Status.OK).entity("Lecture "+ lecture.getLectureId() + " has been successfully added").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Cannot add the given lecture").build();
		}
		return response;
	}
	
	@Path("lecture/{lectureId}")
	@GET
	public Lecture getLecturebyId(@PathParam("lectureId") String lectureId) {
		return lectureServ.getLectureById(lectureId);
	}
	
	@Path("lecture/{lectureId}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateLecture(@PathParam("lectureId") String lectureId, Lecture lecture) {
		boolean status = lectureServ.updateLecture(lectureId, lecture);
		Response response = null;
		if(status) {
			response = Response.status(Status.OK).entity("Lecture "+ lectureId + " successfully updated").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Lecture could not be updated").build();
		}
		return response;
	}
	
	@Path("lecture/{lectureId}")
	@DELETE
	public Response deleteLecture(@PathParam("lectureId") String lectureId) {
		boolean status = lectureServ.deleteLecture(lectureId);
		Response response = null;
		if(status) {
			response = Response.status(Status.OK).entity("Lecture "+ lectureId + " successfully deleted").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Lecture could not be deleted").build();
		}
		return response;
	}
	
	@Path("lecture/{lectureId}/notes")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNotes(@PathParam("lectureId") String lectureId, String notes) {
		boolean status = lectureServ.addNotes(lectureId,notes);
		Response response = null;
		if(status) {
			response = Response.status(Status.OK).entity("Lecture "+ lectureId + " successfully added with given notes").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Cannot add the given lecture to the given course").build();
		}
		return response;
	}
}
