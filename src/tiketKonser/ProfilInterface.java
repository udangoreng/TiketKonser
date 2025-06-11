package tiketKonser;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants; // Added for alignment
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ProfilInterface extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private User currentUser;

    // Instance fields for UI components that need to be updated
    private JLabel lblHiUsername;
    private JLabel lblNamaData;
    private JLabel lblEmailData;
    private JLabel lblFoto;

    /**
     * Launch the application for testing purposes.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                // For testing, create a dummy User object
                User testUser = new User(1, "Alexa", "alx@gmail.com", "Alex12");
                
                ProfilInterface frame = new ProfilInterface(testUser);
                frame.setSize(1024, 678);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Default constructor.
     */
    public ProfilInterface() {
        initComponents();
    }

    /**
     * Preferred constructor that accepts the User object.
     * @param user The currently logged-in User object.
     */
    public ProfilInterface(User user) {
        this();
        this.currentUser = user;
        populateProfileData();
    }

    /**
     * Fills the UI with data from the currentUser object.
     */
    private void populateProfileData() {
        if (currentUser != null) {
            lblHiUsername.setText("Hi, " + currentUser.getNama());
            
            lblNamaData.setText(currentUser.getNama());
            lblEmailData.setText(currentUser.getEmail());
            
        } else {
            lblHiUsername.setText("Hi, Guest");
            lblNamaData.setText("N/A");
            lblEmailData.setText("N/A");
        }
    }

    /**
     * Initializes all GUI components.
     */
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 678);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 20, 24));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // --- Sidebar Panel ---
        JPanel panelSidebar = new JPanel();
        panelSidebar.setBounds(0, 0, 300, 678);
        panelSidebar.setLayout(null);
        panelSidebar.setBackground(new Color(81, 20, 101));
        contentPane.add(panelSidebar);

        lblHiUsername = new JLabel("Hi, Username");
        lblHiUsername.setForeground(Color.WHITE);
        lblHiUsername.setFont(new Font("Poppins", Font.BOLD, 20));
        lblHiUsername.setBounds(24, 55, 250, 30); // Wider for longer names
        lblHiUsername.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblHiUsername.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new DashboardInterface(currentUser).setVisible(true); // Pass user
                dispose();
            }
        });
        panelSidebar.add(lblHiUsername);

        JLabel lblLihatKonser = new JLabel("Lihat Konser");
        lblLihatKonser.setForeground(Color.WHITE);
        lblLihatKonser.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblLihatKonser.setBounds(24, 120, 150, 30);
        lblLihatKonser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblLihatKonser.addMouseListener(new MouseAdapter() {
        	@Override
		    public void mousePressed(MouseEvent e) {
		    	DaftarKonserInterface konser = new DaftarKonserInterface(currentUser);
                konser.setSize(1024, 678);
                konser.setVisible(true);
		    	dispose();
		    }
        });
        panelSidebar.add(lblLihatKonser);

        JLabel lblTiketSaya = new JLabel("Tiket Saya");
        lblTiketSaya.setForeground(Color.WHITE);
        lblTiketSaya.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblTiketSaya.setBounds(24, 170, 150, 30);
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
        lblProfilSaya.setForeground(new Color(200, 200, 255)); // Highlight active page
        lblProfilSaya.setFont(new Font("Poppins", Font.BOLD, 14));
        lblProfilSaya.setBounds(24, 220, 150, 30);
        panelSidebar.add(lblProfilSaya);

        JLabel lblLogout = new JLabel("Logout");
        lblLogout.setForeground(Color.WHITE);
        lblLogout.setFont(new Font("Poppins", Font.BOLD, 14));
        lblLogout.setBounds(24, 550, 150, 30);
        lblLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new LoginInterface().setVisible(true);
                dispose();
            }
        });
        panelSidebar.add(lblLogout);

        // --- Main Content Area ---
        JLabel lblTitle = new JLabel("Profil Saya");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Poppins", Font.BOLD, 28));
        lblTitle.setBounds(350, 30, 300, 50);
        contentPane.add(lblTitle);

        JPanel panelProfil = new JPanel();
        panelProfil.setBounds(350, 100, 600, 400); // Adjusted height
        panelProfil.setLayout(null);
        panelProfil.setBackground(new Color(41, 25, 45));
        panelProfil.setBorder(new LineBorder(new Color(130, 70, 180), 2, true));
        contentPane.add(panelProfil);

        lblFoto = new JLabel();
        lblFoto.setBounds(230, 20, 140, 140);
        lblFoto.setOpaque(true);
        lblFoto.setBackground(new Color(130, 70, 180));
        lblFoto.setBorder(new LineBorder(Color.WHITE, 2, true));
        panelProfil.add(lblFoto);

        // Add default profile icon image
        try {
            // Using a more generic icon URL for portability
            URL url = new URL("https://drive.google.com/uc?export=view&id=1pOJwNaFtThjUVk2CK2-QqZFDjzdLSMaA"); 
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(url).getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
            lblFoto.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
            lblFoto.setText("Gagal Memuat");
            lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
            lblFoto.setForeground(Color.WHITE);
        }

        // --- Nama Field ---
        JLabel lblNamaTitle = new JLabel("Nama");
        lblNamaTitle.setForeground(Color.WHITE);
        lblNamaTitle.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNamaTitle.setBounds(50, 180, 200, 20); // Positioned below image
        panelProfil.add(lblNamaTitle);

        JPanel panelNama = new JPanel();
        panelNama.setBounds(50, 205, 500, 35); // Adjusted width and height
        panelNama.setBackground(new Color(60, 35, 70));
        panelNama.setLayout(null);
        panelNama.setBorder(new LineBorder(new Color(130, 70, 180), 1, true));
        panelProfil.add(panelNama);

        lblNamaData = new JLabel("Nama Pengguna"); // Placeholder
        lblNamaData.setForeground(Color.WHITE);
        lblNamaData.setFont(new Font("Poppins", Font.BOLD, 14));
        lblNamaData.setBounds(15, 5, 470, 25); // Adjusted padding and width
        panelNama.add(lblNamaData);

        // --- Email Field ---
        JLabel lblEmailTitle = new JLabel("Email");
        lblEmailTitle.setForeground(Color.WHITE);
        lblEmailTitle.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblEmailTitle.setBounds(50, 260, 200, 20); // Positioned below Nama field
        panelProfil.add(lblEmailTitle);

        JPanel panelEmail = new JPanel();
        panelEmail.setBounds(50, 285, 500, 35);
        panelEmail.setBackground(new Color(60, 35, 70));
        panelEmail.setLayout(null);
        panelEmail.setBorder(new LineBorder(new Color(130, 70, 180), 1, true));
        panelProfil.add(panelEmail);

        lblEmailData = new JLabel("email@pengguna.com"); // Placeholder
        lblEmailData.setForeground(Color.WHITE);
        lblEmailData.setFont(new Font("Poppins", Font.BOLD, 14));
        lblEmailData.setBounds(15, 5, 470, 25);
        panelEmail.add(lblEmailData);
    }
}