package com.saimen.dspPortal;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.saimen.AbstractPage;

public class informasiSettlementPage extends AbstractPage {
    @FindBy(xpath = "//h6[.='Finance Detail']")
    private WebElement validator;

    @FindBy(xpath = "//input[@id='pic_finance']")
    private WebElement picNameField;
    @FindBy(xpath = "//input[@id='finance_phone_number']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//input[@id='finance_email']")
    private WebElement emailField;

    @FindBy(xpath = "(//input[@class='select2-search__field'])[5]")
    private WebElement supportCardField;
    @FindBy(xpath = "//li[text()='Credit Card']")
    private WebElement creditCard;
    @FindBy(xpath = "//li[text()='Debit Card']")
    private WebElement debitCard;
    @FindBy(xpath = "//li[text()='E-Money']")
    private WebElement eMoney;

    @FindBy(xpath = "//*[@id=\"select2-bankname-container\"]")
    private WebElement pilihBankDropdown;
    @FindBy(xpath = "(//input[@type='search'])[6]")
    private WebElement cariBank;
    @FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
    private WebElement bankTerpilih;
    @FindBy(xpath = "//div[@class='swal2-html-container']")
    private WebElement bankValid;
    @FindBy(xpath = "//li[text()='125 - KALTENG-BANK KALTENG']")
    private WebElement kaltengBank;

    @FindBy(xpath = "//input[@id='card_number']")
    private WebElement noRekeningField;
    @FindBy(xpath = "//span[.='INQ']")
    private WebElement inqBtn;
    @FindBy(xpath = "//input[@id='user_card_name']")
    private WebElement namaPemilikRekening;
    @FindBy(xpath = "//input[@id='branch_name']")
    private WebElement kcKcpField;

    @FindBy(xpath = "(//span[text()='Sebelumnya'])[2]")
    private WebElement sebelumnyaBtn;

    @FindBy(xpath = "(//span[text()='Simpan'])[3]")
    private WebElement simpanBtn;
    @FindBy(xpath = "(//span[text()='Selanjutnya'])[3]")
    private WebElement selanjutnyaBtn;

    public informasiSettlementPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void isiPICFinance(String PICFinance) {
        picNameField.sendKeys(PICFinance);
    }

    public void isiNoTelp(String noTelp) {
        phoneNumberField.sendKeys(noTelp);
    }

    public void isiEmail(String email) {
        emailField.sendKeys(email);
    }

    public void supportCard(List<String> card) {
        if (card.size() > 5) {
            throw new IllegalArgumentException("Maksimal hanya boleh 5 parameter");
        }

        for (String arg : card) {
            supportCardField.click();
            this.wait.until(ExpectedConditions.visibilityOf(this.creditCard));
            if ("credit card".equalsIgnoreCase(arg)) {
                creditCard.click();
            } else if ("debit card".equalsIgnoreCase(arg)) {
                debitCard.click();
            } else if ("e-money".equalsIgnoreCase(arg)) {
                eMoney.click();
            } else {
                Assert.fail("Karuti " + arg + " Tidak Ada");
            }
        }

    }

    public void pilihBank(String noBank) {
        pilihBankDropdown.click();
        cariBank.sendKeys(noBank);
        bankTerpilih.click();
    }

    public void isiNoRekening(String noRekening) {
        noRekeningField.sendKeys(noRekening);
    }

    public void inqClick() {
        inqBtn.click();
    }

    public void assertNamaPemilik(String namaPemilik) {
        this.wait.until(ExpectedConditions.visibilityOf(bankValid));
        this.wait.until(ExpectedConditions.visibilityOf(namaPemilikRekening));
        Assert.assertEquals(namaPemilikRekening.getAttribute("value"), namaPemilik);
    }

    public void isKcKcp(String kcKcp) {
        kcKcpField.sendKeys(kcKcp);
    }

    public void sebelumnya() {
        sebelumnyaBtn.click();
    }

    public void simpan() {
        simpanBtn.click();
    }

    public void selanjutnya() {
        selanjutnyaBtn.click();
    }

    public void assertPicName(String expectedPicName, SoftAssert softAssert) {
        softAssert.assertEquals(picNameField.getAttribute("value"), expectedPicName, "PIC Name tidak sesuai");
    }

    public void assertPhoneNumber(String expectedPhoneNumber, SoftAssert softAssert) {
        softAssert.assertEquals(phoneNumberField.getAttribute("value"), expectedPhoneNumber,
                "Nomor telepon tidak sesuai");
    }

    public void assertEmail(String expectedEmail, SoftAssert softAssert) {
        softAssert.assertEquals(emailField.getAttribute("value"), expectedEmail, "Email tidak sesuai");
    }

    public void assertSupportCard(List<String> expectedSupportCards, SoftAssert softAssert) {

        List<WebElement> supportCardList = driver
                .findElements(By.xpath("//*[@id=\"step2\"]/div[2]/div[4]/div/span/span[1]/span/ul/li"));
        List<String> actualCards = supportCardList.stream()
                .map(WebElement::getText)
                .map(text -> text.replaceAll("[^\\p{L}\\p{N}\\s]", "").trim())
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());

        softAssert.assertEquals(actualCards, expectedSupportCards, "Support card tidak sesuai");
    }

    public void assertPilihBank(String expectedBank, SoftAssert softAssert) {
        softAssert.assertEquals(pilihBankDropdown.getText().trim(), expectedBank, "Bank yang dipilih tidak sesuai");
    }

    public void assertNoRekening(String expectedNoRekening, SoftAssert softAssert) {
        softAssert.assertEquals(noRekeningField.getAttribute("value"), expectedNoRekening, "No Rekening tidak sesuai");
    }

    public void assertNamaPemilikRekening(String expectedNamaPemilik, SoftAssert softAssert) {
        softAssert.assertEquals(namaPemilikRekening.getAttribute("value"), expectedNamaPemilik,
                "Nama pemilik rekening tidak sesuai");
    }

    public void assertKCKCP(String expectedKCKCP, SoftAssert softAssert) {
        softAssert.assertEquals(kcKcpField.getAttribute("value"), expectedKCKCP, "KC/KCP tidak sesuai");
    }
}
