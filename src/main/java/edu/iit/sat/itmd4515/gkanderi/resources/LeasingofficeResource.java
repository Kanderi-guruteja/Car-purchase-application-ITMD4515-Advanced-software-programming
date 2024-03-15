/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.resources;

import edu.iit.sat.itmd4515.gkanderi.domain.Leasingoffice;
import edu.iit.sat.itmd4515.gkanderi.service.LeasingofficeService;
import jakarta.ejb.EJB;
import jakarta.persistence.OptimisticLockException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author 18722
 */
@Path("/carleasing/leasingoffices")
public class LeasingofficeResource {

    private static final Logger LOG = Logger.getLogger(LeasingofficeResource.class.getName());

    @EJB
    LeasingofficeService leasingofficeService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Leasingoffice> getAllLeasingoffices() {
        List<Leasingoffice> leasingoffices = leasingofficeService.findAll();
        LOG.info("Retrieved all leasing offices: " + leasingoffices.size());
        return leasingoffices;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Leasingoffice createLeasingoffice(Leasingoffice leasingoffice) {
        leasingofficeService.create(leasingoffice);
        LOG.info("Created new leasing office: " + leasingoffice.toString());
        return leasingoffice;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Leasingoffice getLeasingofficeById(@PathParam("id") Long id) {
        Leasingoffice leasingoffice = leasingofficeService.read(id);
        if (leasingoffice != null) {
            LOG.info("Retrieved leasing office with ID " + id + ": " + leasingoffice.toString());
        } else {
            LOG.info("Leasing office with ID " + id + " not found");
        }
        return leasingoffice;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response updateLeasingoffice(@PathParam("id") Long id, Leasingoffice updatedLeasingoffice) {
        updatedLeasingoffice.setId(id);

        int maxRetries = 3;
        for (int i = 0; i < maxRetries; i++) {
            try {
                Leasingoffice currentLeasingoffice = leasingofficeService.read(id);
                if (currentLeasingoffice == null) {
                    return Response.status(Response.Status.NOT_FOUND)
                            .entity("Leasingoffice with ID " + id + " not found.")
                            .build();
                }
                currentLeasingoffice.setLeasingofficeName(updatedLeasingoffice.getLeasingofficeName());
                leasingofficeService.update(currentLeasingoffice);
                LOG.info("Updated Leasingoffice with ID " + id + ": " + currentLeasingoffice.toString());
                return Response.ok(currentLeasingoffice).build();
            } catch (OptimisticLockException e) {
                LOG.warning("OptimisticLockException occurred during update. Retrying... (Attempt " + (i + 1) + ")");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Failed to update Leasingoffice after " + maxRetries + " retries.")
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteLeasingoffice(@PathParam("id") Long id) {
        Leasingoffice leasingofficeToDelete = leasingofficeService.read(id);
        if (leasingofficeToDelete != null) {
            leasingofficeService.delete(leasingofficeToDelete);
            return Response.ok("Leasing office with ID " + id + " deleted.").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Leasing office with ID " + id + " not found.")
                    .build();
        }
    }
}
