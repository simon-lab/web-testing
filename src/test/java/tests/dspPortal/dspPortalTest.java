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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saimen.TestListener;
import com.saimen.dspPortal.dataMerchantPage;
import com.saimen.dspPortal.fdmPage;
import com.saimen.dspPortal.informasiLayananPage;
import com.saimen.dspPortal.informasiSettlementPage;
import com.saimen.dspPortal.informasiUsahaPage;
import com.saimen.dspPortal.loginPage;
import com.saimen.dspPortal.oprHomePage;

import tests.dspPortal.model.FDMTestData;
import util.JsonUtil;

public class dspPortalTest implements ITestListener {

    WebDriver driver;
    int testStatus = 0;
    private FDMTestData testData;

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

    }

    @BeforeMethod
    public void setStatus(Method method) {
        testStatus = 0;
        System.out.println("🚀 Akan menjalankan test: " + method.getName());

    }

    @Test
    public void loginTest() {
        driver.get("https://uat.dspportal.local/");
        loginPage loginPage = new loginPage(driver);
        loginPage.isAt();
        loginPage.fillUsername("art");
        loginPage.fillPassword("123");
        loginPage.signInClick();
        testStatus = 1;

    }

    @Test(dependsOnMethods = "loginTest")
    public void fdmNormalTest() {
        oprHomePage oprHomePage = new oprHomePage(driver);
        oprHomePage.isAt();
        oprHomePage.fdmClick();

        fdmPage fdmPage = new fdmPage(driver);
        fdmPage.isAt();
        fdmPage.setStatus("Approved");
        fdmPage.buatMOS();

        dataMerchantPage dataMerchant = new dataMerchantPage(driver);
        dataMerchant.isAt();
        dataMerchant.pilihSumberFDM("reguler");
        dataMerchant.pilihKategoriMerchant("badan usaha");
        dataMerchant.isiNamaMerchant("Test Merchant");
        dataMerchant.isiNamaPerusahaan("PT Test DSP");
        dataMerchant.isiAlamat("Alam Sutera");
        dataMerchant.isiProvinsiKota();
        dataMerchant.isiKodePos("40123");
        dataMerchant.isiCityPten("1234");
        dataMerchant.pilihCountry();
        dataMerchant.pilihMCC();
        dataMerchant.isiOnset("5000000");
        dataMerchant.pilihKategoriUsaha("ume");
        dataMerchant.selanjutnya();

        informasiLayananPage layanan = new informasiLayananPage(driver);
        layanan.isAt();
        layanan.isiPICUsaha("SaimenTest");
        layanan.isiNoTelp("08123123123");
        layanan.isiEmail("rajasimon0@gmail.com");
        layanan.pilihJenisUsaha("single");
        layanan.pilihJenisLayanan("vkiosk", "self order kiosk", "edc qr");
        layanan.pilihTipeKiosk("regular");
        layanan.pilihTipeOrder("dine in", "take away");
        layanan.isiPPN("11");
        layanan.isiServiceCharge("5");
        layanan.isiBiayaAdmin("5000");
        layanan.pilihMetodePembayaran("qris", "debit");
        layanan.activeOnline();
        layanan.isiActiveOffline("OnGood");
        layanan.activeOffline();
        layanan.isiActiveOffline("OffGood");
        layanan.isiJumlahEDC("2");
        layanan.pilihJenisKartu("visa", "master");
        layanan.selanjutnya();

        informasiSettlementPage settlement = new informasiSettlementPage(driver);
        settlement.isAt();
        settlement.isiPICFinance("Test Saimen");
        settlement.isiEmail("rajasimon0@gmail.com");
        settlement.isiNoTelp("08123123123");
        settlement.supportCard("credit card", "debit card");
        settlement.pilihBank();
        settlement.isiNoRekening("1234123412");
        settlement.assertNamaPemilik("");
        settlement.selanjutnya();

        informasiUsahaPage usaha = new informasiUsahaPage(driver);
        usaha.isAt();
        usaha.isiPemilikUsaha(testData.nama());
        usaha.isiPekerjaan("Testing");
        usaha.isiJenisIdentitas("nik");
        usaha.isiNoIdentitas("123123123123");
        // usaha.checkClick();
        usaha.isiTempatLahir("Alam Sutera");
        usaha.pilihTanggalLahir("10/05/2025");
        usaha.isiAlamatKtp("Alam Sutera, Tangerang");
        usaha.isiProvinsiKotaKTP();
        usaha.isiNoNPWP("12341234123");
        usaha.isiNamaNPWP("Saimen Test");
        usaha.isiNoTelp("08123123123");
        usaha.isiAlamatNPWP("Alam Sutera, Tangerang, Bantan");
        usaha.isiAlamatUsaha("Alam Sutera, Usaha");
        usaha.isiProvinsiKotaUsaha();
        usaha.isiKodePos("40123");

        testStatus = 1;

    }

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
