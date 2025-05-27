package TiketKonser;

public class Admin extends User {
    private String hakAkses;

    public Admin(int userId, String nama, String email, String password, String hakAkses) {
        super(userId, nama, email, password);
        this.hakAkses = hakAkses;
    }

    public void manageKonser() {
        System.out.println("Manage Konser");
    }

    public void manageOrder() {
        System.out.println("Manage Order");
    }

    public void verifikasiPembayaran() {
        System.out.println("Verifikasi Pembayaran");
    }

    public void kirimETicket() {
        System.out.println("Kirim E-Ticket");
    }

    // Getter dan Setter untuk hakAkses dapat ditambahkan jika perlu
}

}
