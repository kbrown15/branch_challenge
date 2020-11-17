package com.example.branch_challenge.service;

import com.example.branch_challenge.delegate.ExampleDelegate;
import com.example.branch_challenge.model.APIObject;
import com.example.branch_challenge.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    private ExampleDelegate delegate;

    @Autowired
    public ExampleService(ExampleDelegate delegate) {
        this.delegate = delegate;
    }

    public ResponseObject getResponse(String username) {
        APIObject apiObject = delegate.getMainObject(username);
        ResponseObject response = new ResponseObject().fromAPIObject(apiObject);
        response.setRepos(delegate.getRepoObject(username));

        return response;
    }
}
