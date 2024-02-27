package com.insurance.ConfigurationService.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
public class ConfigurationWrapper {
    // Getter and setter methods
    private List<Configuration> configurationList;

    // Default constructor
    public ConfigurationWrapper() {
    }

    // Constructor with parameters
    public ConfigurationWrapper(List<Configuration> configurationList) {
        this.configurationList = configurationList;
    }

}