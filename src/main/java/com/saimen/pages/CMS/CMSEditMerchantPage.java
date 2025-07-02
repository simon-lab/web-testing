package com.saimen.pages.CMS;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.saimen.AbstractPage;

public class CMSEditMerchantPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='text-weight-bold']/span[text()=' | Form']")
    private WebElement validator;

    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[1]")
    private WebElement namaMerchantField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[2]")
    private WebElement alamatField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[3]")
    private WebElement noTelpField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[4]")
    private WebElement ownerField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[5]")
    private WebElement npwpField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[6]")
    private WebElement deedField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[7]")
    private WebElement decreeField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[8]")
    private WebElement NIBField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[9]")
    private WebElement namaPicField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[10]")
    private WebElement noPicField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[11]")
    private WebElement emailPicField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[12]")
    private WebElement lineField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[13]")
    private WebElement nikOwnerField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[14]")
    private WebElement alamatOwnerField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[15]")
    private WebElement emailOwnerField;
    @FindBy(xpath = "(//div[@class='q-field__control relative-position row no-wrap'])[16]")
    private WebElement noOwnerField;

    @FindBy(xpath = "(//button)[4]")
    private WebElement kioskMultiOutletBtn;

    @FindBy(xpath = "(//button)[5]")
    private WebElement kioskSingleOutletBtn;

    @FindBy(css = "div.q-chip__content > span.ellipsis")
    private List<WebElement> platformList;

    public CMSEditMerchantPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void assertNamaMerchant(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(namaMerchantField.getText().trim(), expected, "Nama Merchant tidak sesuai");
    }

    public void assertAlamat(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(alamatField.getText().trim(), expected, "Alamat tidak sesuai");
    }

    public void assertNoTelp(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(noTelpField.getText().trim(), expected, "No Telp tidak sesuai");
    }

    public void assertOwner(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(ownerField.getText().trim(), expected, "Owner tidak sesuai");
    }

    public void assertNPWP(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(npwpField.getText().trim(), expected, "NPWP tidak sesuai");
    }

    public void assertDeed(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(deedField.getText().trim(), expected, "Deed tidak sesuai");
    }

    public void assertDecree(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(decreeField.getText().trim(), expected, "Decree tidak sesuai");
    }

    public void assertNIB(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(NIBField.getText().trim(), expected, "NIB tidak sesuai");
    }

    public void assertNamaPIC(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(namaPicField.getText().trim(), expected, "Nama PIC tidak sesuai");
    }

    public void assertNoPIC(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(noPicField.getText().trim(), expected, "No PIC tidak sesuai");
    }

    public void assertEmailPIC(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(emailPicField.getText().trim(), expected, "Email PIC tidak sesuai");
    }

    public void assertLine(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(lineField.getText().trim(), expected, "Line tidak sesuai");
    }

    public void assertNIKOwner(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(nikOwnerField.getText().trim(), expected, "NIK Owner tidak sesuai");
    }

    public void assertAlamatOwner(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(alamatOwnerField.getText().trim(), expected, "Alamat Owner tidak sesuai");
    }

    public void assertEmailOwner(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(emailOwnerField.getText().trim(), expected, "Email Owner tidak sesuai");
    }

    public void assertNoOwner(String expected, SoftAssert softAssert) {
        softAssert.assertEquals(noOwnerField.getText().trim(), expected, "No Owner tidak sesuai");
    }

    public void assertPlatform(List<String> expectedPlatformList, SoftAssert softAssert) {
        List<String> actualPlatformList = platformList.stream()
                .map(e -> e.getText().trim())
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());

        softAssert.assertEquals(actualPlatformList, expectedPlatformList, "Platform list tidak sesuai");
    }

    public void assertOutletType(String expected, SoftAssert softAssert) {
        boolean isMultiActive = kioskMultiOutletBtn.getAttribute("class").contains("bg-primary");
        boolean isSingleActive = kioskSingleOutletBtn.getAttribute("class").contains("bg-primary");

        if (expected.equalsIgnoreCase("multi")) {
            softAssert.assertTrue(isMultiActive, "Expected MULTI outlet to be selected");
            softAssert.assertFalse(isSingleActive, "SINGLE outlet should not be selected");
        } else if (expected.equalsIgnoreCase("single")) {
            softAssert.assertTrue(isSingleActive, "Expected SINGLE outlet to be selected");
            softAssert.assertFalse(isMultiActive, "MULTI outlet should not be selected");
        } else {
            softAssert.fail("Expected outlet type must be either 'multi' or 'single'");
        }
    }

}
