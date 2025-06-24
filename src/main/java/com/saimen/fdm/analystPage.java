package com.saimen.fdm;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.saimen.AbstractPage;

public class analystPage extends AbstractPage {

    @FindBy(xpath = "//h4[text()='Formulir Perhitungan Nilai Tingkat Risiko Pengguna Jasa (Mitra)']")
    private WebElement validator;

    @FindBy(xpath = "//*[@id=\"_10\"]/table[1]/tbody/tr[1]/td[3]")
    private WebElement namaMitraField;
    @FindBy(xpath = "//*[@id=\"_10\"]/table[1]/tbody/tr[1]/td[7]")
    private WebElement alamatUsahaField;
    @FindBy(xpath = "//*[@id=\"_10\"]/table[1]/tbody/tr[2]/td[3]")
    private WebElement namaPemilikField;
    @FindBy(xpath = "//*[@id=\"_10\"]/table[1]/tbody/tr[2]/td[7]")
    private WebElement kotaUsahaField;
    @FindBy(xpath = "//*[@id=\"_10\"]/table[1]/tbody/tr[4]/td[3]/a")
    private WebElement idFDMField;
    @FindBy(xpath = "//*[@id=\"_10\"]/table[1]/tbody/tr[4]/td[7]")
    private WebElement provinsiUsahaField;
    @FindBy(xpath = "//*[@id=\"_10\"]/table[1]/tbody/tr[5]/td[3]")
    private WebElement noFDMField;
    @FindBy(xpath = "//*[@id=\"_10\"]/table[1]/tbody/tr[5]/td[7]")
    private WebElement kategoriUsahaField;
    @FindBy(xpath = "//*[@id=\"_10\"]/table[1]/tbody/tr[6]/td[3]")
    private WebElement statusPekerjaanField;
    @FindBy(xpath = "//*[@id=\"_10\"]/table[1]/tbody/tr[6]/td[7]")
    private WebElement fdmStatusField;

    @FindBy(xpath = "//*[@id=\"select2-option_1-container\"]")
    private WebElement pilihFaktorResiko;
    @FindBy(xpath = "//*[@id=\"select2-option_2-container\"]")
    private WebElement pilihIdentitasPengguna;
    @FindBy(xpath = "//*[@id=\"select2-option_3-container\"]")
    private WebElement pilihLokasiUsaha;
    @FindBy(xpath = "//*[@id=\"select2-option_4-container\"]")
    private WebElement pilihProfilPengguna;
    @FindBy(xpath = "//*[@id=\"select2-option_5-container\"]")
    private WebElement pilihKegiatanUsaha;
    @FindBy(xpath = "//*[@id=\"select2-option_6-container\"]")
    private WebElement pilihKategoriNegara;
    @FindBy(xpath = "//ul[@class='select2-results__options']/li")
    private List<WebElement> optionList;

    @FindBy(xpath = "//*[@id=\"row_total_1\"]")
    private WebElement faktorResikoTotal;
    @FindBy(xpath = "//*[@id=\"row_total_2\"]")
    private WebElement identitasPenggunaTotal;
    @FindBy(xpath = "//*[@id=\"row_total_3\"]")
    private WebElement lokasiUsahaTotal;
    @FindBy(xpath = "//*[@id=\"row_total_4\"]")
    private WebElement profilPenggunaTotal;
    @FindBy(xpath = "//*[@id=\"row_total_5\"]")
    private WebElement kegiatanUsahaTotal;
    @FindBy(xpath = "//*[@id=\"row_total_6\"]")
    private WebElement kategoriNegaraTotal;
    @FindBy(xpath = "//*[@id=\"score_text\"]")
    private WebElement totalScore;
    @FindBy(xpath = "//*[@id=\"status_text\"]")
    private WebElement totalStatus;

    @FindBy(xpath = "//input[@id='CDD'] ")
    private WebElement cddBtn;
    @FindBy(xpath = "//input[@id='EDD']")
    private WebElement eddBtn;
    @FindBy(xpath = "//input[@value='N']")
    private WebElement tidakDTTOTBtn;
    @FindBy(xpath = "//form[@id='form_analyzer']//td[3]/input[@name='DTTOT_validation']")
    private WebElement DTTOTBtn;
    @FindBy(xpath = "//input[@name='DTTOT_validation_check']")
    private WebElement keteranganBtn;
    @FindBy(xpath = "//textarea[@name='DTTOT_validation_desc_n']")
    private WebElement keteranganField;

