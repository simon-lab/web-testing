package com.saimen.fdm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.saimen.AbstractPage;

public class fdmDetailPage extends AbstractPage {

    @FindBy(xpath = "//h6[.='DATA MERCHANT']")
    private WebElement validator;
    @FindBy(xpath = "(//div[@class='w-100'])[1]")
    private WebElement sumberFDM;
    @FindBy(xpath = "(//div[@class='w-100'])[2]")
    private WebElement kategoriMerchant;
    @FindBy(xpath = "(//div[@class='w-100'])[3]")
    private WebElement namaMerchant;
    @FindBy(xpath = "(//div[@class='w-100'])[4]")
    private WebElement namaPerusahaan;
    @FindBy(xpath = "(//div[@class='w-100'])[5]")
    private WebElement alamatKorespondensi;
    @FindBy(xpath = "(//div[@class='w-100'])[6]")
    private WebElement provinsiKorespondensi;
    @FindBy(xpath = "(//div[@class='w-100'])[7]")
    private WebElement kotaKorespondensi;
    @FindBy(xpath = "(//div[@class='w-100'])[8]")
    private WebElement kecamatanKorespondensi;
    @FindBy(xpath = "(//div[@class='w-100'])[9]")
    private WebElement kelurahanKorespondensi;
    @FindBy(xpath = "(//div[@class='w-100'])[10]")
    private WebElement kodePosKorespondensi;
    @FindBy(xpath = "(//div[@class='w-100'])[11]")
    private WebElement cityPTEN;
    @FindBy(xpath = "(//div[@class='w-100'])[12]")
    private WebElement country;
    @FindBy(xpath = "(//div[@class='w-100'])[13]")
    private WebElement mcc;
    @FindBy(xpath = "(//div[@class='w-100'])[14]")
    private WebElement omset;
    @FindBy(xpath = "(//div[@class='w-100'])[15]")
    private WebElement kategoriUsaha;
    @FindBy(xpath = "(//div[@class='w-100'])[16]")
    private WebElement namaPICUsaha;
    @FindBy(xpath = "(//div[@class='w-100'])[17]")
    private WebElement noTelpPICUsaha;
    @FindBy(xpath = "(//div[@class='w-100'])[18]")
    private WebElement emailPICUsaha;
    @FindBy(xpath = "(//div[@class='w-100'])[19]")
    private WebElement jenisUsahaFDM;
    @FindBy(xpath = "(//div[@class='w-100'])[20]")
    private WebElement jenisLayanan;
    @FindBy(xpath = "(//div[@class='w-100'])[21]")
    private WebElement tipeKiosk;
    @FindBy(xpath = "(//div[@class='w-100'])[22]")
    private WebElement orderType;
    @FindBy(xpath = "(//div[@class='w-100'])[23]")
    private WebElement ppn;
    @FindBy(xpath = "(//div[@class='w-100'])[24]")
    private WebElement serviceCharge;
    @FindBy(xpath = "(//div[@class='w-100'])[25]")
    private WebElement adminFee;
    @FindBy(xpath = "(//div[@class='w-100'])[26]")
    private WebElement metodePembayaran;
    @FindBy(xpath = "(//div[@class='w-100'])[27]")
    private WebElement online;
    @FindBy(xpath = "(//div[@class='w-100'])[28]")
    private WebElement offline;
    @FindBy(xpath = "(//div[@class='w-100'])[29]")
    private WebElement jumlahEDC;
    @FindBy(xpath = "(//div[@class='w-100'])[30]")
    private WebElement jenisKartu;
    @FindBy(xpath = "(//div[@class='w-100'])[31]")
    private WebElement namaPICFinance;
    @FindBy(xpath = "(//div[@class='w-100'])[32]")
    private WebElement noTelpFinance;
    @FindBy(xpath = "(//div[@class='w-100'])[33]")
    private WebElement emailFinance;
    @FindBy(xpath = "(//div[@class='w-100'])[34]")
    private WebElement supportedCard;
    @FindBy(xpath = "(//div[@class='w-100'])[35]")
    private WebElement namaBank;
    @FindBy(xpath = "(//div[@class='w-100'])[36]")
    private WebElement noRekening;
    @FindBy(xpath = "(//div[@class='w-100'])[37]")
    private WebElement namaPemilikRekening;
    @FindBy(xpath = "(//div[@class='w-100'])[38]")
    private WebElement kcKcp;
    @FindBy(xpath = "(//div[@class='w-100'])[39]")
    private WebElement namaPemilikUsaha;
    @FindBy(xpath = "(//div[@class='w-100'])[40]")
    private WebElement pekerjaan;
    @FindBy(xpath = "(//div[@class='w-100'])[41]")
    private WebElement jenisIdentitas;
    @FindBy(xpath = "(//div[@class='w-100'])[42]")
    private WebElement noIdentitas;
    @FindBy(xpath = "(//div[@class='w-100'])[43]")
    private WebElement tempatLahir;
    @FindBy(xpath = "(//div[@class='w-100'])[44]")
    private WebElement tanggalLahir;
    @FindBy(xpath = "(//div[@class='w-100'])[45]")
    private WebElement alamatKTP;
    @FindBy(xpath = "(//div[@class='w-100'])[46]")
    private WebElement provinceKTP;
    @FindBy(xpath = "(//div[@class='w-100'])[47]")
    private WebElement cityKTP;
    @FindBy(xpath = "(//div[@class='w-100'])[48]")
    private WebElement noNPWP;
    @FindBy(xpath = "(//div[@class='w-100'])[49]")
    private WebElement namaNPWP;
    @FindBy(xpath = "(//div[@class='w-100'])[50]")
    private WebElement noTelpNPWP;
    @FindBy(xpath = "(//div[@class='w-100'])[51]")
    private WebElement alamatNPWP;
    @FindBy(xpath = "(//div[@class='w-100'])[52]")
    private WebElement alamatUsaha;
    @FindBy(xpath = "(//div[@class='w-100'])[53]")
    private WebElement provinsiUsaha;
    @FindBy(xpath = "(//div[@class='w-100'])[54]")
    private WebElement kotaUsaha;
    @FindBy(xpath = "(//div[@class='w-100'])[55]")
    private WebElement kecamatanUsaha;
    @FindBy(xpath = "(//div[@class='w-100'])[56]")
    private WebElement kelurahanUsaha;
    @FindBy(xpath = "(//div[@class='w-100'])[57]")
    private WebElement kodePosUsaha;

