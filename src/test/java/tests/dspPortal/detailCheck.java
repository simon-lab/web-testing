package tests.dspPortal;

import org.testng.asserts.SoftAssert;

import com.saimen.pages.dspPortal.fdmDetailPage;

import tests.dspPortal.model.FDMTestData;

public class detailCheck {
    public static void detailAssert(FDMTestData testData, fdmDetailPage detail,
            SoftAssert softAssert, String uniqString) {

        try {
            detail.assertSumberFDM(testData.sumberFDM(), softAssert);
            detail.assertJenisUsaha(testData.jenisUsaha(), softAssert);
            detail.assertNamaMerchant(testData.namaMerchant(), softAssert, uniqString);
            detail.assertNamaPerusahaan(testData.namaPerusahaan(), softAssert, uniqString);
            detail.assertAlamatKorespondensi(testData.alamatKorespondensi(), softAssert);
            detail.assertProvinsiKorespondensi("JAWA BARAT", softAssert);
            detail.assertKotaKorespondensi("KOTA BANDUNG", softAssert);
            detail.assertKecamatanKorespondensi("Antapani", softAssert);
            detail.assertKelurahanKorespondensi("Antapani Tengah", softAssert);
            detail.assertKodePosKorespondensi(testData.kodePosKorespondensi(), softAssert);
            detail.assertCityPTEN(testData.cityPten(), softAssert);
            detail.assertCountry("ID-Indonesia", softAssert);
            detail.assertMcc("BOAT RENTALS & LEASES", softAssert);
            detail.assertOmset(testData.omset(), softAssert);
            detail.assertTipeUsaha(testData.tipeUsaha(), softAssert);
            detail.assertNamaPICUsaha(testData.namaPICUsaha(), softAssert, uniqString);
            detail.assertNoTelpPICUsaha(testData.noTelpLayanan(), softAssert);
            detail.assertEmailPICUsaha(testData.emailLayanan(), softAssert);
            detail.assertJenisKiosk(testData.jenisKiosk(), softAssert);
            detail.assertJenisLayanan(testData.jenisLayanan(), softAssert);
            detail.assertTipeKiosk(testData.tipeKiosk(), softAssert);
            detail.assertOrderType(testData.tipeOrder(), softAssert);
            detail.assertPpn(testData.ppn(), softAssert);
            detail.assertServiceCharge(testData.serviceCharge(), softAssert);
            detail.assertAdminFee(testData.adminFee(), softAssert);
            detail.assertMetodePembayaran(testData.metodePembayaran(), softAssert);
            detail.assertOnline(testData.online(), softAssert);
            detail.assertOffline(testData.offline(), softAssert);
            detail.assertJumlahEDC(testData.jumlahEDC(), softAssert);
            detail.assertJenisKartu(testData.jenisKartu(), softAssert);
            detail.assertNamaPICFinance(testData.namaPICFinance(), softAssert);
            detail.assertNoTelpFinance(testData.noTelpFinance(), softAssert);
            detail.assertEmailFinance(testData.emailFinance(), softAssert);
            // detail.assertSupportedCard(testData.supportCard()); CAPSLOCK
            // detail.assertNamaBank(testData.namaPemilikRekening()); PASTIKAN FORMAT NAMA
            // BANK
            detail.assertNoRekening(testData.noRekening(), softAssert);
            detail.assertNamaPemilikRekening(testData.namaPemilikRekening(), softAssert);
            detail.assertKcKcp(testData.kcKcp(), softAssert);
            detail.assertNamaPemilikUsaha(testData.namaPemilikUsaha(), softAssert, uniqString);
            detail.assertPekerjaan(testData.pekerjaan(), softAssert);
            detail.assertJenisIdentitas(testData.jenisIdentitas(), softAssert);
            detail.assertNoIdentitas(testData.noIdentitasKTP(), softAssert);
            detail.assertTempatLahir(testData.tempatLahir(), softAssert);
            detail.assertTanggalLahir(testData.tanggalLahir(), softAssert);
            detail.assertAlamatKTP(testData.alamatKTP(), softAssert);
            detail.assertProvinceKTP("JAWA BARAT", softAssert);
            detail.assertCityKTP("KOTA BANDUNG", softAssert);
            detail.assertNoNPWP(testData.noNPWP(), softAssert);
            detail.assertNamaNPWP(testData.namaNPWP(), softAssert);
            detail.assertNoTelpNPWP(testData.noTelpPemilik(), softAssert);
            detail.assertAlamatNPWP(testData.alamatNPWP(), softAssert);
            detail.assertAlamatUsaha(testData.alamatUsaha(), softAssert);
            detail.assertProvinsiUsaha("JAWA BARAT", softAssert);
            detail.assertKotaUsaha("KOTA BANDUNG", softAssert);
            detail.assertKecamatanUsaha("Antapani", softAssert);
            detail.assertKelurahanUsaha("Antapani Tengah", softAssert);
            detail.assertKodePosUsaha(testData.kodePos(), softAssert);
        } catch (Exception e) {
            System.out.println("Exception during assertions: " + e.getMessage());
        }
    }
}
