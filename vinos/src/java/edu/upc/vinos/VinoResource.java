/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.vinos;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alumno
 */
@Path("/vinos")
public class VinoResource {

    VinoDAO dao = new VinoDAO();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Vino> findAll() {
        return dao.findAll();
    }

    @GET
    @Path("search/{query}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Vino> findByName(@PathParam("query") String query) {
        System.out.println("findByName: " + query);
        return dao.findByName(query);
    }
}