    @FindBy(xpath = "//button[@class='btn btn-warning']")
    private WebElement revisionBtn;
    @FindBy(xpath = "//button[@class='btn btn-danger']")
    private WebElement rejectBtn;
    @FindBy(xpath = "//button[@class='btn btn-success']")
    private WebElement requestApproveBtn;

    public analystPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void assertNamaMitra(String expectedNamaMitra) {

        String actualNamaMitra = namaMitraField.getText();
        Assert.assertEquals(actualNamaMitra, expectedNamaMitra, "Nama Mitra Tidak Sesuai");
    }

    public void assertNamaPemilik(String expectedNamaPemilik) {

        String actualNamaPemilik = namaPemilikField.getText();
        Assert.assertEquals(actualNamaPemilik, expectedNamaPemilik);
    }

    public String idFDMGetText() {

        return idFDMField.getText();
    }

    public String noFDMGetText() {

        return noFDMField.getText();
    }

    public void assertStatusPekerjaan(String expectedStatusPekerjaan) {

        String actualStatusPekerjaan = statusPekerjaanField.getText();
        Assert.assertEquals(actualStatusPekerjaan, expectedStatusPekerjaan);
    }

    public void assertAlamatUsaha(String expectedAlamatUsaha) {

        String actualAlamatUsaha = alamatUsahaField.getText();
        Assert.assertEquals(actualAlamatUsaha, expectedAlamatUsaha);
    }

    public void assertKotaUsaha(String expectedKotaUsaha) {

        String actualKotaUsaha = kotaUsahaField.getText();
        Assert.assertEquals(actualKotaUsaha, expectedKotaUsaha);
    }

    public void assertProvinsiUsaha(String expectedProvinsiUsaha) {

        String actualProvinsiUsaha = provinsiUsahaField.getText();
        Assert.assertEquals(actualProvinsiUsaha, expectedProvinsiUsaha);
    }

    public void assertKategoriUsaha(String expectedKategoriUsaha) {

        if ("umi".equalsIgnoreCase(expectedKategoriUsaha)) {
            expectedKategoriUsaha = "Usaha Mikro";
        } else if ("uke".equalsIgnoreCase(expectedKategoriUsaha)) {
            expectedKategoriUsaha = "Usaha Kecil";
        } else if ("ume".equalsIgnoreCase(expectedKategoriUsaha)) {
            expectedKategoriUsaha = "Usaha Menangah";
        } else if ("ube".equalsIgnoreCase(expectedKategoriUsaha)) {
            expectedKategoriUsaha = "Usaha Besar";
        }

        String actualKategoriUsaha = kategoriUsahaField.getText();
        Assert.assertEquals(actualKategoriUsaha, expectedKategoriUsaha);
    }

    public void assertFDMStatus(String expectedFDMStatus) {

        String actualFDMStatus = fdmStatusField.getText();
        Assert.assertEquals(actualFDMStatus, expectedFDMStatus);
    }

    public void assertJasaRisikoTinggiCheck() {

        pilihFaktorResiko.click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(optionList));
        System.out.println("Ini option.size nya: " + options.size());

