package com.instil;

import io.dropwizard.Configuration;

public class DemoConfiguration extends Configuration {
    public String clientName;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
