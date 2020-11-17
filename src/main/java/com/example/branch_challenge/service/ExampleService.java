package com.example.branch_challenge.service;

import com.example.branch_challenge.delegate.ExampleDelegate;
import com.example.branch_challenge.model.ExampleObject;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    private ExampleDelegate delegate;

    public ExampleObject getAPIResponse(String username) {
        ExampleObject exampleObject = delegate.getMainObject(username);
        exampleObject.setRepos(delegate.getRepoObject(username));

        return  exampleObject;
    }
}
