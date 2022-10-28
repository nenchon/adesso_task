package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InitialDetailsPage {

    WebDriver driver;

    public InitialDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    @FindBy(name = "email")
//    WebElement emailField;
//
//    @FindBy(name = "error")
//    WebElement errorMark;
//
//    @FindBy(name = "check")
//    WebElement checkMark;

    By emailField = By.name("email");
    By passwordField = By.name("password");
    By errorMark = By.name("error");
    By checkMark = By.name("check");

    public void enterEmail(String email) {

        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {

        driver.findElement(passwordField).sendKeys(password);
    }

    public Boolean isErrorMarkDisplayed() {
        return driver.findElement(errorMark).isDisplayed();
    }

    public Boolean isCheckMarkDisplayed() {
        return driver.findElement(checkMark).isDisplayed();
    }
}
