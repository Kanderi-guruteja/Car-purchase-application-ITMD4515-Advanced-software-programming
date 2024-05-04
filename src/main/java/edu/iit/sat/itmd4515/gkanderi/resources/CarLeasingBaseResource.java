/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 * Resource class for handling base requests related to car leasing.
 * Provides endpoints for basic operations like ping and version.
 * 
 * @author 18722
 */
@Path("/carleasing")
public class CarLeasingBaseResource {

    /**
     * Endpoint to check the availability of the service.
     * 
     * @return a response indicating that the service is available
     */
    @GET
    public Response ping() {
        return Response
                .ok("ping Jakarta EE")
                .build();
    }

    /**
     * Endpoint to get the version of the service.
     * 
     * @return a response containing the version of the service
     */
    @GET
    @Path("/version")
    public Response version() {
        return Response
                .ok("v1")
                .build();
    }

}
