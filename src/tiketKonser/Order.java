package tiketKonser;

import java.util.ArrayList;

public class Order {
    private int orderId;
    private int userId;
    private int konserId;
    private double total;
    private String statusBayar;
    private String kategoriTiket;
    
    private static ArrayList<Order> orders = new ArrayList<>();
    private static int nextOrderId = 1;

    // Constructor yang diperlukan!
    public Order(int userId, int konserId, String statusBayar, String kategori, double total) {
        this.orderId = nextOrderId++;
        this.userId = userId;
        this.konserId = konserId;
        this.statusBayar = statusBayar;
        this.kategoriTiket = kategori;
        this.total = total;
        orders.add(this);
    }

    public static Order buatOrder(int userId, int konserId, String kategori, double total) {
        Order newOrder = new Order(userId, konserId, "Belum Bayar", kategori, total);
        System.out.println("Order berhasil dibuat. Order ID: " + newOrder.getOrderId());
        return newOrder;
    }
    
    static {
    	Order.buatOrder(1, 1, "VIP A", 45000);
    	Order.buatOrder(2, 1, "Standing", 25000);
    }

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
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public static ArrayList<Order> getOrdersByUserId(int userId) {
        ArrayList<Order> userOrders = new ArrayList<>();
        for (Order o : orders) {
            if (o.getUserId() == userId) {
                userOrders.add(o);
            }
        }
        return userOrders;
    }
    
    public static Order getOrderById(int id) {
    	for (Order order : orders) {
    		if(order.orderId == id) {
    			return order;
    		}
    	}
    	return null;
    }
    
    public static ArrayList<Order> getAllOrder(){
    	return orders;
    }
}
