package tiketKonser;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
// Assuming Konser and User classes are in the same package or imported
import java.util.ArrayList; // For Konser.getAllKonser()

public class DetailKonserInterface extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private User currentUser;
    private Konser currentKonser;

    private JLabel lblSidebarGreeting;
    private JLabel lblConcertTitleVenue;
    private JLabel lblConcertImageDisplay;
    private JTextArea txtConcertDescriptionArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    User testUser = new User(99, "Main Test User", "main@test.com", "password123");

                    Konser konserToDisplay = null;
                    ArrayList<Konser> allAvailableKonsers = Konser.getAllKonser();

                    if (allAvailableKonsers != null && !allAvailableKonsers.isEmpty()) {
                        konserToDisplay = allAvailableKonsers.get(0);
                    } else {
                        System.err.println("Konser list is empty. Creating a dummy konser for DetailKonserInterface test.");
                        konserToDisplay = new Konser(0, "Test Concert", "2025-12-31", "20:00", 
                                                     "Test Venue Arena", 
                                                     "Test Description.", 
                                                     "default_image.jpg");
                    }
                    
                    DetailKonserInterface frame = new DetailKonserInterface(konserToDisplay, testUser);
                    frame.setVisible(true);
                    frame.setSize(1024, 678);
                    frame.setLocationRelativeTo(null);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DetailKonserInterface() {
        initComponents();
        updateUserGreeting();     
        populateConcertDetails(); 
    }

    public DetailKonserInterface(User user) {
        this(); 
        this.currentUser = user;
        updateUserGreeting();
    }
    
    public DetailKonserInterface(Konser konser, User user) {
        this(); 
        this.currentUser = user;
        this.currentKonser = konser; 
        
        updateUserGreeting();       
        populateConcertDetails();   
    }
    
    private void updateUserGreeting() {
        if (lblSidebarGreeting == null) return; 
        if (this.currentUser != null) {
            lblSidebarGreeting.setText("Hi, " + this.currentUser.getNama());
        } else {
            lblSidebarGreeting.setText("Hi, Guest");
        }
    }

    private void populateConcertDetails() {
        if (currentKonser != null) {
            if (lblConcertTitleVenue != null) {
                lblConcertTitleVenue.setText(currentKonser.getNamaKonser().toUpperCase() + 
                                             " - " + currentKonser.getLokasiKonser().toUpperCase());
            }
            if (lblConcertImageDisplay != null) {
                try {
                    String imagePath = "./img/" + currentKonser.getFilepathGambar();
                    ImageIcon icon = new ImageIcon(imagePath);
                    Image img = icon.getImage();
                    Image newImg = img.getScaledInstance(350, 450, Image.SCALE_SMOOTH);
                    lblConcertImageDisplay.setIcon(new ImageIcon(newImg));
                    lblConcertImageDisplay.setText(""); 
                } catch (Exception e) {
                    lblConcertImageDisplay.setIcon(null);
                    lblConcertImageDisplay.setText("Gambar tidak tersedia");
                    System.err.println("Error loading image: " + currentKonser.getFilepathGambar() + " - " + e.getMessage());
                }
            }
            if (txtConcertDescriptionArea != null) {
                StringBuilder description = new StringBuilder();
                description.append("🎤 Konser: ").append(currentKonser.getNamaKonser()).append("\n\n");
                description.append("📅 Tanggal: ").append(currentKonser.getTanggalKonser()).append("\n");
                description.append("🕗 Waktu: ").append(currentKonser.getWaktuKonser()).append("\n"); 
                description.append("📍 Lokasi:\n").append(currentKonser.getLokasiKonser()).append("\n\n");
                description.append("📖 Tentang Konser:\n").append(currentKonser.getDeskripsi()).append("\n\n");
                
                txtConcertDescriptionArea.setText(description.toString());
                txtConcertDescriptionArea.setCaretPosition(0); 
            }
        } else {
            if (lblConcertTitleVenue != null) lblConcertTitleVenue.setText("Detail Konser Tidak Tersedia");
            if (lblConcertImageDisplay != null) {
                lblConcertImageDisplay.setIcon(null);
                lblConcertImageDisplay.setText("Gambar tidak tersedia");
            }
            if (txtConcertDescriptionArea != null) {
                txtConcertDescriptionArea.setText("Informasi konser tidak dapat dimuat.");
            }
        }
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(26, 21, 24));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelSidebar = new JPanel();
        panelSidebar.setBackground(new Color(81, 20, 101));
        panelSidebar.setBounds(0, 0, 250, 678); 
        contentPane.add(panelSidebar);
        panelSidebar.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 250, panelSidebar.getHeight());
        panelSidebar.add(layeredPane);

        JLabel lblSidebarBackground = new JLabel("");
        try {
             lblSidebarBackground.setIcon(new ImageIcon("./img/sidebar_bg_default.jpg")); 
        } catch (Exception ex){
            // Provide a fallback or ensure the image exists
            // For now, using the user's specific path as an example if relative fails during their test
            // In a real app, this path should be relative or loaded as a resource.
            try {
                lblSidebarBackground.setIcon(new ImageIcon("C:\\Users\\hasnatyam\\Downloads\\download (4).jpg"));
            } catch (Exception e2) {
                System.err.println("Sidebar background image not found.");
            }
        }
        lblSidebarBackground.setBounds(0, 0, 250, layeredPane.getHeight());
        layeredPane.add(lblSidebarBackground, Integer.valueOf(0));

        lblSidebarGreeting = new JLabel("Hi, Username"); 
        lblSidebarGreeting.setBounds(20, 51, 210, 30); 
        lblSidebarGreeting.setFont(new Font("Poppins", Font.BOLD, 20));
        lblSidebarGreeting.setForeground(new Color(255, 255, 255));
        layeredPane.add(lblSidebarGreeting, Integer.valueOf(1)); 
        lblSidebarGreeting.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblSidebarGreeting.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (currentUser != null) {
                    new DashboardInterface(currentUser).setVisible(true);
                } else {
                    new DashboardInterface().setVisible(true); // Or navigate to login
                }
                dispose();
            }
        });

        JLabel lblNavLihatKonser = new JLabel("Lihat Konser");
        lblNavLihatKonser.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNavLihatKonser.setForeground(new Color(255, 255, 255));
        lblNavLihatKonser.setBounds(20, 130, 153, 31); 
        layeredPane.add(lblNavLihatKonser, Integer.valueOf(1));
        lblNavLihatKonser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavLihatKonser.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                 if (currentUser != null) {
                    new DaftarKonserInterface(currentUser).setVisible(true);
                } else {
                    new DaftarKonserInterface().setVisible(true); // Or navigate to login
                }
                dispose();
            }
        });
        
        JLabel lblNavTiketSaya = new JLabel("Tiket Saya");
        lblNavTiketSaya.setForeground(new Color(255, 255, 255));
        lblNavTiketSaya.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNavTiketSaya.setBounds(20, 170, 138, 31); 
        layeredPane.add(lblNavTiketSaya, Integer.valueOf(1));
        lblNavTiketSaya.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavTiketSaya.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Assuming TiketSayaInterface might also need currentUser
                // new TiketSayaInterface(currentUser).setVisible(true); 
                new TiketSayaInterface().setVisible(true);
                dispose();
            }
        });
        
        JLabel lblNavProfilSaya = new JLabel("Profil Saya");
        lblNavProfilSaya.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNavProfilSaya.setForeground(new Color(255, 255, 255));
        lblNavProfilSaya.setBounds(20, 210, 133, 31); 
        layeredPane.add(lblNavProfilSaya, Integer.valueOf(1));
        lblNavProfilSaya.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavProfilSaya.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new ProfilInterface().setVisible(true);
                dispose();
            }
        });
        
        JLabel lblNavLogout = new JLabel("Logout");
        lblNavLogout.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNavLogout.setForeground(new Color(255, 255, 255));
        lblNavLogout.setBounds(20, panelSidebar.getHeight() - 70, 79, 31); 
        layeredPane.add(lblNavLogout, Integer.valueOf(1));
        lblNavLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new LoginInterface().setVisible(true);
                dispose();
            }
        });
        
        lblConcertTitleVenue = new JLabel("NAMA KONSER - LOKASI"); 
        lblConcertTitleVenue.setFont(new Font("Poppins", Font.BOLD, 20));
        lblConcertTitleVenue.setForeground(new Color(255, 255, 255));
        lblConcertTitleVenue.setBounds(275, 30, 700, 30); 
        contentPane.add(lblConcertTitleVenue);
        
        lblConcertImageDisplay = new JLabel(); 
        lblConcertImageDisplay.setBounds(275, 75, 350, 450); 
        lblConcertImageDisplay.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        lblConcertImageDisplay.setHorizontalAlignment(JLabel.CENTER);
        lblConcertImageDisplay.setForeground(Color.WHITE); 
        contentPane.add(lblConcertImageDisplay);
        
        txtConcertDescriptionArea = new JTextArea(); 
        txtConcertDescriptionArea.setEditable(false);
        txtConcertDescriptionArea.setWrapStyleWord(true);
        txtConcertDescriptionArea.setLineWrap(true);
        txtConcertDescriptionArea.setFont(new Font("Poppins", Font.PLAIN, 13));
        txtConcertDescriptionArea.setForeground(Color.WHITE);
        txtConcertDescriptionArea.setBackground(new Color(30, 25, 29)); 
        txtConcertDescriptionArea.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JScrollPane descriptionScrollPane = new JScrollPane(txtConcertDescriptionArea);
        descriptionScrollPane.setBounds(lblConcertImageDisplay.getX() + lblConcertImageDisplay.getWidth() + 20, 75, 
                                        1024 - (lblConcertImageDisplay.getX() + lblConcertImageDisplay.getWidth() + 20) - 30, 
                                        372); 
        descriptionScrollPane.setBorder(BorderFactory.createEmptyBorder());
        contentPane.add(descriptionScrollPane);
        
        JButton btnPesanTiket = new JButton("Pesan Tiket");
        btnPesanTiket.setFont(new Font("Poppins", Font.BOLD, 13));
        btnPesanTiket.setForeground(Color.WHITE);
        btnPesanTiket.setBackground(new Color(100, 40, 120)); 
        btnPesanTiket.setBounds(descriptionScrollPane.getX() + descriptionScrollPane.getWidth() - 142, 
                                descriptionScrollPane.getY() + descriptionScrollPane.getHeight() + 20, 
                                142, 30);
        btnPesanTiket.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPesanTiket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentUser != null && currentKonser != null) {
                    System.out.println("Pesan Tiket: User ID " + currentUser.getUserId() + ", Konser ID " + currentKonser.getKonserId());
                    // Navigate to DetailStageKonserInterface, passing necessary info
                    // Example: new DetailStageKonserInterface(currentKonser, currentUser).setVisible(true);
                    new DetailStageKonserInterface().setVisible(true); // Replace with actual data passing
                    // dispose(); 
                } else {
                    JOptionPane.showMessageDialog(DetailKonserInterface.this, 
                                                  "Data konser atau pengguna tidak lengkap untuk memesan.", 
                                                  "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        contentPane.add(btnPesanTiket);
        
        JLabel lblKategoriSeatInfo = new JLabel("Kategori seat:");
        lblKategoriSeatInfo.setFont(new Font("Poppins", Font.PLAIN, 13));
        lblKategoriSeatInfo.setForeground(new Color(255, 255, 255));
        lblKategoriSeatInfo.setBounds(descriptionScrollPane.getX(), btnPesanTiket.getY(), 98, 30);
        contentPane.add(lblKategoriSeatInfo);
        
        JLabel lblKategoriSeatLink = new JLabel("info stage"); 
        lblKategoriSeatLink.setFont(new Font("Poppins", Font.PLAIN, 13));
        lblKategoriSeatLink.setForeground(new Color(100, 150, 255)); 
        lblKategoriSeatLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblKategoriSeatLink.setBounds(lblKategoriSeatInfo.getX() + lblKategoriSeatInfo.getWidth() + 5, lblKategoriSeatInfo.getY(), 150, 30);
        lblKategoriSeatLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                 new DetailStageKonserInterface().setVisible(true); // Replace with actual data passing
            }
        });
        contentPane.add(lblKategoriSeatLink);
    }
}