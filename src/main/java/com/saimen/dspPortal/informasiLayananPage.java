package com.saimen.dspPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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

    @FindBy(css = "[title='Pilih Jenis Usaha FDM']")
    private WebElement jenisUsahaDropdown;
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

    @FindBy(css = "[title='Pilih Tipe Kiosk']")
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

    public void pilihJenisUsaha(String jenisUsaha) {
        jenisUsahaDropdown.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.singleBtn));

        if (jenisUsaha == "single") {
            singleBtn.click();
        } else if (jenisUsaha == "multi") {
            multiBtn.click();
        } else if (jenisUsaha == "kosong") {
            kosongUsahaBtn.click();
        } else {
            Assert.fail("Jenis Usaha Tidak Ada");
        }

    }

    public void pilihJenisLayanan(String... jenisLayanan) {
        if (jenisLayanan.length > 5) {
            throw new IllegalArgumentException("Maksimal hanya boleh 5 parameter");
        }

        for (String arg : jenisLayanan) {
            jenisLayananField.click();
            this.wait.until(ExpectedConditions.visibilityOf(this.vKioskLayanan));
            if ("self order kiosk".equals(arg)) {
                selfOrderLayanan.click();
            } else if ("vkiosk".equals(arg)) {
                vKioskLayanan.click();
            } else if ("edc qr".equals(arg)) {
                edcQrLayanan.click();
            } else if ("qris e-commerce".equals(arg)) {
                eCommerceLayanan.click();
            } else if ("qris statis".equals(arg)) {
                qrStatisLayanan.click();
            } else {
                Assert.fail("Jenis Layanan " + arg + " Tidak Ada");
            }
        }

    }

    public void pilihTipeKiosk(String tipeKiosk) {

        tipeKioskDropdown.click();

        this.wait.until(ExpectedConditions.visibilityOf(this.regularBtn));

        if (tipeKiosk == "regular") {
            regularBtn.click();
        } else if (tipeKiosk == "ticketing") {
            ticketingBtn.click();
        } else if (tipeKiosk == "reservation") {
            reservationBtn.click();
        } else if (tipeKiosk == "delivery") {
            deliveryBtn.click();
        } else if (tipeKiosk == "kosong") {
            deliveryBtn.click();
        } else {
            Assert.fail("Tipe Kiosk Tidak Ada");
        }

    }

    public void pilihTipeOrder(String... tipeOrder) {
        if (tipeOrder.length > 4) {
            throw new IllegalArgumentException("Maksimal hanya boleh 4 parameter");
        }

        for (String arg : tipeOrder) {
            tipeOrderDropdown.click();
            this.wait.until(ExpectedConditions.visibilityOf(this.dineInBtn));
            if ("dine in".equals(arg)) {
                dineInBtn.click();
            } else if ("take away".equals(arg)) {
                takeAwayBtn.click();
            } else if ("delivery".equals(arg)) {
                deliveryOrderBtn.click();
            } else if ("pick up".equals(arg)) {
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

    public void pilihMetodePembayaran(String... metodePelayanan) {
        if (metodePelayanan.length > 3) {
            throw new IllegalArgumentException("Maksimal hanya boleh 3 parameter");
        }

        for (String arg : metodePelayanan) {
            metodePembayaranField.click();
            this.wait.until(ExpectedConditions.visibilityOf(this.qrisMetode));
            if ("qris".equals(arg)) {
                qrisMetode.click();
            } else if ("debit".equals(arg)) {
                debitMetode.click();
            } else if ("e-money".equals(arg)) {
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

    public void pilihJenisKartu(String... jenisKartu) {
        if (jenisKartu.length > 4) {
            throw new IllegalArgumentException("Maksimal hanya boleh 4 parameter");
        }

        for (String arg : jenisKartu) {
            jenisKartuField.click();
            this.wait.until(ExpectedConditions.visibilityOf(this.kartuMaster));
            if ("visa".equals(arg)) {
                kartuVisa.click();
            } else if ("master".equals(arg)) {
                kartuMaster.click();
            } else if ("jcb".equals(arg)) {
                kartuJCB.click();
            } else if ("upi".equals(arg)) {
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
}
