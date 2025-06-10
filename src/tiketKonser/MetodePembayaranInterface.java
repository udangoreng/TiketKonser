package tiketKonser;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class MetodePembayaranInterface extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    // Data fields to store the context
    private Order currentOrder;
    private User currentUser;

    // UI components that need to be updated dynamically
    private JLabel lblConcertImage;
    private JLabel lblConcertTitleAndVenue;
    private JLabel lblOrderId;
    private JLabel lblCategory;
    private JLabel lblPrice;
    private JComboBox<String> comboBoxMetode;
    private JComboBox<String> comboBoxBank;
    private JLabel lblBank;

    /**
     * Launch the application for testing purposes.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                // --- For Testing This Interface Directly ---
                // 1. Get a sample user and order
                User testUser = User.searchUserById(1); // Assuming user with ID 1 exists
                Order testOrder = Order.getOrderById(1); // Assuming order with ID 1 exists
                
                if (testUser != null && testOrder != null) {
                    MetodePembayaranInterface frame = new MetodePembayaranInterface(testOrder, testUser);
                    frame.setSize(1024, 678);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } else {
                    System.err.println("Test User or Order not found. Cannot run MetodePembayaranInterface test.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    /**
     * Default constructor.
     */
    public MetodePembayaranInterface() {
        initComponents();
    }
    
    /**
     * Preferred constructor that accepts the order and user context.
     * @param order The order being processed.
     * @param user The user who made the order.
     */
    public MetodePembayaranInterface(Order order, User user) {
        this(); // Calls initComponents
        this.currentOrder = order;
        this.currentUser = user;
        populateData(); // Fill the UI with dynamic data from the objects
    }
    
    /**
     * Populates the UI components with data from the currentOrder and currentUser.
     */
    private void populateData() {
        if (currentOrder == null) {
            JOptionPane.showMessageDialog(this, "Data order tidak valid.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Konser konser = Konser.searchKonserById(currentOrder.getKonserId());
        if (konser == null) {
            JOptionPane.showMessageDialog(this, "Data konser untuk order ini tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Find the category name by matching the price from the order
        String kategoriNama = "Unknown Category";
        for (Kategori kat : konser.getKategoriList()) {
            if (kat.getHarga() == currentOrder.getTotal()) {
                kategoriNama = kat.getNamaKategori();
                break;
            }
        }

        Locale localeID = new Locale("in", "ID");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeID);
        String formattedPrice = currencyFormatter.format(currentOrder.getTotal());
        
        lblConcertTitleAndVenue.setText("<html>" + konser.getNamaKonser() + " - " + konser.getLokasiKonser() + "</html>");
        lblOrderId.setText("Order ID: " + currentOrder.getOrderId());
        lblCategory.setText("Kategori Seat: " + kategoriNama);
        lblPrice.setText("Harga : " + formattedPrice);
        
        try {
            ImageIcon originalIcon = new ImageIcon("./img/" + konser.getFilepathGambar());
            Image resizedImage = originalIcon.getImage().getScaledInstance(309, 356, Image.SCALE_SMOOTH);
            lblConcertImage.setIcon(new ImageIcon(resizedImage));
        } catch (Exception e) {
            lblConcertImage.setIcon(null);
            lblConcertImage.setText("Image not found");
        }
    }

    /**
     * Create the frame.
     */
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 678);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBackground(new Color(26, 21, 24));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // --- Main Content Panel (Right side) ---
        JLabel lblTitle = new JLabel("Metode Pembayaran");
        lblTitle.setFont(new Font("Poppins", Font.BOLD, 30));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(547, 81, 400, 40);
        contentPane.add(lblTitle);

        comboBoxMetode = new JComboBox<>();
        comboBoxMetode.setBackground(Color.WHITE);
        comboBoxMetode.setFont(new Font("Poppins", Font.PLAIN, 14));
        comboBoxMetode.setBounds(527, 201, 400, 40);
        comboBoxMetode.addItem("Pilih Metode Pembayaran");
        comboBoxMetode.addItem("Transfer Bank");
        comboBoxMetode.addItem("Kartu Debit");
        comboBoxMetode.addItem("Virtual Account");
        contentPane.add(comboBoxMetode);

        lblBank = new JLabel("Pilih Bank:");
        lblBank.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblBank.setForeground(Color.WHITE);
        lblBank.setBounds(527, 260, 200, 25); // Adjusted Y
        lblBank.setVisible(false);
        contentPane.add(lblBank);

        comboBoxBank = new JComboBox<>();
        comboBoxBank.setFont(new Font("Poppins", Font.PLAIN, 14));
        comboBoxBank.setBounds(527, 290, 400, 40); // Adjusted Y
        comboBoxBank.setVisible(false);
        contentPane.add(comboBoxBank);

        comboBoxMetode.addActionListener(e -> {
            String selected = (String) comboBoxMetode.getSelectedItem();
            boolean isBankMethod = selected.equals("Transfer Bank") || selected.equals("Virtual Account");
            
            lblBank.setVisible(isBankMethod);
            comboBoxBank.setVisible(isBankMethod);

            if (isBankMethod) {
                comboBoxBank.removeAllItems();
                comboBoxBank.addItem("BCA");
                comboBoxBank.addItem("BRI");
                comboBoxBank.addItem("BNI");
                comboBoxBank.addItem("MANDIRI");
            }
        });
        
        JButton btnKonfirmasi = new JButton("Konfirmasi Pembayaran");
        btnKonfirmasi.setForeground(new Color(255, 255, 255));
        btnKonfirmasi.setFont(new Font("Poppins", Font.BOLD, 16));
        btnKonfirmasi.setBackground(new Color(81, 20, 101));
        btnKonfirmasi.setBounds(527, 415, 400, 45); // Adjusted size and position
        contentPane.add(btnKonfirmasi);
        
        JLabel lblPilihMetode = new JLabel("Pilih Metode Pembayaran");
        lblPilihMetode.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblPilihMetode.setForeground(new Color(255, 255, 255));
        lblPilihMetode.setBounds(527, 176, 263, 25);
        contentPane.add(lblPilihMetode);

        // --- Left Sidebar Panel ---
        JPanel panel = new JPanel();
        panel.setBackground(new Color(81, 20, 101));
        panel.setForeground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 469, 700);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 469, 700);
        panel.add(layeredPane);
        
        JLabel lblDetailTitle = new JLabel("Detail Pembelian");
        lblDetailTitle.setBounds(89, 36, 281, 30);
        lblDetailTitle.setFont(new Font("Poppins", Font.BOLD, 30));
        lblDetailTitle.setForeground(Color.WHITE);
        layeredPane.add(lblDetailTitle, Integer.valueOf(1));

        lblPrice = new JLabel("Harga : Rp 0");
        lblPrice.setBounds(10, 533, 449, 24); // Increased width
        lblPrice.setFont(new Font("Poppins Medium", Font.PLAIN, 18));
        lblPrice.setForeground(Color.WHITE);
        layeredPane.add(lblPrice, Integer.valueOf(1));

        lblOrderId = new JLabel("Order Id: #");
        lblOrderId.setBounds(10, 486, 449, 24);
        lblOrderId.setFont(new Font("Poppins Medium", Font.PLAIN, 18));
        lblOrderId.setForeground(Color.WHITE);
        layeredPane.add(lblOrderId, Integer.valueOf(1));

        lblConcertTitleAndVenue = new JLabel("Nama Konser - Venue");
        lblConcertTitleAndVenue.setBounds(10, 432, 449, 58);
        lblConcertTitleAndVenue.setFont(new Font("Poppins Medium", Font.BOLD, 17));
        lblConcertTitleAndVenue.setForeground(Color.WHITE);
        layeredPane.add(lblConcertTitleAndVenue, Integer.valueOf(1));

        lblCategory = new JLabel("Kategori Seat: -");
        lblCategory.setBounds(10, 510, 449, 24);
        lblCategory.setFont(new Font("Poppins Medium", Font.PLAIN, 18));
        lblCategory.setForeground(Color.WHITE);
        layeredPane.add(lblCategory, Integer.valueOf(1));
        
        lblConcertImage = new JLabel("Loading image...");
        lblConcertImage.setHorizontalAlignment(JLabel.CENTER);
        lblConcertImage.setBounds(61, 81, 309, 356);
        layeredPane.add(lblConcertImage, Integer.valueOf(1));

        btnKonfirmasi.addActionListener(e -> {
            if (currentOrder == null) {
                JOptionPane.showMessageDialog(this, "Tidak ada data order untuk diproses.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String metode = (String) comboBoxMetode.getSelectedItem();
            if (metode.equals("Pilih Metode Pembayaran")) {
                JOptionPane.showMessageDialog(this, "Silakan pilih metode pembayaran terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String bank = "-";
            if (comboBoxBank.isVisible()) {
                bank = (String) comboBoxBank.getSelectedItem();
            }

            String paymentCode = currentOrder.generateVA();
            currentOrder.setStatusBayar("Belum Terbayar");
            System.out.println("Order #" + currentOrder.getOrderId() + " status updated to Paid.");

            String vaMessage = "<html><b>Pembayaran Berhasil!</b><br><br>" +
                               "Silakan selesaikan pembayaran Anda.<br><br>" +
                               "<b>Metode:</b> " + metode + "<br>" +
                               "<b>Bank:</b> " + bank + "<br>" +
                               "<b>Nomor Virtual Account:</b> <font color=blue>" + paymentCode + "</font><br>" +
                               "<b>Total:</b> " + String.format("Rp %,.0f", currentOrder.getTotal()) + "<br><br>" +
                               "Tiket Anda telah diterbitkan.</html>";
                               
            JOptionPane.showMessageDialog(this, vaMessage, "Instruksi Pembayaran", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new DashboardInterface(currentUser).setVisible(true);
        });
    }
}