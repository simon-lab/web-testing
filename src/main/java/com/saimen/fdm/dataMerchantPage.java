package com.saimen.fdm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.saimen.AbstractPage;

public class dataMerchantPage extends AbstractPage {
    @FindBy(xpath = "//h6[contains(.,'Merchant')]")
    private WebElement validator;

    @FindBy(xpath = "//*[@id='select2-sumber_fdm-container']")
    private WebElement sumberFdmDropDown;
    @FindBy(xpath = "//li[text()='Reguler']")
    private WebElement regulerFdm;
    @FindBy(xpath = "//li[text()='BCAS']")
    private WebElement bcasFdm;
    @FindBy(xpath = "//li[text()='Parimanta']")
    private WebElement parimantaFdm;
    @FindBy(xpath = "//li[text()='SSDI']")
    private WebElement ssdiFdm;

    @FindBy(xpath = "//*[@id='select2-category_merchant-container']")
    private WebElement pilihJenisUsaha;
    @FindBy(xpath = "//li[text()='Badan Usaha']")
    private WebElement kategoriBadanUsaha;
    @FindBy(xpath = "//li[text()='Perseorangan']")
    private WebElement kategoriPerseorangan;
    @FindBy(xpath = "//li[text()='Charity']")
    private WebElement kategoriCharity;
    @FindBy(xpath = "//li[text()='Pendidikan']")
    private WebElement kategoriPendidikan;

    @FindBy(xpath = "//input[@id='merchant_name']")
    private WebElement namaMerchantField;
    @FindBy(xpath = "//input[@id='perusahaan_name']")
    private WebElement namaPerusahaanField;
    @FindBy(xpath = "//input[@id='alamat_korespondensi']")
    private WebElement alamatKorespondensiField;

    @FindBy(xpath = "//*[@id='select2-province_korespondensi-container']")
    private WebElement provinsiKorespondensiDropdown;
    @FindBy(xpath = "//li[text()='JAWA BARAT']")
    private WebElement jawaBarat;
    @FindBy(xpath = "//span[text()='- Pilih Kabupaten/Kota Korespondensi -']")
    private WebElement kotaKorespondensiDropdown;
    @FindBy(xpath = "//li[text()='KOTA BANDUNG']")
    private WebElement bandung;
    @FindBy(xpath = "//span[text()='- Pilih Kecamatan -']")
    private WebElement kecamatanKorespondensiDropdown;
    @FindBy(xpath = "//li[text()='Antapani']")
    private WebElement antapani;
    @FindBy(xpath = "//span[text()='- Pilih Kelurahan/Desa -']")
    private WebElement kelurahanKorespondensiDropdown;
    @FindBy(xpath = "//li[text()='Antapani Tengah']")
    private WebElement antapaniTengah;

    @FindBy(xpath = "//*[@id='select2-province_korespondensi-container']")
    private WebElement provinsiKorespondensiDropdownEdit;
    @FindBy(xpath = "//*[@id='select2-city_korespondensi-container']")
    private WebElement kotaKorespondensiDropdownEdit;
    @FindBy(xpath = "//*[@id='select2-district_korespondensi-container']")
    private WebElement kecamatanKorespondensiDropdownEdit;
    @FindBy(xpath = "//*[@id='select2-village_korespondensi-container']")
    private WebElement kelurahanKorespondensiDropdownEdit;

    @FindBy(xpath = "//input[@id='postal_code_korespondensi']")
    private WebElement kodePosField;
    @FindBy(xpath = "//input[@id='city_pten_list']")
    private WebElement cityPtenField;

    @FindBy(xpath = "//*[@id='select2-country-container']")
    private WebElement countryDropdown;
    @FindBy(xpath = "//li[text()='Indonesia']")
    private WebElement indonesia;

    @FindBy(xpath = "//*[@id='select2-mcc_id-container']")
    private WebElement MCCDropdown;
    @FindBy(xpath = "//li[text()='4457 - BOAT RENTALS & LEASES']")
    private WebElement boatRental;

    @FindBy(xpath = "//input[@id='omset']")
    private WebElement omsetField;

    @FindBy(xpath = "//*[@id='select2-trx_type-container']")
    private WebElement pilihTipeUsaha;
    @FindBy(xpath = "//li[text()='(Usaha Mikro) UMI']")
    private WebElement usahaMikro;
    @FindBy(xpath = "//li[text()='(Usaha Kecil) UKE']")
    private WebElement usahaKecil;
    @FindBy(xpath = "//li[text()='(Usaha Menangah) UME']")
    private WebElement usahaMenengah;
    @FindBy(xpath = "(Usaha Besar) UBE']")
    private WebElement usahaBesar;

    @FindBy(xpath = "//button[contains(.,'Daftar MOS')]")
    private WebElement daftarMosBtn;

    @FindBy(xpath = "(//span[text()='Simpan'])[1]")
    private WebElement simpanBtn;
    @FindBy(xpath = "(//span[text()='Selanjutnya'])[1]")
    private WebElement selanjutnyaBtn;

    public dataMerchantPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void pilihSumberFDM(String sumber) {
        sumberFdmDropDown.click();

        if ("reguler".equalsIgnoreCase(sumber)) {
            regulerFdm.click();
        } else if ("bcas".equalsIgnoreCase(sumber)) {
            bcasFdm.click();
        } else if ("parimanta".equalsIgnoreCase(sumber)) {
            parimantaFdm.click();
        } else if ("ssdi".equalsIgnoreCase(sumber)) {
            ssdiFdm.click();
        } else {
            Assert.fail("Sumber FDM Tidak Ada");
        }

    }

