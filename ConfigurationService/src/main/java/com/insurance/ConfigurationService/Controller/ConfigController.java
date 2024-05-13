package com.insurance.ConfigurationService.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.insurance.ConfigurationService.model.Configuration;
import com.insurance.ConfigurationService.model.ConfigurationWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ConfigController {

    @GetMapping(path = "/getConfig")
    public ResponseEntity<ConfigurationWrapper> getConfigurations(){
        List<Configuration> configurationList = new ArrayList<>();

        Storage storage = StorageOptions.getDefaultInstance().getService();
        Blob blob = storage.get("cofiguration_bucket", "configuration.json");
        String jsonConfigData = new String(blob.getContent());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ConfigurationWrapper configurationWrapper = objectMapper.readValue(jsonConfigData, ConfigurationWrapper.class);
            List<Configuration> configurations = configurationWrapper.getConfigurationList();
            configurationList.addAll(configurations);
            configurationWrapper.setConfigurationList(configurationList);
            return new ResponseEntity<>(configurationWrapper, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/hello")
    public String getHello(){
        return "Hello I am here!";
    }
}
