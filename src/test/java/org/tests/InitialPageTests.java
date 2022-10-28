package org.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.pages.InitialDetailsPage;
import org.resources.Constants;
import org.resources.DataProviderClass;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InitialPageTests {
    WebDriver driver;
    ChromeOptions chromeOptions;
    @BeforeTest
    public void setUp() {
        chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().browserVersion(Constants.CHROME_VERSION).setup();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.get(Constants.BASE_URL);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "emails", dataProviderClass = DataProviderClass.class)
    public void emailNegativeTest(String mail) {

        InitialDetailsPage initPage = new InitialDetailsPage(driver);

        initPage.enterEmail(mail);
        Assert.assertEquals(initPage.isErrorMarkDisplayed(), true);

    }

    @Test
    public void emailPositiveTest() {

        InitialDetailsPage initPage = new InitialDetailsPage(driver);

        initPage.enterEmail("test@mail.com");
        Assert.assertEquals(initPage.isCheckMarkDisplayed(), true);
    }

    @Test(dataProvider = "passwords", dataProviderClass = DataProviderClass.class)
    public void passwordNegativeTest(String password) {
        InitialDetailsPage initPage = new InitialDetailsPage(driver);

        initPage.enterPassword(password);
        Assert.assertEquals(initPage.isErrorMarkDisplayed(), true);
    }

    @Test
    public void passwordPositiveTest() {

        InitialDetailsPage initPage = new InitialDetailsPage(driver);

        initPage.enterPassword("1P@ssword");
        Assert.assertEquals(initPage.isCheckMarkDisplayed(), true);
    }
}