    public void pilihJenisUsaha(String jenisUsaha) {
        pilihJenisUsaha.click();

        if ("badan usaha".equalsIgnoreCase(jenisUsaha)) {
            kategoriBadanUsaha.click();
        } else if ("perseorangan".equalsIgnoreCase(jenisUsaha)) {
            kategoriPerseorangan.click();
        } else if ("charity".equalsIgnoreCase(jenisUsaha)) {
            kategoriCharity.click();
        } else if ("pendidikan".equalsIgnoreCase(jenisUsaha)) {
            kategoriPendidikan.click();
        } else {
            Assert.fail("Kategori Merchant Tidak Ada");
        }

    }

    public void isiNamaMerchant(String namaMerchant) {
        namaMerchantField.sendKeys(namaMerchant);
    }

    public void isiNamaPerusahaan(String namaPerusahaan) {
        namaPerusahaanField.sendKeys(namaPerusahaan);
    }

    public void isiAlamat(String alamat) {
        alamatKorespondensiField.sendKeys(alamat);
    }

    public void isiProvinsiKota() {
        provinsiKorespondensiDropdown.click();
        jawaBarat.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.kotaKorespondensiDropdown));
        kotaKorespondensiDropdown.click();
        bandung.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.kecamatanKorespondensiDropdown));
        kecamatanKorespondensiDropdown.click();
        antapani.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.kelurahanKorespondensiDropdown));
        kelurahanKorespondensiDropdown.click();
        antapaniTengah.click();
    }

    public void isiKodePos(String kode) {
        kodePosField.sendKeys(kode);
    }

    public void isiCityPten(String cityPten) {
        cityPtenField.sendKeys(cityPten);
    }

    public void pilihCountry() {
        countryDropdown.click();
        indonesia.click();
    }

    public void pilihMCC() {
        MCCDropdown.click();
        boatRental.click();
    }

    public void isiOmset(String omset) {
        omsetField.sendKeys(omset);
    }

    public void pilihTipeUsaha(String tipeUsaha) {
        pilihTipeUsaha.click();
        if ("umi".equalsIgnoreCase(tipeUsaha)) {
            usahaMikro.click();
        } else if ("uke".equalsIgnoreCase(tipeUsaha)) {
            usahaKecil.click();
        } else if ("ume".equalsIgnoreCase(tipeUsaha)) {
            usahaMenengah.click();
        } else if ("ube".equalsIgnoreCase(tipeUsaha)) {
            usahaBesar.click();
        } else {
            Assert.fail("Kategori Merchant Tidak Ada");
        }

    }

    public void simpan() {
        simpanBtn.click();
    }

    public void selanjutnya() {
        selanjutnyaBtn.click();
    }

    public void assertSumberFDM(String expectedSumberFDM, SoftAssert softAssert) {
        softAssert.assertEquals(sumberFdmDropDown.getText(), expectedSumberFDM);
    }

    public void assertKategoriUsaha(String expectedJenisUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(pilihJenisUsaha.getText(), expectedJenisUsaha);
    }

    public void assertNamaMerchant(String expectedNamaMerchant, SoftAssert softAssert) {
        softAssert.assertEquals(namaMerchantField.getAttribute("value"), expectedNamaMerchant);
    }

    public void assertNamaPerusahaan(String expectedNamaPerusahaan, SoftAssert softAssert) {
        softAssert.assertEquals(namaPerusahaanField.getAttribute("value"), expectedNamaPerusahaan);
    }

    public void assertAlamatKorespondensi(String expectedAlamat, SoftAssert softAssert) {
        softAssert.assertEquals(alamatKorespondensiField.getAttribute("value"), expectedAlamat);
    }

    public void assertProvinsiKorespondensi(String expectedProvinsi, SoftAssert softAssert) {
        softAssert.assertEquals(provinsiKorespondensiDropdownEdit.getText(), expectedProvinsi);
    }

    public void assertKotaKorespondensi(String expectedKota, SoftAssert softAssert) {
        softAssert.assertEquals(kotaKorespondensiDropdownEdit.getText(), expectedKota);
    }

    public void assertKecamatanKorespondensi(String expectedKecamatan, SoftAssert softAssert) {
        softAssert.assertEquals(kecamatanKorespondensiDropdownEdit.getText(), expectedKecamatan);
    }

    public void assertKelurahanKorespondensi(String expectedKelurahan, SoftAssert softAssert) {
        softAssert.assertEquals(kelurahanKorespondensiDropdownEdit.getText(), expectedKelurahan);
    }

    public void assertKodePos(String expectedKodePos, SoftAssert softAssert) {
        softAssert.assertEquals(kodePosField.getAttribute("value"), expectedKodePos);
    }

    public void assertCityPTEN(String expectedCity, SoftAssert softAssert) {
        softAssert.assertEquals(cityPtenField.getAttribute("value"), expectedCity);
    }

    public void assertCountry(String expectedCountry, SoftAssert softAssert) {
        softAssert.assertEquals(countryDropdown.getText(), expectedCountry);
    }

    public void assertMCC(String expectedMCC, SoftAssert softAssert) {
        softAssert.assertEquals(MCCDropdown.getText(), expectedMCC);
    }

    public void assertOmset(String expectedOmset, SoftAssert softAssert) {
        softAssert.assertEquals(omsetField.getAttribute("value"), expectedOmset);
    }

    public void assertTipeUsaha(String expectedTipeUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(pilihTipeUsaha.getText(), expectedTipeUsaha);
    }
}
