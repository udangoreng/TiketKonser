package tiketKonser;

public class Ticket {
	private int tiketId;
    private int orderId;
    private int konserId;
    private String kodeEticket;
    private String metodePembayaran;
    private double totalBayar;
    private String statusPembayaran;
    private String seatNumber;

    public Ticket(int tiketId, int orderId, int konserId, String kodeEticket, String metodePembayaran,double totalBayar, String statusPembayaran, String seatNumber) {
        this.tiketId = tiketId;
        this.orderId = orderId;
        this.konserId = konserId;
        this.kodeEticket = kodeEticket;
        this.metodePembayaran = metodePembayaran;
        this.totalBayar = totalBayar;
        this.statusPembayaran = statusPembayaran;
        this.seatNumber = seatNumber;
}
    public void checkKetersediaan() {
        System.out.println("checkKetersediaan");
    }

    public void generateETicket() {
        System.out.println("generateEticket");
    }

    public void kirimETicket() {
        System.out.println("kirimETicket");
    }

    // Getter dan Setter (opsional, bisa ditambahkan jika diperlukan)
    public int getTiketId() {
        return tiketId;
    }

    public void setTiketId(int tiketId) {
        this.tiketId = tiketId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getKonserId() {
        return konserId;
    }

    public void setKonserId(int konserId) {
        this.konserId = konserId;
    }

    public String getKodeEticket() {
        return kodeEticket;
    }

    public void setKodeEticket(String kodeEticket) {
        this.kodeEticket = kodeEticket;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }

    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
