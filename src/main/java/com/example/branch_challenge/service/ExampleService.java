package com.example.branch_challenge.service;

import com.example.branch_challenge.delegate.ExampleDelegate;
import com.example.branch_challenge.model.ExampleObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    private ExampleDelegate delegate;

    @Autowired
    public ExampleService(ExampleDelegate delegate) {
        this.delegate = delegate;
    }

    public ExampleObject getAPIResponse(String username) {
        ExampleObject exampleObject = delegate.getMainObject(username);
        exampleObject.setRepos(delegate.getRepoObject(username));

        return  exampleObject;
    }
}
