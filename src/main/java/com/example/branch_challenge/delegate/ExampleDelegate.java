package com.example.branch_challenge.delegate;

import com.example.branch_challenge.model.APIObject;
import com.example.branch_challenge.model.APIRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

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
        try {
            return restTemplate.getForObject(urlStart, APIObject.class, userName);
        } catch (HttpClientErrorException e) {
            //just going to default to 404 on error since it's the most common/likely scenario
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Response not found");
        }
    }

    public APIRepo[] getRepoObject(String userName) {
        LOGGER.info("Repo API call with username=" + userName);
        try {
            return restTemplate.getForObject(urlStart + "/repos", APIRepo[].class, userName);
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Response not found");
        }
    }
}