    public fdmDetailPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void assertSumberFDM(String expectedSumberFDM, SoftAssert softAssert) {
        softAssert.assertEquals(sumberFDM.getText(), expectedSumberFDM);
    }

    public void assertKategoriMerchant(String expectedKategoriMerchant, SoftAssert softAssert) {
        softAssert.assertEquals(kategoriMerchant.getText(), expectedKategoriMerchant);
    }

    public void assertNamaMerchant(String expectedNamaMerchant, SoftAssert softAssert, String uniqString) {
        softAssert.assertEquals(namaMerchant.getText(), expectedNamaMerchant + " " + uniqString);
    }

    public void assertNamaPerusahaan(String expectedNamaPerusahaan, SoftAssert softAssert, String uniqString) {
        softAssert.assertTrue((namaPerusahaan.getText())
                .equalsIgnoreCase(expectedNamaPerusahaan + " " + uniqString));
    }

    public void assertAlamatKorespondensi(String expectedAlamatKorespondensi, SoftAssert softAssert) {
        softAssert.assertEquals(alamatKorespondensi.getText(), expectedAlamatKorespondensi);
    }

    public void assertProvinsiKorespondensi(String expectedProvinsiKorespondensi, SoftAssert softAssert) {
        softAssert.assertEquals(provinsiKorespondensi.getText(), expectedProvinsiKorespondensi,
                "Provinsi Korespondensi Salah");
    }

    public void assertKotaKorespondensi(String expectedKotaKorespondensi, SoftAssert softAssert) {
        softAssert.assertEquals(kotaKorespondensi.getText(), expectedKotaKorespondensi, "Kota Korespondensi Salah");
    }

    public void assertKecamatanKorespondensi(String expectedKecamatanKorespondensi, SoftAssert softAssert) {
        softAssert.assertEquals(kecamatanKorespondensi.getText(), expectedKecamatanKorespondensi,
                "Kecamatan Korespondensi Salah");
    }

    public void assertKelurahanKorespondensi(String expectedKelurahanKorespondensi, SoftAssert softAssert) {
        softAssert.assertEquals(kelurahanKorespondensi.getText(), expectedKelurahanKorespondensi,
                "Kelurahan Korespondensi Salah");
    }

    public void assertKodePosKorespondensi(String expectedKodePosKorespondensi, SoftAssert softAssert) {
        softAssert.assertEquals(kodePosKorespondensi.getText(), expectedKodePosKorespondensi);
    }

    public void assertCityPTEN(String expectedCityPTEN, SoftAssert softAssert) {
        softAssert.assertEquals(cityPTEN.getText(), expectedCityPTEN);
    }

    public void assertCountry(String expectedCountry, SoftAssert softAssert) {
        softAssert.assertEquals(country.getText(), expectedCountry);
    }

    public void assertMcc(String expectedMcc, SoftAssert softAssert) {
        softAssert.assertEquals(mcc.getText(), expectedMcc);
    }

