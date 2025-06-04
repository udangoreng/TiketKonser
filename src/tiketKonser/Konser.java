package tiketKonser;

import java.util.ArrayList;

public class Konser {
    private int konserId;
    private String namaKonser;
    private String tanggalKonser;
    private String waktuKonser;
    private String lokasi;
    private String deskripsi;
    private String filepathGambar;
    private ArrayList<Kategori> kategori;
    private static ArrayList<Konser> konserAll = new ArrayList<>();
    private static Konser lastAddedKonser = null;
    private static int nextId = 1;

    public Konser(int konserId, String namaKonser, String tanggalKonser, String waktuKonser,
                  String lokasi, String deskripsi, String gambar) {
        this.konserId = konserId;
        this.namaKonser = namaKonser;
        this.tanggalKonser = tanggalKonser;
        this.waktuKonser = waktuKonser;
        this.lokasi = lokasi;
        this.kategori = new ArrayList<>();
        this.deskripsi = deskripsi;
        this.filepathGambar = gambar;
    }
    
    static {
    	Konser.addKonser("Tulus", "2025-07-01", "20:00", "Stadium JIS", "Konser Tur Manusia oleh Tulus", "tulusKonser.jpg");
        Konser.addKonser("Bruno Mars", "2025-07-15", "19:00", "Madya Stadium", "Konser Bruno Mars World Tour", "brunoKonser.jpg");
//        Konser.addKonser("Hindia", "2025-08-01", "19:30", "Basket Hall Senayan", "Tur Album 'Lagipula Hidup Akan Berakhir'", "hindiaKonser.jpg");
//        Konser.addKonser("Taylor Swift", "2025-09-10", "20:00", "GBK Stadium", "The Eras Tour - Jakarta", "taylorKonser.jpg");
    }
    
    public static void addKonser(String nama, String tanggal, String waktu, String lokasi, String deskripsi, String gambar) {
        Konser konser = new Konser(nextId++, nama, tanggal, waktu, lokasi, deskripsi, gambar);
        konserAll.add(konser);
        lastAddedKonser = konser;
    }

    public static Konser getLastAddedKonser() {
        return lastAddedKonser;
    }
    
    public static ArrayList<Konser> getAllKonser() {
    	for (Konser konser : konserAll) {
            System.out.println("ID: " + konser.getKonserId() + ", Nama: " + konser.getNamaKonser());
        }
        return konserAll;
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

    public String getLokasiKonser() {
        return lokasi;
    }

    public void setLokasiKonser(String lokasi) {
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
	
	public String getFilepathGambar() {
        return filepathGambar;
    }

    public void setFilepathGambar(String gambar) {
        this.filepathGambar = gambar;
    }
}
