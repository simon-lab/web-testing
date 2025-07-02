package com.saimen.pages.nuPay;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.saimen.AbstractPage;

public class NUPAYEditECommPage extends AbstractPage {
    @FindBy(xpath = "//h3[text()='Edit Data E-commerce']")
    private WebElement validator;

    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[1]")
    private WebElement namaMerchantField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[2]")
    private WebElement namaShoppingField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[3]")
    private WebElement alamatField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[4]")
    private WebElement kotaField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[5]")
    private WebElement countryField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[6]")
    private WebElement kodePosField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[7]")
    private WebElement noTelpField;
    @FindBy(xpath = "(//div[@class='q-field__native row items-center']/span)[1]")
    private WebElement nokategoriMerchantField;
    @FindBy(xpath = "(//div[@class='q-field__native row items-center']/span)[2]")
    private WebElement tipeUsahaField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[8]")
    private WebElement namaPICUsahaField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[9]")
    private WebElement namaPICEmailField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[10]")
    private WebElement noTelpPICField;
    @FindBy(xpath = "(//div[@class='q-field__native row items-center']/span)[3]")
    private WebElement bankField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[11]")
    private WebElement noBankField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[12]")
    private WebElement mPanField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[13]")
    private WebElement namaBankField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[14]")
    private WebElement kcKcpField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[15]")
    private WebElement nMIDField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[15]")
    private WebElement linkECommField;
    @FindBy(xpath = "(//input[@class='q-field__native q-placeholder'])[15]")
    private WebElement websiteField;

    @FindBy(xpath = "(//div[@class='q-checkbox cursor-pointer no-outline row inline no-wrap items-center'])[1]")
    private WebElement creditCardCheckBox;
    @FindBy(xpath = "(//div[@class='q-checkbox cursor-pointer no-outline row inline no-wrap items-center'])[2]")
    private WebElement debitCardCheckBox;
    @FindBy(xpath = "(//div[@class='q-checkbox cursor-pointer no-outline row inline no-wrap items-center'])[3]")
    private WebElement eMoneyCheckBox;
    @FindBy(xpath = "(//div[@class='q-field__native row items-center']/span)[4]")
    private WebElement aggregatorField;

    public NUPAYEditECommPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void assertNamaMerchant(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(namaMerchantField.getAttribute("value"), expected);
    }

    public void assertNamaShopping(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(namaShoppingField.getAttribute("value"), expected);
    }

    public void assertAlamat(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(alamatField.getAttribute("value"), expected);
    }

    public void assertKota(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(kotaField.getAttribute("value"), expected);
    }

    public void assertCountry(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(countryField.getAttribute("value"), expected);
    }

    public void assertKodePos(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(kodePosField.getAttribute("value"), expected);
    }

    public void assertNoTelp(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(noTelpField.getAttribute("value"), expected);
    }

    public void assertKategoriMerchant(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(nokategoriMerchantField.getText().trim(), expected);
    }

    public void assertTipeUsaha(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(tipeUsahaField.getText().trim(), expected);
    }

    public void assertNamaPICUsaha(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(namaPICUsahaField.getAttribute("value"), expected);
    }

    public void assertNamaPICEmail(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(namaPICEmailField.getAttribute("value"), expected);
    }

    public void assertNoTelpPIC(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(noTelpPICField.getAttribute("value"), expected);
    }

    public void assertBank(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(bankField.getText().trim(), expected);
    }

    public void assertNoBank(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(noBankField.getAttribute("value"), expected);
    }

    public void assertMPan(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(mPanField.getAttribute("value"), expected);
    }

    public void assertNamaBank(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(namaBankField.getAttribute("value"), expected);
    }

    public void assertKcKcp(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(kcKcpField.getAttribute("value"), expected);
    }

    public void assertNMID(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(nMIDField.getAttribute("value"), expected);
    }

    public void assertLinkEComm(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(linkECommField.getAttribute("value"), expected);
    }

    public void assertWebsite(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(websiteField.getAttribute("value"), expected);
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

    public void assertDebitCardChecked(SoftAssert softAssert) {
        boolean debitIsChecked = debitCardCheckBox.getAttribute("aria-checked").contains("true");

    }

    public void assertEMoneyChecked(SoftAssert softAssert) {
        boolean eMoneyIsChecked = eMoneyCheckBox.getAttribute("aria-checked").contains("true");

    }

    public void assertAggregator(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(aggregatorField.getText().trim(), expected);
    }

}
