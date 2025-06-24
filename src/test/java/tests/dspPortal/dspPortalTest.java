package tests.dspPortal;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.saimen.fdm.analystPage;
import com.saimen.fdm.dataMerchantPage;
import com.saimen.fdm.fdmDetailPage;
import com.saimen.fdm.fdmPage;
import com.saimen.fdm.informasiLayananPage;
import com.saimen.fdm.informasiSettlementPage;
import com.saimen.fdm.informasiUsahaPage;
import com.saimen.fdm.loginPage;
import com.saimen.fdm.oprHomePage;

import tests.dspPortal.model.FDMTestData;
import tests.reusableMethod.generatingDateToday;
import tests.reusableMethod.generatingString;
import util.JsonUtil;

public class dspPortalTest implements ITestListener {

    WebDriver driver;
    WebDriver driver2;
    int testStatus = 0;
    private FDMTestData testData;
    String dateToday = generatingDateToday.generatingToday();
    SoftAssert softAssert = new SoftAssert();
    oprHomePage oprHomePage;
    fdmPage fdmPage;
    dataMerchantPage dataMerchant;
    informasiLayananPage layanan;
    informasiSettlementPage settlement;
    informasiUsahaPage usaha;
    fdmDetailPage detail;
    analystPage analystPage;

    String uniqString = generatingString.generateUniqueCode();
    String namaMerchant;
    String namaPerusahaan;
    String namaPemilikMerchant;

