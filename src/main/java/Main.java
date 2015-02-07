import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Main extends HttpServlet {

    public static final String PROGRAM_INFO_MODEL = "{" +
            "\"api_version\":\"1.0\"," +
            "\"data\":{" +
            "\"resource\":\"program\"," +
            "\"total_server_items\":7," +
            "\"items\":[" +
            "{" +
            "\"code\":\"jamkesda-sleman\"," +
            "\"name\":\"Jamkesda\"," +
            "\"region_id\":\"98fbf6e8-d63c-4494-97f6-1e99346f84e5\"," +
            "\"description\":\"\\u003cp\\u003eJaminan Kesehatan Daerah (Jamkesda) adalah sistem jaminan kesehatan yang diselenggarakan oleh Pemerintah Daerah yang penyelenggaraannya berdasarkan atas usaha bersama dan kekeluargaan untuk menggabungkan resiko sakit seseorang ke dalam suatu kelompok masyarakat yang pembiayaannya dilakukan secara praupaya serta mutu terjamin.\\u003c/p\\u003e\"," +
            "\"objectives\":\"\\u003cp\\u003eMaksud jamkesda untuk meningkatkan derajat kesehatan masyarakat. Tujuan jamkesda untuk menjamin peserta memperoleh manfaat pemeliharaan kesehatan dan perlindungan kesehatan sebagai kebutuhan dasar.\\u003c/p\\u003e\"," +
            "\"legal_basis\":\"\\u003cul\\u003e\\n \\u003cli\\u003ePerda No 11 Tahun 2010 tentang Jaminan Kesehatan Daerah\\u003c/li\\u003e\\n \\u003cli\\u003ePerda No. 20 Tahun 2012 tentang Perubahan Atas Perda No 11 Tahun 2010 tentang Jaminan Kesehatan Daerah\\u003c/li\\u003e\\n \\u003cli\\u003eSK Bupati No 436/Kep.KDH/A/2012 tentang Keluarga Miskin dan Rentan Miskin Peserta Jaminan Kesehatan Daerah Tahun 2013\\u003c/li\\u003e\\n \\u003c/ul\\u003e\"," +
            "\"beneficiaries_description\":\"\\u003cp\\u003ePenerima Manfaat dari program Jamkesda adalah seluruh warga Kabupaten Sleman yang belum menjadi peserta Jaminan Kesehatan. Warga miskin (yang ada di SK Bupati/ memiliki Kartu Keluarga Miskin) ditanggung oleh Pemerintah Daerah sesuai dengan kemampuan keuangan daerah.\\u003c/p\\u003e\"," +
            "\"benefit\":\"\"," +
            "\"beneficiaries_number\":136169," +
            "\"institution\":\"\"," +
            "\"contact_person\":\"\"," +
            "\"contact_person_title\":\"\"," +
            "\"contact_person_phone\":\"\"," +
            "\"local_institution\":\"UPT Jaminan Pemeliharaan Kesehatan Masyarakat (JPKM)\"," +
            "\"local_contact_person\":\"Agus Triono\"," +
            "\"local_contact_person_title\":\"Kepala UPT JPKM\"," +
            "\"local_contact_person_phone\":\"081392402743\"," +
            "\"program_type\":\"local\"," +
            "\"created_at\":\"2014-11-02T21:42:00.987+07:00\"," +
            "\"updated_at\":\"2014-11-02T21:42:00.987+07:00\"," +
            "\"state\":\"inactive\"," +
            "\"id\":\"81a19097-dd81-444b-87c0-4bfa68345abd\"" +
            "}," +
            "{" +
            "\"code\":\"jamkesmas-sleman\"," +
            "\"name\":\"Jamkesmas\"," +
            "\"region_id\":\"98fbf6e8-d63c-4494-97f6-1e99346f84e5\"," +
            "\"description\":\"\\u003cp\\u003eJaminan Kesehatan Masyarakat (Jamkesmas) adalah program bantuan sosial untuk pelayanan kesehatan bagi masyarakat miskin dan tidak mampu. Pada hakekatnya pelayanan kesehatan terhadap masyarakat miskin menjadi tanggung jawab dan dilaksanakan bersama oleh Pemerintah Pusat dan Pemerintah Daerah. Pemerintah Provinsi/ Kabupaten/Kota berkewajiban memberikan kontribusi sehingga menghasilkan pelayanan kesehatan yang optimal.\\u003c/p\\u003e\"," +
            "\"objectives\":\"\\u003cp\\u003eSecara umum, tujuan penyelenggaraan program Jamkesmas mencakup:\\u003c/p\\u003e\\u003cul\\u003e\\u003cli\\u003eTerselenggaranya akses dan mutu pelayanan kesehatan terhadap seluruh masyarakat miskin dan tidak mampu agar tercapai derajat kesehatan masyarakat yang optimal secara efektif dan efisien.\\u003c/li\\u003e\\u003cli\\u003eMeningkatnya akses dan mutu pelayanan kesehatan sehingga tercapai derajat kesehatan yang optimal secara efektif dan efisien bagi seluruh peserta Jamkesmas.\\u003c/li\\u003e\\u003c/ul\\u003e\\u003cp\\u003eSedangkan, tujuan khusus program ini adalah:\\u003c/p\\u003e\\u003cul\\u003e\\u003cli\\u003eMemberikan kemudahan dan akses pelayanan kesehatan kepada peserta di seluruh jaringan PPK Jamkesmas.\\u003c/li\\u003e\\u003cli\\u003eMendorong peningkatan pelayanan kesehatan yang terstandar bagi peserta, tidak berlebihan sehingga terkendali mutu dan biayanya\\u003c/li\\u003e\\u003cli\\u003eTerselenggaranya pengelolaan keuangan yang transparan dan akuntabel\\u003c/li\\u003e\\u003cli\\u003eMeningkatkan cakupan masyarakat yang tidak mampu yang mendapat pelayanan kesehatan di puskesmas serta jaringannya dan di rumah sakit,\\u003c/li\\u003e\\u003cli\\u003eMeningkatkan kualitas pelayanan kesehatan bagi masyarakat miskin.\\u003c/li\\u003e\\u003c/ul\\u003e\"," +
            "\"legal_basis\":\"\\u003cul\\u003e\\u003cli\\u003eUndang Undang \\u0026nbsp;No. 17 Tahun 2003, tentang Keuangan Negara\\u003c/li\\u003e\\u003cli\\u003eUndang Undang\\u0026nbsp; No.1 Tahun\\u0026nbsp; 2004, tentang \\u0026nbsp;Perbendaharaan Negara\\u0026nbsp;\\u003c/li\\u003e\\u003cli\\u003eUndang Undang\\u0026nbsp; No 15 Tahun 2004, tentang Pemeriksaan Pengelolaan dan Tanggung Jawab Keuangan Negara\\u003c/li\\u003e\\u003cli\\u003eUndang Undang\\u0026nbsp; No 29 Tahun 2004\\u0026nbsp; tentang Praktek Kedokteran\\u003c/li\\u003e\\u003cli\\u003eUndang Undang no. 32 Tahun 2004 tentang Pemerintah Daerah\\u003c/li\\u003e\\u003cli\\u003eUndang Undang No 33 Tahun 2004 tentang Perimbangan Keuangan antara Pemerintah Pusat dan pemerintah Daerah\\u003c/li\\u003e\\u003cli\\u003eUndang Undang No. 40 Tahun 2004 tentang Sistem Jaminan Sosial\\u003c/li\\u003e\\u003cli\\u003eUndang Undang No. 36 Tahun 2009 tentang Kesehatan\\u003c/li\\u003e\\u003cli\\u003eUndang Undang No 44 Tahun 2009 tentang Rumah sakit\\u003c/li\\u003e\\u003cli\\u003eUndang Undang No: 19 Tahun 2012 Tentang Anggaran Pendapatan dan Belanja Negara Tahun 2013\\u003c/li\\u003e\\u003cli\\u003ePeraturan Pemerintah No 32 Tahun 1996 tentang Tenaga Kesehatan\\u003c/li\\u003e\\u003cli\\u003ePeraturan Pemerintah No 38 Tahun 2007 tentang Pembagian Urusan antara Pemerintah, Pemerintah Daerah Provinsi dan Pemerintah Kabupaten/Kota\\u003c/li\\u003e\\u003cli\\u003ePeraturan presiden No. 34 Tahun 2010 tentang Pembentukan dan organisasi Kementerian Negara\\u003c/li\\u003e\\u003cli\\u003ePeraturan Menteri Keuangan No. 171/PMK.05/2007 tentang sistem akuntasi dan pelaporan keuangan Pemerintah Pusat.\\u003c/li\\u003e\\u003cli\\u003ePeraturan menteri Kesehatan No. 1144/Menkes/Per/VIII/2010 tentang Organisasi dan Tata Kerja Kementrian Kesehatan\\u003c/li\\u003e\\u003cli\\u003eKeputusan Menteri Kesehatan RI No. 374 Tahun 2009 tentang Sistem Kesehatan Nasional\\u003c/li\\u003e\\u003c/ul\\u003e\"," +
            "\"beneficiaries_description\":\"\\u003cp\\u003eSasaran program Jamkesmas ini adalah masyarakat miskin tidak mampu dan yang tidak termasuk yang sudah mempunyai jaminan kesehatan lainnya, masyarakat miskin (Miskin) dan tidak mampu yang ditetapkan oleh bupati/walikota sesuai kuota, Gelandangan, pengemis, anak terlantar, Peserta Program Keluarga Harapan (PKH), Masyarakat miskin penghuni lapas, panti sosial, rutan dan korban bencana alam pasca bencana.\\u003c/p\\u003e\"," +
            "\"benefit\":\"\\u003cp\\u003eManfaat, program Jamkesmas bagi masyarakat miskin menawarkan jaminan kesehatan yang komprehensif (preventif, promotif, kuratif dan rehabilitatif), berjenjang (rawat jalan dan rawat inap di Puskesmas, rawat jalan spesialistik di rumah sakit dan rawat inap di rumah sakit), tanpa batasan nilai rupiah.\\u003c/p\\u003e\\u003cp\\u003eProgram Jamkesmas akan mengganti biaya layanan kesehatan sesuai dengan indikasi medis pasien, tetapi membatasi jenis layanan (kosmetika dan fertilitas) dan tanpa iur biaya (peserta tidak harus membayar biaya apapun). Jenis pelayanan yang dicakup relatif komprehensif termasuk layanan kasus katastropik seperti operasi jantung, hemodialisa dan operasi cesar, sehingga upaya mencapai kesejahteraan masyarakat terus menjadi prioritas utama pemerintah.\\u003c/p\\u003e\"," +
            "\"beneficiaries_number\":140377," +
            "\"institution\":\"Direktorat Jenderal Bina Upaya Kesehatan, Departemen Kesehatan Republik Indonesia\"," +
            "\"contact_person\":\"\"," +
            "\"contact_person_title\":\"\"," +
            "\"contact_person_phone\":\"\"," +
            "\"local_institution\":\"Dinas Kesehatan Kabupaten/Kota\"," +
            "\"local_contact_person\":\"dr. Tunggul\"," +
            "\"local_contact_person_title\":\"\"," +
            "\"local_contact_person_phone\":\"081328844549\"," +
            "\"program_type\":\"national\"," +
            "\"created_at\":\"2014-11-02T21:42:00.996+07:00\"," +
            "\"updated_at\":\"2014-11-02T21:42:00.996+07:00\"," +
            "\"state\":\"inactive\"," +
            "\"id\":\"1a6db7ec-ad93-46a2-b20d-2b9cf0c34c42\"" +
            "}," +
            "{" +
            "\"code\":\"jamkesta-sleman\"," +
            "\"name\":\"Jamkesta\"," +
            "\"region_id\":\"98fbf6e8-d63c-4494-97f6-1e99346f84e5\"," +
            "\"description\":\"\\u003cp\\u003eJaminan Kesehatan Semesta (Jamkesta) adalah sistem jaminan kesehatan yang pengelolaannya secara bersama dan terkoordinasi antara Pemerintah Provinsi dengan Pemerintah Kabupaten/Kota meliputi paket manfaat, kepesertaan, penyelenggaraan dan administrasi.\\u003c/p\\u003e\"," +
            "\"objectives\":\"\\u003cp\\u003eMaksud diselenggarakannya Jamkesta sebagai upaya untuk sinkronisasi, koordinasi, dan sinergi menuju integrasi antara Pemerintah, Pemerintah Provinsi dan Pemerintah Kabupaten/Kota dalam pengembangan dan penyelenggaraan program jaminan kesehatan guna memberikan jaminan pemeliharaan kesehatan kepada masyarakat.\\u003c/p\\u003e\\u003cp\\u003eTujuan diselenggarakannya Jamkesta adalah memberikan wadah dalam pelaksanaan program jaminan kesehatan kepada penduduk Daerah Istimewa Yogyakarta untuk memperoleh manfaat pemeliharaan kesehatan dan perlindungan jaminan kesehatan, secara terintegrasi.\\u003c/p\\u003e\"," +
            "\"legal_basis\":\"\\u003cul\\u003e\\n \\u003cli\\u003eUndang-Undang Nomor 3 Tahun 1950 tentang Pembentukan Daerah Istimewa Jogjakarta (Berita Negara Republik Indonesia Tahun 1950 Nomor 3) sebagaimana telah diubah terakhir dengan Undang-Undang Nomor 9 Tahun 1955 tentang Perubahan Undang-Undang Nomor 3 Jo. Nomor 19 Tahun 1950 tentang Pembentukan Daerah Istimewa Yogyakarta (Lembaran Negara Republik Indonesia Tahun 1955 Nomor 43, Tambahan Lembaran Negara Republik Indonesia Nomor 827);\\u003c/li\\u003e\\n \\u003cli\\u003eUndang-Undang Nomor 6 Tahun 1974 tentang Ketentuan-ketentuan Pokok Kesejahteraan Sosial (Lembaran Negara Republik Indonesia Tahun 1974 Nomor 53, Tambahan Lembaran Negara Republik Indonesia Nomor 3851) sebagaimana telah diubah dengan Undang-Undang Nomor 11 Tahun 2009 tentang Perubahan Atas Undang-Undang Nomor 6 Tahun 1974 tentang Ketentuan-ketentuan Pokok Kesejahteraan Sosial (Lembaran Negara Republik Indonesia Tahun 2009 Nomor 12, Tambahan Lembaran Negara Republik Indonesia Nomor 4967);\\u003c/li\\u003e\\n \\u003cli\\u003eUndang-Undang Nomor 32 Tahun 2004 tentang Pemerintahan Daerah (Lembaran Negara Republik Indonesia Tahun 2004 Nomor 125, Tambahan Lembaran Negara Republik Indonesia Nomor 4437) sebagaimana telah diubah terakhir dengan Undang-Undang Nomor 12 Tahun 2008 tentang Perubahan Kedua Atas Undang-Undang Nomor 32 Tahun 2004 tentang Pemerintahan Daerah (Lembaran Negara Republik Indonesia Tahun 2008 Nomor 59, Tambahan Lembaran Negara Republik Indonesia Nomor 4844);\\u003c/li\\u003e\\n \\u003cli\\u003eUndang-Undang Nomor 40 Tahun 2004 tentang Sistem Jaminan Sosial Nasional (Lembaran Negara Republik Indonesia Tahun 2004 Nomor 150, Tambahan Lembaran Negara Republik Indonesia Nomor 4456);\\u003c/li\\u003e\\n \\u003cli\\u003eUndang-Undang Nomor 36 Tahun 2009 tentang Kesehatan (Lembaran Negara Republik Indonesia Tahun 2009 Nomor 144, Tambahan Lembaran Negara Republik Indonesia Nomor 5063);\\u003c/li\\u003e\\n \\u003cli\\u003ePeraturan Pemerintah Nomor 31 Tahun 1950 tentang Berlakunya Undang- Undang Nomor 2, 3, 10 dan 11 Tahun 1950 (Berita Negara Republik Indonesia Tahun 1950 Nomor 58);\\u003c/li\\u003e\\n \\u003cli\\u003ePeraturan Pemerintah Nomor 65 tahun 2005 tentang Pedoman Penyusunan dan Penerapan Standar Pelayanan Minimal (Lembaran Negara Republik Indonesia Tahun 2005 Nomor 150, Tambahan Lembaran Negara Republik Indonesia Nomor 4585);\\u003c/li\\u003e\\n \\u003cli\\u003eKeputusan Menteri Kesehatan Nomor 922/MENKES/SK/X/2008 tentang Pedoman Teknis Pembagian Urusan Pemerintahan Bidang Kesehatan Antara Pemerintah, Pemerintah Daerah Provinsi dan Pemerintah Daerah Kabupaten/Kota;\\u003c/li\\u003e\\n \\u003cli\\u003ePeraturan Daerah Provinsi Daerah Istimewa Yogyakarta Nomor 7 Tahun 2007 tentang Urusan Pemerintahan Yang Menjadi Kewenangan Provinsi Daerah Istimewa Yogyakarta (Lembaran Daerah Provinsi Daerah Istimewa Yogyakarta Tahun 2007 Nomor 7);\\u003c/li\\u003e\\n \\u003c/ul\\u003e\"," +
            "\"beneficiaries_description\":\"\\u003cul\\u003e\\n \\u003cli\\u003ePeserta Jamkesta yang selanjutnya disebut Peserta adalah perorangan yang terdaftar sebagai penerima bantuan iuran dari Pemerintah Provinsi dan Pemerintah Kabupaten/Kota dan/atau masyarakat yang telah membayar iuran kepada pengelola Jamkesta.\\u003c/li\\u003e\\n \\u003cli\\u003ePenerima Bantuan Iuran yaitu masyarakat tidak mampu yang menerima bantuan iuran yang dibayar secara teratur oleh pemerintah kepada Penyelenggara Jamkesta untuk mendapatkan jaminan kesehatan.\\u003c/li\\u003e\\n \\u003c/ul\\u003e\"," +
            "\"benefit\":\"\"," +
            "\"beneficiaries_number\":271180," +
            "\"institution\":\"\"," +
            "\"contact_person\":\"\"," +
            "\"contact_person_title\":\"\"," +
            "\"contact_person_phone\":\"\"," +
            "\"local_institution\":\"UPT Jaminan Pemeliharaan Kesehatan Masyarakat (JPKM)\"," +
            "\"local_contact_person\":\"Agus Triono, ST\"," +
            "\"local_contact_person_title\":\"Kepala UPT JPKM\"," +
            "\"local_contact_person_phone\":\"081392402743\"," +
            "\"program_type\":\"local\"," +
            "\"created_at\":\"2014-11-02T21:42:01.005+07:00\"," +
            "\"updated_at\":\"2014-11-02T21:42:01.005+07:00\"," +
            "\"state\":\"inactive\"," +
            "\"id\":\"2308773f-3da8-4463-b77c-39aa7aa64337\"" +
            "}," +
            "{" +
            "\"code\":\"jppd-sleman\"," +
            "\"name\":\"JPPD\"," +
            "\"region_id\":\"98fbf6e8-d63c-4494-97f6-1e99346f84e5\"," +
            "\"description\":\"\\u003cp\\u003eJaminan Pembiayaan Pendidikan Daerah di Sleman.\\u003c/p\\u003e\\r\\n\"," +
            "\"objectives\":\"\\u003cp\\u003eMemberikan kesempatan kepada masyarakat miskin dan rentan miskin untuk memperoleh pendidikan.\\u003c/p\\u003e\\r\\n\"," +
            "\"legal_basis\":\"\\u003cul\\u003e\\r\\n\\t\\u003cli\\u003eUndang \\u0026ndash; undang nomor 20 tahun 2003 tentang Sistem Pendidikan Nasional\\u003c/li\\u003e\\r\\n\\t\\u003cli\\u003ePerbup Sleman No. 2 Tahun 2013 Tentang Jaminan Pembiayaan Pendidikan Daerah\\u003c/li\\u003e\\r\\n\\t\\u003cli\\u003eKeputusan Bupati Sleman no. 89./Kep.KDH/A/2013 tentang Besaran Jaminan Pembiayaan Pendidikan Daerah\\u003c/li\\u003e\\r\\n\\t\\u003cli\\u003eSK Bupati Sleman Nomor 425/Kep.KDH/A/2012 tentang keluarga rentan miskin\\u003c/li\\u003e\\r\\n\\u003c/ul\\u003e\\r\\n\"," +
            "\"beneficiaries_description\":\"\\u003cp\\u003ePenerima Manfaat dari program JPPD adalah Siswa SMA/MA dan SMK yang berstatus miskin (yang ada di SK Bupati/ memiliki Kartu Keluarga Miskin) dan rentan miskin yang bertempat tinggal di sleman. Bahkan di tahun 2014 ada kebijakan baru anak sleman yang sekolah di luar sleman juga bisa mendapat JPPD asalkan memenuhi syarat sebegai penerima JPPD. Ada kurang lebih 7.547 anak yang menerima JPPD.\\u003c/p\\u003e\\r\\n\"," +
            "\"benefit\":\"\\u003cp\\u003eSiswa SMA, MA dan SMK peserta JPPD dibebaskan dari biaya-biaya pendidikan sehingga mampu menekan angka drop out.\\u003c/p\\u003e\\r\\n\"," +
            "\"beneficiaries_number\":7547," +
            "\"institution\":\"\"," +
            "\"contact_person\":\"\"," +
            "\"contact_person_title\":\"\"," +
            "\"contact_person_phone\":\"\"," +
            "\"local_institution\":\"Dinas Pendidikan Pemuda dan Olahraga Kabupaten Sleman\"," +
            "\"local_contact_person\":\"Sudiro\"," +
            "\"local_contact_person_title\":\"Kepala Seksi Kurikulum dan Kesiswaan Dinas Pendidikan, Pemuda dan Olahraga Kabupaten Sleman\"," +
            "\"local_contact_person_phone\":\"081328210473\"," +
            "\"program_type\":\"local\"," +
            "\"created_at\":\"2014-11-02T21:42:01.014+07:00\"," +
            "\"updated_at\":\"2014-11-17T02:59:40.298+07:00\"," +
            "\"state\":\"inactive\"," +
            "\"id\":\"02c08443-759f-4e5e-a66b-a7e8b0394c98\"" +
            "}," +
            "{" +
            "\"code\":\"raskin-sleman\"," +
            "\"name\":\"Raskin\"," +
            "\"region_id\":\"98fbf6e8-d63c-4494-97f6-1e99346f84e5\"," +
            "\"description\":\"\\u003cp\\u003eRaskin adalah program peningkatan ketahanan pangan dan memberikan perlindungan serta pengurangan beban pengeluaran masyarakat miskin terhadap biaya konsumsi makan khususnya beras.\\u003c/p\\u003e\"," +
            "\"objectives\":\"\\u003cp\\u003eMengurangi beban pengeluaran rumah tangga miskin (RTS) melalui pemenuhan sebagian kebutuhan pangan pokok dalam bentuk Beras.\\u003c/p\\u003e\"," +
            "\"legal_basis\":\"\\u003cul\\u003e\\u003cli\\u003eUU No. 8 Tahun 1985, tentang Organisasi Masyarakat\\u003c/li\\u003e\\u003cli\\u003eUU No. 18 Tahun 1986, tentang Pelaksanaan UU No 8 Tahun 1985\\u003c/li\\u003e\\u003cli\\u003eUU No 19 Tahun 2003, tentang Badan Usaha Milik Negara\\u003c/li\\u003e\\u003cli\\u003eUU No. 32 Tahun 2004, tentang Pemerintahan Daerah\\u003c/li\\u003e\\u003cli\\u003eUU No 18 Tahun 2012 tentang Pangan\\u003c/li\\u003e\\u003cli\\u003eUU tentang Anggaran Pendapatan dan Belanja Negara (APBN) tahun 2013\\u003c/li\\u003e\\u003cli\\u003ePP no. 68 Tahun 2002, Tentang Ketahanan Pangan\\u003c/li\\u003e\\u003cli\\u003ePP No. 7 Tahun 2003, Pendirian Perusahaan Umum BULOG\\u003c/li\\u003e\\u003cli\\u003ePP No. 58, Tahun 2005, tentang Pengelolaan keuangan Daerah\\u003c/li\\u003e\\u003cli\\u003ePP No. 38, Tahun 2007, tentang Pembagian Urusan Pemerintahan antara Pemerintah, Pemerintah Daerah Provinsi dan Pemerintah Daerah Kabupaten/kota\\u003c/li\\u003e\\u003cli\\u003ePeraturan Presiden RI no. 15 Tahun 2010, tentang Percepatan Penanggulangan Kemiskinan\\u003c/li\\u003e\\u003cli\\u003ePeraturan Presiden RI tentang Rencana Kerja Pemerintah Tahun 2013\\u003c/li\\u003e\\u003cli\\u003eInpres No. 3, Tahun 2012 tentang Kebijakan Pengadaan Gabah/ Beras dan Pengaluran Beras oleh Pemerintah\\u003c/li\\u003e\\u003cli\\u003ePermendagri mo. 59, tahun 2007 tentang Perubahan atas Peratruran Menteri Dalam Negeri No. 13 Tahun 2006 tentang Pedoman Pengelolaan Keuangan Daerah\\u003c/li\\u003e\\u003cli\\u003ePermenko Kesra Nol 59 Tahun 2012 tentang Tim Koordinasi Raskin Pusat\\u003c/li\\u003e\\u003c/ul\\u003e\"," +
            "\"beneficiaries_description\":\"\\u003cp\\u003eRumah Tangga Sasaran Penerima Manfaat (RTS-PM) Program RASKIN adalah Rumah Tangga yang berhak menerima beras dari Program RASKIN sesuai data yang diterbitkan dari Basis Data Terpadu hasil PPLS 2011 yang dikelola oleh Tim Nasional Percepatan Penanggulangan Kemiskinan (TNP2K), disahkan oleh Kemenko Kesra RI dan Rumah Tangga Hasil Pemutakhiran daftar penerima manfaat oleh musyawarah Desa/Kelurahan/Pemerintah setingkat.\\u003c/p\\u003e\"," +
            "\"benefit\":\"\\u003cp\\u003eManfaat yang diterima oleh\\u0026nbsp;Rumah Tangga\\u0026nbsp;Sasaran (RTS) berupa:\\u003c/p\\u003e\\u003cul\\u003e\\u003cli\\u003eMasing-masing RTS menerima 15 kg/bulan\\u003c/li\\u003e\\u003cli\\u003eDurasi waktu pendistribusian selama 12 bulan\\u003c/li\\u003e\\u003cli\\u003eHarga tebus bersa sebesar Rp 1.600,-/kg di titik distribusi.\\u003c/li\\u003e\\u003c/ul\\u003e\"," +
            "\"beneficiaries_number\":60485," +
            "\"institution\":\"Tim Koordinasi Raskin Pusat\"," +
            "\"contact_person\":\"\"," +
            "\"contact_person_title\":\"\"," +
            "\"contact_person_phone\":\"\"," +
            "\"local_institution\":\"Tim Koordinasi Raskin Kabupaten\"," +
            "\"local_contact_person\":\"Surono\"," +
            "\"local_contact_person_title\":\"Kepala Bidang Kesejahteraan Sosial, Dinas Sosial dan Tenaga Kerja Kabupaten Sleman\"," +
            "\"local_contact_person_phone\":\"08157936093\"," +
            "\"program_type\":\"national\"," +
            "\"created_at\":\"2014-11-02T21:42:01.068+07:00\"," +
            "\"updated_at\":\"2014-11-02T21:42:01.068+07:00\"," +
            "\"state\":\"inactive\"," +
            "\"id\":\"7ad6de9d-ec4d-4526-8c75-42fca6b42137\"" +
            "}," +
            "{" +
            "\"code\":\"bsm-smp-sleman\"," +
            "\"name\":\"BSM-SMP\"," +
            "\"region_id\":\"98fbf6e8-d63c-4494-97f6-1e99346f84e5\"," +
            "\"description\":\"\\u003cp\\u003eProgram Bantuan Siswa Miskin untuk Sekolah Menegah Pertama\\u003c/p\\u003e\"," +
            "\"objectives\":\"\\u003cul\\u003e\\u003cli\\u003eMembantu siswa SMP yang orang tuanya tidak mampu/miskin untuk memenuhi kebutuhan pribadi siswa selama duduk di bangku sekolah\\u003c/li\\u003e\\u003cli\\u003eMencegah siswa\\u0026nbsp; SMP dari kemungkinan pustus sekolah akibat kesulitan ekonomi\\u003c/li\\u003e\\u003cli\\u003eMemberi peluang dan kesempatan yang lebih besar kepada siswa untuk terus bersekolah hingga menyelesaikan pendidikan SMP\\u003c/li\\u003e\\u003cli\\u003eMembantu kelancaran program Sekolah.\\u003c/li\\u003e\\u003c/ul\\u003e\"," +
            "\"legal_basis\":\"\\u003cul\\u003e\\u003cli\\u003eUndang Undang \\u0026nbsp;No. 17 Tahun 2003, tentang Keuangan Negara\\u003c/li\\u003e\\u003cli\\u003eUndang Undang\\u0026nbsp; No. 20 Tahun\\u0026nbsp; 2003, tentang \\u0026nbsp;Sistem Pendidikan Nasional\\u003c/li\\u003e\\u003cli\\u003eUndang Undang\\u0026nbsp; No 32 Tahun 2004, tentang Pemerintahan Daerah\\u003c/li\\u003e\\u003cli\\u003eUndang Undang\\u0026nbsp; No 33 Tahun 2004\\u0026nbsp; tentang Perimbangan Keuangan antara PemerintahPusat dan Pemerintah Daerah\\u003c/li\\u003e\\u003cli\\u003ePeraturan Pemerintah\\u0026nbsp; no. 106, Tahun 2000, Tentang Pengelolaan dan Pertanggungjawaban Keuangan dalam pelaksanaan Dekonsentrasi dan Tugas Pembantuan\\u003c/li\\u003e\\u003cli\\u003ePeraturan Pemerintah Republik Indonesia no. 48 Tahun 2008, tentang\\u0026nbsp; Pendanaan Pendidikan\\u003c/li\\u003e\\u003cli\\u003ePeraturan Pemerintah\\u0026nbsp; No. 17, Tahun 2010, tentang Pengelolaan dan Penyelenggaraan Pendidikan\\u003c/li\\u003e\\u003cli\\u003eIntruksi Presiden Republik Indonesia No. 1, Tahun 1994 tentang Pelaksanaan Wajib Belajar Pendidikan Dasar\\u003c/li\\u003e\\u003cli\\u003eIntruksi Presiden Republik Indonesia No. 5, Tahun 2006 tentang\\u0026nbsp; Gerakan Nasional Percepatan Penuntasan Wajib Belajar Pendidikan Dasar 9 Tahun dan Buta Aksara\\u003c/li\\u003e\\u003cli\\u003eKeputusan Menko\\u0026nbsp; Kesra No. 22/KERP/MENKO/KESRA/IX/2006 tentang Pemberntukan Tim Koordinasi Nasional Percepatan Penuntasan Wajib Belajar Pendidikan Dasar 9 tahun dan Pemberantasan Buta Aksara\\u003c/li\\u003e\\u003cli\\u003eKeputusan Mentri Pendidikan Nasional no.044/U/2002\\u0026nbsp; Dewan Pendidikan dan Komite Sekolah\\u003c/li\\u003e\\u003cli\\u003ePeraturan Menteri PendidikanNasional\\u0026nbsp; no. 35, Tahun 2006 tentang Pedoman Pelaksanaan\\u0026nbsp; Gerakan Nasional Percepatan Penuntasan Wajib Belajar Pendidikan Dasar 9 Tahun\\u0026nbsp; dan Pemberantasan buta Aksara\\u003c/li\\u003e\\u003cli\\u003ePeraturan Menteri Pendidikan Nasional No. 69 Tahun\\u0026nbsp; 2009 tentang Standar Biaya Non Personalia Tahun 2009\\u0026nbsp; untuk SD/MI, SMP/MTs SMA/MA, SMK dan SDLB\\u003c/li\\u003e\\u003cli\\u003ePermendagri No. 60 Tahun 2011 tentang\\u0026nbsp; larangan Pungutan Biaya Pendidikan\\u0026nbsp; pada Sekolah Dasar\\u0026nbsp; dan Sekolah menengah Pertama\\u003c/li\\u003e\\u003cli\\u003ePeraturan tentang Indeks Kemiskinan Berita Resmi Statistik dari Badan Pusat Statistik (BPS) No. 06/01/TH.XV,2 Januari 2013\\u003c/li\\u003e\\u003c/ul\\u003e\"," +
            "\"beneficiaries_description\":\"\\u003cp\\u003eKriteria Penerima BSM 2013\\u003c/p\\u003e\\u003cul\\u003e\\u003cli\\u003ePada tahun2013/2014 berstatus sebagai siswa SMP\\u003c/li\\u003e\\u003cli\\u003eSiswa SMP ybs pada tahun pelajaran 2013/2014 adalah siswa kelas VII\\u003c/li\\u003e\\u003cli\\u003eMinimal tingkat kehadiran siswa di kelas 75%\\u003c/li\\u003e\\u003cli\\u003eYang terancam putus sekolah karena kesulitan biaya\\u003c/li\\u003e\\u003cli\\u003eTelah dibebaskan dari segala jenis iuran sekolah\\u003c/li\\u003e\\u003cli\\u003eOrang tua tidak mampu/miskin(diutamakan dari peserta PKH)\\u003c/li\\u003e\\u003cli\\u003eYatim dan atau Piatu\\u003c/li\\u003e\\u003cli\\u003ePertimbangan lain (mis: kelainan fisik, korban musibah berkepanjangan, anak dari koran PHK, mempunyai lebih dari 3 orang bersaudara yang berusia di bawah 18 tahun, atau indikator lokal lainnya)\\u003c/li\\u003e\\u003c/ul\\u003e\"," +
            "\"benefit\":\"\\u003cp\\u003eMasing-masing siwa penerima program BSM akan menerima sebesar Rp 375.000,- (Tiga ratus tujuh puluh lima ribu rupiah)\\u003c/p\\u003e\"," +
            "\"beneficiaries_number\":null," +
            "\"institution\":\"Direktur Pembinaan Sekolah Menengah Pertama, Direktorat Jenderal Pendidikan Dasar, Kementerian Pendidikan dan Kebudayaan\"," +
            "\"contact_person\":\"\"," +
            "\"contact_person_title\":\"\"," +
            "\"contact_person_phone\":\"021-5725707\"," +
            "\"local_institution\":\"Dinas Pendidikan Pemuda dan Olahraga Kabupaten Sleman\"," +
            "\"local_contact_person\":\"Sudiro\"," +
            "\"local_contact_person_title\":\"Kepala Seksi Kurikulum dan Kesiswaan\"," +
            "\"local_contact_person_phone\":\"081328210473\"," +
            "\"program_type\":\"national\"," +
            "\"created_at\":\"2014-11-02T21:42:01.108+07:00\"," +
            "\"updated_at\":\"2014-11-02T21:42:01.108+07:00\"," +
            "\"state\":\"inactive\"," +
            "\"id\":\"05af2aba-3047-47bb-88ab-f834cc35209f\"" +
            "}," +
            "{" +
            "\"code\":\"pkh-sleman\"," +
            "\"name\":\"PKH\"," +
            "\"region_id\":\"98fbf6e8-d63c-4494-97f6-1e99346f84e5\"," +
            "\"description\":\"\\u003cp\\u003eProgram Keluarga Harapan (PKH) merupakan program bantuan dan perlindungan sosial dalam upaya memotong generasi. PKH masuk yang masuk dalam klaster I strategi penanggulangan kemiskinan di Indonesia. PKH merupakan bantuan tunai bersyarat yang berkaitan dengan persyaratan pendidikan dan kesehatan.\\u003c/p\\u003e\"," +
            "\"objectives\":\"\\u003cp\\u003eTujuan Umum Program\\u003c/p\\u003e\\u003cp\\u003eMengurangi angka dan memutus rantai kemiskinan, meningkatkan kualitas sumber daya manusia, serta mengubah perilaku yang kurang mendukung peningkatan kesejahteraan dari kelompok paling miskin. Tujuan ini berkaitan langsung dengan upaya mempercepat pencapaian target Millennium Development Goals (MDGs).\\u0026nbsp;\\u003c/p\\u003e\\u003cp\\u003eTujuan Khusus Program\\u003c/p\\u003e\\u003cul\\u003e\\u003cli\\u003eMeningkatkan akses dan kualitas pelayanan pendidikan dan kesehatan bagi Peserta PKH\\u003c/li\\u003e\\u003cli\\u003eMeningkatkan taraf pendidikan Peserta PKH\\u003c/li\\u003e\\u003cli\\u003eMeningkatkan status kesehatan dan gizi ibu hamil (bumil), ibu nifas, bawah lima tahun (balita) dan anak prasekolah anggota Rumah Tangga Sangat Miskin (RTSM)/Keluarga Sangat Miskin (KSM)\\u0026nbsp;\\u003c/li\\u003e\\u003c/ul\\u003e\"," +
            "\"legal_basis\":\"\"," +
            "\"beneficiaries_description\":\"\\u003cp\\u003eProgram Keluarga Harapan (PKH) diberikan kepada Rumah Tangga Sangat Miskin (RTSM) yang sesuai dengan kriteria BPS dan memenuhi sedikitnya satu kriteria kepesertaan program di bawah ini: \\u0026nbsp;\\u003c/p\\u003e\\u003cul\\u003e\\u003cli\\u003eMemiliki ibu hamil/nifas.\\u0026nbsp;\\u003c/li\\u003e\\u003cli\\u003eMemiliki anak balita atau anak pra sekolah.\\u0026nbsp;\\u003c/li\\u003e\\u003cli\\u003eMemiliki anak usia SD dan/atau SLTP dan/atau anak 15-18 tahun yang belum menyelesaikan pendidikan dasar\\u003c/li\\u003e\\u003c/ul\\u003e\"," +
            "\"benefit\":\"\\u003cul\\u003e\\u003cli\\u003eBantuan Tetap: Rp 300.000,-\\u003c/li\\u003e\\u003cli\\u003eBantuan bagi RTSM/KSM yang memiliki anak usia di bawah 6 tahun, ibu hamil/menyusui: Rp 1.000.000,-\\u003c/li\\u003e\\u003cli\\u003eAnak peserta pendidikan setara SD/MI: Rp 500.000,-\\u003c/li\\u003e\\u003cli\\u003eAnak peserta pendidikan setara SMP/Mts: Rp 1.000.000,-\\u003c/li\\u003e\\u003cli\\u003eBantuan maksimum per RTSM/KSM: Rp 2.800.000,-\\u003c/li\\u003e\\u003cli\\u003eBantuan minimum per RTSM/KSM: Rp 800.000,-\\u003c/li\\u003e\\u003cli\\u003eRata-rata bantuan per RTSM/KSM: Rp 1.800.000,-\\u003c/li\\u003e\\u003c/ul\\u003e\"," +
            "\"beneficiaries_number\":3406," +
            "\"institution\":\"Kementerian Sosial Republik Indonesia\"," +
            "\"contact_person\":\"Emmy Widayanti\"," +
            "\"contact_person_title\":\"Direktur Jaminan Sosial\"," +
            "\"contact_person_phone\":\"021-3103591\"," +
            "\"local_institution\":\"Unit Pelaksana Program Keluarga Harapan Kabuptaen Sleman\"," +
            "\"local_contact_person\":\"Surono\"," +
            "\"local_contact_person_title\":\"Kepala Bidang Kesejahteraan Sosial, Dinas Sosial dan Tenaga Kerja Kabupaten Sleman\"," +
            "\"local_contact_person_phone\":\"08157936093\"," +
            "\"program_type\":\"national\"," +
            "\"created_at\":\"2014-11-02T21:42:01.146+07:00\"," +
            "\"updated_at\":\"2014-11-02T21:42:01.146+07:00\"," +
            "\"state\":\"inactive\"," +
            "\"id\":\"73bbc2b3-d093-4f53-baf1-b663ede4fa7c\"" +
            "}" +
            "]" +
            "}" +
            "}";


    public static final String FAMILY_INFO_MODELS = "{\"api_version\":\"1.0\"," +
            "\"data\":{\"resource\":\"person\",\"total_server_items\":595,\"items\":[{" +
            "\"full_name\":\"Afgan Cahyo Saputra\",\"gender\":\"1\",\"birthdate\":\"2012-02-09\",\"marital_status\":\"1\"," +
            "\"cellphone_number\":null,\"household_id\":\"73585acd-1784-4fff-ad32-00142084dddc\",\"household_seq\":null," +
            "\"relation_with_household_head\":\"3\",\"family_id\":\"73585acd-1784-4fff-ad32-00142084dddc\"," +
            "\"relation_with_family_head\":null,\"birthplace\":\"Sleman\",\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:42.129+07:00\",\"updated_at\":\"2014-11-27T12:05:42.808+07:00\"," +
            "\"id\":\"87e70ca9-a17c-4026-b930-15a75ca0fde3\"},{\"full_name\":\"Usup\",\"gender\":\"1\",\"birthdate\":\"1936-11-30\"," +
            "\"marital_status\":\"2\",\"cellphone_number\":null,\"household_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\"," +
            "\"household_seq\":null,\"relation_with_household_head\":\"1\",\"family_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\"," +
            "\"relation_with_family_head\":null,\"birthplace\":\"Sleman\",\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:43.175+07:00\",\"updated_at\":\"2014-11-27T12:05:42.828+07:00\"," +
            "\"id\":\"638aae27-8dc5-43b4-8741-f573a8612a15\"},{\"full_name\":\"Djumijem\",\"gender\":\"2\"," +
            "\"birthdate\":\"1938-12-31\",\"marital_status\":\"2\",\"cellphone_number\":null," +
            "\"household_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\",\"household_seq\":null," +
            "\"relation_with_household_head\":\"2\",\"family_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\"," +
            "\"relation_with_family_head\":null,\"birthplace\":\"Sleman\",\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:43.526+07:00\",\"updated_at\":\"2014-11-27T12:05:42.833+07:00\"," +
            "\"id\":\"79e5e158-1bf3-4947-898f-97b2624d59a8\"},{\"full_name\":\"Semi\",\"gender\":\"2\"," +
            "\"birthdate\":\"1970-05-04\",\"marital_status\":\"2\",\"cellphone_number\":null," +
            "\"household_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\",\"household_seq\":null,\"relation_with_household_head\":\"3\"," +
            "\"family_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\",\"relation_with_family_head\":null,\"birthplace\":\"Sleman\"," +
            "\"state\":\"udb_imported\",\"created_at\":\"2014-11-27T11:01:43.883+07:00\"," +
            "\"updated_at\":\"2014-11-27T12:05:42.837+07:00\",\"id\":\"739ab421-372d-45a8-84be-7342ca4d41c9\"},{" +
            "\"full_name\":\"Jumeno\",\"gender\":\"1\",\"birthdate\":\"1949-12-31\",\"marital_status\":\"2\"," +
            "\"cellphone_number\":null,\"household_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\",\"household_seq\":null," +
            "\"relation_with_household_head\":\"3\",\"family_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\"," +
            "\"relation_with_family_head\":null,\"birthplace\":\"Sleman\",\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:44.254+07:00\",\"updated_at\":\"2014-11-27T12:05:42.853+07:00\"," +
            "\"id\":\"b22a569f-16e2-4256-9871-79b6aa2fa4ed\"},{\"full_name\":\"Ny. Gito Pawiro\",\"gender\":\"2\"," +
            "\"birthdate\":\"1938-07-20\",\"marital_status\":\"2\",\"cellphone_number\":null," +
            "\"household_id\":\"0c062f4a-b143-4239-a31e-d631fd15a82f\",\"household_seq\":null," +
            "\"relation_with_household_head\":\"2\",\"family_id\":\"0c062f4a-b143-4239-a31e-d631fd15a82f\"," +
            "\"relation_with_family_head\":null,\"birthplace\":\"Sleman\",\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:45.782+07:00\",\"updated_at\":\"2014-11-27T12:05:42.869+07:00\"," +
            "\"id\":\"d19fc5fc-e506-4132-9708-91f127c91bb2\"},{\"full_name\":\"Sukarjo\",\"gender\":\"1\"," +
            "\"birthdate\":\"1969-12-03\",\"marital_status\":\"1\",\"cellphone_number\":null," +
            "\"household_id\":\"0c062f4a-b143-4239-a31e-d631fd15a82f\",\"household_seq\":null," +
            "\"relation_with_household_head\":\"3\",\"family_id\":\"0c062f4a-b143-4239-a31e-d631fd15a82f\"," +
            "\"relation_with_family_head\":null,\"birthplace\":\"Sleman\",\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:46.115+07:00\",\"updated_at\":\"2014-11-27T12:05:42.884+07:00\"," +
            "\"id\":\"e8eea9ad-c206-472b-b776-ab6f3ec7862a\"},{\"full_name\":\"Supangat\",\"gender\":\"1\"," +
            "\"birthdate\":\"1972-09-21\",\"marital_status\":\"1\",\"cellphone_number\":null," +
            "\"household_id\":\"0c062f4a-b143-4239-a31e-d631fd15a82f\",\"household_seq\":null," +
            "\"relation_with_household_head\":\"3\",\"family_id\":\"0c062f4a-b143-4239-a31e-d631fd15a82f\"," +
            "\"relation_with_family_head\":null,\"birthplace\":\"Sleman\",\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:46.472+07:00\",\"updated_at\":\"2014-11-27T12:05:42.892+07:00\"," +
            "\"id\":\"5da3256e-8cd9-4345-ba7a-ceb856c89bd4\"},{\"full_name\":\"Mulyorejo / Mugi Mulyono\",\"gender\":\"1\"," +
            "\"birthdate\":\"1937-12-11\",\"marital_status\":\"2\",\"cellphone_number\":null," +
            "\"household_id\":\"45358877-a3f7-44fe-b51b-294384e69d50\",\"household_seq\":null,\"relation_with_household_head\":\"1\"," +
            "\"family_id\":\"45358877-a3f7-44fe-b51b-294384e69d50\",\"relation_with_family_head\":null,\"birthplace\":\"Sleman\"," +
            "\"state\":\"udb_imported\",\"created_at\":\"2014-11-27T11:01:47.699+07:00\"," +
            "\"updated_at\":\"2014-11-27T12:05:42.897+07:00\",\"id\":\"e14a0b7e-f2ba-4d9c-924b-2fcfabe2d367\"},{" +
            "\"full_name\":\"Ny. Wagiyem / Mugimulyono\",\"gender\":\"2\",\"birthdate\":\"1939-04-08\",\"marital_status\":\"2\"," +
            "\"cellphone_number\":null,\"household_id\":\"45358877-a3f7-44fe-b51b-294384e69d50\",\"household_seq\":null," +
            "\"relation_with_household_head\":\"2\",\"family_id\":\"45358877-a3f7-44fe-b51b-294384e69d50\"," +
            "\"relation_with_family_head\":null,\"birthplace\":\"Sleman\",\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:48.035+07:00\",\"updated_at\":\"2014-11-27T12:05:42.909+07:00\"," +
            "\"id\":\"3dbcea29-fc87-44f9-babc-8c2ebd1377e3\"}]}}";

    @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    if (req.getRequestURI().endsWith("/db")) {
      showDatabase(req,resp);
    } else {
      showHome(req,resp);
    }
  }

  private void showHome(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.getWriter().print(Main.FAMILY_INFO_MODELS);
  }

  private void showDatabase(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Connection connection = null;
    try {
      connection = getConnection();

      Statement stmt = connection.createStatement();
      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
      stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
      ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

      String out = "Hello!";
      while (rs.next()) {
          out += "Read from DB: " + rs.getTimestamp("tick") + "";
      }

      resp.getWriter().print(out);
    } catch (Exception e) {
      resp.getWriter().print("There was an error: " + e.getMessage());
    } finally {
      if (connection != null) try{connection.close();} catch(SQLException e){}
    }
  }

  private Connection getConnection() throws URISyntaxException, SQLException {
    URI dbUri = new URI(System.getenv("DATABASE_URL"));

    String username = dbUri.getUserInfo().split(":")[0];
    String password = dbUri.getUserInfo().split(":")[1];
    int port = dbUri.getPort();

    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + port + dbUri.getPath();

    return DriverManager.getConnection(dbUrl, username, password);
  }

  public static void main(String[] args) throws Exception {
    Server server = new Server(Integer.valueOf(System.getenv("PORT")));
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    server.setHandler(context);
    context.addServlet(new ServletHolder(new Main()),"/*");
    server.start();
    server.join();
  }
}
