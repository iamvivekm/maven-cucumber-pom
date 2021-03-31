package com.vivek.automation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class By extends org.openqa.selenium.By {

    public By() {

    }

    public static org.openqa.selenium.By all(By.ByType type, String identifier) {
        switch (type) {
            case Name:
                return org.openqa.selenium.By.name(identifier);
            case Classname:
                return org.openqa.selenium.By.className(identifier);
            case Id:
                return org.openqa.selenium.By.id(identifier);
            case LinkText:
                return org.openqa.selenium.By.linkText(identifier);
            case TagName:
                return org.openqa.selenium.By.tagName(identifier);
            case Css:
                return org.openqa.selenium.By.cssSelector(identifier);
            case Xpath:
                return org.openqa.selenium.By.xpath(identifier);
            default:
                throw new NoSuchElementException("By type incorrectly set to:" + type.toString());
        }
    }

    @Override
    public List<WebElement> findElements(SearchContext searchContext) {
        throw new AssertionError("Do not use this. Had to implement this");
    }

    public enum ByType {
        Name,
        Id,
        Classname,
        LinkText,
        Css,
        Xpath,
        TagName;

        ByType() {

        }
    }
}
