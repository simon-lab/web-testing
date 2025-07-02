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
import org.testng.asserts.SoftAssert;

import com.saimen.AbstractPage;

public class informasiUsahaPage extends AbstractPage {
    @FindBy(xpath = "//h6[.='Company Info']")
    private WebElement validator;
    @FindBy(xpath = "//h4[.='List MOS']")
    private WebElement fdmPageValidator;
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    private WebElement popUpValidator;

    @FindBy(xpath = "//input[@id='business_pic']")
    private WebElement picNameField;
    @FindBy(xpath = "//input[@id='work']")
    private WebElement workField;

    @FindBy(xpath = "//*[@id=\"select2-nikPassportKitasType-container\"]")
    private WebElement jenisUsahaDropdown;
    @FindBy(xpath = "//*[@id=\"select2-nikPassportKitasType-container\"]")
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

    @FindBy(xpath = "//*[@id=\"select2-IDNProvince-container\"]")
    private WebElement pilihProvinsiDropdown;
    @FindBy(xpath = "//li[text()='JAWA BARAT']")
    private WebElement jawaBaratBtn;

    @FindBy(xpath = "//span[text()='- Pilih Kabupaten/Kota -']")
    private WebElement pilihKotaDropdown;
    @FindBy(xpath = "//li[text()='KOTA BANDUNG']")
    private WebElement bandungBtn;

    @FindBy(xpath = "//*[@id=\"select2-IDNCity-container\"]")
    private WebElement pilihKotaDropdownEdit;

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

    @FindBy(xpath = "//*[@id=\"select2-province-container\"]")
    private WebElement provinsiUsahaDropdown;
    @FindBy(xpath = "//li[text()='JAWA BARAT']")
    private WebElement jawaBarat;
    @FindBy(xpath = "//span[text()='- Pilih Kabupaten/Kota -']")
    private WebElement kotaUsahaDropdown;
    @FindBy(xpath = "//li[text()='KOTA BANDUNG']")
    private WebElement bandung;
    @FindBy(xpath = "//span[text()='- Pilih Kecamatan -']")
    private WebElement kecamatanUsahaDropdown;
    @FindBy(xpath = "//li[text()='Antapani']")
    private WebElement antapani;
    @FindBy(xpath = "//span[text()='- Pilih Kelurahan/Desa -']")
    private WebElement kelurahanUsahaDropdown;
    @FindBy(xpath = "//li[text()='Antapani Tengah']")
    private WebElement antapaniTengah;

    @FindBy(xpath = "//*[@id=\"select2-province-container\"]")
    private WebElement provinsiUsahaDropdownEdit;
    @FindBy(xpath = "//*[@id=\"select2-city-container\"]")
    private WebElement kotaUsahaDropdownEdit;
    @FindBy(xpath = "//*[@id=\"select2-district-container\"]")
    private WebElement kecamatanUsahaDropdownEdit;
    @FindBy(xpath = "//*[@id=\"select2-village-container\"]")
    private WebElement kelurahanUsahaDropdownEdit;

    @FindBy(xpath = "//input[@id='postal_code']")
    private WebElement kodePosField;

    @FindBy(xpath = "(//span[text()='Sebelumnya'])[3]")
    private WebElement sebelumnyaBtn;

    @FindBy(xpath = "//button[.='Simpan']")
    private WebElement simpanBtn;
    @FindBy(xpath = "//*[@id=\"step3\"]/div[2]/div[20]/div/button[2]")
    private WebElement requestBtn;
    @FindBy(xpath = "/html/body/div[3]/div/div[3]/button[1]")
    private WebElement sendRequestBtn;
    @FindBy(xpath = "//button[@class='swal2-cancel swal2-styled']")
    private WebElement cancelRequestBtn;

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

    public void isiPekerjaan(String pekerjaan) {
        workField.sendKeys(pekerjaan);
    }

