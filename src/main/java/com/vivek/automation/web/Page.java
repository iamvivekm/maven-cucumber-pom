package com.vivek.automation.web;

import com.vivek.automation.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    private final RemoteWebDriver driver;
    private final String id;
    private final By.ByType byType;
    private boolean isPageLoaded;
    private WebElement element;
    private long pageWait = 2 * 60;

    public Page(RemoteWebDriver driver, String id, By.ByType byType) {
        this.driver = driver;
        this.id = id;
        this.byType = byType;
        this.waitForPage();
    }

    public RemoteWebDriver getDriver() {
        return this.driver;
    }

    public boolean isLoaded() {
        return isPageLoaded;
    }

    public WebElement getElement() {
        return element;
    }

    public void waitForPage() {
        WebDriverWait wait = new WebDriverWait(this.driver, this.pageWait);
        String state = (String) this.driver.executeScript("return document.readyState;", new Object[0]);
        if (!"complete".equals(state)) {
            (new WebDriverWait(this.driver, this.pageWait)).until((driverWait) ->
                    "complete".equals(((JavascriptExecutor) driverWait).executeScript("return document.readyState;"
                    )));
        }
        try {
            this.element = wait.until(ExpectedConditions.presenceOfElementLocated(By.all(this.byType, id)));
            this.isPageLoaded = true;
        } catch (NullPointerException | NoSuchElementException ex) {
            {
                this.element = null;
                this.isPageLoaded = false;
            }
        }
    }

    public String getTitle(){
        return this.driver.getTitle();
    }

}
