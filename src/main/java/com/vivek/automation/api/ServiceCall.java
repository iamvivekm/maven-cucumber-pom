package com.vivek.automation.api;

import io.restassured.http.Method;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ServiceCall {
    private ServiceResponse serviceResponse;
    private ServiceRequest serviceRequest;

    ServiceCall(ServiceRequest serviceRequest, ServiceResponse serviceResponse) {
        this.serviceRequest = serviceRequest;
        this.serviceResponse = serviceResponse;
    }

    public void sendRequest() {
        Response response = given().spec(this.serviceRequest.getRequestSpec())
                .request(this.serviceRequest.getHttpMethod());
        if (response != null) {
            serviceResponse.setResponse(response);
        } else {
            throw new AssertionError("Empty response received");
        }
    }

}
