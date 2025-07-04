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

import com.saimen.pages.CMS.*;
import com.saimen.pages.dspPortal.*;
import com.saimen.pages.nuPay.*;

import tests.dspPortal.model.FDMTestData;
import tests.reusableMethod.generatingDateToday;
import tests.reusableMethod.generatingString;
import util.JsonUtil;

public class dspPortalTest implements ITestListener {

    WebDriver driver;
    WebDriver driver2;
    WebDriver driverCMS;
    WebDriver driverNUPAY;
    int testStatus = 0;
    private FDMTestData testData;
    String dateToday = generatingDateToday.generatingToday();
    String dateTodayText = generatingDateToday.generatingTodayTextFormat();
    SoftAssert softAssert = new SoftAssert();
    SoftAssert softAssert2 = new SoftAssert();
    SoftAssert softAssertCMS = new SoftAssert();
    SoftAssert softAssertNUPAY = new SoftAssert();
    loginPage loginPage;
    oprHomePage oprHomePage;
    fdmPage fdmPage;
    dataMerchantPage dataMerchant;
    informasiLayananPage layanan;
    informasiSettlementPage settlement;
    informasiUsahaPage usaha;
    fdmDetailPage detail;
    analystPage analystPage;

    loginPage loginPage2;
    oprHomePage oprHomePage2;
    fdmPage fdmPage2;
    dataMerchantPage dataMerchant2;
    informasiLayananPage layanan2;
    informasiSettlementPage settlement2;
    informasiUsahaPage usaha2;
    fdmDetailPage detail2;
    analystPage analystPage2;

    CMSLoginPage cmsLoginPage;
    CMSEditMerchantPage cmsEditMerchantPage;
    CMShomePage cmsHomePage;
    CMSmerchantPage cmsMerchantPage;

    NUPAYLoginPage nupayLogin;
    NUPAYhomePage nupayHomePage;
    NUPAYeCommPage nupayEcomm;
    NUPAYDetailPopUp nupayDetailPopUp;
    NUPAYEditECommPage nupayEditEcomm;
    NUPAYmerchantWebPage nupayWebPage;
    NUPAYEditMerchantPage nupayEditWebPage;

    String uniqString = generatingString.generateUniqueCode();
    String namaMerchant;
    String namaPerusahaan;
    String namaPemilikMerchant;
    int kolomTerkait;
    String merchantID;

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

        driver2 = new ChromeDriver(option);
        driver2.manage().window().minimize();

        driverCMS = new ChromeDriver(option);
        driverCMS.manage().window().minimize();

        driverNUPAY = new ChromeDriver(option);
        driverNUPAY.manage().window().minimize();

        driver.get("https://uat.dspportal.local/");
        loginPage = new loginPage(driver);
        oprHomePage = new oprHomePage(driver);
        dataMerchant = new dataMerchantPage(driver);
        layanan = new informasiLayananPage(driver);
        settlement = new informasiSettlementPage(driver);
        usaha = new informasiUsahaPage(driver);
        detail = new fdmDetailPage(driver);
        fdmPage = new fdmPage(driver);
        analystPage = new analystPage(driver);

        driver2.get("https://uat.dspportal.local/");
        loginPage2 = new loginPage(driver2);
        oprHomePage2 = new oprHomePage(driver2);
        dataMerchant2 = new dataMerchantPage(driver2);
        layanan2 = new informasiLayananPage(driver2);
        settlement2 = new informasiSettlementPage(driver2);
        usaha2 = new informasiUsahaPage(driver2);
        detail2 = new fdmDetailPage(driver2);
        fdmPage2 = new fdmPage(driver2);
        analystPage2 = new analystPage(driver2);

        driverCMS.get("https://jpdigi-kioskweb-uat.dspratama.co.id/");
        cmsLoginPage = new CMSLoginPage(driverCMS);
        cmsEditMerchantPage = new CMSEditMerchantPage(driverCMS);
        cmsHomePage = new CMShomePage(driverCMS);
        cmsMerchantPage = new CMSmerchantPage(driverCMS);

        driverNUPAY.get("https://jpdigi-ppayweb-uat.dspratama.co.id/");
        nupayLogin = new NUPAYLoginPage(driverNUPAY);
        nupayHomePage = new NUPAYhomePage(driverNUPAY);
        nupayEcomm = new NUPAYeCommPage(driverNUPAY);
        nupayDetailPopUp = new NUPAYDetailPopUp(driverNUPAY);
        nupayEditEcomm = new NUPAYEditECommPage(driverNUPAY);
        nupayWebPage = new NUPAYmerchantWebPage(driverNUPAY);
        nupayEditWebPage = new NUPAYEditMerchantPage(driverNUPAY);

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