    public void assertOmset(String expectedOmset, SoftAssert softAssert) {
        softAssert.assertEquals(omset.getText(), expectedOmset);
    }

    public void assertKategoriUsaha(String expectedKategoriUsaha, SoftAssert softAssert) {
        String expected = null;
        if ("umi".equalsIgnoreCase(expectedKategoriUsaha)) {
            expected = "Usaha Mikro";
        } else if ("uki".equalsIgnoreCase(expectedKategoriUsaha)) {
            expected = "Usaha Kecil";
        } else if ("ume".equalsIgnoreCase(expectedKategoriUsaha)) {
            expected = "Usaha Menangah";
        } else if ("ube".equalsIgnoreCase(expectedKategoriUsaha)) {
            expected = "Usaha Besar";
        } else {
            Assert.fail("Kategori Merchant Tidak Ada");
        }

        softAssert.assertEquals(kategoriUsaha.getText(), expected);
    }

    public void assertNamaPICUsaha(String expectedNamaPICUsaha, SoftAssert softAssert, String uniqString) {
        softAssert.assertEquals(namaPICUsaha.getText(), expectedNamaPICUsaha + " " + uniqString);
    }

    public void assertNoTelpPICUsaha(String expectedNoTelpPICUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(noTelpPICUsaha.getText(), expectedNoTelpPICUsaha);
    }

    public void assertEmailPICUsaha(String expectedEmailPICUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(emailPICUsaha.getText(), expectedEmailPICUsaha);
    }

    public void assertJenisUsahaFDM(String expectedJenisUsahaFDM, SoftAssert softAssert) {
        softAssert.assertEquals(jenisUsahaFDM.getText(), expectedJenisUsahaFDM);
    }

