package tiketKonser;

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
    
    public void setHakAkses(String previlege) {
    	this.hakAkses = previlege;
    }
    
    public String getHakAkses() {
    	return hakAkses;
    }
    
    
}
