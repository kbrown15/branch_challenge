package com.example.branch_challenge.delegate;

import com.example.branch_challenge.model.APIObject;
import com.example.branch_challenge.model.APIRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Component
public class ExampleDelegate {
    private RestTemplate restTemplate;
    private static final String urlStart = "https://api.github.com/users/{username}";
    private static final Logger LOGGER = Logger.getLogger(ExampleDelegate.class.getName());

    @Autowired
    public ExampleDelegate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public APIObject getMainObject(String userName) {
        LOGGER.info("Main object API call with username=" + userName);
        return restTemplate.getForObject(urlStart, APIObject.class, userName);
    }

    public APIRepo[] getRepoObject(String userName) {
        LOGGER.info("Repo API call with username=" + userName);
        return restTemplate.getForObject(urlStart + "/repos", APIRepo[].class, userName);
    }
}
