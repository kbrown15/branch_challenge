package com.example.branch_challenge.service;

import com.example.branch_challenge.delegate.ExampleDelegate;
import com.example.branch_challenge.model.APIObject;
import com.example.branch_challenge.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ExampleService {
    private ExampleDelegate delegate;
    private static Logger LOGGER = Logger.getLogger(ExampleService.class.getName());

    @Autowired
    public ExampleService(ExampleDelegate delegate) {
        this.delegate = delegate;
    }

    public ResponseObject getResponse(String username) {
        if (username == null) {
            throw new IllegalArgumentException("No username provided");
        }
        ResponseObject response = new ResponseObject();
        LOGGER.info("First delegate call with username=" + username);
        APIObject apiObject = delegate.getMainObject(username);
        if (apiObject != null) {
            response = response.fromAPIObject(apiObject);
            LOGGER.info("Second delegate call with username=" + username);
            response.setRepos(delegate.getRepoObject(username));
        } else {
            LOGGER.warning("Call returned null");
        }

        return response;
    }
}
