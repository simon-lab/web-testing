package tests.dspPortal.model;

import java.util.List;

public record FDMTestData(String sumberFDM, String jenisUsaha, String namaMerchant, String namaPerusahaan,
                String alamatKorespondensi,
                String kodePosKorespondensi,
                String cityPten, String omset, String tipeUsaha, String namaPICUsaha, String noTelpLayanan,
                String emailLayanan, String jenisKiosk, List<String> jenisLayanan, String tipeKiosk,
                List<String> tipeOrder,
                String ppn, String serviceCharge, String adminFee, List<String> metodePembayaran, String online,
                String offline, String jumlahEDC, List<String> jenisKartu,
                String namaPICFinance, String noTelpFinance, String emailFinance, List<String> supportCard,
                String noBank, String noRekening,
                String namaPemilikRekening, String kcKcp, String namaPemilikUsaha, String pekerjaan,
                String jenisIdentitas,
                String noIdentitasKTP,
                String tempatLahir, String tanggalLahir, String alamatKTP, String noNPWP, String namaNPWP,
                String noTelpPemilik,
                String alamatNPWP, String alamatUsaha, String kodePos, String provinsiUsaha, String kotaUsaha) {

}
