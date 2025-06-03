package tiketKonser;

import java.util.ArrayList;

public class Konser {
    private int konserId;
    private String namaKonser;
    private String tanggalKonser;
    private String waktuKonser;
    private String lokasi;
    private ArrayList<Kategori> kategori;
    private String deskripsi;
    private static ArrayList<Konser> konserAll = new ArrayList<>();
    private static int nextId = 1;

    public Konser(int konserId, String namaKonser, String tanggalKonser, String waktuKonser,
                  String lokasi, String deskripsi) {
        this.konserId = konserId;
        this.namaKonser = namaKonser;
        this.tanggalKonser = tanggalKonser;
        this.waktuKonser = waktuKonser;
        this.lokasi = lokasi;
        this.kategori = new ArrayList<>();
        this.deskripsi = deskripsi;
    }
    
    public static void addKonser(String nama, String tanggal, String waktu, String lokasi, String deskripsi) {
        Konser konser = new Konser(nextId++, nama, tanggal, waktu, lokasi, deskripsi);
        konserAll.add(konser);
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

    public ArrayList<Kategori> getKategoriList() {
        return kategori;
    }
    
    public void setKategori (ArrayList<Kategori> kategori) {
        this.kategori = kategori;
   }

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	
    public static ArrayList<Konser> getAllKonser() {
        return konserAll;
    }
}
