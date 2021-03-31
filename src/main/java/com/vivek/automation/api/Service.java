package com.vivek.automation.api;


import com.vivek.automation.utils.PropertyReader;
import io.restassured.RestAssured;

import java.util.Properties;

public class Service {
    private String baseUri;
    private ServiceRequest serviceRequest;
    private ServiceResponse serviceResponse;

    public Service() {
        this.setServiceProperties();
        RestAssured.baseURI = this.baseUri;
        serviceRequest = new ServiceRequest();
        serviceResponse = new ServiceResponse();
    }

    public static void reset() {
        RestAssured.reset();
    }

    public ServiceRequest ServiceRequest() {
        if (this.serviceRequest == null) {
            return new ServiceRequest();
        }
        return this.serviceRequest;
    }

    public ServiceCall ServiceCall() {
        return new ServiceCall(this.serviceRequest, this.serviceResponse);
    }

    public ServiceResponse ServiceResponse() {
        return this.serviceResponse;
    }

    private void setServiceProperties() {
        Properties properties = new PropertyReader().loadProperties("config.properties");
        this.baseUri = properties.getProperty("base-uri");
    }

}
