package com.example.branch_challenge.delegate;

import com.example.branch_challenge.model.APIObject;
import com.example.branch_challenge.model.APIRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExampleDelegate {
    private RestTemplate restTemplate;
    private static final String urlStart = "https://api.github.com/users/{username}";

    @Autowired
    public ExampleDelegate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public APIObject getMainObject(String userName) {
        return restTemplate.getForObject(urlStart, APIObject.class, userName);
    }

    public APIRepo[] getRepoObject(String userName) {
        return restTemplate.getForObject(urlStart + "/repos", APIRepo[].class, userName);     //kb: fix this
    }
}
