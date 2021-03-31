package com.vivek.automation.elements;

import com.vivek.automation.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Link extends Element {
    public Link(RemoteWebDriver driver, String id, By.ByType byType) {
        super(driver, id, byType);
    }

    public Link(RemoteWebDriver driver, WebElement parentElement, String id, By.ByType byType) {
        super(driver, parentElement, byType, id);
    }
}
