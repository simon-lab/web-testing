package com.saimen.pages.nuPay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.saimen.AbstractPage;

public class NUPAYDetailPopUp extends AbstractPage {
    @FindBy(xpath = "//div[@class='q-toolbar__title ellipsis' and text()]")
    private WebElement validator;

    @FindBy(xpath = "//table/tr[1]/td[2]")
    private WebElement namaMerchantField;
    @FindBy(xpath = "//table/tr[2]/td[2]")
    private WebElement alamatField;
    @FindBy(xpath = "//table/tr[3]/td[2]")
    private WebElement noTelpField;
    @FindBy(xpath = "//table/tr[4]/td[2]")
    private WebElement levelField;
    @FindBy(xpath = "//table/tr[5]/td[2]")
    private WebElement namaKontakField;
    @FindBy(xpath = "//table/tr[6]/td[2]")
    private WebElement emailKontakField;
    @FindBy(xpath = "//table/tr[7]/td[2]")
    private WebElement noTelpKontakField;
    @FindBy(xpath = "//table/tr[8]/td[2]")
    private WebElement mPanField;
    @FindBy(xpath = "//table/tr[9]/td[2]")
    private WebElement billerField;
    @FindBy(xpath = "//table/tr[10]/td[2]")
    private WebElement dateCreateField;
    @FindBy(xpath = "//table/tr[11]/td[2]")
    private WebElement dateUpdateField;

    public NUPAYDetailPopUp(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void assertNamaMerchant(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(namaMerchantField.getText().trim(), expected);
    }

    public void assertAlamat(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(alamatField.getText().trim(), expected);
    }

    public void assertNoTelp(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(noTelpField.getText().trim(), expected);
    }

    public void assertLevel(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(levelField.getText().trim(), expected);
    }

    public void assertNamaKontak(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(namaKontakField.getText().trim(), expected);
    }

    public void assertEmailKontak(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(emailKontakField.getText().trim(), expected);
    }

    public void assertNoTelpKontak(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(noTelpKontakField.getText().trim(), expected);
    }

    public void assertMPAN(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(mPanField.getText().trim(), expected);
    }

    public void assertBiller(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(billerField.getText().trim(), expected);
    }

    public void assertDateCreate(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(dateCreateField.getText().trim(), expected);
    }

    public void assertDateUpdate(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(dateUpdateField.getText().trim(), expected);
    }

}
