package com.vivek.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"com/vivek/automation"},
        plugin = {"pretty", "html:reports/index.html",
                "json:reports/report.json",
                "junit:reports/junit.xml",
                "de.monochromata.cucumber.report.PrettyReports:reports"},
        dryRun = false,
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
//        tags = "@scenario4",
        publish = false
)
public class TestRunner {

    @AfterClass
    public static void afterClass() {
    }
}
