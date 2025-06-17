package com.saimen.dspPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.saimen.AbstractPage;

public class dataMerchantPage extends AbstractPage {
    @FindBy(xpath = "//h6[contains(.,'Merchant')]")
    private WebElement validator;

    @FindBy(css = "[title='Pilih Sumber FDM']")
    private WebElement sumberFdmDropDown;
    @FindBy(xpath = "//li[text()='Reguler']")
    private WebElement regulerFdm;
    @FindBy(xpath = "//li[text()='BCAS']")
    private WebElement bcasFdm;
    @FindBy(xpath = "//li[text()='Parimanta']")
    private WebElement parimantaFdm;
    @FindBy(xpath = "//li[text()='SSDI']")
    private WebElement ssdiFdm;

    @FindBy(css = "[title='Pilih Kategori Merchant']")
    private WebElement pilihKategoriDropdown;
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

    @FindBy(css = "[title='Pilih Provinsi korespondensi']")
    private WebElement provinsiKorespondensiDropdown;
    @FindBy(xpath = "//li[text()='JAWA BARAT']")
    private WebElement jawaBarat;
    @FindBy(xpath = "//*[@id='select2-city_korespondensi-container']")
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

    @FindBy(xpath = "//input[@id='postal_code_korespondensi']")
    private WebElement kodePosField;
    @FindBy(xpath = "//input[@id='city_pten_list']")
    private WebElement cityPtenField;

    @FindBy(css = "[title='Indonesia']")
    private WebElement countryDropdown;
    @FindBy(xpath = "//li[text()='Indonesia']")
    private WebElement indonesia;

    @FindBy(css = "[title='Pilih MCC']")
    private WebElement MCCDropdown;
    @FindBy(xpath = "//li[text()='4457 - BOAT RENTALS & LEASES']")
    private WebElement boatRental;

    @FindBy(xpath = "//input[@id='omset']")
    private WebElement omsetField;

    @FindBy(css = "[title='Pilih Kategori usaha']")
    private WebElement usahaDropdown;
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

    @FindBy(xpath = "//div[@class='content active dstepper-block']//button[@class='btn btn-warning btn-submit']")
    private WebElement simpanBtn;
    @FindBy(xpath = "//div[@class='content active dstepper-block']//button[@class='btn btn-primary btn-next']/span[@class='align-middle d-sm-inline-block d-none me-sm-2']")
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

        if (sumber == "reguler") {
            regulerFdm.click();
        } else if (sumber == "bcas") {
            bcasFdm.click();
        } else if (sumber == "parimanta") {
            parimantaFdm.click();
        } else if (sumber == "ssdi") {
            ssdiFdm.click();
        } else {
            Assert.fail("Sumber FDM Tidak Ada");
        }

    }

    public void pilihKategoriMerchant(String kategoriMerchant) {
        pilihKategoriDropdown.click();

        if (kategoriMerchant == "badan usaha") {
            kategoriBadanUsaha.click();
        } else if (kategoriMerchant == "perseorangan") {
            kategoriPerseorangan.click();
        } else if (kategoriMerchant == "charity") {
            kategoriCharity.click();
        } else if (kategoriMerchant == "pendidikan") {
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
        kotaKorespondensiDropdown.click();
        bandung.click();
        kecamatanKorespondensiDropdown.click();
        antapani.click();
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

    public void isiOnset(String omset) {
        omsetField.sendKeys(omset);
    }

    public void pilihKategoriUsaha(String kategoriUsaha) {
        usahaDropdown.click();
        if (kategoriUsaha == "umi") {
            usahaMikro.click();
        } else if (kategoriUsaha == "uke") {
            usahaKecil.click();
        } else if (kategoriUsaha == "ume") {
            usahaMenengah.click();
        } else if (kategoriUsaha == "ube") {
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
}
