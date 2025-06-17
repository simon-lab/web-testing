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

        dataMerchantPage dataMerchantPage = new dataMerchantPage(driver);
        dataMerchantPage.isAt();
        dataMerchantPage.pilihSumberFDM("reguler");

        dataMerchantPage.pilihKategoriMerchant("badan usaha");
        dataMerchantPage.isiNamaMerchant("Test Merchant");
        dataMerchantPage.isiNamaPerusahaan("PT Test DSP");
        dataMerchantPage.isiAlamat("Alam Sutera");
        dataMerchantPage.isiProvinsiKota();
        dataMerchantPage.isiKodePos("40123");
        dataMerchantPage.isiCityPten("1234");
        dataMerchantPage.pilihCountry();
        dataMerchantPage.pilihMCC();
        dataMerchantPage.isiOnset("5000000");
        dataMerchantPage.pilihKategoriUsaha("ume");
        dataMerchantPage.selanjutnya();

        informasiLayananPage informasiLayananPage = new informasiLayananPage(driver);
        informasiLayananPage.isiPICUsaha("SaimenTest");
        informasiLayananPage.isiNoTelp("08123123123");
        informasiLayananPage.isiEmail("rajasimon0@gmail.com");
        informasiLayananPage.pilihJenisUsaha("single");
        informasiLayananPage.pilihJenisLayanan("vkiosk", "self order kiosk", "edc qr");
        informasiLayananPage.pilihTipeKiosk("regular");
        informasiLayananPage.pilihTipeOrder("dine in", "take away");
        informasiLayananPage.isiPPN("11");
        informasiLayananPage.isiServiceCharge("5");
        informasiLayananPage.isiBiayaAdmin("5000");
        informasiLayananPage.pilihMetodePembayaran("qris", "debit");
        informasiLayananPage.activeOnline();
        informasiLayananPage.isiActiveOffline("OnGood");
        informasiLayananPage.activeOffline();
        informasiLayananPage.isiActiveOffline("OffGood");
        informasiLayananPage.isiJumlahEDC("2");
        informasiLayananPage.pilihJenisKartu("visa", "master");
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
