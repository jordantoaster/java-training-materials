package com.instil;

import com.instil.errors.CoursesExceptionMapper;
import com.instil.health.CoursesHealthCheck;
import com.instil.model.Builder;
import com.instil.resources.CatalogueResource;
import com.instil.resources.CoursesResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/*
    Run with the following:
    java -jar build/libs/[NAME].jar server config.yaml
 */
class CourseApplication extends Application<CourseConfiguration> {
    public static void main(String[] args) throws Exception {
        new CourseApplication().run(args);
    }

    @Override
    public void run(CourseConfiguration configuration, Environment environment) throws Exception {
        System.out.printf("Running service for %s\n", configuration.getClientName());

        var client = new JerseyClientBuilder(environment)
                .using(configuration.getJerseyClientConfiguration())
                .build(getName());

        var coursesResource = new CoursesResource(Builder.buildPortfolio());
        var catalogueResource = new CatalogueResource(client);
        var errorMapper = new CoursesExceptionMapper();
        var healthCheck = new CoursesHealthCheck();


        environment.healthChecks()
                .register("template", healthCheck);

        environment.jersey()
                .register(coursesResource);

        environment.jersey()
                .register(catalogueResource);

        environment.jersey()
                .register(errorMapper);
    }


    @Override
    public void initialize(Bootstrap<CourseConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/", "/client"));
    }
}
