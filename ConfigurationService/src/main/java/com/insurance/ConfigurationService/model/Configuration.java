package com.insurance.ConfigurationService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Configuration {
    String remoteEntry;
    String remoteName;
    String exposedModule;
    String outlet;
    String module;

    public Configuration(){

    }

    public Configuration(String remoteEntry, String remoteName, String exposedModule, String outlet, String module) {
        this.remoteEntry = remoteEntry;
        this.remoteName = remoteName;
        this.exposedModule = exposedModule;
        this.outlet = outlet;
        this.module = module;
    }
}
