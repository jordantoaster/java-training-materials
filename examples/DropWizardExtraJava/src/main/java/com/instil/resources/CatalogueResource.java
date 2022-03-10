package com.instil.resources;

import com.instil.model.Course;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static com.instil.model.CourseDifficulty.BEGINNER;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

@Path("/catalogue")
public class CatalogueResource {
    private final Client client;

    public CatalogueResource(Client client) {
        this.client = client;
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Response allCoursesAsJson() {
        return client.target("http://localhost:8080")
                .path("courses")
                .request(APPLICATION_JSON_TYPE)
                .get();
    }

    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public Response courseByIdAsJson(@PathParam("id") String id) {
        var response = client.target("http://localhost:8080")
                .path("courses")
                .path(id)
                .request(APPLICATION_JSON_TYPE)
                .get();

        if(response.getStatus() == 200) {
            return response;
        }

        var dummyCourse = new Course("AA11", "Presentation Skills", BEGINNER, 2);
        return Response.ok(dummyCourse).build();
    }
}
