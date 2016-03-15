package resources;

import java.util.Collection;

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

import org.springframework.beans.factory.annotation.Autowired;

import sendto.StatusChangesSendto;
import service.StatusChangesService;

@Path(value = "/statusChanges")
public class StatusChangesResource {

	@Autowired
	private StatusChangesService statusChangesService;

	@GET
	@Path(value = "{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public StatusChangesSendto getStatusChanges(@PathParam("id") long id) {
		return statusChangesService.retrieve(id);
	}

	@DELETE
	@Path(value = "{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteStatusChanges(@PathParam("id") long id) {
		statusChangesService.delete(id);
		return Response.status(Status.NO_CONTENT).type(MediaType.APPLICATION_JSON).build();
	}

	@PUT
	@Path(value = "{id}")
	public StatusChangesSendto updateStatusChanges(@PathParam("id") long id, StatusChangesSendto status) {
		return statusChangesService.update(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public StatusChangesSendto saveStatusChanges(StatusChangesSendto status) {
		return statusChangesService.save(status);
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<StatusChangesSendto> findallStatusChanges() {
		return statusChangesService.findAll();
	}

}