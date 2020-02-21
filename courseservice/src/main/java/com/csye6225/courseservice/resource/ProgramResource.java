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

import com.csye6225.courseservice.service.Program;
import com.csye6225.courseservice.service.ProgramService;

@Path("programs")
public class ProgramResource {
	
	ProgramService progserv = new ProgramService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Program> getAllPrograms(){
		return progserv.getAllPrograms();
	}
	
	@Path("program/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Program getProgramById(@PathParam("id") String id) {
		return ProgramService.getProgramById(id);
	}
	
	
	@Path("program/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProgramById(@PathParam("id") String id, Program prog) {
		Response res = null;
		boolean stat =  progserv.updateProgramById(id, prog);
		if(stat) {
			res = Response.status(Status.OK).entity("Program with ID " + id + " has been updated successfully").build();
		}else {
			res = Response.status(Status.NOT_FOUND).entity("Program could not be updated").build();
		}
		return res;
	}
	
	@Path("program")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProgram(Program prog) {
		Response res =  null;
		boolean added = progserv.addProgram(prog);
		if(added) {
			res = Response.status(Status.OK).entity("New Program with ID " + prog.getProgramId() + " has been added successfully").build();
		}else {
			res = Response.status(Status.NOT_FOUND).entity("Program could not be added").build();
		}
		return res;
	}
	
	@Path("program/{id}")
	@DELETE
	public Response deleteProgram(@PathParam("id") String id) {
		boolean stat = progserv.deleteProgram(id);
		Response response = null;
		if(stat) {
			response = Response.status(Status.OK).entity("Program with ID " + id + " successfully deleted").build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Program could not be deleted").build();
		}
		return response;
	}
	
	@Path("program/{programId}/addCourse/{courseName}")
	@GET
	public Response addCoursesToProgram(@PathParam("programId") String programId, @PathParam("courseName") String courseName) {
		boolean status = progserv.addCoursesToProgram(programId, courseName);
		Response response = null;
		if(status) {
			response = Response.status(Status.OK).entity("Course " + courseName + " successfully add to program " + programId).build();
		}else {
			response = Response.status(Status.NOT_FOUND).entity("Course could not be added to the specified program").build();
		}
		return response;
	}
	

}
