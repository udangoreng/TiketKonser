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
        Konser tulus = new Konser(nextId++, "Tulus", "01-07-2025", "20:00", "Stadium JIS", "Konser Tur Manusia oleh Tulus, menampilkan lagu-lagu hits dari album terbarunya.", "tulusKonser.jpg");
        ArrayList<Kategori> kategoriList1 = new ArrayList<>();
        kategoriList1.add(new Kategori("Festival", 550000, 2000));
        kategoriList1.add(new Kategori("CAT 1 (Numbered Seating)", 750000, 1000));
        kategoriList1.add(new Kategori("CAT 2 (Numbered Seating)", 450000, 1500));
        tulus.setKategori(kategoriList1);
        konserAll.add(tulus);
        
        Konser bruno = new Konser(nextId++, "Bruno Mars", "13-09-2025", "19:00", "Jakarta International Stadium", "Live in Jakarta, bagian dari tur dunia 24K Magic yang telah memenangkan berbagai penghargaan.", "brunoKonser.jpg");
        ArrayList<Kategori> kategoriList2 = new ArrayList<>();
        kategoriList2.add(new Kategori("Gold VIP Package", 7650000, 500));
        kategoriList2.add(new Kategori("CAT 1", 6000000, 800));
        kategoriList2.add(new Kategori("Festival A (Standing)", 3500000, 3000));
        kategoriList2.add(new Kategori("CAT 4", 1750000, 2000));
        kategoriList2.add(new Kategori("CAT 7 (Restricted View)", 950000, 1000));
        bruno.setKategori(kategoriList2);
        konserAll.add(bruno);

        Konser hindia = new Konser(nextId++, "Hindia", "01-08-2025", "19:30", "Basket Hall Senayan", "Tur Album 'Lagipula Hidup Akan Berakhir', sebuah perayaan musik dan cerita.", "hindiaKonser.jpg");
        ArrayList<Kategori> kategoriList3 = new ArrayList<>();
        kategoriList3.add(new Kategori("Festival (Standing)", 480000, 1500));
        kategoriList3.add(new Kategori("Tribun A", 320000, 1000));
        kategoriList3.add(new Kategori("Tribun B", 320000, 1000));
        hindia.setKategori(kategoriList3);
        konserAll.add(hindia);
        
        Konser taylor = new Konser(nextId++, "Taylor Swift", "20-11-2025", "20:00", "GBK Stadium", "The Eras Tour - Jakarta. Sebuah perjalanan musikal melewati semua era karirnya.", "taylorKonser.jpg");
        ArrayList<Kategori> kategoriList4 = new ArrayList<>();
        kategoriList4.add(new Kategori("CAT 1 (Karma is My Boyfriend)", 12500000, 200));
        kategoriList4.add(new Kategori("CAT 2 (It's a Love Story)", 8000000, 1000));
        kategoriList4.add(new Kategori("CAT 3 (You Belong With Me)", 6500000, 1500));
        kategoriList4.add(new Kategori("CAT 5 (Restricted View)", 4800000, 2500));
        taylor.setKategori(kategoriList4);
        konserAll.add(taylor);  
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
//    	for (Konser konser : konserAll) {
//            System.out.println("ID: " + konser.getKonserId() + ", Nama: " + konser.getNamaKonser());
//        }
        return konserAll;
    }
    
    public static Konser searchKonserById(int id) {
        for (Konser konser : konserAll) {
            if (konser.getKonserId() == id) {
                return konser;
            }
        }
        return null;
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
