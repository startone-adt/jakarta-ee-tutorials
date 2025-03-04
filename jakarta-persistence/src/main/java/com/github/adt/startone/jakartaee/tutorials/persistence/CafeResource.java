package com.github.adt.startone.jakartaee.tutorials.persistence;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.logging.Logger;

import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@Path("coffees")
public class CafeResource {
    private final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Inject
    private CafeRepository cafeRepository;

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Coffee findCoffee(@PathParam("id") Long id) {
        logger.info("Getting coffee by id " + id);
        return cafeRepository.findById(id).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @GET
    @Produces("application/json")
    public List<Coffee> findAll() {
        logger.info("Getting all coffee");
        return cafeRepository.findAll();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Coffee create(Coffee coffee) {
        logger.info("Creating coffee " + coffee.getName());
        try {
            return cafeRepository.create(coffee);
        } catch (PersistenceException ex) {
            logger.info("Error creating coffee " + coffee.getName());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        logger.info("Deleting coffee by id " + id);
        try {
            cafeRepository.delete(id);
        } catch (IllegalArgumentException e) {
            logger.info("Error deleting coffee by id " + id);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Coffee update(Coffee coffee) {
        logger.info("Updating coffee " + coffee.getName());
        try {
            return cafeRepository.create(coffee);
        } catch (PersistenceException ex) {
            logger.info("Error updating coffee " + coffee.getName());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }
}
