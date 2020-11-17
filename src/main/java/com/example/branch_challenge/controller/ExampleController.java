package com.example.branch_challenge.controller;

import com.example.branch_challenge.model.ExampleObject;
import com.example.branch_challenge.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//kb: request mapping here
@RestController
public class ExampleController {
    private ExampleService exampleService;

    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/users/{username}")
    public ExampleObject getAPIResponse(@PathVariable String userName) {
        return exampleService.getAPIResponse(userName);
    }

}