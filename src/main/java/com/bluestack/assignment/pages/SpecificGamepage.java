package com.bluestack.assignment.pages;

import com.bluestack.assignment.base.TestBase;
import com.bluestack.assignment.util.DomService;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class SpecificGamepage extends TestBase {

    @FindBy(xpath = "//span[@class=\"count-tournaments\"]")
    private WebElement tournamentCounts;

    public SpecificGamepage() {
        PageFactory.initElements(driver, this);
    }

    public String getCurrentUrl() {

        DomService domService = new DomService();
        return domService.getCurrentPageUrl();
    }

    public int getStatusCode() {
        int code = 0;
        try {
            URL url = new URL(getCurrentUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            code = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

    public String getTournamentCount() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", tournamentCounts);
        DomService domService = new DomService();
        return domService.getWebElementText(tournamentCounts);
    }
}
