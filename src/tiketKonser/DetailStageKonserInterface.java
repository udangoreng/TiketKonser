package tiketKonser;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class DetailStageKonserInterface extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Konser currentKonser;
    private User currentUser;

    // UI components that need to be updated
    private JLabel lblConcertTitle;
    private JComboBox<Kategori> comboBoxKategori; // Store Kategori objects
    private JTextArea textAreaKategoriDetails;

    /**
     * Launch the application for testing.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Get a sample user and concert for testing
                    User testUser = User.searchUserById(1); // Assumes user with ID 1 exists
                    Konser testKonser = Konser.searchKonserById(2); // Assumes Bruno Mars (ID 2) exists

                    if (testUser != null && testKonser != null) {
                        DetailStageKonserInterface frame = new DetailStageKonserInterface(testKonser, testUser);
                        frame.setVisible(true);
                        frame.setSize(1024, 678);
                        frame.setLocationRelativeTo(null);
                    } else {
                        System.err.println("Test User or Konser not found. Cannot run test.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Default constructor.
     */
    public DetailStageKonserInterface() {
        initComponents();
    }

    /**
     * Preferred constructor to create a dynamic interface.
     * @param konser The Konser object to display details for.
     * @param user The currently logged-in User.
     */
    public DetailStageKonserInterface(Konser konser, User user) {
        this(); // Calls initComponents
        this.currentKonser = konser;
        this.currentUser = user;
        populateData(); // Populate the UI with dynamic data
    }

    /**
     * Fills the UI components with data from the currentKonser object.
     */
    private void populateData() {
        if (currentKonser == null) {
            JOptionPane.showMessageDialog(this, "Informasi konser tidak tersedia.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        lblConcertTitle.setText("Stage Konser " + currentKonser.getNamaKonser());

        comboBoxKategori.removeAllItems();
        comboBoxKategori.addItem(new Kategori("Pilih Kategori...", 0, 0));
        for (Kategori kat : currentKonser.getKategoriList()) {
            comboBoxKategori.addItem(kat);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Kategori Tiket Tersedia untuk\n")
          .append(currentKonser.getNamaKonser()).append(":\n\n");
        
        Locale localeID = new Locale("in", "ID");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeID);

        for (Kategori kat : currentKonser.getKategoriList()) {
            String formattedPrice = currencyFormatter.format(kat.getHarga());
            sb.append(String.format("- %-30s: %s\n", kat.getNamaKategori(), formattedPrice));
        }
        sb.append("\nCatatan:\n")
          .append("- Harga belum termasuk pajak & biaya platform.\n")
          .append("- Tata letak tempat duduk dapat berubah.\n");
        
        textAreaKategoriDetails.setText(sb.toString());
        textAreaKategoriDetails.setCaretPosition(0);
    }

    /**
     * Initializes all GUI components.
     */
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 678); // Set a standard size
        contentPane = new JPanel();
        contentPane.setBackground(new Color(26, 21, 24));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblStageImage = new JLabel();
        ImageIcon originalIcon = new ImageIcon("./img/stage.jpg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        lblStageImage.setIcon(new ImageIcon(scaledImage));
        lblStageImage.setBounds(23, 79, 500, 400);
        contentPane.add(lblStageImage);

        lblConcertTitle = new JLabel("Stage Konser"); // Placeholder text
        lblConcertTitle.setFont(new Font("Poppins", Font.BOLD, 25));
        lblConcertTitle.setForeground(new Color(255, 255, 255));
        lblConcertTitle.setBounds(23, 11, 500, 62);
        contentPane.add(lblConcertTitle);

        JLabel lblDetailStageImage = new JLabel("");
        ImageIcon icon = new ImageIcon("./img/detailStage.jpg");
        Image scaledImage1 = icon.getImage().getScaledInstance(500, 100, Image.SCALE_SMOOTH);
        lblDetailStageImage.setIcon(new ImageIcon(scaledImage1));
        lblDetailStageImage.setBounds(23, 502, 500, 163);
        contentPane.add(lblDetailStageImage);

        comboBoxKategori = new JComboBox<>();
        comboBoxKategori.setFont(new Font("Poppins", Font.PLAIN, 14));
        comboBoxKategori.setBounds(588, 515, 387, 30); // Wider combo box
        contentPane.add(comboBoxKategori);

        JLabel lblPilihKategori = new JLabel("Pilih Kategori Seat");
        lblPilihKategori.setFont(new Font("Poppins", Font.PLAIN, 13));
        lblPilihKategori.setForeground(new Color(255, 255, 255));
        lblPilihKategori.setBounds(588, 495, 167, 14);
        contentPane.add(lblPilihKategori);

        JLabel lblDeskripsi = new JLabel("Deskripsi:");
        lblDeskripsi.setFont(new Font("Poppins", Font.PLAIN, 13));
        lblDeskripsi.setForeground(new Color(255, 255, 255));
        lblDeskripsi.setBounds(23, 484, 118, 14);
        contentPane.add(lblDeskripsi);

        JButton btnPesan = new JButton("Pesan");
        btnPesan.setFont(new Font("Poppins", Font.BOLD, 13));
        btnPesan.setBounds(588, 560, 120, 35);
        btnPesan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object selectedItem = comboBoxKategori.getSelectedItem();
                if (selectedItem instanceof Kategori) {
                    Kategori selectedKategori = (Kategori) selectedItem;
                    if (selectedKategori.getHarga() <= 0) {
                        JOptionPane.showMessageDialog(DetailStageKonserInterface.this, "Silakan pilih kategori tiket yang valid.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    Order newOrder = Order.buatOrder(currentUser.getUserId(), currentKonser.getKonserId(), "Belum Bayar", selectedKategori.getHarga());
                    
                    new MetodePembayaranInterface().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(DetailStageKonserInterface.this, "Pilihan kategori tidak valid.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        contentPane.add(btnPesan);

        textAreaKategoriDetails = new JTextArea();
        textAreaKategoriDetails.setEditable(false);
        textAreaKategoriDetails.setBackground(new Color(40, 35, 39));
        textAreaKategoriDetails.setForeground(Color.WHITE);
        textAreaKategoriDetails.setFont(new Font("Monospaced", Font.PLAIN, 13)); // Use monospaced for alignment
        textAreaKategoriDetails.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(textAreaKategoriDetails);
        scrollPane.setBounds(588, 79, 400, 400);
        scrollPane.setBorder(null);
        contentPane.add(scrollPane);
    }
}