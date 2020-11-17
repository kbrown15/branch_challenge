package com.example.branch_challenge.delegate;

import com.example.branch_challenge.model.ExampleObject;
import com.example.branch_challenge.model.ExampleRepo;
import org.springframework.web.client.RestTemplate;

public class ExampleDelegate {
    private RestTemplate restTemplate;
    private static final String urlStart = "https://api.github.com/users/{username}";

    public ExampleDelegate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ExampleObject getMainObject(String userName) {
        return restTemplate.getForObject(urlStart, ExampleObject.class, userName);
    }

    public ExampleRepo[] getRepoObject(String userName) {
        return restTemplate.getForObject(urlStart + "/repos", ExampleRepo[].class, userName);     //kb: fix this
    }
}
