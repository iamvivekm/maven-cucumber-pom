package com.vivek.automation.elements;

import com.vivek.automation.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element {
    private RemoteWebDriver driver;
    private WebElement element;
    private WebElement parentElement;
    private String id;
    private By.ByType byType;
    private long loadWaitTime = 60; //Seconds
    private long clickWaitTime = 60; //Seconds

    public Element(RemoteWebDriver driver, String id, By.ByType byType) {
        this.driver = driver;
        this.id = id;
        this.byType = byType;
        try {
            this.element = this.driver.findElement(By.all(byType, id));
        } catch (NoSuchElementException exception) {
            this.element = null;
        }
    }

    public Element(RemoteWebDriver driver, WebElement parentElement, By.ByType byType, String id) {
        this.driver = driver;
        this.parentElement = parentElement;
        this.byType = byType;
        this.id = id;
    }

    public void waitForLoading() {
        WebDriverWait wait = new WebDriverWait(this.driver, this.loadWaitTime);
        this.element = wait.until(ExpectedConditions.presenceOfElementLocated(By.all(this.byType, this.id)));
    }

    public boolean isVisible() {
        if (this.element != null) {
            return this.element.isDisplayed();
        }
        return false;
    }

    public void SendKeys(String input) {
        this.element.sendKeys(input);
    }

    public void SendKeys(Integer input) {
        this.element.sendKeys(String.valueOf(input));
    }

    public void click() {
        WebDriverWait wait = new WebDriverWait(this.driver, this.clickWaitTime);
        wait.until(ExpectedConditions.elementToBeClickable(this.element));
        try {
            this.element.click();
        } catch (Exception ex) {
            if (ex.getMessage().contains("is not clickable at point")) {
                Actions actions = new Actions(this.driver);
                actions.moveToElement(this.element).click().perform();
                return;
            }
            throw ex;
        }
    }

    public void jsClick(){
        WebDriverWait wait = new WebDriverWait(this.driver, this.clickWaitTime);
        wait.until(ExpectedConditions.elementToBeClickable(this.element));
        JavascriptExecutor javascriptExecutor = this.driver;
        javascriptExecutor.executeScript("argument[0].click();", this.element);
    }

}
