package com.saimen.dspPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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

    @FindBy(css = "[title='Pilih Bank']")
    private WebElement pilihBankDropdown;
    @FindBy(xpath = "//li[text()='125 - KALTENG-BANK KALTENG']")
    private WebElement kaltengBank;

    @FindBy(xpath = "//input[@id='card_number']")
    private WebElement noRekeningField;
    @FindBy(xpath = "//span[.='INQ']")
    private WebElement inqBtn;
    @FindBy(xpath = "//input[@id='user_card_name']")
    private WebElement namaPemilikRekening;

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

    public void supportCard(String... card) {
        if (card.length > 5) {
            throw new IllegalArgumentException("Maksimal hanya boleh 5 parameter");
        }

        for (String arg : card) {
            supportCardField.click();
            this.wait.until(ExpectedConditions.visibilityOf(this.creditCard));
            if ("credit card".equals(arg)) {
                creditCard.click();
            } else if ("debit card".equals(arg)) {
                debitCard.click();
            } else if ("e-money".equals(arg)) {
                eMoney.click();
            } else {
                Assert.fail("Karuti " + arg + " Tidak Ada");
            }
        }

    }

    public void pilihBank() {
        pilihBankDropdown.click();
        kaltengBank.click();
    }

    public void isiNoRekening(String noRekening) {
        noRekeningField.sendKeys(noRekening);
    }

    public void inqClick() {
        inqBtn.click();
    }

    public void assertNamaPemilik(String namaPemilik) {
        Assert.assertEquals(namaPemilik, "");
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
}
