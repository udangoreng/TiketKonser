package tiketKonser;

import java.util.ArrayList;

public class Order {
    private int orderId;
    private int userId;
    private int konserId;
    private String statusBayar;
    
    private static ArrayList<Order> orders = new ArrayList<>();
    private static int nextOrderId = 1;

    // Constructor yang diperlukan!
    public Order(int userId, int konserId, String statusBayar) {
        this.orderId = nextOrderId++;
        this.userId = userId;
        this.konserId = konserId;
        this.statusBayar = statusBayar;
        orders.add(this);
    }

    public static Order buatOrder(int userId, int konserId) {
        Order newOrder = new Order(userId, konserId, "Belum Bayar");
        System.out.println("Order berhasil dibuat. Order ID: " + newOrder.getOrderId());
        return newOrder;
    }

    // Method untuk konfirmasi pembayaran
    public void konfirmasiBayar() {
        if (!statusBayar.equalsIgnoreCase("Sudah Bayar")) {
            this.statusBayar = "Sudah Bayar";
            System.out.println("Pembayaran berhasil dikonfirmasi untuk Order ID: " + orderId);
        } else {
            System.out.println("Order ID " + orderId + " sudah dibayar.");
        }
    }

    // Method untuk generate Virtual Account (dummy)
    public void generateVA() {
        String vaNumber = "VA" + orderId + konserId + userId;
        System.out.println("Virtual Account untuk Order ID " + orderId + ": " + vaNumber);
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
    
    // Tambahan: mencari order berdasarkan userId
    public static ArrayList<Order> getOrdersByUserId(int userId) {
        ArrayList<Order> userOrders = new ArrayList<>();
        for (Order o : orders) {
            if (o.getUserId() == userId) {
                userOrders.add(o);
            }
        }
        return userOrders;
    }
}
