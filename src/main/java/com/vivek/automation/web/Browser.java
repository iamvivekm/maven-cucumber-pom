package com.vivek.automation.web;

import com.vivek.automation.utils.PropertyReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.Properties;

public class Browser {
    private RemoteWebDriver driver;
    private BrowserName browserName;
    private String url;

    public Browser() {
        this.setBrowserProperties();
        this.setBrowserDriver();
        this.driver.manage().window().maximize();
        this.driver.get(this.url);
    }

    private void setBrowserProperties() {
        Properties properties = new PropertyReader().loadProperties("config.properties");
        this.browserName = BrowserName.valueOf(properties.getProperty("browser").toUpperCase());
        this.url = properties.getProperty("url");
    }

    private void setBrowserDriver() {
        switch (this.browserName) {
            case CHROME:
                this.setupChromeDriver();
                break;
            case FIREFOX:
                this.setupFirefoxDriver();
                break;
            default:
                throw new AssertionError("Invalid browser name");
        }
    }

    private void setupFirefoxDriver() {
        try {
            File file = new File(System.getProperty("user.dir") + File.separator + "lib" + File.separator + "geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            this.driver = new FirefoxDriver();
        } catch (Exception ex) {
            throw new AssertionError("Unable to find the Chromedriver: " + ex.getMessage());
        }
    }

    private void setupChromeDriver() {
        try {
            File file = new File(System.getProperty("user.dir") + File.separator + "lib" + File.separator + "chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            this.driver = new ChromeDriver();
        } catch (Exception ex) {
            throw new AssertionError("Unable to find the Geckodriver: " + ex.getMessage());
        }
    }

    public RemoteWebDriver getDriver() {
        return this.driver;
    }

    public void quitDriver() {
        if (this.driver != null) {
            driver.quit();
        }
    }

    public enum BrowserName {
        CHROME,
        FIREFOX;
    }
}