    // @Test(priority = 0)
    public void checkingFormatFdmPage() {

        fdmPage.isAt();
        fdmPage.buatMOS();

        dataMerchant.isAt();
        dataMerchant.isiNamaMerchant("Nama Merchant !@#");
        dataMerchant.isiNamaPerusahaan("Nama Perusahaan !@#");
        dataMerchant.isiKodePos("40asd@123");
        dataMerchant.isiCityPten("Ban1!Sel");
        dataMerchant.isiOmset("100as!@#000000");

        dataMerchant.assertNamaMerchant("Nama Merchant", softAssert);
        dataMerchant.assertNamaPerusahaan("Nama Perusahaan", softAssert);
        dataMerchant.assertKodePos("40123", softAssert);
        dataMerchant.assertCityPTEN("BanSel", softAssert);
        dataMerchant.assertOmset("100.000.000", softAssert);
        testStatus = 1;
    }

    @Test(priority = 1)
    public void normalFdmPage() {

        fdmPage.isAt();
        fdmPage.buatMOS();

        dataMerchant.isAt();
        dataMerchant.pilihSumberFDM(testData.sumberFDM());
        dataMerchant.pilihJenisUsaha(testData.jenisUsaha());
        dataMerchant.isiNamaMerchant(namaMerchant);
        dataMerchant.isiNamaPerusahaan(namaPerusahaan);
        dataMerchant.isiAlamat(testData.alamatKorespondensi());
        dataMerchant.isiProvinsiKota();
        dataMerchant.isiKodePos(testData.kodePosKorespondensi());
        dataMerchant.isiCityPten(testData.cityPten());
        dataMerchant.pilihCountry();
        dataMerchant.pilihMCC();
        dataMerchant.isiOmset(testData.omset());
        dataMerchant.pilihTipeUsaha(testData.tipeUsaha());
        dataMerchant.selanjutnya();

        testStatus = 1;
    }

    // @Test(priority = 2)
    public void formatCheckingLayananPage() {
        layanan.isAt();
        layanan.isiPICUsaha("PIC Usaha 12@#");
        layanan.isiNoTelp("0821qwe!@#29851234");
        layanan.isiPPN("as!@10");
        layanan.isiServiceCharge("as!@10");
        layanan.isiBiayaAdmin("as!@5000");
        layanan.activeOnline();
        layanan.isiActiveOnline("as!@10");
        layanan.activeOffline();
        layanan.isiActiveOffline("as!@10");
        layanan.isiJumlahEDC("as!@5");

        layanan.assertNamaPICUsaha("PIC Usaha", softAssert);
        layanan.assertNoTelpPICUsaha("082129851234", softAssert);
        layanan.assertPPN("10", softAssert);
        layanan.assertServiceCharge("10", softAssert);
        layanan.assertAdminFee("5000", softAssert);
        layanan.assertOnline("10", softAssert);
        layanan.assertOffline("10", softAssert);
        layanan.assertJumlahEDC("5", softAssert);

        testStatus = 1;
    }

