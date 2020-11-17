package com.example.branch_challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExampleRepo {
    public String getName() {
        return name;
    }

    public ExampleRepo setName(String name) {
        this.name = name;
        return this;
    }

    public URL getUrl() {
        return url;
    }

    public ExampleRepo setUrl(URL url) {
        this.url = url;
        return this;
    }

    public String name;
    public URL url;
}
