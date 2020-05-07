package com.bluestack.assignment.pages;

import com.bluestack.assignment.base.TestBase;
import com.bluestack.assignment.util.ClickService;
import com.bluestack.assignment.util.DomService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends TestBase {

    @FindBy(xpath = "//a[@href=\"/find-tournaments/garena-free-fire-spooky-night-tournaments\"]")
    private WebElement garenaFreeFire;

    @FindBy(xpath = "//a[@href=\"/find-tournaments/brawl-stars-tournaments\"]")
    private WebElement brawlStars;

    @FindBy(xpath = "//a[@href=\"/find-tournaments/clash-royale-tournaments\"]")
    private WebElement clashRoyale;

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    public String getGameName(String game) {
        WebElement element = null;
        if (game.equalsIgnoreCase("Garena")) {
            element = garenaFreeFire;
        } else if (game.equalsIgnoreCase("Brawl stars")) {
            element = brawlStars;
        } else if (game.equalsIgnoreCase("Clash Royale")) {
            element = clashRoyale;
        }
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
        DomService domService = new DomService();
        return domService.getWebElementText(element);
    }

    public SpecificGamepage clickOnGarenaFreeFireGame(String game) {
        WebElement element = null;
        if (game.equalsIgnoreCase("Garena")) {
            element = garenaFreeFire;
        } else if (game.equalsIgnoreCase("Brawl stars")) {
            element = brawlStars;
        } else if (game.equalsIgnoreCase("Clash Royale")) {
            element = clashRoyale;
        }
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
        ClickService clickService = new ClickService();
        clickService.clickOnElement(element);
        return new SpecificGamepage();
    }
}
