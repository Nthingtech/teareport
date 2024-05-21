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
import org.ads.entities.ChildReport;
import org.ads.services.ChildReportService;

import java.util.List;

@Path("childreports")
public class ChildReportController {

    @Inject
    ChildReportService childReportService;


    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findById(@QueryParam("idChildReport") Long idChildReport){
        ChildReport childReport = childReportService.findById(idChildReport);
        if (childReport != null) {
            return Response.status(Response.Status.OK).entity(childReport).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("childReport/{nameChild}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findNameChild(@PathParam("nameChild") String nameChild) {
        List<ChildReport> childReports = childReportService.searchByName(nameChild);
        if (!childReports.isEmpty()){
            return Response.status(Response.Status.OK).entity(nameChild).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("listChildReport")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response listChildReport() {
        List<ChildReport> childReports = childReportService.listAllChildReport();
        return Response.ok(childReports).build();
    }

    @POST
    @Path("createChildReport")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response newChildReport(ChildReport childReport) {
        ChildReport childRepo = childReportService.createNewChildReport(childReport);
        if (childRepo != null) {
            return Response.status(Response.Status.CREATED).entity(childReport).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @PUT
    @Path("updateChildReport")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateChildReport(@QueryParam("idChildReport") Long idChildReport, ChildReport childReport) {
        childReport.setIdChildReport(idChildReport);
        ChildReport foundChildReport = childReportService.findById(idChildReport);
        if (foundChildReport == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Relatório não encontrado").build();
        }
        childReportService.updateChildReport(childReport);
        return Response.status(Response.Status.OK).entity(childReport).build();
    }

    @DELETE
    @Path("delete")
    @Transactional
    public Response deleteChildReport(@QueryParam("idChildReport") Long idChildReport){
        childReportService.deleteChildReport(idChildReport);
        return Response.status(Response.Status.OK).build();
    }


}
