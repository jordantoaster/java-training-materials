package com.instil.health;

import com.codahale.metrics.health.HealthCheck;

public class CoursesHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
