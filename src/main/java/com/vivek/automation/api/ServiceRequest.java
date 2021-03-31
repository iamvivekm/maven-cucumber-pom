package com.vivek.automation.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class ServiceRequest {
    private String path;
    private RequestSpecBuilder requestSpecBuilder;
    private Map<String, String> headers;
    private LogDetail logDetail;
    private Method httpMethod;

    ServiceRequest() {
        requestSpecBuilder = new RequestSpecBuilder();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        this.requestSpecBuilder.setBasePath(path);
    }

    public RequestSpecification getRequestSpec() {
        return requestSpecBuilder.build();
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
        this.requestSpecBuilder.addHeaders(headers);
    }

    public LogDetail getLogDetail() {
        return logDetail;
    }

    public void setLogDetail(LogDetail logDetail) {
        this.logDetail = logDetail;
        this.requestSpecBuilder.log(logDetail);
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = Method.valueOf(httpMethod);
    }

    public Method getHttpMethod() {
        return httpMethod;
    }
}