    @Test(priority = 3)
    public void normalLayananPage() {
        layanan.isAt();
        layanan.isiPICUsaha(namaPemilikMerchant);
        layanan.isiNoTelp(testData.noTelpLayanan());
        layanan.isiEmail(testData.emailLayanan());
        layanan.pilihJenisKiosk(testData.jenisKiosk());
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

    // @Test(priority = 4)
    public void formatCheckSettlement() {
        settlement.isAt();
        settlement.isiPICFinance("PIC Finance 12@#");
        settlement.isiNoTelp("08no!@#7714541236");
        settlement.isiNoRekening("08no!@#7714541236");

        settlement.assertPicName("PIC Finance", softAssert);
        settlement.assertPhoneNumber("087714541236", softAssert);
        settlement.assertNoRekening("087714541236", softAssert);

        testStatus = 1;
    }

    @Test(priority = 5)
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

    // @Test(priority = 6)
    public void formatCheckingUsaha() {

        usaha.isAt();
        usaha.isiPemilikUsaha("Pemilik Usaha 12#@");
        usaha.isiJenisIdentitas(testData.jenisIdentitas());
        usaha.isiNoIdentitas("12312123QWE!@#123");
        usaha.isiTempatLahir("Band123!@#ung");
        usaha.pilihTanggalLahir("25/08/2025");
        usaha.isiNoNPWP("123123QWE!@#123123123");
        usaha.isiNoTelp("08123QWE!@#12341234");
        usaha.isiKodePos("40asd@123");

        usaha.assertPicName("Pemilik Usaha", softAssert);
        usaha.assertNoIdentitas("12312123123", softAssert);
        usaha.assertTempatLahir("Bandung", softAssert);
        usaha.assertTanggalLahir("--", softAssert);
        usaha.assertNpwp("123123123123123", softAssert);
        usaha.assertNoTelp("0812312341234", softAssert);
        usaha.assertKodePos("40123", softAssert);

        testStatus = 1;

    }

    @Test(priority = 7)
    public void normalUsaha() {

        usaha.isAt();
        usaha.isiPemilikUsaha(testData.namaPemilikUsaha() + " " + uniqString);
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

        System.out.println("Data " + testData.namaMerchant() + " " + uniqString + "Telah Disimpan");

        testStatus = 1;

    }

    @Test(priority = 8)
    void assertDetailAfterBuatMOS() {
        fdmPage.isAt();
        kolomTerkait = fdmPage.cariKolom(namaMerchant);
        fdmPage.assertData(testData.namaMerchant(), testData.namaPerusahaan(),
                testData.namaPemilikUsaha(), dateToday, "DRAFT", kolomTerkait, uniqString);
        fdmPage.detailClick(kolomTerkait);

        detailCheck.detailAssert(testData, detail, softAssert, uniqString);
        softAssert.assertAll();

        oprHomePage.fdmClick();
        System.out.println("Data " + testData.namaMerchant() + " " + uniqString + "Pada page fdm sudah Benar");

        testStatus = 1;
    }

    @Test(priority = 9)
    void assertEditPage() throws InterruptedException {
        fdmPage.isAt();
        fdmPage.editClick(kolomTerkait);
        dataMerchant.isAt();
        dataMerchant.assertSumberFDM(testData.sumberFDM(), softAssert);
        dataMerchant.assertKategoriUsaha(testData.jenisUsaha() + " " +
                uniqString, softAssert);
        dataMerchant.assertNamaMerchant(testData.namaMerchant() + " " + uniqString,
                softAssert);
        dataMerchant.assertNamaPerusahaan(testData.namaPerusahaan(), softAssert);
        dataMerchant.assertAlamatKorespondensi(testData.alamatKorespondensi(),
                softAssert);
        dataMerchant.assertProvinsiKorespondensi(testData.provinsiUsaha(),
                softAssert);
        dataMerchant.assertKotaKorespondensi(testData.kotaUsaha(), softAssert);
        dataMerchant.assertKecamatanKorespondensi("Antapani", softAssert);
        dataMerchant.assertKelurahanKorespondensi("Antapani Tengah", softAssert);
        dataMerchant.assertKodePos(testData.kodePos(), softAssert);
        dataMerchant.assertCityPTEN(testData.cityPten(), softAssert);
        dataMerchant.assertCountry("Indonesia", softAssert);
        dataMerchant.assertMCC("4457 - BOAT RENTALS & LEASES", softAssert);
        dataMerchant.assertOmset(testData.omset(), softAssert);
        dataMerchant.assertTipeUsaha(testData.tipeUsaha(), softAssert);
        dataMerchant.selanjutnya();

        layanan.isAt();
        layanan.assertNamaPICUsaha(testData.namaPICUsaha(), softAssert);
        layanan.assertNoTelpPICUsaha(testData.noTelpLayanan(), softAssert);
        layanan.assertEmailPICUsaha(testData.emailLayanan(), softAssert);
        layanan.assertJenisKiosk(testData.jenisKiosk(), softAssert);
        layanan.assertJenisLayanan(testData.jenisLayanan(), softAssert);
        layanan.assertTipeKiosk(testData.tipeKiosk(), softAssert);
        layanan.assertOrderType(testData.tipeOrder(), softAssert);
        layanan.assertPPN(testData.ppn(), softAssert);
        layanan.assertServiceCharge(testData.serviceCharge(), softAssert);
        layanan.assertAdminFee(testData.adminFee(), softAssert);
        layanan.assertMetodePembayaran(testData.metodePembayaran(), softAssert);
        layanan.assertOnline(testData.online(), softAssert);
        layanan.assertOffline(testData.offline(), softAssert);
        layanan.assertJumlahEDC(testData.jumlahEDC(), softAssert);
        layanan.assertJenisKartu(testData.jenisKartu(), softAssert);
        layanan.selanjutnya();

        settlement.isAt();
        settlement.assertPicName(testData.namaPICFinance(), softAssert);
        settlement.assertPhoneNumber(testData.noTelpFinance(), softAssert);
        settlement.assertEmail(testData.emailFinance(), softAssert);
        settlement.assertSupportCard(testData.supportCard(), softAssert);
        settlement.assertPilihBank("037 - Artha Graha-BANK ARTHA GRAHA", softAssert);
        settlement.assertNoRekening(testData.noRekening(), softAssert);
        settlement.assertNamaPemilikRekening(testData.namaPemilikRekening(),
                softAssert);
        settlement.assertKCKCP(testData.kcKcp(), softAssert);
        settlement.selanjutnya();

        usaha.isAt();
        usaha.assertPicName(testData.namaPemilikUsaha(), softAssert);
        usaha.assertWork(testData.pekerjaan(), softAssert);
        usaha.assertJenisUsaha(testData.jenisUsaha(), softAssert);
        usaha.assertNoIdentitas(testData.noIdentitasKTP(), softAssert);
        usaha.assertTempatLahir(testData.tempatLahir(), softAssert);
        usaha.assertTanggalLahir(testData.tanggalLahir(), softAssert);
        usaha.assertAlamatKtp(testData.alamatKTP(), softAssert);
        usaha.assertProvinsiKtp(testData.provinsiUsaha(), softAssert);
        usaha.assertKotaKtp(testData.kotaUsaha(), softAssert);
        usaha.assertNpwp(testData.noNPWP(), softAssert);
        usaha.assertNamaNpwp(testData.namaNPWP(), softAssert);
        usaha.assertNoTelp(testData.noTelpPemilik(), softAssert);
        usaha.assertAlamatNpwp(testData.alamatNPWP(), softAssert);
        usaha.assertAlamatUsaha(testData.alamatUsaha(), softAssert);
        usaha.assertProvinsiUsaha(testData.provinsiUsaha(), softAssert);
        usaha.assertKotaUsaha(testData.kotaUsaha(), softAssert);
        usaha.assertKecamatanUsaha("Antapani", softAssert);
        usaha.assertKelurahanUsaha("Antapani Tengah", softAssert);
        usaha.assertKodePos(testData.kodePos(), softAssert);
        usaha.requestClick();
        usaha.sendRequestClick();

        System.out.println("Data " + testData.namaMerchant() + " " + uniqString + "Sudah Benar Edit Page");
    }

    @Test(priority = 10)
    public void assertScoringPageDataAndOption() {
        fdmPage.isAt();
        fdmPage.analystClick(kolomTerkait);
        analystPage.assertNamaMitra(testData.namaMerchant() + " " + uniqString);
        analystPage.assertNamaPemilik(testData.namaPemilikUsaha() + " " +
                uniqString);
        analystPage.assertStatusPekerjaan(testData.pekerjaan());
        analystPage.assertAlamatUsaha(testData.alamatUsaha());
        analystPage.assertKotaUsaha(testData.kotaUsaha());
        analystPage.assertProvinsiUsaha(testData.provinsiUsaha());
        analystPage.assertTipeUsaha(testData.tipeUsaha());
        analystPage.assertJasaRisikoTinggiCheck();
        analystPage.assertIdentitasPenggunaCheck();
        analystPage.assertLokasiUsahaChecked();
        analystPage.assertProfilPengguna();
        analystPage.assertKegiatanUsahaPenggunaJasa();
        analystPage.assertKategoriNegaraBisnisProduk();

        testStatus = 1;
    }

    @Test(priority = 11)
    public void normalScoring() {
        // analystPage.pilihPenggunaJasaResiko("Presiden");
        analystPage.pilihIdentitasPengguna("Data atau informasi identitas"); // score3
        analystPage.pilihLokasiUsaha("Berada di kota"); // score 1
        analystPage.pilihProfilPenggunaJasa("Merchant adalah pegawai perusahaan");// score 1
        analystPage.pilihKegiatanUsaha("perusahaan publik atau perusahaan yang terdaftar");// score 1
        analystPage.pilihKategoriNegara("Merchant tidak masuk kedalam");// score 4
        analystPage.assertTotal("10", "LOW");
        analystPage.assertCddEdd("cdd");
        analystPage.tidakDTTOT();
        analystPage.requestApproceClick();
        analystPage.sendItBtn();

        fdmPage.assertData(testData.namaMerchant(), testData.namaPerusahaan(),
                testData.namaPemilikUsaha(), dateToday, "DRAFT REQUEST SUBMITTED FOR APPROVAL", kolomTerkait,
                uniqString);

        System.out.println("Data " + testData.namaMerchant() + " " + uniqString + " Telah di Scoring");
    }

    @Test(priority = 12)
    public void normalLoginDeptHead() {

        driver2.manage().window().maximize();

        loginPage2.fillUsername("css");
        loginPage2.fillPassword("123");
        loginPage2.signInClick();
    }

    @Test(priority = 13)
    public void normalApproving() {

        oprHomePage2.isAt();
        oprHomePage2.approvalClick();
        oprHomePage2.approve1Click();
        // oprHomePage2.approvalClick();
        // int kolomDataApproval = oprHomePage2.cariKolom(testData.namaMerchant() + " "
        // + uniqString);
        // oprHomePage2.approveClick(kolomDataApproval);
    }

    @Test(priority = 14)
    void assertDetailAfterApproval() {
        oprHomePage2.fdmClick();
        fdmPage2.isAt();

        kolomTerkait = fdmPage2.cariKolom(namaMerchant);
        fdmPage2.assertData(testData.namaMerchant(), testData.namaPerusahaan(),
                testData.namaPemilikUsaha(), dateToday, "APPROVED", kolomTerkait, uniqString);
        fdmPage2.detailClick(kolomTerkait);

        detailCheck.detailAssert(testData, detail2, softAssert2, uniqString);
        softAssert2.assertAll();

        oprHomePage2.fdmClick();
        System.out.println("Data " + testData.namaMerchant() + " " + uniqString + "Pada page fdm sudah Benar");

        testStatus = 1;
    }

    @Test(priority = 15)
    void checkingCMS() {

        driverCMS.manage().window().maximize();
        cmsLoginPage.isAt();
        cmsLoginPage.fillEmail("admin@mggsoftware.com");
        cmsLoginPage.fillPassword("123456");
        cmsLoginPage.logInClick();

        cmsHomePage.isAt();
        cmsHomePage.merchantClick();

        cmsMerchantPage.isAt();
        int kolomTerkait = cmsMerchantPage.cariKolom(namaMerchant);
        merchantID = cmsMerchantPage.assertDataAndGetMID(namaMerchant, testData.jenisKiosk(), kolomTerkait);
        System.out.println("Merchant ID Nya: " + merchantID);
        cmsMerchantPage.clickEdit(kolomTerkait);

        cmsEditMerchantPage.isAt();
        cmsEditMerchantPage.assertNamaMerchant(namaMerchant, softAssertCMS);
        cmsEditMerchantPage.assertAlamat(testData.alamatUsaha(), softAssertCMS);
        cmsEditMerchantPage.assertNoTelp(testData.noTelpLayanan(), softAssertCMS);
        cmsEditMerchantPage.assertOwner(testData.namaPemilikUsaha(), softAssertCMS);
        cmsEditMerchantPage.assertNPWP(testData.noNPWP(), softAssertCMS);
        cmsEditMerchantPage.assertNamaPIC(testData.namaPICUsaha(), softAssertCMS);
        cmsEditMerchantPage.assertNoPIC(testData.noTelpLayanan(), softAssertCMS);
        cmsEditMerchantPage.assertEmailPIC(testData.emailLayanan(), softAssertCMS);
        cmsEditMerchantPage.assertNIKOwner(testData.noIdentitasKTP(), softAssertCMS);
        cmsEditMerchantPage.assertAlamatOwner(testData.alamatKTP(), softAssertCMS);
        cmsEditMerchantPage.assertEmailOwner(testData.emailLayanan(), softAssertCMS);
        cmsEditMerchantPage.assertNoOwner(testData.noTelpPemilik(), softAssertCMS);
        // cmsEditMerchantPage.assertPlatform(testData., softAssert);
        cmsEditMerchantPage.assertOutletType(testData.jenisKiosk(), softAssertCMS);
    }

    @Test(priority = 16)
    void checkingNuPay() {

        driverNUPAY.manage().window().maximize();
        nupayLogin.isAt();
        nupayLogin.fillEmail("admindefault@mggsoftware.com");
        nupayLogin.fillPassword("123456");
        nupayLogin.logInClick();

        nupayHomePage.isAt();
        nupayHomePage.eCommClick();

        nupayEcomm.isAt();
        int kolomTerkait = nupayEcomm.cariKolom(namaMerchant);
        nupayEcomm.assertData(merchantID, namaMerchant, dateTodayText, kolomTerkait);
        nupayEcomm.clickEdit(kolomTerkait);

        nupayEditEcomm.isAt();
        nupayEditEcomm.assertNamaMerchant(namaMerchant, softAssertNUPAY);
        // nupayEditEcomm.assertNamaShopping(testData., softAssertNUPAY);
        nupayEditEcomm.assertAlamat(testData.alamatUsaha(), softAssertNUPAY);
        nupayEditEcomm.assertKota(testData.kotaUsaha(), softAssertNUPAY);
        nupayEditEcomm.assertCountry("ID", softAssertNUPAY);
        nupayEditEcomm.assertKodePos(testData.kodePos(), softAssertNUPAY);
        nupayEditEcomm.assertNoTelp(testData.noTelpLayanan(), softAssertNUPAY);
        nupayEditEcomm.assertKategoriMerchant("4457", softAssertNUPAY);
        nupayEditEcomm.assertTipeUsaha(testData.tipeUsaha(), softAssertNUPAY);
        nupayEditEcomm.assertNamaPICUsaha(testData.namaPICUsaha(), softAssertNUPAY);
        nupayEditEcomm.assertNamaPICEmail(testData.emailLayanan(), softAssertNUPAY);
        nupayEditEcomm.assertNoTelpPIC(testData.noTelpPemilik(), softAssertNUPAY);
        nupayEditEcomm.assertBank("BANK ARTHA GRAHA", softAssertNUPAY);
        nupayEditEcomm.assertNoBank(testData.noRekening(), softAssertNUPAY);
        // nupayEditEcomm.assertMPan(testData., softAssertNUPAY);
        nupayEditEcomm.assertNamaBank(testData.namaPemilikRekening(), softAssertNUPAY);
        nupayEditEcomm.assertKcKcp(testData.kcKcp(), softAssertNUPAY);
        // nupayEditEcomm.assertNMID(testData., softAssertNUPAY);
        nupayEditEcomm.assertSupportedCard(testData.supportCard(), softAssertNUPAY);
        nupayEditEcomm.assertAggregator("Merchant DSP", softAssertNUPAY);// Ini harus ditanyakan

        nupayHomePage.merchantsWebsiteClick();
        nupayWebPage.isAt();
        kolomTerkait = nupayWebPage.cariKolom(namaMerchant);
        nupayWebPage.assertData(merchantID, namaMerchant, testData.jenisKiosk(), dateTodayText, kolomTerkait);
        nupayWebPage.clickEdit(kolomTerkait);

        nupayEditWebPage.isAt();
        nupayEditWebPage.assertNamaMerchant(namaMerchant, softAssertNUPAY);
        nupayEditWebPage.assertAlamat(testData.alamatUsaha(), softAssertNUPAY);
        nupayEditWebPage.assertNoTelp(testData.noTelpLayanan(), softAssertNUPAY);
        nupayEditWebPage.assertPIC(testData.namaPICUsaha(), softAssertNUPAY);
        nupayEditWebPage.assertEmail(testData.emailLayanan(), softAssertNUPAY);
        nupayEditWebPage.assertNoTelpOwner(testData.noTelpPemilik(), softAssertNUPAY);
        nupayEditWebPage.assertNnpwp(testData.noNPWP(), softAssertNUPAY);
        nupayEditWebPage.assertNikOwner(testData.noIdentitasKTP(), softAssertNUPAY);
        nupayEditWebPage.assertAlamatOwner(testData.alamatKTP(), softAssertNUPAY);
        nupayEditWebPage.assertBankNo(testData.noBank(), softAssertNUPAY);
        nupayEditWebPage.assertBankAccNo(testData.noRekening(), softAssertNUPAY);
        nupayEditWebPage.assertKcKcp(testData.kcKcp(), softAssertNUPAY);
        nupayEditWebPage.assertNamaPemilikBank(testData.namaPemilikRekening(), softAssertNUPAY);
        // nupayEditWebPage.assertMpan(expected, softAssertNUPAY);
        nupayEditWebPage.assertSupportedCard(testData.supportCard(), softAssertNUPAY);
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
