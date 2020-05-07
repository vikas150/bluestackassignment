package com.bluestack.assignment.util;

import com.bluestack.assignment.base.TestBase;
import okio.Timeout;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickService extends TestBase {

    public void clickOnElement(final WebElement webElement) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", webElement);
        } catch (NoSuchElementException e) {
            WebDriverWait webDriverWait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement)).click();
        }
    }
}
