package tiketKonser;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DaftarKonserInterface extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblHiUsername; // Make it an instance variable to access it in the constructor
    private User currentUser; // To store the currently logged-in user

    /**
     * Main method for direct testing (will show default username).
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                // When running directly, no user is passed, so it uses the default constructor.
                DaftarKonserInterface frame = new DaftarKonserInterface();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Default constructor: Initializes components.
     * Called when no user is passed (e.g., direct execution via main).
     */
    public DaftarKonserInterface() {
        initComponents(); // Call a common method to initialize GUI components
        // lblHiUsername will retain its default text "Hi, Username" set in initComponents
    }

    /**
     * Constructor that accepts a User object.
     * This should be called after a successful login.
     * @param user The currently logged-in User object.
     */
    public DaftarKonserInterface(User user) {
        this(); // Calls the default constructor to set up the GUI (initComponents)
        this.currentUser = user;

        if (this.currentUser != null) {
            lblHiUsername.setText("Hi, " + this.currentUser.getNama());
        } else {
            lblHiUsername.setText("Hi, Guest");
        }
    }

    /**
     * Initializes all GUI components.
     * This method is called by both constructors.
     */
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 678);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 20, 24));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JPanel panelSidebar = new JPanel();
        panelSidebar.setBackground(new Color(81, 20, 101));
        panelSidebar.setBounds(0, 0, 311, 678);
        panelSidebar.setLayout(null);
        contentPane.add(panelSidebar);

        lblHiUsername = new JLabel("Hi, Username"); // Default text
        lblHiUsername.setForeground(Color.WHITE);
        lblHiUsername.setFont(new Font("Poppins", Font.BOLD, 20));
        lblHiUsername.setBounds(24, 55, 250, 30); // Ensure width is sufficient
        panelSidebar.add(lblHiUsername);

        JLabel lblLihatKonser = new JLabel("Lihat Konser");
        lblLihatKonser.setForeground(Color.WHITE);
        lblLihatKonser.setFont(new Font("Poppins", Font.BOLD, 14));
        lblLihatKonser.setBounds(24, 149, 131, 30);
        panelSidebar.add(lblLihatKonser);

        JLabel lblTiketSaya = new JLabel("Tiket Saya");
        lblTiketSaya.setForeground(Color.WHITE);
        lblTiketSaya.setFont(new Font("Poppins", Font.BOLD, 14));
        lblTiketSaya.setBounds(24, 191, 131, 30);
        lblTiketSaya.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblTiketSaya.addMouseListener(new MouseAdapter() {
        	@Override
		    public void mousePressed(MouseEvent e) {
		    	TiketSayaInterface tiket = new TiketSayaInterface(currentUser);
		    	tiket.setSize(1024, 678);
		    	tiket.setVisible(true);
		    	dispose();
		    }
        });
        panelSidebar.add(lblTiketSaya);

        JLabel lblProfilSaya = new JLabel("Profil Saya");
        lblProfilSaya.setForeground(Color.WHITE);
        lblProfilSaya.setFont(new Font("Poppins", Font.BOLD, 14));
        lblProfilSaya.setBounds(24, 232, 131, 30);
        lblProfilSaya.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblProfilSaya.addMouseListener(new MouseAdapter() {
        	@Override
		    public void mousePressed(MouseEvent e) {
		    	ProfilInterface profil = new ProfilInterface(currentUser);
		    	profil.setSize(1024, 678);
		    	profil.setVisible(true);
		    	dispose();
		    }
        });
        panelSidebar.add(lblProfilSaya);

        JLabel lblLogout = new JLabel("Logout");
        lblLogout.setForeground(Color.WHITE);
        lblLogout.setFont(new Font("Poppins", Font.BOLD, 14));
        lblLogout.setBounds(24, 586, 131, 30);
        lblLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new LoginInterface().setVisible(true);
                dispose();
            }
        });
        panelSidebar.add(lblLogout);

        JLabel lblTitle = new JLabel("Semua Konser");
        lblTitle.setFont(new Font("Poppins", Font.BOLD, 28));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(340, 30, 400, 40);
        contentPane.add(lblTitle);

        JPanel panelGambar = new JPanel(new GridLayout(0, 3, 15, 15));
        panelGambar.setBackground(new Color(25, 20, 24));
        panelGambar.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setBackground(new Color(25, 20, 24));

        ArrayList<Konser> konserList = Konser.getAllKonser();

        if (konserList.isEmpty()) {
            JLabel noKonserLabel = new JLabel("Belum ada konser yang tersedia.");
            noKonserLabel.setForeground(Color.WHITE);
            noKonserLabel.setFont(new Font("Poppins", Font.PLAIN, 16));
            noKonserLabel.setHorizontalAlignment(SwingConstants.CENTER);
            wrapperPanel.add(noKonserLabel, BorderLayout.CENTER);
        } else {
            for (Konser konser : konserList) {
                JPanel itemPanel = new JPanel();
                itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
                itemPanel.setBackground(new Color(35, 30, 34));
                itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                try {
                    String imagePath = "./img/" + konser.getFilepathGambar();
                    ImageIcon icon = new ImageIcon(imagePath);
                    Image image = icon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                    JLabel imageLabel = new JLabel(new ImageIcon(image));
                    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    itemPanel.add(imageLabel);
                } catch (Exception e) {
                    JLabel errorLabel = new JLabel("Gagal memuat gambar");
                    errorLabel.setForeground(Color.ORANGE);
                    errorLabel.setFont(new Font("Poppins", Font.ITALIC, 12));
                    errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    itemPanel.add(errorLabel);
                }

                itemPanel.add(Box.createVerticalStrut(8));
                JLabel nameLabel = new JLabel(konser.getNamaKonser());
                nameLabel.setForeground(Color.WHITE);
                nameLabel.setFont(new Font("Poppins", Font.BOLD, 16));
                nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                itemPanel.add(nameLabel);

                JLabel dateLabel = new JLabel(konser.getTanggalKonser());
                dateLabel.setForeground(Color.LIGHT_GRAY);
                dateLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
                dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                itemPanel.add(Box.createVerticalStrut(3));
                itemPanel.add(dateLabel);
                itemPanel.add(Box.createVerticalStrut(8));

                JButton detailButton = new JButton("Detail");
                detailButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                detailButton.setBackground(new Color(81, 20, 101));
                detailButton.setForeground(Color.WHITE);
                detailButton.setFocusPainted(false);
                detailButton.setFont(new Font("Poppins", Font.PLAIN, 12));
                detailButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                detailButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
                detailButton.addActionListener(e -> {
                    System.out.println("Detail untuk: " + konser.getNamaKonser());
                    
                    DetailKonserInterface detail = new DetailKonserInterface(konser, currentUser);
                    detail.setSize(1024, 678);
                    detail.setVisible(true);
                    dispose();
                });
                itemPanel.add(detailButton);
                panelGambar.add(itemPanel);
            }
            wrapperPanel.add(panelGambar, BorderLayout.NORTH);
        }

        JScrollPane scrollPane = new JScrollPane(wrapperPanel);
        scrollPane.setBounds(340, 90, 660, 550);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getViewport().setBackground(new Color(25, 20, 24));
        contentPane.add(scrollPane);
    }
}