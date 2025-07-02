package com.saimen.fdm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.saimen.AbstractPage;

public class CMSLoginPage extends AbstractPage {

    @FindBy(xpath = "//div[text()='Content Management System']")
    private WebElement validator;
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;
    @FindBy(xpath = "//span[text()='Login']")
    private WebElement logInBtn;

    public CMSLoginPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void fillEmail(String email) {
        emailField.sendKeys(email);
    }

    public void fillPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void logInClick() {
        logInBtn.click();
    }

}
