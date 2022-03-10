package com.instil.resources

import com.instil.errors.NoCoursesException
import com.instil.model.Course
import com.instil.model.CourseDifficulty
import javax.ws.rs.*
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType.APPLICATION_JSON
import javax.ws.rs.core.MediaType.TEXT_PLAIN
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriInfo

@Path("/courses")
class CoursesResource(private val courses: MutableMap<String, Course>) {
    @GET
    @Produces(APPLICATION_JSON)
    fun allCoursesAsJson(@Context info: UriInfo): Response {
        val criteria = info.queryParameters["type"]?.get(0)

        val output = if (criteria != null) {
            val difficulty = CourseDifficulty.valueOf(criteria)
            courses
                .filterValues { it.difficulty == difficulty }
                .values
        } else {
            courses.values
        }

        if (output.isEmpty()) {
            val extra = if (criteria != null) "of that type" else ""
            throw NoCoursesException("No courses $extra remain")
        }

        return Response.ok()
            .header("NumCourses", output.size)
            .entity(output)
            .build()
    }

    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    fun courseByIdAsJson(@PathParam("id") id: String): Response {
        return if (courses[id] != null) {
            Response.ok(courses[id])
        } else {
            Response.status(404)
        }.build()
    }

    @DELETE
    @Path("{id}")
    @Produces(TEXT_PLAIN)
    fun deleteACourse(@PathParam("id") id: String): Response {
        return if (courses[id] != null) {
            courses.remove(id)
            Response.ok("[\"$id\"]")
        } else {
            Response.status(404)
        }.build()
    }

    @PUT
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    fun addOrUpdateCourseFromJson(@PathParam("id") id: String, newCourse: Course): Response {
        courses[newCourse.id] = newCourse
        return Response.noContent().build()
    }
}
