package org.ads.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.ads.entities.Child;
import org.ads.services.ChildService;

import java.util.List;

@Path("children")
public class ChildController {

    @Inject
    ChildService childService;

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findById(@QueryParam("id") Long id){
        Child child = childService.findById(id);
        if (child != null) {
            return Response.status(Response.Status.OK).entity(child).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("child/{nameChild}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findNameUser(@PathParam("nameChild") String nameChild) {
        List<Child> childList = childService.searchByName(nameChild);
        if (!childList.isEmpty()){
            return Response.status(Response.Status.OK).entity(childList).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("listChildren")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response listUser() {
        List<Child> children = childService.listAllChild();
        return Response.ok(children).build();
    }

    @POST
    @Path("createChild")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response newChildReport(Child child) {
        Child childRepo = childService.newChild(child);
        if (childRepo != null) {
            return Response.status(Response.Status.CREATED).entity(child).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("updateChild")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateChild(@QueryParam("id") Long id, Child child) {
        child.setId(id);
        Child foundChild = childService.findById(id);
        if (foundChild == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Criança não encontrada").build();
        }
        childService.updateChild(child);
        return Response.status(Response.Status.OK).entity(child).build();
    }

    @DELETE
    @Path("delete")
    @Transactional
    public Response deleteChild(@QueryParam("id") Long id){
        childService.deleteChild(id);
        return Response.status(Response.Status.OK).build();
    }


}
