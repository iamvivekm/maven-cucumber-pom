package com.vivek.automation;

import com.vivek.automation.web.Browser;
import com.vivek.pom.HomePage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestState {
    private static Browser browser;

    public TestState(){
        if(TestState.browser == null){
            TestState.browser = new Browser();
        }
    }

    public RemoteWebDriver getDriver(){
        return TestState.browser.getDriver();
    }

    public static void destroy(){
        if(TestState.browser != null){
            TestState.browser.quitDriver();
            TestState.browser = null;
        }
    }

    public HomePage HomePage(){
        return new HomePage(this.getDriver());
    }

}
