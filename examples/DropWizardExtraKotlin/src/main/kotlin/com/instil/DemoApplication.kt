package com.instil

import com.instil.errors.CoursesExceptionMapper
import com.instil.health.CoursesHealthCheck
import com.instil.model.Builder
import com.instil.resources.CatalogueResource
import com.instil.resources.CoursesResource
import io.dropwizard.Application
import io.dropwizard.assets.AssetsBundle
import io.dropwizard.client.JerseyClientBuilder
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import javax.ws.rs.client.Client

/*
    Run with the following:
    java -jar build/libs/[NAME].jar server config.yaml
 */
class DemoApplication : Application<DemoConfiguration>() {

    override fun initialize(bootstrap: Bootstrap<DemoConfiguration>) {
        bootstrap.addBundle(AssetsBundle("/assets/", "/client"))
    }

    override fun run(
        configuration: DemoConfiguration,
        environment: Environment
    ) {
        println("Running service for ${configuration.clientName}")

        val client: Client = JerseyClientBuilder(environment)
            .using(configuration.jerseyClient)
            .build(name)

        val coursesResource = CoursesResource(Builder.buildPortfolio())
        val catalogueResource = CatalogueResource(client)
        val errorMapper = CoursesExceptionMapper()
        val healthCheck = CoursesHealthCheck()

        with(environment) {
            healthChecks().register("template", healthCheck)
            with(jersey()) {
                register(coursesResource)
                register(catalogueResource)
                register(errorMapper)
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            DemoApplication().run(*args)
        }
    }
}
