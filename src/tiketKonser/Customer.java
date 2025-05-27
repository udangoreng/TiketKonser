package tiketKonser;

public class Customer extends User {
    private String gender;
    private String tanggalLahir;
    private String noTelp;

    public Customer(int userId, String nama, String email, String password, String gender, String tanggalLahir, String noTelp) {
        super(userId, nama, email, password);
        this.gender = gender;
        this.tanggalLahir = tanggalLahir;
        this.noTelp = noTelp;
    }

    public void lihatKonser() {
        System.out.println("Lihat Semua Konser");
    }

    public void pesanTiket() {
        System.out.println("Pesan Tiket");
    }

    // Getter dan Setter opsional
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
}
