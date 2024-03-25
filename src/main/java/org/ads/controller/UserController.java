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
import org.ads.entities.User;
import org.ads.services.UserService;

import java.util.List;

@Path("users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findById(@QueryParam("id") Long id){
        User user = userService.findById(id);
        if (user != null) {
            return Response.status(Response.Status.OK).entity(user).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("user/{nameuser}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findNameUser(@PathParam("nameuser") String nameuser) {
        List<User> users = userService.searchByName(nameuser);
        if (!users.isEmpty()){
            return Response.status(Response.Status.OK).entity(users).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("listUsers")
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
        User createdUser = userService.createNewUser(user.getName(), user.getEmail(), user.getUserName(), user.getRole(), user.getPassword() );
        if (createdUser != null){
            return Response.status(Response.Status.CREATED).entity(user).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("updateUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateUser(@QueryParam("id") Long id, User user) {
        user.setId(id);
        User foundUser = userService.findById(id);
        if (foundUser == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado").build();
        }
        userService.updateUser(user);
        return Response.status(Response.Status.OK).entity(user).build();
    }

    @DELETE
    @Path("delete")
    public Response deleteUser(@QueryParam("id") Long id) {
        userService.deleteUser(id);
        return Response.status(Response.Status.OK).build();
    }
}

