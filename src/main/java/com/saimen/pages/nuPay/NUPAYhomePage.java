package com.saimen.pages.nuPay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.saimen.AbstractPage;

public class NUPAYhomePage extends AbstractPage {
    @FindBy(xpath = "//div[@class='q-toolbar__title ellipsis']")
    private WebElement validator;

    @FindBy(xpath = "//div[@class='q-item__label' and text()='Merchants Management']")
    private WebElement merchantsManagementBtn;
    @FindBy(xpath = "//div[text()='E-commerce']")
    private WebElement eCommBtn;

    @FindBy(xpath = "//div[@class='q-item__label' and text()='Company Website Management']")
    private WebElement companyWebsiteBtn;
    @FindBy(xpath = "//a[@href='#/company-website-management/merchants/list']")
    private WebElement merchantsWebsiteBtn;

    public NUPAYhomePage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void eCommClick() {
        merchantsManagementBtn.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.eCommBtn));
        eCommBtn.click();
    }

    public void merchantsWebsiteClick() {
        companyWebsiteBtn.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.merchantsWebsiteBtn));
        merchantsWebsiteBtn.click();
    }

}
