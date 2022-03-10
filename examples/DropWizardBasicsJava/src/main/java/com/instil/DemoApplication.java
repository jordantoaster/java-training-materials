package com.instil;

import com.instil.health.CoursesHealthCheck;
import com.instil.model.Builder;
import com.instil.resources.CoursesResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/*
    Run with the following:
    java -jar build/libs/[NAME].jar server config.yaml
 */
class DemoApplication extends Application<DemoConfiguration> {
    public static void main(String[] args) throws Exception {
        new DemoApplication().run(args);
    }

    @Override
    public void run(DemoConfiguration configuration, Environment environment) throws Exception {
        System.out.printf("Running service for %s\n", configuration.getClientName());

        var resource = new CoursesResource(Builder.buildPortfolio());
        var healthCheck = new CoursesHealthCheck();


        environment.healthChecks()
                .register("template", healthCheck);

        environment.jersey()
                .register(resource);
    }


    @Override
    public void initialize(Bootstrap<DemoConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/", "/client"));
    }
}
