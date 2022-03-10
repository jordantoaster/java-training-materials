package com.instil.health

import com.codahale.metrics.health.HealthCheck

class CoursesHealthCheck : HealthCheck() {
    override fun check() = Result.healthy()
}
