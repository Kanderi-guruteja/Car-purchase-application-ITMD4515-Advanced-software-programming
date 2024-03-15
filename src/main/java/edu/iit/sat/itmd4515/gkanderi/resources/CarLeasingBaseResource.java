package edu.iit.sat.itmd4515.gkanderi.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 18722
 */
@Path("/carleasing")
public class CarLeasingBaseResource {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
     @GET
     @Path("/version")
    public Response version(){
        return Response
                .ok("v1")
                .build();
    }
    
}
