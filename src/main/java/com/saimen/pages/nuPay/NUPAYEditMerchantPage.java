package com.saimen.pages.nuPay;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.saimen.AbstractPage;

public class NUPAYEditMerchantPage extends AbstractPage {
    @FindBy(xpath = "//h3[text()='Edit Data Merchants']")
    private WebElement validator;

    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[1]")
    private WebElement namaMerchantField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[2]")
    private WebElement alamatField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[3]")
    private WebElement noTelpField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[4]")
    private WebElement PICField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[5]")
    private WebElement emailField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[6]")
    private WebElement noTelpOwnerField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[7]")
    private WebElement nnpwpField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[8]")
    private WebElement nikOwnerField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[9]")
    private WebElement alamatOwnerField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[10]/div/div/span")
    private WebElement bankNoField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[11]")
    private WebElement bankAccNoField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[12]")
    private WebElement kcKcpField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[13]")
    private WebElement namaPemilikBankField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[14]")
    private WebElement mpanField;

    @FindBy(xpath = "(//div[@class='q-checkbox cursor-pointer no-outline row inline no-wrap items-center'])[1]")
    private WebElement creditCardCheckBox;
    @FindBy(xpath = "(//div[@class='q-checkbox cursor-pointer no-outline row inline no-wrap items-center'])[2]")
    private WebElement debitCardCheckBox;
    @FindBy(xpath = "(//div[@class='q-checkbox cursor-pointer no-outline row inline no-wrap items-center'])[3]")
    private WebElement eMoneyCheckBox;

    public NUPAYEditMerchantPage(WebDriver driver) {
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

    public void assertPIC(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(PICField.getText().trim(), expected);
    }

    public void assertEmail(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(emailField.getText().trim(), expected);
    }

    public void assertNoTelpOwner(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(noTelpOwnerField.getText().trim(), expected);
    }

    public void assertNnpwp(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(nnpwpField.getText().trim(), expected);
    }

    public void assertNikOwner(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(nikOwnerField.getText().trim(), expected);
    }

    public void assertAlamatOwner(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(alamatOwnerField.getText().trim(), expected);
    }

    public void assertBankNo(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(bankNoField.getText().trim(), expected);
    }

    public void assertBankAccNo(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(bankAccNoField.getText().trim(), expected);
    }

    public void assertKcKcp(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(kcKcpField.getText().trim(), expected);
    }

    public void assertNamaPemilikBank(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(namaPemilikBankField.getText().trim(), expected);
    }

    public void assertMpan(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(mpanField.getText().trim(), expected);
    }

    public void assertSupportedCard(List<String> expectedSupportCard, SoftAssert softAssert) {
        boolean creditIsChecked = creditCardCheckBox.getAttribute("aria-checked").contains("true");
        boolean debitIsChecked = debitCardCheckBox.getAttribute("aria-checked").contains("true");
        boolean eMoneyIsChecked = eMoneyCheckBox.getAttribute("aria-checked").contains("true");

        if (expectedSupportCard.contains("Credit Card")) {
            softAssert.assertTrue(creditIsChecked, "Credit Card checkbox should be checked.");
        } else {
            softAssert.assertFalse(creditIsChecked, "Credit Card checkbox should not be checked.");
        }

        if (expectedSupportCard.contains("Debit Card")) {
            softAssert.assertTrue(debitIsChecked, "Debit Card checkbox should be checked.");
        } else {
            softAssert.assertFalse(debitIsChecked, "Debit Card checkbox should not be checked.");
        }

        if (expectedSupportCard.contains("e-Money")) {
            softAssert.assertTrue(eMoneyIsChecked, "e-Money checkbox should be checked.");
        } else {
            softAssert.assertFalse(eMoneyIsChecked, "e-Money checkbox should not be checked.");
        }
    }

}
