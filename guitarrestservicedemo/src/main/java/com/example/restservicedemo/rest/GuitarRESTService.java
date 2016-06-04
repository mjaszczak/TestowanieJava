package com.example.restservicedemo.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restservicedemo.domain.Guitar;
import com.example.restservicedemo.service.GuitarManager;

@Path("guitar")
public class GuitarRESTService {

    private GuitarManager gm = new GuitarManager();

    @GET
    @Path("/{guitarId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Guitar getGuitar(@PathParam("guitarId") Long id) {
        Guitar g = gm.getGuitar(id);
        return g;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGuitar(Guitar guitar) {
        gm.addGuitar(guitar);
        return Response.status(201).entity("Guitar").build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Guitar> getAllGuitars() {
        List<Guitar> guitars = gm.getAllGuitars();
        return guitars;
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_HTML)
    public String testGuitar() {
        return "REST API /guitar is running";
    }

    @DELETE
    public Response clearGuitars() {
        gm.clearGuitars();
        return Response.status(200).build();
    }

    @POST
    @Path("/{guitarId}")
    public Response updateGuitar(@PathParam("guitarId") Long id){
        Guitar guitar = gm.getGuitar(id);
        gm.updateGuitar(guitar, "Czibson", "Dres Paul");
        return Response.status(200).build();
    }

}