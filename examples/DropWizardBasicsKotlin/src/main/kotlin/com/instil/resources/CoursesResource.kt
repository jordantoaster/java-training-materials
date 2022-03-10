package com.instil.resources

import javax.ws.rs.*

import com.instil.model.Course
import com.instil.model.CourseDifficulty
import javax.ws.rs.core.Context

import javax.ws.rs.core.MediaType.*
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriInfo

@Path("/courses")
class CoursesResource(private val courses: MutableMap<String, Course>) {
    @GET
    @Produces(APPLICATION_JSON)
    fun allCoursesAsJson(@Context info: UriInfo): Response {
        val criteria = info.queryParameters["type"]?.get(0)

        val courses = if (criteria != null) {
            val difficulty = CourseDifficulty.valueOf(criteria)
            courses
                .filterValues { it.difficulty == difficulty }
                .values
        } else {
            courses.values
        }

        return Response.ok()
            .header("NumCourses", courses.size)
            .entity(courses)
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
