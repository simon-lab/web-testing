package com.saimen.pages.dspPortal;

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

public class informasiLayananPage extends AbstractPage {
    @FindBy(xpath = "//h6[.='Personal Info']")
    private WebElement validator;

    @FindBy(xpath = "//input[@id='pic_name']")
    private WebElement picNameField;
    @FindBy(xpath = "//input[@id='phone_number']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"select2-ju_fdm-container\"]")
    private WebElement jenisKioskDropdown;
    @FindBy(xpath = "//li[text()='SINGLE']")
    private WebElement singleBtn;
    @FindBy(xpath = "//li[text()='MULTI']")
    private WebElement multiBtn;
    @FindBy(xpath = "//li[text()='Pilih Jenis Usaha FDM']")
    private WebElement kosongUsahaBtn;

    @FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[1]")
    private WebElement jenisLayananField;
    @FindBy(xpath = "//li[text()='Self Order Kiosk']")
    private WebElement selfOrderLayanan;
    @FindBy(xpath = "//li[text()='VKiosk']")
    private WebElement vKioskLayanan;
    @FindBy(xpath = "//li[text()='EDC QR']")
    private WebElement edcQrLayanan;
    @FindBy(xpath = "//li[text()='QRIS E-Commerce']")
    private WebElement eCommerceLayanan;
    @FindBy(xpath = "//li[text()='QRIS Statis']")
    private WebElement qrStatisLayanan;

    @FindBy(xpath = "//*[@id=\"select2-tp_kiosk-container\"]")
    private WebElement tipeKioskDropdown;
    @FindBy(xpath = "//li[text()='Regular']")
    private WebElement regularBtn;
    @FindBy(xpath = "//li[text()='Ticketing']")
    private WebElement ticketingBtn;
    @FindBy(xpath = "//li[text()='Reservation']")
    private WebElement reservationBtn;
    @FindBy(xpath = "//li[text()='Delivery']")
    private WebElement deliveryBtn;
    @FindBy(xpath = "//li[text()='Pilih Tipe Kiosk']")
    private WebElement tipeKioskKosongBtn;

    @FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[2]")
    private WebElement tipeOrderDropdown;
    @FindBy(xpath = "//li[text()='Dine In']")
    private WebElement dineInBtn;
    @FindBy(xpath = "//li[text()='Take Away']")
    private WebElement takeAwayBtn;
    @FindBy(xpath = "//li[text()='Delivery']")
    private WebElement deliveryOrderBtn;
    @FindBy(xpath = "//li[text()='Pick Up']")
    private WebElement pickUpBtn;

    @FindBy(xpath = "//input[@id='PPN']")
    private WebElement ppnField;
    @FindBy(xpath = "//input[@id='Service_Charge']")
    private WebElement serviceChargeField;
    @FindBy(xpath = "//input[@id='Biaya_Admin']")
    private WebElement adminFeeField;

    @FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[3]")
    private WebElement metodePembayaranField;
    @FindBy(xpath = "//li[text()='QRIS']")
    private WebElement qrisMetode;
    @FindBy(xpath = "//li[text()='Debit']")
    private WebElement debitMetode;
    @FindBy(xpath = "//li[text()='E-Money']")
    private WebElement eMoneyMetode;

    @FindBy(xpath = "//input[@id='daring_checkbox']")
    private WebElement layananDaringCheckBox;
    @FindBy(xpath = "//input[@id='daring_mdr']")
    private WebElement layananDaringField;

    @FindBy(xpath = "//input[@id='luring_checkbox']")
    private WebElement layananLuringCheckBox;
    @FindBy(xpath = "//input[@id='luring_mdr']")
    private WebElement layananLuringField;

    @FindBy(xpath = "//input[@id='Jumlah_Mesin_EDC']")
    private WebElement jumlahEdcField;

    @FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[4]")
    private WebElement jenisKartuField;
    @FindBy(xpath = "//li[text()='Visa']")
    private WebElement kartuVisa;
    @FindBy(xpath = "//li[text()='Master']")
    private WebElement kartuMaster;
    @FindBy(xpath = "//li[text()='JCB']")
    private WebElement kartuJCB;
    @FindBy(xpath = "//li[text()='UPI']")
    private WebElement kartuUPI;

    @FindBy(xpath = "(//span[text()='Sebelumnya'])[1]")
    private WebElement sebelumnyaBtn;

    @FindBy(xpath = "(//span[text()='Simpan'])[2]")
    private WebElement simpanBtn;
    @FindBy(xpath = "(//span[text()='Selanjutnya'])[2]")
    private WebElement selanjutnyaBtn;

    public informasiLayananPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void isiPICUsaha(String PICUsaha) {
        picNameField.sendKeys(PICUsaha);
    }

    public void isiNoTelp(String noTelp) {
        phoneNumberField.sendKeys(noTelp);
    }

    public void isiEmail(String email) {
        emailField.sendKeys(email);
    }

