package org.ads.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.ads.entities.ChildReport;
import org.ads.services.ChildReportService;

import java.util.List;

@Path("childreports")
public class ChildReportController {

    @Inject
    ChildReportService childReportService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response newChildReport(ChildReport childReport) {
        ChildReport childRepoAux = childReportService.createNewChildReport(childReport);
        return Response.status(Response.Status.CREATED).entity(childReport).build();
    }

    @GET
    @Path("listChildReport")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response listChildReport() {
        List<ChildReport> childReports = childReportService.listAllChildReport();
        return Response.ok(childReports).build();
    }
}
