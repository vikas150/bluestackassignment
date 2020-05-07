package com.bluestack.assignment.util;

import com.bluestack.assignment.base.TestBase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DomService extends TestBase {

    public String getWebElementText(WebElement webElement) {
        String elementText;
        try {
            elementText = webElement.getText();
        } catch (NoSuchElementException e) {
            WebDriverWait webDriverWait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
            elementText = webDriverWait.until(ExpectedConditions.visibilityOf(webElement)).getText();
        }
        return elementText;
    }

    public String getCurrentPageUrl() {
        String pageUrl;
        try {
            pageUrl = driver.getCurrentUrl();
        } catch (NoSuchElementException e) {
            WebDriverWait webDriverWait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
            webDriverWait.until(ExpectedConditions.visibilityOfAllElements());
            pageUrl = driver.getCurrentUrl();
        }
        return pageUrl;
    }
}
