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
    @FindBy(xpath = "//li[@id='select2-ju_fdm-result-9x6n-SINGLE']")
    private WebElement singleBtn;
    @FindBy(xpath = "//li[@id='select2-ju_fdm-result-l6t1-MULTI']")
    private WebElement multiBtn;
    @FindBy(xpath = "//li[text()='Pilih Jenis Usaha FDM']")
    private WebElement kosongUsahaBtn;

    @FindBy(xpath = "//span[@class='select2 select2-container select2-container--default select2-container--below select2-container--focus']//input[@class='select2-search__field']")
    private WebElement jenisLayananField;
    @FindBy(id = "//li[@id='select2-jl_fdm-result-ijl1-Self Order Kiosk']")
    private WebElement selfOrderLayanan;
    @FindBy(id = "//li[@id='select2-jl_fdm-result-hyza-VKiosk']")
    private WebElement vKioskLayanan;
    @FindBy(id = "//li[@id='select2-jl_fdm-result-9mxw-EDC QR']")
    private WebElement edcQrLayanan;
    @FindBy(id = "//li[@id='select2-jl_fdm-result-94xu-QRIS E-Commerce']")
    private WebElement eCommerceLayanan;
    @FindBy(id = "//li[@id='select2-jl_fdm-result-cpvy-QRIS Statis']")
    private WebElement qrStatisLayanan;

    @FindBy(xpath = "//input[@id='PPN']")
    private WebElement ppnField;
    @FindBy(xpath = "//input[@id='Service_Charge']")
    private WebElement serviceChargeField;
    @FindBy(xpath = "//input[@id='Biaya_Admin']")
    private WebElement adminFeeField;

    @FindBy(xpath = "//span[@class='select2 select2-container select2-container--default select2-container--below select2-container--focus']//li[@class='select2-search select2-search--inline']")
    private WebElement metodePembayaranField;
    @FindBy(id = "//li[@id='select2-jp_kiosk-result-lq3r-QRIS']")
    private WebElement qrisMetode;
    @FindBy(id = "//li[@id='select2-jp_kiosk-result-x3t8-Debit']")
    private WebElement debitMetode;
    @FindBy(id = "//li[@id='select2-jp_kiosk-result-egdo-E-Money']")
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

    @FindBy(xpath = "//span[@class='select2 select2-container select2-container--default select2-container--below select2-container--focus']//input[@class='select2-search__field']")
    private WebElement jenisKartuField;
    @FindBy(id = "//li[@id='select2-Jenis_Kartu-result-6gnc-Visa']")
    private WebElement kartuVisa;
    @FindBy(id = "//li[@id='select2-Jenis_Kartu-result-rd4q-Master']")
    private WebElement kartuMaster;
    @FindBy(id = "//li[@id='select2-Jenis_Kartu-result-pmq2-JCB']")
    private WebElement kartuJCB;
    @FindBy(id = "//li[@id='select2-Jenis_Kartu-result-8vry-UPI']")
    private WebElement kartuUPI;

    @FindBy(xpath = "//div[@class='content active dstepper-block']//button[@class='btn btn-primary btn-prev']")
    private WebElement sebelumnyaBtn;

    @FindBy(xpath = "//div[@class='content active dstepper-block']//button[@class='btn btn-warning btn-submit']")
    private WebElement simpanBtn;
    @FindBy(xpath = "//div[@class='content active dstepper-block']//button[@class='btn btn-primary btn-next']/span[@class='align-middle d-sm-inline-block d-none me-sm-2']")
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

        jenisLayananField.click();

        for (String arg : jenisLayanan) {
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

    public void isiPPN(String ppn) {
        ppnField.sendKeys(ppn);
    }

    public void isiServiceCharge(String serviceCharge) {
        serviceChargeField.sendKeys(serviceCharge);
    }

    public void isiBiayaAdmin(String biayaAdmin) {
        adminFeeField.sendKeys(biayaAdmin);
    }

    public void pilihMotedePembayaran(String... metodePelayanan) {
        if (metodePelayanan.length > 3) {
            throw new IllegalArgumentException("Maksimal hanya boleh 3 parameter");
        }

        metodePembayaranField.click();

        for (String arg : metodePelayanan) {
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

        jenisKartuField.click();

        for (String arg : jenisKartu) {
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
