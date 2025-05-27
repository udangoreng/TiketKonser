package tiketKonser;

public class Order {
    private int orderId;
    private int userId;
    private int konserId;
    private String statusBayar;

    public Order(int orderId, int userId, int konserId, String statusBayar) {
        this.orderId = orderId;
        this.userId = userId;
        this.konserId = konserId;
        this.statusBayar = statusBayar;
    }

    public void konfirmasi(int orderId) {
        System.out.println("konfirmasi");
        // Tambahkan logika jika diperlukan menggunakan orderId
    }

    public void generateVA() {
        System.out.println("generateVA");
        // Tambahkan logika pembuatan virtual account
    }

    public void buatOrder(int orderId, int konserId) {
        System.out.println("buatOrder");
        // Tambahkan logika pemesanan order
    }

    // Getter dan Setter (opsional)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getKonserId() {
        return konserId;
    }

    public void setKonserId(int konserId) {
        this.konserId = konserId;
    }

    public String getStatusBayar() {
        return statusBayar;
    }

    public void setStatusBayar(String statusBayar) {
        this.statusBayar = statusBayar;
    }
}
