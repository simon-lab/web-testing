package com.saimen.fdm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.saimen.AbstractPage;

public class NUPAYLoginPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='text-h6 text-blue']")
    private WebElement validator;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//span[text()='Login']")
    private WebElement logInBtn;

    public NUPAYLoginPage(WebDriver driver) {
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
