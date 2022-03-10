package com.instil

import io.dropwizard.Configuration
import com.fasterxml.jackson.annotation.JsonProperty

class DemoConfiguration : Configuration() {

    @get:JsonProperty
    @set:JsonProperty
    var clientName = "Megacorp"
}