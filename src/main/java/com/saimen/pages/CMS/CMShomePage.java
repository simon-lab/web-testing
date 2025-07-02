package com.saimen.pages.CMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.saimen.AbstractPage;

public class CMShomePage extends AbstractPage {
    @FindBy(xpath = "//div[@class='q-toolbar__title ellipsis']")
    private WebElement validator;

    @FindBy(xpath = "//div[@class='q-item__label' and text()='Company Management']")
    private WebElement companyManagementBtn;
    @FindBy(xpath = "//a[@href='#/merchants']")
    private WebElement merchantBtn;

    public CMShomePage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void merchantClick() {
        companyManagementBtn.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.merchantBtn));
        merchantBtn.click();
    }

}
