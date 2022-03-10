package com.instil

import com.instil.health.CoursesHealthCheck
import com.instil.model.Builder
import com.instil.resources.CoursesResource
import io.dropwizard.Application
import io.dropwizard.assets.AssetsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

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

        val resource = CoursesResource(Builder.buildPortfolio())
        val healthCheck = CoursesHealthCheck()

        with(environment) {
            healthChecks().register("template", healthCheck)
            jersey().register(resource)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            DemoApplication().run(*args)
        }
    }
}
