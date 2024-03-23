package org.ads.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.ads.entities.User;
import org.ads.services.UserService;

import java.util.List;

@Path("users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Path("listUsers")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response listUser() {
        List<User> users = userService.listaAllUsers();
        return Response.ok(users).build();
    }

    @POST
    @Path("createUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createUser(User user) {
        User createdUser = userService.createNewUser(user.getName(), user.getEmail(), user.getUserName(), user.getPassword(), user.getRole());
        return Response.ok(createdUser).build();
    }
}

