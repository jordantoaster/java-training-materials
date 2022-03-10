package com.instil.errors;

import static javax.ws.rs.core.Response.Status.SERVICE_UNAVAILABLE;

import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.core.Response;

public class CoursesExceptionMapper implements ExceptionMapper<NoCoursesException> {
    @Override
    public Response toResponse(NoCoursesException ex) {
        String msg = String.format("[\"%s\"]", ex.getMessage());
        return Response.status(SERVICE_UNAVAILABLE)
                .entity(msg)
                .build();
    }
}
