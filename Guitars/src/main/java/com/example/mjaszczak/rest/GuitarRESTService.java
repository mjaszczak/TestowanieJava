package com.example.mjaszczak.rest;

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

import com.example.mjaszczak.domain.Guitar;
import com.example.mjaszczak.service.GuitarManager;

@Path("guitar")
public class GuitarRESTService {

    private GuitarManager pm = new GuitarManager();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Guitar> getAllGuitar(){
        List<Guitar> guitar = pm.getAllGuitars();
        return guitar;
    }

    @GET
    @Path("/{guitarId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Guitar getGuitar(@PathParam("guitarId") Long id){
        List<Guitar> guitar = pm.getGuitar(id);
        Guitar g = guitar.get(0);
        return g;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGuitar(Guitar guitar){
        pm.addGuitar(guitar);
        return Response.status(201).entity("Guitar").build();
    }

    @POST
    @Path("/{guitarId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateGuitar(@PathParam("guitarId") Long id){
        List<Guitar> g = pm.getGuitar(id);
        Guitar guitar = g.get(0);
        pm.updateGuitar(guitar, "Brand", "Model");
        return Response.status(200).build();
    }


    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_HTML)
    public String test(){
        return "REST API /guitar is running";
    }

    @GET
    @Path("/testGuitar")
    @Produces(MediaType.TEXT_HTML)
    public String testGuitar() {
        return "REST API /guitar is running";
    }

    @DELETE
    @Path("/")
    public Response clearGuitars(){
        pm.clearGuitars();
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{guitarId}")
    public Response deleteGuitar(@PathParam("guitarId") Long id){
        List<Guitar> g = pm.getGuitar(id);
        Guitar guitar = g.get(0);
        pm.deleteGuitar(guitar);
        return Response.status(200).build();
    }

}