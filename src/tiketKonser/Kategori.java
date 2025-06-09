package tiketKonser;

public class Kategori {
	private String nama;
	private int jumlah;
	private double harga;
	
	public Kategori(String namaKategori, int jumlahSeat, double harga) {
        this.nama = namaKategori;
        this.jumlah = jumlahSeat;
        this.harga = harga;
    }

    public String getNamaKategori() {
        return nama;
    }

    public int getJumlahSeat() {
        return jumlah;
    }

    public double getHarga() {
        return harga;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s", this.nama, this.harga);
    }

}
