package com.example.branch_challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.net.URL;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseObject {
    private String user_name;
    private String display_name;
    private URL avatar;
    private String geo_location;
    private String email;
    private  URL url;
    private Date created_at;
    private APIRepo[] repos;

    public ResponseObject() {

    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public URL getAvatar() {
        return avatar;
    }

    public void setAvatar(URL avatar) {
        this.avatar = avatar;
    }

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

    public APIRepo[] getRepos() {
        return repos;
    }

    public void setRepos(APIRepo[] repos) {
        this.repos = repos;
    }

    public ResponseObject fromAPIObject(APIObject o) {
        this.user_name = o.getUser_name();
        this.display_name = o.getDisplay_name();
        this.avatar = o.getAvatar();
        this.geo_location = o.getGeo_location();
        this.email = o.getEmail();
        this.url = o.getUrl();
        this.created_at = o.getCreated_at();

        return  this;
    }
}