    public void isiJenisIdentitas(String jenisIdentitas) {
        jenisUsahaDropdown.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.nikBtn));

        if ("nik".equalsIgnoreCase(jenisIdentitas)) {
            nikBtn.click();
        } else if ("paspor".equalsIgnoreCase(jenisIdentitas)) {
            pasportBtn.click();
        } else if ("kitas".equalsIgnoreCase(jenisIdentitas)) {
            kitasBtn.click();
        } else if ("kosong".equalsIgnoreCase(jenisIdentitas)) {
            kosongBtn.click();
        } else {
            Assert.fail("Jenis Identitas Tidak Ada");
        }

    }

    public void isiNoIdentitas(String noIdentitas) {
        noIdentitasField.sendKeys(noIdentitas);
    }

    public void checkClick() {
        checkBtn.click();
    }

    public void isiTempatLahir(String tempatLahir) {
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
            String displayedMonthYear = driver.findElement(By.xpath("(//th[@class='month'])[1]")).getText();
            DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy",
                    new Locale("id"));
            LocalDate displayedDate = YearMonth.parse(displayedMonthYear, monthYearFormatter).atDay(1);

            int displayedMonth = displayedDate.getMonthValue();
            int displayedYear = displayedDate.getYear();

            if (displayedYear == targetYear && displayedMonth == targetMonth) {
                break;
            }

            if (displayedYear > targetYear || (displayedYear == targetYear && displayedMonth > targetMonth)) {
                driver.findElement(By.xpath("(//th[@class='prev available'])[1]")).click();
            } else {
                driver.findElement(By.className("(//th[@class='next available'])[1]")).click();
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

    public void requestClick() throws InterruptedException {

        int maxTries = 5;
        int attempts = 0;
        // requestBtn.click();

        while (attempts < maxTries) {
            if (!driver.findElements(By.xpath("//*[@id='swal2-title']")).isEmpty()) {
                return;
            }
            System.out.println("Klik requestBtn ke-" + (attempts + 1));
            requestBtn.click();
            attempts++;
            Thread.sleep(2000);

        }
    }

    public void sendRequestClick() throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.popUpValidator));
        // WebElement button =
        // driver.findElement(By.cssSelector("button.swal2-confirm.swal2-styled"));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        int maxTries = 10;
        int attempts = 0;

        while (attempts < maxTries) {
            if (driver.findElements(By.xpath("//*[@id='swal2-title']")).isEmpty()) {
                return;
            }
            System.out.println("Klik requestBtn ke-" + (attempts + 1));
            sendRequestBtn.click();
            attempts++;
            Thread.sleep(2000);

        }

    }

    public void assertPicName(String expectedPicName, SoftAssert softAssert) {
        softAssert.assertEquals(picNameField.getAttribute("value"), expectedPicName, "Nama PIC tidak sesuai");
    }

    public void assertWork(String expectedWork, SoftAssert softAssert) {
        softAssert.assertEquals(workField.getAttribute("value"), expectedWork, "Pekerjaan tidak sesuai");
    }

    public void assertJenisUsaha(String expectedJenisUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(jenisUsahaDropdown.getText().trim(), expectedJenisUsaha, "Jenis usaha tidak sesuai");
    }

    public void assertNoIdentitas(String expectedNoIdentitas, SoftAssert softAssert) {
        softAssert.assertEquals(noIdentitasField.getAttribute("value"), expectedNoIdentitas,
                "Nomor identitas tidak sesuai");
    }

    public void assertTempatLahir(String expectedTempatLahir, SoftAssert softAssert) {
        softAssert.assertEquals(tempatLahirField.getAttribute("value"), expectedTempatLahir,
                "Tempat lahir tidak sesuai");
    }

    public void assertTanggalLahir(String expectedTanggalLahir, SoftAssert softAssert) {
        softAssert.assertEquals(tanggalLahirField.getAttribute("value"), expectedTanggalLahir,
                "Tanggal lahir tidak sesuai");
    }

    public void assertAlamatKtp(String expectedAlamatKtp, SoftAssert softAssert) {
        softAssert.assertEquals(alamatKtpField.getAttribute("value"), expectedAlamatKtp, "Alamat KTP tidak sesuai");
    }

    public void assertProvinsiKtp(String expectedProvinsi, SoftAssert softAssert) {
        softAssert.assertEquals(pilihProvinsiDropdown.getText().trim(), expectedProvinsi, "Provinsi KTP tidak sesuai");
    }

    public void assertKotaKtp(String expectedKota, SoftAssert softAssert) {
        softAssert.assertEquals(pilihKotaDropdownEdit.getText().trim(), expectedKota, "Kota KTP tidak sesuai");
    }

    public void assertNpwp(String expectedNpwp, SoftAssert softAssert) {
        softAssert.assertEquals(npwpField.getAttribute("value"), expectedNpwp, "NPWP tidak sesuai");
    }

    public void assertNamaNpwp(String expectedNamaNpwp, SoftAssert softAssert) {
        softAssert.assertEquals(namaNpwpField.getAttribute("value"), expectedNamaNpwp, "Nama NPWP tidak sesuai");
    }

    public void assertNoTelp(String expectedNoTelp, SoftAssert softAssert) {
        softAssert.assertEquals(noTelpField.getAttribute("value"), expectedNoTelp, "Nomor Telepon NPWP tidak sesuai");
    }

    public void assertAlamatNpwp(String expectedAlamatNpwp, SoftAssert softAssert) {
        softAssert.assertEquals(alamatNpwpField.getAttribute("value"), expectedAlamatNpwp, "Alamat NPWP tidak sesuai");
    }

    public void assertAlamatUsaha(String expectedAlamatUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(alamatUsahaField.getAttribute("value"), expectedAlamatUsaha,
                "Alamat usaha tidak sesuai");
    }

    public void assertProvinsiUsaha(String expectedProvinsiUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(provinsiUsahaDropdownEdit.getText().trim(), expectedProvinsiUsaha,
                "Provinsi usaha tidak sesuai");
    }

    public void assertKotaUsaha(String expectedKotaUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(kotaUsahaDropdownEdit.getText().trim(), expectedKotaUsaha, "Kota usaha tidak sesuai");
    }

    public void assertKecamatanUsaha(String expectedKecamatanUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(kecamatanUsahaDropdownEdit.getText().trim(), expectedKecamatanUsaha,
                "Kecamatan usaha tidak sesuai");
    }

    public void assertKelurahanUsaha(String expectedKelurahanUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(kelurahanUsahaDropdownEdit.getText().trim(), expectedKelurahanUsaha,
                "Kelurahan usaha tidak sesuai");
    }

    public void assertKodePos(String expectedKodePos, SoftAssert softAssert) {
        softAssert.assertEquals(kodePosField.getAttribute("value"), expectedKodePos, "Kode pos tidak sesuai");
    }
}
