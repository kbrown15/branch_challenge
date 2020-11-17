package com.example.branch_challenge.controller;

import com.example.branch_challenge.model.ResponseObject;
import com.example.branch_challenge.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    private ExampleService exampleService;

    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping(value = "/users/{userName}")
    public ResponseObject getResponse(@PathVariable String userName) {
        return exampleService.getResponse(userName);
    }

}
