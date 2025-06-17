package com.saimen.dspPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.saimen.AbstractPage;

public class oprHomePage extends AbstractPage {
    @FindBy(xpath = "//span[@class='brand-text font-weight-light']")
    private WebElement validator;

    @FindBy(xpath = "//a[@href='/mos']")
    private WebElement fdmBtn;

    public oprHomePage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void fdmClick() {
        fdmBtn.click();
    }
}
