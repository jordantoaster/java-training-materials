package com.instil.errors

import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper

class CoursesExceptionMapper : ExceptionMapper<NoCoursesException> {
    override fun toResponse(ex: NoCoursesException): Response {
        return Response.status(Response.Status.SERVICE_UNAVAILABLE)
            .entity("[\"${ex.message}\"]")
            .build()
    }
}
