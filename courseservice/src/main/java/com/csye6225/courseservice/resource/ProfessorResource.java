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

import com.csye6225.courseservice.service.Professor;
import com.csye6225.courseservice.service.ProfessorService;

@Path("professors")
public class ProfessorResource {
	
	ProfessorService profService = new ProfessorService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> getProfessors() {
		return profService.getAllProfessors();
	}
	
	@Path("professor")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProfessor(Professor prof) {
		boolean stat = profService.addProfessor(prof);
		Response response = null;
		if(stat) {
			response = Response.status(Status.OK).entity("New Professor with ID " + prof.getProfessorId() + " Successfully Added").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Professor could not be added").build();
		}
		return response;
	}
	
	@Path("professor/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Professor getProfessorById(@PathParam("id") String id) {
		return ProfessorService.getProfessorById(id);
	}
	
	@Path("professor/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProfessor(@PathParam("id") String id, Professor prof) {
		boolean stat = profService.updateProfessor(id, prof);
		Response response = null;
		if(stat) {
			response = Response.status(Status.OK).entity("Professor with ID " + id + " Successfully Updated").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Professor could not be updated").build();
		}
		return response;
	}
	
	@Path("professor/{id}")
	@DELETE
	public Response deleteProfessor(@PathParam("id") String id) {
		boolean stat = profService.deleteProfessor(id);
		Response response = null;
		if(stat) {
			response = Response.status(Status.OK).entity("Professor with ID " + id + " Successfully Deleted").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Professor could not be deleted").build();
		}
		return response;
	}
}
