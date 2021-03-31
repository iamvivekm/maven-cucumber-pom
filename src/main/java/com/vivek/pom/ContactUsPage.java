package com.vivek.pom;

import com.vivek.automation.By;
import com.vivek.automation.web.Page;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ContactUsPage extends Page {
    public ContactUsPage(RemoteWebDriver driver) {
        super(driver, "div.breadcrumb > span.navigation_page", By.ByType.Css);
    }

}
