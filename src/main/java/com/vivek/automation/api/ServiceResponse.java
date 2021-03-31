package com.vivek.automation.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ServiceResponse {
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Integer getStatusCode(){
        return this.response.getStatusCode();
    }

    public String readJsonPath(String path){
        return this.response.path(path).toString();
    }
}