    public void pilihJenisKiosk(String jenisKiosk) {
        jenisKioskDropdown.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.singleBtn));

        if ("single".equalsIgnoreCase(jenisKiosk)) {
            singleBtn.click();
        } else if ("multi".equalsIgnoreCase(jenisKiosk)) {
            multiBtn.click();
        } else if ("kosong".equalsIgnoreCase(jenisKiosk)) {
            kosongUsahaBtn.click();
        } else {
            Assert.fail("Jenis Usaha Tidak Ada");
        }

    }

    public void pilihJenisLayanan(List<String> jenisLayanan) {
        if (jenisLayanan.size() > 5) {
            throw new IllegalArgumentException("Maksimal hanya boleh 5 parameter");
        }

        for (String arg : jenisLayanan) {
            jenisLayananField.click();
            this.wait.until(ExpectedConditions.visibilityOf(this.vKioskLayanan));
            if ("self order kiosk".equalsIgnoreCase(arg)) {
                selfOrderLayanan.click();
            } else if ("vkiosk".equalsIgnoreCase(arg)) {
                vKioskLayanan.click();
            } else if ("edc qr".equalsIgnoreCase(arg)) {
                edcQrLayanan.click();
            } else if ("qris e-commerce".equalsIgnoreCase(arg)) {
                eCommerceLayanan.click();
            } else if ("qris statis".equalsIgnoreCase(arg)) {
                qrStatisLayanan.click();
            } else {
                Assert.fail("Jenis Layanan " + arg + " Tidak Ada");
            }
        }

    }

    public void pilihTipeKiosk(String tipeKiosk) {

        tipeKioskDropdown.click();

        this.wait.until(ExpectedConditions.visibilityOf(this.regularBtn));

        if ("regular".equalsIgnoreCase(tipeKiosk)) {
            regularBtn.click();
        } else if ("ticketing".equalsIgnoreCase(tipeKiosk)) {
            ticketingBtn.click();
        } else if ("reservation".equalsIgnoreCase(tipeKiosk)) {
            reservationBtn.click();
        } else if ("delivery".equalsIgnoreCase(tipeKiosk)) {
            deliveryBtn.click();
        } else if ("kosong".equalsIgnoreCase(tipeKiosk)) {
            deliveryBtn.click();
        } else {
            Assert.fail("Tipe Kiosk Tidak Ada");
        }

    }

    public void pilihTipeOrder(List<String> tipeOrder) {
        if (tipeOrder.size() > 4) {
            throw new IllegalArgumentException("Maksimal hanya boleh 4 parameter");
        }

        for (String arg : tipeOrder) {
            tipeOrderDropdown.click();
            this.wait.until(ExpectedConditions.visibilityOf(this.dineInBtn));
            if ("dine in".equalsIgnoreCase(arg)) {
                dineInBtn.click();
            } else if ("take away".equalsIgnoreCase(arg)) {
                takeAwayBtn.click();
            } else if ("delivery".equalsIgnoreCase(arg)) {
                deliveryOrderBtn.click();
            } else if ("pick up".equalsIgnoreCase(arg)) {
                pickUpBtn.click();
            } else {
                Assert.fail("Tipe Order " + arg + " Tidak Ada");
            }
        }

    }

    public void isiPPN(String ppn) {
        ppnField.sendKeys(ppn);
    }

    public void isiServiceCharge(String serviceCharge) {
        serviceChargeField.sendKeys(serviceCharge);
    }

    public void isiBiayaAdmin(String biayaAdmin) {
        adminFeeField.sendKeys(biayaAdmin);
    }

    public void pilihMetodePembayaran(List<String> metodePelayanan) {
        if (metodePelayanan.size() > 3) {
            throw new IllegalArgumentException("Maksimal hanya boleh 3 parameter");
        }

        for (String arg : metodePelayanan) {
            metodePembayaranField.click();
            this.wait.until(ExpectedConditions.visibilityOf(this.qrisMetode));
            if ("qris".equalsIgnoreCase(arg)) {
                qrisMetode.click();
            } else if ("debit".equalsIgnoreCase(arg)) {
                debitMetode.click();
            } else if ("e-money".equalsIgnoreCase(arg)) {
                eMoneyMetode.click();
            } else {
                Assert.fail("Metode Pelayanan " + arg + " Tidak Ada");
            }
        }

    }

    public void activeOnline() {
        layananDaringCheckBox.click();
    }

    public void isiActiveOnline(String isi) {
        layananDaringField.sendKeys(isi);
    }

    public void activeOffline() {
        layananLuringCheckBox.click();
    }

    public void isiActiveOffline(String isi) {
        layananLuringField.sendKeys(isi);
    }

    public void isiJumlahEDC(String jumlah) {
        jumlahEdcField.sendKeys(jumlah);
    }

    public void pilihJenisKartu(List<String> jenisKartu) {
        if (jenisKartu.size() > 4) {
            throw new IllegalArgumentException("Maksimal hanya boleh 4 parameter");
        }

        for (String arg : jenisKartu) {
            jenisKartuField.click();
            this.wait.until(ExpectedConditions.visibilityOf(this.kartuMaster));
            if ("visa".equalsIgnoreCase(arg)) {
                kartuVisa.click();
            } else if ("master".equalsIgnoreCase(arg)) {
                kartuMaster.click();
            } else if ("jcb".equalsIgnoreCase(arg)) {
                kartuJCB.click();
            } else if ("upi".equalsIgnoreCase(arg)) {
                kartuUPI.click();
            } else {
                Assert.fail("Kartu " + arg + " Tidak Ada");
            }
        }

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

    public void assertNamaPICUsaha(String expectedNamaPIC, SoftAssert softAssert) {
        softAssert.assertEquals(picNameField.getAttribute("value"), expectedNamaPIC);
    }

    public void assertNoTelpPICUsaha(String expectedPhone, SoftAssert softAssert) {
        softAssert.assertEquals(phoneNumberField.getAttribute("value"), expectedPhone);
    }

    public void assertEmailPICUsaha(String expectedEmail, SoftAssert softAssert) {
        softAssert.assertEquals(emailField.getAttribute("value"), expectedEmail);
    }

    public void assertJenisKiosk(String expectedJenisKiosk, SoftAssert softAssert) {
        softAssert.assertEquals(jenisKioskDropdown.getText(), expectedJenisKiosk);
    }

    public void assertJenisLayanan(List<String> expectedJenisLayanan, SoftAssert softAssert) {
        List<WebElement> jenisLayananList = driver
                .findElements(By.xpath("//*[@id='step1']/div[2]/div[5]/span/span[1]/span/ul/li"));

        List<String> actualList = jenisLayananList.stream()
                .map(WebElement::getText).map(text -> text.replaceAll("[^\\p{L}\\p{N}\\s]", "").trim())
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());

        System.out.println("Ini actual Jenis Layanan List: " + actualList);
        System.out.println("Ini Expected Jenis Layanan List: " + expectedJenisLayanan);

        softAssert.assertEquals(actualList, expectedJenisLayanan, "Isi Jenis Layanan tidak sesuai.");
    }

    public void assertTipeKiosk(String expectedTipeKiosk, SoftAssert softAssert) {
        softAssert.assertEquals(tipeKioskDropdown.getText(), expectedTipeKiosk);
    }

    public void assertOrderType(List<String> expectedOrderType, SoftAssert softAssert) {
        List<WebElement> orderTypeList = driver
                .findElements(By.xpath("//*[@id=\"step1\"]/div[2]/div[7]/span/span[1]/span/ul/li"));

        List<String> actualList = orderTypeList.stream()
                .map(WebElement::getText).map(text -> text.replaceAll("[^\\p{L}\\p{N}\\s]", "").trim())
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());

        softAssert.assertEquals(actualList, expectedOrderType, "Isi Tipe Order tidak sesuai.");
    }

    public void assertPPN(String expectedPPN, SoftAssert softAssert) {
        softAssert.assertEquals(ppnField.getAttribute("value"), expectedPPN);
    }

    public void assertServiceCharge(String expectedServiceCharge, SoftAssert softAssert) {
        softAssert.assertEquals(serviceChargeField.getAttribute("value"), expectedServiceCharge);
    }

    public void assertAdminFee(String expectedAdminFee, SoftAssert softAssert) {
        softAssert.assertEquals(adminFeeField.getAttribute("value"), expectedAdminFee);
    }

    public void assertMetodePembayaran(List<String> expectedMetodePembayaran, SoftAssert softAssert) {
        List<WebElement> metodePembayaranList = driver
                .findElements(By.xpath("//*[@id=\"step1\"]/div[2]/div[7]/span/span[1]/span/ul/li"));

        List<String> actualList = metodePembayaranList.stream()
                .map(WebElement::getText).map(text -> text.replaceAll("[^\\p{L}\\p{N}\\s]", "").trim())
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());

        softAssert.assertEquals(actualList, expectedMetodePembayaran, "Isi Tipe Order tidak sesuai.");
    }

    public void assertOnline(String expectedOnline, SoftAssert softAssert) {
        softAssert.assertEquals(layananDaringField.getAttribute("value"), expectedOnline);
    }

    public void assertOffline(String expectedOffline, SoftAssert softAssert) {
        softAssert.assertEquals(layananLuringField.getAttribute("value"), expectedOffline);
    }

    public void assertJumlahEDC(String expectedJumlahEDC, SoftAssert softAssert) {
        softAssert.assertEquals(jumlahEdcField.getAttribute("value"), expectedJumlahEDC);
    }

    public void assertJenisKartu(List<String> expectedJenisKartu, SoftAssert softAssert) {
        List<WebElement> jenisKartuList = driver
                .findElements(By.xpath("//*[@id=\"step1\"]/div[2]/div[15]/div/span/span[1]/span/ul/li"));

        List<String> actualList = jenisKartuList.stream()
                .map(WebElement::getText).map(text -> text.replaceAll("[^\\p{L}\\p{N}\\s]", "").trim())
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());

        softAssert.assertEquals(actualList, expectedJenisKartu, "Isi Tipe Order tidak sesuai.");
    }
}
