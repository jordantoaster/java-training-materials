package com.instil

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import io.dropwizard.client.JerseyClientConfiguration

class DemoConfiguration : Configuration() {

    @get:JsonProperty
    @set:JsonProperty
    var clientName = "Megacorp"

    @get:JsonProperty("jerseyClient")
    @set:JsonProperty("jerseyClient")
    var jerseyClient = JerseyClientConfiguration()
}
