package tiketKonser;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MetodePembayaranInterface extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MetodePembayaranInterface frame = new MetodePembayaranInterface();
                frame.setVisible(true);
                frame.setSize(1024, 678);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MetodePembayaranInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1166, 737);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(26, 21, 24));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Judul
        JLabel lblTitle = new JLabel("Metode Pembayaran");
        lblTitle.setFont(new Font("Poppins", Font.BOLD, 24));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(630, 208, 400, 40);
        contentPane.add(lblTitle);

        // ComboBox metode pembayaran
        JComboBox<String> comboBoxMetode = new JComboBox<>();
        comboBoxMetode.setFont(new Font("Poppins", Font.PLAIN, 14));
        comboBoxMetode.setBounds(630, 301, 250, 30);
        comboBoxMetode.addItem("Pilih Metode Pembayaran");
        comboBoxMetode.addItem("Transfer Bank");
        comboBoxMetode.addItem("Kartu Debit");
        comboBoxMetode.addItem("Virtual Account");
        contentPane.add(comboBoxMetode);

        // Label bank (default: hidden)
        JLabel lblBank = new JLabel("Pilih Bank:");
        lblBank.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblBank.setForeground(Color.WHITE);
        lblBank.setBounds(630, 337, 200, 25);
        lblBank.setVisible(false);
        contentPane.add(lblBank);

        // ComboBox bank (default: hidden)
        JComboBox<String> comboBoxBank = new JComboBox<>();
        comboBoxBank.setFont(new Font("Poppins", Font.PLAIN, 14));
        comboBoxBank.setBounds(630, 357, 250, 30);
        comboBoxBank.setVisible(false);
        contentPane.add(comboBoxBank);

        // Action listener metode pembayaran
        comboBoxMetode.addActionListener(e -> {
            String selected = (String) comboBoxMetode.getSelectedItem();

            if (!selected.equals("Pilih Metode Pembayaran")) {
                // Tampilkan pilihan bank
                comboBoxBank.removeAllItems();
                comboBoxBank.addItem("BCA");
                comboBoxBank.addItem("BRI");
                comboBoxBank.addItem("BNI");
                comboBoxBank.addItem("MANDIRI");

                lblBank.setVisible(true);
                comboBoxBank.setVisible(true);
            } else {
                lblBank.setVisible(false);
                comboBoxBank.setVisible(false);
            }
        });

        // Tombol konfirmasi
        JButton btnKonfirmasi = new JButton("Konfirmasi");
        btnKonfirmasi.setFont(new Font("Poppins", Font.BOLD, 14));
        btnKonfirmasi.setBackground(new Color(255, 255, 255));
        btnKonfirmasi.setForeground(new Color(0, 0, 0));
        btnKonfirmasi.setBounds(630, 435, 250, 35);
        contentPane.add(btnKonfirmasi);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(81, 20, 101));
        panel.setForeground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 469, 700);
        panel.setLayout(null);
        contentPane.add(panel);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 469, 700);
        panel.add(layeredPane);

        // Layer 0: Gambar latar belakang
        JLabel lblNewLabel_7 = new JLabel();
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\hasnatyam\\Downloads\\download (4).jpg"));
        lblNewLabel_7.setBounds(0, 0, 469, 712);
        layeredPane.add(lblNewLabel_7, Integer.valueOf(0)); // background layer

        // Layer 1: Gambar depan
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\hasnatyam\\Downloads\\download.jpg");
        Image image = originalIcon.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setBounds(89, 71, 281, 369);
        lblNewLabel.setIcon(new ImageIcon(image));
        layeredPane.add(lblNewLabel, Integer.valueOf(1)); // foreground image

        // Layer 2: Teks di atas semuanya
        JLabel lblNewLabel_1 = new JLabel("Detail Pembelian");
        lblNewLabel_1.setBounds(122, 36, 193, 24);
        lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 20));
        lblNewLabel_1.setForeground(Color.WHITE);
        layeredPane.add(lblNewLabel_1, Integer.valueOf(2));

        JLabel lblNewLabel_4 = new JLabel("Harga : Rp 7.650.000");
        lblNewLabel_4.setBounds(29, 514, 193, 24);
        lblNewLabel_4.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNewLabel_4.setForeground(Color.WHITE);
        layeredPane.add(lblNewLabel_4, Integer.valueOf(2));

        JLabel lblNewLabel_5 = new JLabel("Order Id: 12345");
        lblNewLabel_5.setBounds(29, 474, 160, 14);
        lblNewLabel_5.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNewLabel_5.setForeground(Color.WHITE);
        layeredPane.add(lblNewLabel_5, Integer.valueOf(2));

        JLabel lblNewLabel_2 = new JLabel("Bruno Mars - JAKARTA INTERNASIONAL STADIUM");
        lblNewLabel_2.setBounds(29, 430, 493, 58);
        lblNewLabel_2.setFont(new Font("Poppins Medium", Font.BOLD, 15));
        lblNewLabel_2.setForeground(Color.WHITE);
        layeredPane.add(lblNewLabel_2, Integer.valueOf(2));

        JLabel lblNewLabel_3 = new JLabel("Kategori Seat: Gold VIP Package");
        lblNewLabel_3.setBounds(29, 491, 252, 24);
        lblNewLabel_3.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNewLabel_3.setForeground(Color.WHITE);
        layeredPane.add(lblNewLabel_3, Integer.valueOf(2));
        
        JLabel lblNewLabel_6 = new JLabel("Pilih Metode Pembayaran");
        lblNewLabel_6.setFont(new Font("Poppins", Font.PLAIN, 13));
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setBounds(630, 288, 173, 14);
        contentPane.add(lblNewLabel_6);

        // Aksi tombol konfirmasi
        btnKonfirmasi.addActionListener(e -> {
            String metode = (String) comboBoxMetode.getSelectedItem();
            String bank = comboBoxBank.isVisible() ? (String) comboBoxBank.getSelectedItem() : "-";
            JOptionPane.showMessageDialog(this, "Metode: " + metode + "\nBank: " + bank);
        });
    }
}
