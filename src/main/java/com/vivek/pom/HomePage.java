package com.vivek.pom;

import com.vivek.automation.By;
import com.vivek.automation.elements.Link;
import com.vivek.automation.web.Page;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage extends Page {

    public HomePage(RemoteWebDriver driver) {
        super(driver, "header_logo", By.ByType.Id);
    }

    public Link ContactUs() {
        return new Link(getDriver(), "div#contact-link > a", By.ByType.Css);
    }

    public Link SignIn() {
        return new Link(getDriver(), "div.header_user_info > a", By.ByType.Css);
    }

    public ContactUsPage ContactUsPage() {
        return new ContactUsPage(getDriver());
    }

    public SignInPage SignInPage() {
        return new SignInPage(getDriver());
    }

}
