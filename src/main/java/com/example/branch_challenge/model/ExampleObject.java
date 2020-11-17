package com.example.branch_challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExampleObject {
    public String user_name;
    public String display_name;
    public URL avatar;
    public String geo_location;
    //TODO: make email validator
    public String email;
    public  URL url;
    public Date created_at;
    public ExampleRepo[] repos;

    @JsonProperty("login")
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @JsonProperty("name")
    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    @JsonProperty("avatar_url")
    public URL getAvatar() {
        return avatar;
    }

    public void setAvatar(URL avatar) {
        this.avatar = avatar;
    }

    @JsonProperty("location")
    public String getGeo_location() {
        return geo_location;
    }

    public void setGeo_location(String geo_location) {
        this.geo_location = geo_location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public ExampleRepo[] getRepos() {
        return repos;
    }

    public void setRepos(ExampleRepo[] repos) {
        this.repos = repos;
    }
}
