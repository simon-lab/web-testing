package com.saimen.dspPortal;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.saimen.AbstractPage;

public class informasiUsahaPage extends AbstractPage {
    @FindBy(xpath = "//h6[.='Company Info']")
    private WebElement validator;

    @FindBy(xpath = "//input[@id='business_pic']")
    private WebElement picNameField;
    @FindBy(xpath = "//input[@id='work']")
    private WebElement workField;

    @FindBy(css = "[title='Pilih Jenis Identitas']")
    private WebElement jenisUsahaDropdown;
    @FindBy(xpath = "//li[text()='Pilih Jenis Identitas']")
    private WebElement kosongBtn;
    @FindBy(xpath = "//li[text()='NIK']")
    private WebElement nikBtn;
    @FindBy(xpath = "//li[text()='Pasport']")
    private WebElement pasportBtn;
    @FindBy(xpath = "//li[text()='Kitas']")
    private WebElement kitasBtn;

    @FindBy(xpath = "//input[@id='id_number']")
    private WebElement noIdentitasField;
    @FindBy(xpath = "//span[.='Check']")
    private WebElement checkBtn;

    @FindBy(xpath = "//input[@id='birth_place']")
    private WebElement tempatLahirField;
    @FindBy(xpath = "//input[@id='birthday']")
    private WebElement tanggalLahirField;
    @FindBy(xpath = "//input[@id='address']")
    private WebElement alamatKtpField;

    @FindBy(css = "[title='Pilih Provinsi KTP']")
    private WebElement pilihProvinsiDropdown;
    @FindBy(xpath = "//li[text()='JAWA BARAT']")
    private WebElement jawaBaratBtn;

    @FindBy(css = "[title='Pilih Kabupaten/Kota KTP']")
    private WebElement pilihKotaDropdown;
    @FindBy(xpath = "//li[text()='KOTA BANDUNG']")
    private WebElement bandungBtn;

    @FindBy(xpath = "//input[@id='npwp_number']")
    private WebElement npwpField;
    @FindBy(xpath = "//input[@id='npwp_account_name']")
    private WebElement namaNpwpField;
    @FindBy(xpath = "//input[@id='npwp_phone']")
    private WebElement noTelpField;
    @FindBy(xpath = "//input[@id='npwp_address']")
    private WebElement alamatNpwpField;
    @FindBy(xpath = "//input[@id='alamat_usaha']")
    private WebElement alamatUsahaField;

    @FindBy(css = "[title='Pilih Provinsi Usaha']")
    private WebElement provinsiUsahaDropdown;
    @FindBy(xpath = "//li[text()='JAWA BARAT']")
    private WebElement jawaBarat;
    @FindBy(xpath = "//span[text()='- Pilih Kabupaten/Kota Usaha -']")
    private WebElement kotaUsahaDropdown;
    @FindBy(xpath = "//li[text()='KOTA BANDUNG']")
    private WebElement bandung;
    @FindBy(xpath = "//span[text()='- Pilih Kecamatan Usaha -']")
    private WebElement kecamatanUsahaDropdown;
    @FindBy(xpath = "//li[text()='Antapani']")
    private WebElement antapani;
    @FindBy(xpath = "//span[text()='- Pilih Kelurahan Usaha -']")
    private WebElement kelurahanUsahaDropdown;
    @FindBy(xpath = "//li[text()='Antapani Tengah']")
    private WebElement antapaniTengah;

    @FindBy(xpath = "//input[@id='postal_code']")
    private WebElement kodePosField;

    @FindBy(xpath = "//div[@class='content active dstepper-block']//button[@class='btn btn-primary btn-prev']")
    private WebElement sebelumnyaBtn;

    @FindBy(xpath = "//div[@class='content active dstepper-block']//button[@class='btn btn-warning btn-submit']")
    private WebElement simpanBtn;
    @FindBy(xpath = "//div[@class='content active dstepper-block']//button[@class='btn btn-primary btn-next']/span[@class='align-middle d-sm-inline-block d-none me-sm-2']")
    private WebElement selanjutnyaBtn;

