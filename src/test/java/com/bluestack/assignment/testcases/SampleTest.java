package com.bluestack.assignment.testcases;

import com.bluestack.assignment.base.TestBase;
import com.bluestack.assignment.pages.Homepage;
import com.bluestack.assignment.pages.SpecificGamepage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SampleTest extends TestBase {

    Homepage homepage;
    SpecificGamepage specificGamepage;

    public SampleTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homepage = new Homepage();
    }

    @Test(enabled = false)
    public void executeGarenaFreeFireGameTest(String game) {
        String gameName = homepage.getGameName(game);
        System.out.print(gameName);
        specificGamepage = homepage.clickOnGarenaFreeFireGame(game);
        System.out.print(specificGamepage.getCurrentUrl());
        System.out.println(specificGamepage.getStatusCode());
        System.out.println(specificGamepage.getTournamentCount());
    }

    @Test(dataProvider = "getTestData")
    public void executeBrawlStarsTest(String game) {
        String gameName = homepage.getGameName(game);
        System.out.print(gameName);
        specificGamepage = homepage.clickOnGarenaFreeFireGame(game);
        System.out.print(specificGamepage.getCurrentUrl());
        System.out.println(specificGamepage.getStatusCode());
        System.out.println(specificGamepage.getTournamentCount());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public Object[] getTestData() {

        Object[] data = new Object[]{"Garena", "Brawl stars", "Clash Royale"};
        return data;
    }

}
