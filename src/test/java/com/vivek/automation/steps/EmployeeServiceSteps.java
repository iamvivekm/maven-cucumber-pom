package com.vivek.automation.steps;

import com.vivek.automation.api.Service;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.filter.log.LogDetail;
import org.junit.Assert;

import java.util.Map;

public class EmployeeServiceSteps extends Service {
    @Given("path {string}")
    public void path(String path) {
        ServiceRequest().setPath(path);
    }

    @When("using {string} method")
    public void usingMethod(String method) {
        ServiceRequest().setHttpMethod(method.toUpperCase());
    }

    @Then("status code is {int}")
    public void statusCodeIs(Integer statusCode) {
        Assert.assertEquals(statusCode, ServiceResponse().getStatusCode());
    }

    @Given("{string} request logging")
    public void requestLogging(String enabled) {
        if (enabled.equalsIgnoreCase("enable")) {
            ServiceRequest().setLogDetail(LogDetail.BODY);
        }
    }

    @When("I send request")
    public void iSendRequest() {
        ServiceCall().sendRequest();
    }

    @Then("response contains below values")
    public void responseContainsBelowValues(DataTable dataTable) {
        dataTable.asMaps().forEach(this::accept);
    }

    private void accept(Map<String, String> row) {
        Assert.assertEquals(row.get("value"), ServiceResponse().readJsonPath(row.get("jsonPath")));
    }
}
