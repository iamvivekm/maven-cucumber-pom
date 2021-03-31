package com.vivek.pom;

import com.vivek.automation.By;
import com.vivek.automation.web.Page;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SignInPage extends Page {

    public SignInPage(RemoteWebDriver driver) {
        super(driver, "//h1[@class=\"page-heading\" and text()=\"Authentication\"] ", By.ByType.Xpath);
    }


}
