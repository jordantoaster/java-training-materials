package com.instil.resources

import com.instil.model.Course
import com.instil.model.CourseDifficulty.*
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.client.Client
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/catalogue")
class CatalogueResource(private val client: Client) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun allCoursesAsJson(): Response {
        return client.target("http://localhost:8080")
            .path("courses")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .get()
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun courseByIdAsJson(@PathParam("id") id: String?): Response {
        val response = client.target("http://localhost:8080")
            .path("courses")
            .path(id)
            .request(MediaType.APPLICATION_JSON_TYPE)
            .get()

        return if (response.status == 200) {
            response
        } else {
            val dummyCourse = Course("AA11", "Presentation Skills", BEGINNER, 2)
            Response.ok(dummyCourse).build()
        }
    }
}

