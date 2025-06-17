package tests.dspPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saimen.TestListener;
import com.saimen.dspPortal.dataMerchantPage;
import com.saimen.dspPortal.fdmPage;
import com.saimen.dspPortal.informasiLayananPage;
import com.saimen.dspPortal.informasiSettlementPage;
import com.saimen.dspPortal.loginPage;
import com.saimen.dspPortal.oprHomePage;

public class dspPortalTest implements ITestListener {

    WebDriver driver;

    @BeforeClass
    public void setEnvironment() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/java/tests/driver/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();

    }

    @Test
    public void loginTest() {
        driver.get("https://uat.dspportal.local/");
        loginPage loginPage = new loginPage(driver);
        loginPage.isAt();
        loginPage.fillUsername("art");
        loginPage.fillPassword("123");
        loginPage.signInClick();

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

    }

    @AfterClass
    public void tearDown() {
        if (!TestListener.hasFailed) {
            System.out.println("Test gagal, driver tidak di-close untuk debugging.");
        } else {
            driver.quit(); // hanya close jika tidak gagal
        }
    }

}