        for (int i = 1; i < options.size(); i++) {

            List<WebElement> currentOptions = wait.until(ExpectedConditions
                    .visibilityOfAllElements(optionList));

            WebElement option = currentOptions.get(i);
            String optionText = option.getText();
            System.out.println("Memilih opsi: " + optionText);

            option.click();

            Assert.assertEquals(faktorResikoTotal.getText(), "99");

            pilihFaktorResiko.click();

        }
        options.get(0).click();
    }

    public void assertIdentitasPenggunaCheck() {

        pilihIdentitasPengguna.click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(optionList));
        System.out.println("Ini option.size nya: " + options.size());

        for (int i = 1; i < options.size(); i++) {

            List<WebElement> currentOptions = wait.until(ExpectedConditions
                    .visibilityOfAllElements(optionList));

            WebElement option = currentOptions.get(i);
            String optionText = option.getText();
            System.out.println("Memilih opsi: " + optionText);

            String txt = option.getText();
            option.click();

            if (txt.contains(
                    "Data atau informasi identitas yang disampaikan Merchant tidak sesuai")) {
                Assert.assertEquals(identitasPenggunaTotal.getText(), "3");
            } else if (txt.contains(
                    "Dokumen identitas calon Merchant palsu")) {
                Assert.assertEquals(identitasPenggunaTotal.getText(), "3");
            } else if (txt.contains(
                    "Informasi pekerjaan dalam dokumen identitas sudah tidak sesuai")) {
                Assert.assertEquals(identitasPenggunaTotal.getText(), "2");
            } else if (txt.contains(
                    "Jangka waktu berlakunya dokumen identitas legalitas sudah kadaluarsa/tidak up to date")) {
                Assert.assertEquals(identitasPenggunaTotal.getText(), "2");
            } else if (txt.contains(
                    "Jangka waktu berlakunya dokumen identitas sudah kadaluarsa/tidak up to date")) {
                Assert.assertEquals(identitasPenggunaTotal.getText(), "2");
            } else if (txt.contains(
                    "Merchant memberikan dokumen identitas yang masih berlaku dan dapat diyakini kebenarannya oleh PJP")) {
                Assert.assertEquals(identitasPenggunaTotal.getText(), "1");
            } else if (txt.contains(
                    "Merchant memberikan dokumen identitas/legalitas yang masih berlaku dan dapat diyakini kebenarannya oleh PJP, seperti Anggaran dasar")) {
                Assert.assertEquals(identitasPenggunaTotal.getText(), "1");
            } else {
                Assert.fail("Teks tidak dikenali: " + txt);
            }

            pilihIdentitasPengguna.click();

        }
        options.get(0).click();
    }

    public void assertLokasiUsahaChecked() {

        pilihLokasiUsaha.click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(optionList));
        System.out.println("Ini option.size nya: " + options.size());

        for (int i = 1; i < options.size(); i++) {

            List<WebElement> currentOptions = wait.until(ExpectedConditions
                    .visibilityOfAllElements(optionList));

            WebElement option = currentOptions.get(i);
            String optionText = option.getText();
            System.out.println("Memilih opsi: " + optionText);

            String txt = option.getText();
            option.click();

            if (txt.contains("rawan tingkat kejahatan")) {
                Assert.assertEquals(lokasiUsahaTotal.getText(), "3");
            } else if (txt.contains("kota yang sama dengan Kantor PJP")) {
                Assert.assertEquals(lokasiUsahaTotal.getText(), "1");
            } else if (txt.contains("propinsi yang berbeda dari Kantor PJP")) {
                Assert.assertEquals(lokasiUsahaTotal.getText(), "3");
            } else if (txt.contains("propinsi yang berbeda dengan Kantor PJP")) {
                Assert.assertEquals(lokasiUsahaTotal.getText(), "3");
            } else if (txt.contains("propinsi yang sama dengan Kantor PJP")) {
                Assert.assertEquals(lokasiUsahaTotal.getText(), "2");
            } else {
                Assert.fail("Teks domisili tidak dikenali: " + txt);
            }

            pilihLokasiUsaha.click();

        }
        options.get(0).click();
    }

    public void assertProfilPengguna() {

        pilihProfilPengguna.click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(optionList));
        System.out.println("Ini option.size nya: " + options.size());

        for (int i = 1; i < options.size(); i++) {

            List<WebElement> currentOptions = wait.until(ExpectedConditions
                    .visibilityOfAllElements(optionList));

            WebElement option = currentOptions.get(i);
            String optionText = option.getText();
            System.out.println("Memilih opsi: " + optionText);

            String txt = option.getText();
            option.click();

            if (txt.contains("Profil Merchant adalah pegawai suatu perusahaan")) {
                Assert.assertEquals(profilPenggunaTotal.getText(), "1");
            } else if (txt.contains("Merchant adalah pegawai perusahaan yang memiliki penghasilan")) {
                Assert.assertEquals(profilPenggunaTotal.getText(), "1");
            } else if (txt.contains("Merchant merupakan peserta program Pemerintah")) {
                Assert.assertEquals(profilPenggunaTotal.getText(), "1");
            } else if (txt.contains("Ibu rumah tangga atau pelajar atau mahasiswa")) {
                Assert.assertEquals(profilPenggunaTotal.getText(), "2");
            } else if (txt.contains("Pegawai instansi pemerintah yang tidak terkait")) {
                Assert.assertEquals(profilPenggunaTotal.getText(), "2");
            } else if (txt.contains("Merchant yang tidak memiliki penghasilan")) {
                Assert.assertEquals(profilPenggunaTotal.getText(), "3");
            } else if (txt.contains("Pegawai instansi pemerintah yang terkait dengan pelayanan publik")) {
                Assert.assertEquals(profilPenggunaTotal.getText(), "3");
            } else if (txt.contains("Aparat penegak hukum")) {
                Assert.assertEquals(profilPenggunaTotal.getText(), "3");
            } else if (txt.contains("Setiap orang/perusahaan/lembaga yang melakukan")) {
                Assert.assertEquals(profilPenggunaTotal.getText(), "3");
            } else if (txt.contains("Pihak-pihak yang dicantumkan dalam daftar")) {
                Assert.assertEquals(profilPenggunaTotal.getText(), "3");
            } else if (txt.contains("Pegawai dari instansi atau lembaga yang berkaitan")) {
                Assert.assertEquals(profilPenggunaTotal.getText(), "3");
            } else if (txt.contains("Pihak lainnya yang masuk dalam kategori high risk")) {
                Assert.assertEquals(profilPenggunaTotal.getText(), "3");
            } else if (txt.contains("Dari informasi yang dapat diyakini")) {
                Assert.assertEquals(profilPenggunaTotal.getText(), "3");
            } else {
                Assert.fail("Teks pekerjaan tidak dikenali: " + txt);
            }

            pilihProfilPengguna.click();

        }
        options.get(0).click();
    }

    public void assertKegiatanUsahaPenggunaJasa() {

        pilihKegiatanUsaha.click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(optionList));
        System.out.println("Ini option.size nya: " + options.size());

        for (int i = 1; i < options.size(); i++) {

            List<WebElement> currentOptions = wait.until(ExpectedConditions
                    .visibilityOfAllElements(optionList));

            WebElement option = currentOptions.get(i);
            String optionText = option.getText();
            System.out.println("Memilih opsi: " + optionText);

            String txt = option.getText();
            option.click();

            if (txt.contains("usaha yang dikelola secara individu")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "1");
            } else if (txt.contains("perusahaan publik atau perusahaan yang terdaftar")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "1");
            } else if (txt.contains(
                    "dan penyampaian salinan kebijakan dan prosedur penerapan Program APU & PPT")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "1");
            } else if (txt
                    .contains("tetapi belum menyampaikan salinan kebijakan dan prosedur penerapan Program APU & PPT")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "2");
            } else if (txt.contains("usaha yang berbasis uang tunai")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "3");
            } else if (txt.contains("belum mengisi kuesioner")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "3");
            } else if (txt.contains("memberikan jasa pengurusan dokumen hukum")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "3");
            } else if (txt.contains("perhiasan, mobil atau aset lainnya")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "3");
            } else if (txt.contains("melalui internet")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "3");
            } else if (txt.contains("ekspor atau impor")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "3");
            } else if (txt.contains("konsultan keuangan")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "3");
            } else if (txt.contains("multi level marketing")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "3");
            } else if (txt.contains("usaha nirlaba")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "3");
            } else if (txt.contains("lainnya yang masuk dalam kategori high risk")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "3");
            } else if (txt.contains("penghasilan tetap, Merchant tidak mempunyai")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "1");
            } else if (txt.contains("penghasilan tetap, Merchant juga memiliki")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "2");
            } else if (txt.contains("(Wirausaha) yang tergolong high risk")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "3");
            } else if (txt.contains("memiliki kegiatan usaha yang dijalankan oleh pihak ketiga")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "3");
            } else if (txt.contains("Merchant memiliki kegiatan usaha")) {
                Assert.assertEquals(kegiatanUsahaTotal.getText(), "2");
            } else {
                Assert.fail("Faktor Produk/Jasa tidak dikenali: " + txt);
            }

            pilihKegiatanUsaha.click();

        }
        options.get(0).click();
    }

    public void assertKategoriNegaraBisnisProduk() {

        pilihKategoriNegara.click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(optionList));
        System.out.println("Ini option.size nya: " + options.size());

        for (int i = 1; i < options.size(); i++) {

            List<WebElement> currentOptions = wait.until(ExpectedConditions
                    .visibilityOfAllElements(optionList));

            WebElement option = currentOptions.get(i);
            String optionText = option.getText();
            System.out.println("Memilih opsi: " + optionText);

            String txt = option.getText();
            option.click();

            if (txt.contains("Merchant tidak masuk kedalam kategori pengguna jasa")) {
                Assert.assertEquals(kategoriNegaraTotal.getText(), "4");
            } else if (txt.contains("Lainnya, yang tidak termasuk dalam Faktor Negara berisiko tinggi")) {
                Assert.assertEquals(kategoriNegaraTotal.getText(), "12");
            } else if (txt.contains("Lainnya, yang tidak termasuk dalam Faktor Bisnis berisiko tinggi")) {
                Assert.assertEquals(kategoriNegaraTotal.getText(), "12");
            } else if (txt.contains("Lainnya, yang tidak termasuk dalam Faktor Produk dan/atau Jasa berisiko tinggi")) {
                Assert.assertEquals(kategoriNegaraTotal.getText(), "12");
            } else {
                Assert.assertEquals(kategoriNegaraTotal.getText(), "99");
            }

            pilihKategoriNegara.click();

        }
        options.get(0).click();
    }

    public void pilihPenggunaJasaResiko(String containText) {
        pilihFaktorResiko.click();

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(optionList));

        boolean found = false;

        for (WebElement option : options) {
            String txt = option.getText().trim();

            if (txt.contains(containText)) {
                option.click();
                found = true;
                break;
            }
        }

        if (!found) {
            Assert.fail("Tidak ada pilihan pengguna jasa yang mengandung teks: " + containText);
        }
    }

    public void pilihIdentitasPengguna(String containText) {
        pilihIdentitasPengguna.click();

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(optionList));

        boolean found = false;

        for (WebElement option : options) {
            String txt = option.getText().trim();

            if (txt.contains(containText)) {
                option.click();
                found = true;
                break;
            }
        }

        if (!found) {
            Assert.fail("Tidak ada pilihan Identitas Pengguna yang mengandung teks: " + containText);
        }
    }

    public void pilihLokasiUsaha(String containText) {
        pilihLokasiUsaha.click();

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(optionList));

        boolean found = false;

        for (WebElement option : options) {
            String txt = option.getText().trim();

            if (txt.contains(containText)) {
                option.click();
                found = true;
                break;
            }
        }

        if (!found) {
            Assert.fail("Tidak ada lokasi usaha yang mengandung teks: " + containText);
        }
    }

    public void pilihProfilPenggunaJasa(String containText) {
        pilihProfilPengguna.click();

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(optionList));

        boolean found = false;

        for (WebElement option : options) {
            String txt = option.getText().trim();

            if (txt.contains(containText)) {
                option.click();
                found = true;
                break;
            }
        }

        if (!found) {
            Assert.fail("Tidak ada profil pengguna jasa yang mengandung teks: " + containText);
        }
    }

    public void pilihKegiatanUsaha(String containText) {
        pilihKegiatanUsaha.click();

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(optionList));

        boolean found = false;

        for (WebElement option : options) {
            String txt = option.getText().trim();

            if (txt.contains(containText)) {
                option.click();
                found = true;
                break;
            }
        }

        if (!found) {
            Assert.fail("Tidak ada kegiatan jasa yang mengandung teks: " + containText);
        }
    }

    public void pilihKategoriNegara(String containText) {
        pilihKategoriNegara.click();

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(optionList));

        boolean found = false;

        for (WebElement option : options) {
            String txt = option.getText().trim();

            if (txt.contains(containText)) {
                option.click();
                found = true;
                break;
            }
        }

        if (!found) {
            Assert.fail("Tidak ada pilihan kategori negara yang mengandung teks: " + containText);
        }
    }

    public void assertTotal(String expectedTotal, String expectedStatus) {
        Assert.assertEquals(totalScore.getText(), expectedTotal);
        Assert.assertEquals(totalStatus.getText(), expectedStatus);

    }

    public void assertCddEdd(String expectedOption) {

        if (expectedOption == "cdd") {
            Assert.assertTrue(cddBtn.isEnabled());
        } else if (expectedOption == "edd") {
            Assert.assertTrue(eddBtn.isEnabled());
        } else {
            Assert.fail("Tidak ada Opsi CDD/EDD");
        }

    }

    public void tidakDTTOT() {

        tidakDTTOTBtn.click();

    }

    public void terdapatDTTOT() {

        DTTOTBtn.click();

    }
}