    public void assertJenisLayanan(List<String> expectedJenisLayanan, SoftAssert softAssert) {
        String actualText = jenisLayanan.getText();
        List<String> actualList = Arrays.stream(actualText.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        softAssert.assertEquals(actualList, expectedJenisLayanan,
                "Daftar jenis layanan tidak sesuai.");
    }

    public void assertTipeKiosk(String expectedTipeKiosk, SoftAssert softAssert) {
        softAssert.assertEquals(tipeKiosk.getText(), expectedTipeKiosk);
    }

    public void assertOrderType(List<String> expectedOrderType, SoftAssert softAssert) {
        String actualText = orderType.getText();

        List<String> actualList = Arrays.stream(actualText.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        softAssert.assertEquals(actualList, expectedOrderType,
                "Daftar Tipe Order tidak sesuai.");
    }

    public void assertPpn(String expectedPpn, SoftAssert softAssert) {
        softAssert.assertEquals(ppn.getText(), expectedPpn + "%");
    }

    public void assertServiceCharge(String expectedServiceCharge, SoftAssert softAssert) {
        softAssert.assertEquals(serviceCharge.getText(), expectedServiceCharge + "%");
    }

    public void assertAdminFee(String expectedAdminFee, SoftAssert softAssert) {
        softAssert.assertEquals(adminFee.getText(), expectedAdminFee);
    }

    public void assertMetodePembayaran(List<String> expectedMetodePembayaran, SoftAssert softAssert) {
        String actualText = metodePembayaran.getText();

        List<String> actualList = Arrays.stream(actualText.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        softAssert.assertEquals(actualList, expectedMetodePembayaran,
                "Daftar Metode Pembayaran tidak sesuai.");
    }

    public void assertOnline(String expectedOnline, SoftAssert softAssert) {
        softAssert.assertEquals(online.getText(), expectedOnline + "%");
    }

    public void assertOffline(String expectedOffline, SoftAssert softAssert) {
        softAssert.assertEquals(offline.getText(), expectedOffline + "%");
    }

    public void assertJumlahEDC(String expectedJumlahEDC, SoftAssert softAssert) {
        softAssert.assertEquals(jumlahEDC.getText(), expectedJumlahEDC);
    }

    public void assertJenisKartu(List<String> expectedJenisKartu, SoftAssert softAssert) {
        String actualText = jenisKartu.getText();
        List<String> actualList = Arrays.stream(actualText.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        softAssert.assertEquals(actualList, expectedJenisKartu,
                "Daftar Jenis Kartu tidak sesuai.");
    }

    public void assertNamaPICFinance(String expectedNamaPICFinance, SoftAssert softAssert) {
        softAssert.assertEquals(namaPICFinance.getText(), expectedNamaPICFinance);
    }

    public void assertNoTelpFinance(String expectedNoTelpFinance, SoftAssert softAssert) {
        softAssert.assertEquals(noTelpFinance.getText(), expectedNoTelpFinance);
    }

    public void assertEmailFinance(String expectedEmailFinance, SoftAssert softAssert) {
        softAssert.assertEquals(emailFinance.getText(), expectedEmailFinance);
    }

    public void assertSupportedCard(List<String> expectedSupportedCard, SoftAssert softAssert) {
        String actualText = supportedCard.getText();

        List<String> actualList = Arrays.stream(actualText.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        softAssert.assertEquals(actualList, expectedSupportedCard,
                "Daftar Supported Card tidak sesuai.");
    }

    public void assertNamaBank(String expectedNamaBank, SoftAssert softAssert) {
        softAssert.assertEquals(namaBank.getText(), expectedNamaBank);
    }

    public void assertNoRekening(String expectedNoRekening, SoftAssert softAssert) {
        softAssert.assertEquals(noRekening.getText(), expectedNoRekening);
    }

    public void assertNamaPemilikRekening(String expectedNamaPemilikRekening, SoftAssert softAssert) {
        softAssert.assertEquals(namaPemilikRekening.getText(), expectedNamaPemilikRekening);
    }

    public void assertKcKcp(String expectedKcKcp, SoftAssert softAssert) {
        softAssert.assertEquals(kcKcp.getText(), expectedKcKcp);
    }

    public void assertNamaPemilikUsaha(String expectedNamaPemilikUsaha, SoftAssert softAssert, String uniqString) {
        softAssert.assertEquals(namaPemilikUsaha.getText(), expectedNamaPemilikUsaha + " " + uniqString);
    }

    public void assertPekerjaan(String expectedPekerjaan, SoftAssert softAssert) {
        softAssert.assertEquals(pekerjaan.getText(), expectedPekerjaan);
    }

    public void assertJenisIdentitas(String expectedJenisIdentitas, SoftAssert softAssert) {
        softAssert.assertEquals(jenisIdentitas.getText(), expectedJenisIdentitas);
    }

    public void assertNoIdentitas(String expectedNoIdentitas, SoftAssert softAssert) {
        softAssert.assertEquals(noIdentitas.getText(), expectedNoIdentitas);
    }

    public void assertTempatLahir(String expectedTempatLahir, SoftAssert softAssert) {
        softAssert.assertEquals(tempatLahir.getText(), expectedTempatLahir);
    }

    public void assertTanggalLahir(String expectedTanggalLahir, SoftAssert softAssert) {
        softAssert.assertEquals(tanggalLahir.getText(), expectedTanggalLahir);
    }

    public void assertAlamatKTP(String expectedAlamatKTP, SoftAssert softAssert) {
        softAssert.assertEquals(alamatKTP.getText(), expectedAlamatKTP);
    }

    public void assertProvinceKTP(String expectedProvinceKTP, SoftAssert softAssert) {
        softAssert.assertEquals(provinceKTP.getText(), expectedProvinceKTP);
    }

    public void assertCityKTP(String expectedCityKTP, SoftAssert softAssert) {
        softAssert.assertEquals(cityKTP.getText(), expectedCityKTP);
    }

    public void assertNoNPWP(String expectedNoNPWP, SoftAssert softAssert) {
        softAssert.assertEquals(noNPWP.getText(), expectedNoNPWP);
    }

    public void assertNamaNPWP(String expectedNamaNPWP, SoftAssert softAssert) {
        softAssert.assertEquals(namaNPWP.getText(), expectedNamaNPWP);
    }

    public void assertNoTelpNPWP(String expectedNoTelpNPWP, SoftAssert softAssert) {
        softAssert.assertEquals(noTelpNPWP.getText(), expectedNoTelpNPWP);
    }

    public void assertAlamatNPWP(String expectedAlamatNPWP, SoftAssert softAssert) {
        softAssert.assertEquals(alamatNPWP.getText(), expectedAlamatNPWP);
    }

    public void assertAlamatUsaha(String expectedAlamatUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(alamatUsaha.getText(), expectedAlamatUsaha);
    }

    public void assertProvinsiUsaha(String expectedProvinsiUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(provinsiUsaha.getText(), expectedProvinsiUsaha);
    }

    public void assertKotaUsaha(String expectedKotaUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(kotaUsaha.getText(), expectedKotaUsaha);
    }

    public void assertKecamatanUsaha(String expectedKecamatanUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(kecamatanUsaha.getText(), expectedKecamatanUsaha);
    }

    public void assertKelurahanUsaha(String expectedKelurahanUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(kelurahanUsaha.getText(), expectedKelurahanUsaha);
    }

    public void assertKodePosUsaha(String expectedKodePosUsaha, SoftAssert softAssert) {
        softAssert.assertEquals(kodePosUsaha.getText(), expectedKodePosUsaha);
    }

}
