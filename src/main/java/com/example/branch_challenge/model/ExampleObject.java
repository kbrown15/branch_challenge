package com.example.branch_challenge.model;

import java.net.URL;
import java.util.Date;

public class ExampleObject {
    public String user_name;
    public String display_name;
    public URL avatar;
    public String geo_Location;
    //TODO: make email validator
    public String email;
    public  URL url;
    public Date created_at;
    public ExampleRepo[] repos;

    public String getUser_name() {
        return user_name;
    }

    public ExampleObject setUser_name(String user_name) {
        this.user_name = user_name;
        return this;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public ExampleObject setDisplay_name(String display_name) {
        this.display_name = display_name;
        return this;
    }

    public URL getAvatar() {
        return avatar;
    }

    public ExampleObject setAvatar(URL avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getGeo_Location() {
        return geo_Location;
    }

    public ExampleObject setGeo_Location(String geo_Location) {
        this.geo_Location = geo_Location;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ExampleObject setEmail(String email) {
        this.email = email;
        return this;
    }

    public URL getUrl() {
        return url;
    }

    public ExampleObject setUrl(URL url) {
        this.url = url;
        return this;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public ExampleObject setCreated_at(Date created_at) {
        this.created_at = created_at;
        return this;
    }

    public ExampleRepo[] getRepos() {
        return repos;
    }

    public ExampleObject setRepos(ExampleRepo[] repos) {
        this.repos = repos;
        return this;
    }
}