    @BeforeClass
    @Parameters({ "testDataPath" })
    public void setEnvironment(String testDataPath) {

        new File(testDataPath);
        this.testData = JsonUtil.getTestData(testDataPath, FDMTestData.class);

        System.setProperty("webdriver.chrome.driver",
                "src/test/java/tests/driver/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();

        // driver2 = new ChromeDriver(option);
        // driver.manage().window().maximize();

        driver.get("https://uat.dspportal.local/");
        loginPage loginPage = new loginPage(driver);
        oprHomePage = new oprHomePage(driver);
        dataMerchant = new dataMerchantPage(driver);
        layanan = new informasiLayananPage(driver);
        settlement = new informasiSettlementPage(driver);
        usaha = new informasiUsahaPage(driver);
        detail = new fdmDetailPage(driver);
        fdmPage = new fdmPage(driver);
        analystPage = new analystPage(driver);

        loginPage.isAt();
        loginPage.fillUsername("art");
        loginPage.fillPassword("123");
        loginPage.signInClick();
        oprHomePage.isAt();
        oprHomePage.fdmClick();

        namaMerchant = testData.namaMerchant() + " " + uniqString;
        namaPerusahaan = testData.namaPerusahaan() + " " + uniqString;
        namaPemilikMerchant = testData.namaPICUsaha() + " " + uniqString;

    }

    @BeforeMethod
    public void setStatus(Method method) {
        testStatus = 0;
        System.out.println("Akan menjalankan test: " + method.getName());

    }

    @Test(priority = 0)
    public void normalFdmPage() {

        fdmPage.isAt();
        fdmPage.buatMOS();

        dataMerchant.isAt();
        System.out.println(testData.sumberFDM());
        dataMerchant.pilihSumberFDM(testData.sumberFDM());
        dataMerchant.pilihKategoriUsaha(testData.kategoriMerchant());
        dataMerchant.isiNamaMerchant(namaMerchant);
        dataMerchant.isiNamaPerusahaan(namaPerusahaan);
        dataMerchant.isiAlamat(testData.alamatKorespondensi());
        dataMerchant.isiProvinsiKota();
        dataMerchant.isiKodePos(testData.kodePosKorespondensi());
        dataMerchant.isiCityPten(testData.cityPten());
        dataMerchant.pilihCountry();
        dataMerchant.pilihMCC();
        dataMerchant.isiOmset(testData.omset());
        dataMerchant.pilihKategoriMerchant(testData.kategoriUsaha());
        dataMerchant.selanjutnya();

        testStatus = 1;
    }

    @Test(priority = 1)
    public void normalLayananPage() {
        layanan.isAt();
        layanan.isiPICUsaha(namaPemilikMerchant);
        layanan.isiNoTelp(testData.noTelpLayanan());
        layanan.isiEmail(testData.emailLayanan());
        layanan.pilihJenisUsaha(testData.jenisUsaha());
        layanan.pilihJenisLayanan(testData.jenisLayanan());
        layanan.pilihTipeKiosk(testData.tipeKiosk());
        layanan.pilihTipeOrder(testData.tipeOrder());
        layanan.isiPPN(testData.ppn());
        layanan.isiServiceCharge(testData.serviceCharge());
        layanan.isiBiayaAdmin(testData.adminFee());
        layanan.pilihMetodePembayaran(testData.metodePembayaran());
        layanan.activeOnline();
        layanan.isiActiveOnline(testData.online());
        layanan.activeOffline();
        layanan.isiActiveOffline(testData.offline());
        layanan.isiJumlahEDC(testData.jumlahEDC());
        layanan.pilihJenisKartu(testData.jenisKartu());
        layanan.selanjutnya();

        testStatus = 1;
    }

    @Test(priority = 2)
    public void normalSettlement() {
        settlement.isAt();
        settlement.isiPICFinance(testData.namaPICFinance());
        settlement.isiEmail(testData.emailFinance());
        settlement.isiNoTelp(testData.noTelpFinance());
        settlement.supportCard(testData.supportCard());
        settlement.pilihBank(testData.noBank());
        settlement.isiNoRekening(testData.noRekening());
        settlement.inqClick();
        // settlement.assertNamaPemilik(testData.namaPemilikRekening());
        settlement.isKcKcp(testData.kcKcp());
        settlement.selanjutnya();

        testStatus = 1;
    }

    @Test(priority = 3)
    public void normalUsaha() {

        usaha.isAt();
        usaha.isiPemilikUsaha(testData.namaPemilikUsaha());
        usaha.isiPekerjaan(testData.pekerjaan());
        usaha.isiJenisIdentitas(testData.jenisIdentitas());
        usaha.isiNoIdentitas(testData.noIdentitasKTP());
        // usaha.checkClick();
        usaha.isiTempatLahir(testData.tempatLahir());
        usaha.pilihTanggalLahir(testData.tanggalLahir());
        usaha.isiAlamatKtp(testData.alamatKTP());
        usaha.isiProvinsiKotaKTP();
        usaha.isiNoNPWP(testData.noNPWP());
        usaha.isiNamaNPWP(testData.namaNPWP());
        usaha.isiNoTelp(testData.noTelpPemilik());
        usaha.isiAlamatNPWP(testData.alamatNPWP());
        usaha.isiAlamatUsaha(testData.alamatUsaha());
        usaha.isiProvinsiKotaUsaha();
        usaha.isiKodePos(testData.kodePos());
        usaha.simpan();

        // fdmPage.deleteClick();

        testStatus = 1;

    }

    @Test(priority = 4)
    void assertDetailAfterBuatMOS() {
        fdmPage.isAt();
        int kolomTerkait = fdmPage.cariKolom(namaMerchant);
        fdmPage.assertData(testData.namaMerchant(), testData.namaPerusahaan(),
                testData.namaPemilikUsaha(), dateToday, "DRAFT", kolomTerkait, uniqString);
        fdmPage.detailClick(kolomTerkait);

        detailCheck.detailAssert(driver, testData, detail, softAssert);
        softAssert.assertAll();

        testStatus = 1;
    }

    // @Test(priority = 5)
    // public void assertScoringPageDataAndOption() {
    // fdmPage.isAt();
    // fdmPage.analystClick();
    // analystPage.assertNamaMitra(testData.namaMerchant());
    // analystPage.assertNamaPemilik(testData.namaPemilikUsaha());
    // analystPage.assertStatusPekerjaan(testData.pekerjaan());
    // analystPage.assertAlamatUsaha(testData.alamatUsaha());
    // analystPage.assertKotaUsaha(testData.kotaUsaha());
    // analystPage.assertProvinsiUsaha(testData.provinsiUsaha());
    // analystPage.assertKategoriUsaha(testData.kategoriUsaha());
    // analystPage.assertJasaRisikoTinggiCheck();
    // analystPage.assertIdentitasPenggunaCheck();
    // analystPage.assertLokasiUsahaChecked();
    // analystPage.assertProfilPengguna();
    // analystPage.assertKegiatanUsahaPenggunaJasa();
    // analystPage.assertKategoriNegaraBisnisProduk();

    // testStatus = 1;
    // }

    // @Test
    // public void normalScoring() {
    // // analystPage.pilihPenggunaJasaResiko("Presiden");
    // analystPage.pilihIdentitasPengguna("Data atau informasi identitas"); // score
    // 3
    // analystPage.pilihLokasiUsaha("Berada di kota"); // score 1
    // analystPage.pilihProfilPenggunaJasa("Merchant adalah pegawai perusahaan");//
    // score 1
    // analystPage.pilihKegiatanUsaha("perusahaan publik atau perusahaan yang
    // terdaftar");// score 1
    // analystPage.pilihKategoriNegara("Merchant tidak masuk kedalam");// score 4
    // analystPage.assertTotal("10", "LOW");
    // analystPage.assertCddEdd("cdd");
    // analystPage.tidakDTTOT();
    // }

    @AfterClass
    public void tearDown() {
        if (testStatus == 0) {
            System.out.println("Test gagal, driver tidak di-close untuk debugging.");
        } else {
            System.out.println("DEBUG DULU BOZZZZ");
            // driver.quit(); // hanya close jika tidak gagal
        }
    }

}
