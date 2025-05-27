package tiketKonser;

public class Konser {
    private int konserId;
    private String namaKonser;
    private String tanggalKonser;
    private String waktuKonser;
    private String lokasi;
    private double harga;
    private String jumlahKategori;
    private String deskripsi;
    private int jumlahSeat;

    public Konser(int konserId, String namaKonser, String tanggalKonser, String waktuKonser,
                  String lokasi, double harga, String jumlahKategori, int jumlahSeat, String deskripsi) {
        this.konserId = konserId;
        this.namaKonser = namaKonser;
        this.tanggalKonser = tanggalKonser;
        this.waktuKonser = waktuKonser;
        this.lokasi = lokasi;
        this.harga = harga;
        this.jumlahKategori = jumlahKategori;
        this.jumlahSeat = jumlahSeat;
        this.deskripsi = deskripsi;
    }

    public void tampilkanAllKonser() {
        System.out.println("tampilkanAllkonser");
    }

    public void tampilkanDetailKonser() {
        System.out.println("tampilkanDetailkonser");
    }

    // Getter dan Setter (opsional)
    public int getKonserId() {
        return konserId;
    }

    public void setKonserId(int konserId) {
        this.konserId = konserId;
    }

    public String getNamaKonser() {
        return namaKonser;
    }

    public void setNamaKonser(String namaKonser) {
        this.namaKonser = namaKonser;
    }

    public String getTanggalKonser() {
        return tanggalKonser;
    }

    public void setTanggalKonser(String tanggalKonser) {
        this.tanggalKonser = tanggalKonser;
    }

    public String getWaktuKonser() {
        return waktuKonser;
    }

    public void setWaktuKonser(String waktuKonser) {
        this.waktuKonser = waktuKonser;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getJumlahKategori() {
        return jumlahKategori;
    }

    public void setJumlahKategori(String jumlahKategori) {
        this.jumlahKategori = jumlahKategori;
    }

    public int getJumlahSeat() {
        return jumlahSeat;
    }

    public void setJumlahSeat(int jumlahSeat) {
        this.jumlahSeat = jumlahSeat;
    }
}
