package com.instil.resources;

import javax.ws.rs.*;

import com.instil.model.Course;
import com.instil.model.CourseDifficulty;
import javax.ws.rs.core.Context;

import static java.util.stream.Collectors.toList;
import static javax.ws.rs.core.MediaType.*;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;
import java.util.Map;

@Path("/courses")
public class CoursesResource {
    private Map<String, Course> courses;

    public CoursesResource(Map<String, Course> courses) {
        this.courses = courses;
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Response allCoursesAsJson(@Context UriInfo info) {
        var typeValues = info.getQueryParameters().get("type");
        Collection<Course> output;

        if (typeValues != null) {
            var difficulty = CourseDifficulty.valueOf(typeValues.get(0));
            output = courses.values()
                    .stream()
                    .filter( c -> c.getDifficulty() == difficulty)
                    .collect(toList());

        } else {
            output = courses.values();
        }

        return Response.ok()
                .header("NumCourses", output.size())
                .entity(output)
                .build();
    }

    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public Response courseByIdAsJson(@PathParam("id") String id) {
        var course = courses.get(id);
        if (course != null) {
            return Response.ok(course).build();
        } else {
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(TEXT_PLAIN)
    public Response deleteACourse(@PathParam("id") String id) {
        var course = courses.get(id);
        if (course != null) {
            courses.remove(id);
            return Response
                    .ok(String.format("[\"%s\"]", id))
                    .build();
        } else {
            return Response
                    .status(404)
                    .build();
        }
    }

    @PUT
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response addOrUpdateCourseFromJson(@PathParam("id") String id, Course newCourse) {
        courses.put(id, newCourse);
        return Response.noContent().build();
    }
}

