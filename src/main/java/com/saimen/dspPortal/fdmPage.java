package com.saimen.dspPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.saimen.AbstractPage;

public class fdmPage extends AbstractPage {
    @FindBy(xpath = "//h4[.='List MOS']")
    private WebElement validator;
    @FindBy(xpath = "//a[@href='/mos']")
    private WebElement fdmBtn;
    @FindBy(xpath = "//span[@class='align-middle d-sm-inline-block d-none me-sm-2']")
    private WebElement buatMosBtn;
    @FindBy(xpath = "//input[@id='create_date']")
    private WebElement dateBtn;
    @FindBy(xpath = "//select[@id='status']")
    private WebElement statusBtn;
    @FindBy(xpath = "//div[@id='mosList_filter']//input[@class='form-control form-control-sm']")
    private WebElement searchFunc;
    @FindBy(xpath = "//li[@id='mosList_previous']")
    private WebElement previousBtn;
    @FindBy(xpath = "//li[@id='mosList_next']")
    private WebElement nextBtn;

    Select dropdown = new Select(statusBtn);

    public fdmPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void setStatus(String status) {

        if (status == "approved") {
            dropdown.selectByValue("APPROVED");
        } else {
            dropdown.selectByValue("DRAFT");
        }
    }

    public void buatMOS() {
        buatMosBtn.click();
    }
}