    public informasiUsahaPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void isiPemilikUsaha(String pemilikUsaha) {
        picNameField.sendKeys(pemilikUsaha);
    }

    public void pilihJenisIdentitas(String jenisIdentitas) {
        jenisUsahaDropdown.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.nikBtn));

        if (jenisIdentitas == "nik") {
            nikBtn.click();
        } else if (jenisIdentitas == "paspor") {
            pasportBtn.click();
        } else if (jenisIdentitas == "kitas") {
            kitasBtn.click();
        } else if (jenisIdentitas == "kosong") {
            kosongBtn.click();
        } else {
            Assert.fail("Jenis Identitas Tidak Ada");
        }

    }

    public void isiNoIdentitas(String noIdentitas) {
        noIdentitasField.sendKeys(noIdentitas);
    }

    public void isiTempatLahir(String tempatLahir) {
        tempatLahirField.sendKeys(tempatLahir);
    }

    public void isiTanggalLahir(String tempatLahir) {
        tempatLahirField.sendKeys(tempatLahir);
    }

    public void pilihTanggalLahir(String tanggalLahir) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate targetDate = LocalDate.parse(tanggalLahir, formatter);

        int targetDay = targetDate.getDayOfMonth();
        int targetMonth = targetDate.getMonthValue();
        int targetYear = targetDate.getYear();

        tanggalLahirField.click();

        while (true) {
            // Ambil teks bulan dan tahun yang sedang tampil, misal: "Juni 2025"
            String displayedMonthYear = driver.findElement(By.className("datepicker-switch")).getText();
            DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy",
                    new Locale("id")); // 'Juni
            // 2025'
            LocalDate displayedDate = YearMonth.parse(displayedMonthYear, monthYearFormatter).atDay(1);

            int displayedMonth = displayedDate.getMonthValue();
            int displayedYear = displayedDate.getYear();

            if (displayedYear == targetYear && displayedMonth == targetMonth) {
                break; // Sudah di bulan yang benar
            }

            if (displayedYear > targetYear || (displayedYear == targetYear && displayedMonth > targetMonth)) {
                // Klik tombol prev
                driver.findElement(By.className("prev")).click();
            } else {
                // Klik tombol next
                driver.findElement(By.className("next")).click();
            }
        }

        String xpathTanggal = "//td[text()='" + targetDay + "']";
        driver.findElement(By.xpath(xpathTanggal)).click();

    }

    public void isiAlamatKtp(String alamatKtp) {
        alamatKtpField.sendKeys(alamatKtp);
    }

    public void isiProvinsiKotaKTP() {
        pilihProvinsiDropdown.click();
        jawaBarat.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.pilihKotaDropdown));
        pilihKotaDropdown.click();
        bandung.click();
    }

    public void isiNoNPWP(String noNPWP) {
        npwpField.sendKeys(noNPWP);
    }

    public void isiNamaNPWP(String namaNPWP) {
        namaNpwpField.sendKeys(namaNPWP);
    }

    public void isiNoTelp(String noTelp) {
        noTelpField.sendKeys(noTelp);
    }

    public void isiAlamatNPWP(String alamatNPWP) {
        alamatNpwpField.sendKeys(alamatNPWP);
    }

    public void isiAlamatUsaha(String alamatUsaha) {
        alamatUsahaField.sendKeys(alamatUsaha);
    }

    public void isiProvinsiKotaUsaha() {
        provinsiUsahaDropdown.click();
        jawaBarat.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.kotaUsahaDropdown));
        kotaUsahaDropdown.click();
        bandung.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.kecamatanUsahaDropdown));
        kecamatanUsahaDropdown.click();
        antapani.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.kelurahanUsahaDropdown));
        kelurahanUsahaDropdown.click();
        antapaniTengah.click();
    }

    public void isiKodePos(String kodePos) {
        kodePosField.sendKeys(kodePos);
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
