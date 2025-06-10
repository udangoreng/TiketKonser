package tiketKonser;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane; // Added for scrollable content
import javax.swing.BorderFactory; // Added

public class TiketSayaInterface extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private User currentUser;
    private JLabel lblHiUsername;
    private JPanel ticketContainerPanel; // A single panel to hold all tickets
    private JScrollPane scrollPane;      // To make the ticket list scrollable

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // For testing, get a sample user
                    User testUser = User.searchUserById(1); // Assuming user with ID 1 (Alexa) exists
                    if (testUser == null) {
                         // Fallback for testing if user list is different
                        testUser = new User(1, "Test User", "test@example.com", "pass");
                    }
                    
                    // Add a dummy past/cancelled order for testing the "History" section
                    Order.buatOrder(testUser.getUserId(), 2, "VIP", 5000000).setStatusBayar("Cancelled");

                    TiketSayaInterface frame = new TiketSayaInterface(testUser);
                    frame.setVisible(true);
                    frame.setSize(1024, 678);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TiketSayaInterface() {
        initComponents();
    }
    
    public TiketSayaInterface(User user) {
        this();
        this.currentUser = user;
        updateUserGreeting();
        loadUserTickets();
    }
    
    private void updateUserGreeting() {
        if (currentUser != null) {
            lblHiUsername.setText("Hi, " + currentUser.getNama());
        }
    }
    
    private boolean isFutureDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            Date concertDate = sdf.parse(dateString);
            Date today = sdf.parse(sdf.format(new Date()));
            return !concertDate.before(today);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private void loadUserTickets() {
        if (currentUser == null) {
            JLabel loginMsg = new JLabel("Silakan login untuk melihat tiket Anda.");
            loginMsg.setForeground(Color.WHITE);
            loginMsg.setFont(new Font("Poppins", Font.PLAIN, 16));
            loginMsg.setBounds(10, 10, 400, 30);
            ticketContainerPanel.add(loginMsg);
            return;
        }

        ticketContainerPanel.removeAll();
        
        ArrayList<Order> userOrders = Order.getOrdersByUserId(currentUser.getUserId());
        
        int currentY = 20; // Initial Y position for the first element
        
        // --- ACTIVE TICKETS ---
        JLabel lblTicketActiveTitle = new JLabel("Ticket Active");
        lblTicketActiveTitle.setForeground(Color.WHITE);
        lblTicketActiveTitle.setFont(new Font("Poppins", Font.BOLD, 28));
        lblTicketActiveTitle.setBounds(0, currentY, 217, 53);
        ticketContainerPanel.add(lblTicketActiveTitle);
        currentY += 60;
        
        boolean hasActiveTickets = false;
        for (Order order : userOrders) {
            Konser konser = Konser.searchKonserById(order.getKonserId());
            if (konser == null) continue;
            
            if (order.getStatusBayar().equalsIgnoreCase("Sudah Bayar") && isFutureDate(konser.getTanggalKonser())) {
                JLabel ticketImageLabel = createTicketImageLabel(konser, currentY);
                ticketContainerPanel.add(ticketImageLabel);
                currentY += ticketImageLabel.getHeight() + 20; // Move Y for the next ticket
                hasActiveTickets = true;
            }
        }
        if (!hasActiveTickets) {
            JLabel noActiveTicketMsg = new JLabel("Anda tidak memiliki tiket aktif.");
            noActiveTicketMsg.setForeground(Color.LIGHT_GRAY);
            noActiveTicketMsg.setFont(new Font("Poppins", Font.PLAIN, 14));
            noActiveTicketMsg.setBounds(0, currentY, 400, 20);
            ticketContainerPanel.add(noActiveTicketMsg);
            currentY += 40;
        }
        
        // --- HISTORY TICKETS ---
        currentY += 20; // Extra space before history section
        JLabel lblHistoryTitle = new JLabel("History");
        lblHistoryTitle.setForeground(Color.WHITE);
        lblHistoryTitle.setFont(new Font("Poppins", Font.BOLD, 28));
        lblHistoryTitle.setBounds(0, currentY, 217, 53);
        ticketContainerPanel.add(lblHistoryTitle);
        currentY += 60;
        
        boolean hasHistoryTickets = false;
        for (Order order : userOrders) {
             Konser konser = Konser.searchKonserById(order.getKonserId());
             if (konser == null) continue;
             
             if (!order.getStatusBayar().equalsIgnoreCase("Sudah Bayar") || !isFutureDate(konser.getTanggalKonser())) {
                 JLabel ticketImageLabel = createTicketImageLabel(konser, currentY);
                 ticketContainerPanel.add(ticketImageLabel);
                 currentY += ticketImageLabel.getHeight() + 20;
                 hasHistoryTickets = true;
             }
        }
        if (!hasHistoryTickets) {
            JLabel noHistoryTicketMsg = new JLabel("Tidak ada riwayat tiket.");
            noHistoryTicketMsg.setForeground(Color.LIGHT_GRAY);
            noHistoryTicketMsg.setFont(new Font("Poppins", Font.PLAIN, 14));
            noHistoryTicketMsg.setBounds(0, currentY, 400, 20);
            ticketContainerPanel.add(noHistoryTicketMsg);
            currentY += 40;
        }

        // Update the size of the container panel and refresh the scroll pane
        ticketContainerPanel.setPreferredSize(new Dimension(660, currentY));
        ticketContainerPanel.revalidate();
        ticketContainerPanel.repaint();
    }
    
    /**
     * Creates a JLabel containing the ticket image for a specific concert.
     * @param konser The concert for which to create the ticket image.
     * @param yPos The vertical position to place the label.
     * @return A JLabel with the ticket image.
     */
    private JLabel createTicketImageLabel(Konser konser, int yPos) {
        // ASSUMPTION: Your ticket images are named like "tulusTicket.jpg", "brunoTicket.jpg", etc.
    	String ticketFilename = konser.getFilepathGambar().replace("Konser", "Tiket");
        String imagePath = "./img/" + ticketFilename;
        
        JLabel lblImage = new JLabel();
        int imgWidth = 500;
        int imgHeight = 160;
        lblImage.setBounds(0, yPos, imgWidth, imgHeight);
        
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            Image scaledImage = icon.getImage().getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
            lblImage.setText("Ticket image not found for: " + konser.getNamaKonser());
            lblImage.setFont(new Font("Poppins", Font.ITALIC, 12));
            lblImage.setForeground(Color.ORANGE);
            lblImage.setHorizontalAlignment(JLabel.CENTER);
            lblImage.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            System.err.println("Could not load image: " + imagePath);
        }
        return lblImage;
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 678);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 20, 24));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // --- Sidebar Panel ---
        JPanel panelSidebar = new JPanel();
        panelSidebar.setLayout(null);
        panelSidebar.setBackground(new Color(81, 20, 101));
        panelSidebar.setBounds(0, 0, 311, 678);
        contentPane.add(panelSidebar);

        lblHiUsername = new JLabel("Hi, Username");
        lblHiUsername.setForeground(Color.WHITE);
        lblHiUsername.setFont(new Font("Poppins", Font.BOLD, 20));
        lblHiUsername.setBounds(24, 55, 250, 30);
        lblHiUsername.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblHiUsername.addMouseListener(new MouseAdapter() {
        	@Override
            public void mousePressed(MouseEvent e) {
                if (currentUser != null) {
        		    	DashboardInterface dashboard= new DashboardInterface(currentUser);
        		    	dashboard.setSize(1024, 678);
        		    	dashboard.setVisible(true);
        		    	dispose();
                } else {
                    new DashboardInterface().setVisible(true);
                }
                dispose();
            }
        });
        panelSidebar.add(lblHiUsername);

        JLabel lblNavLihatKonser = new JLabel("Lihat Konser");
        lblNavLihatKonser.setForeground(Color.WHITE);
        lblNavLihatKonser.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNavLihatKonser.setBounds(24, 149, 101, 30);
        lblNavLihatKonser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavLihatKonser.addMouseListener(new MouseAdapter() {
        	@Override
		    public void mousePressed(MouseEvent e) {
		    	DaftarKonserInterface konser = new DaftarKonserInterface(currentUser);
                konser.setSize(1024, 678);
                konser.setVisible(true);
		    	dispose();
		    }
        });
        panelSidebar.add(lblNavLihatKonser);

        JLabel lblNavTiketSaya = new JLabel("Tiket Saya");
        lblNavTiketSaya.setForeground(new Color(200, 200, 255)); // Highlight active page
        lblNavTiketSaya.setFont(new Font("Poppins", Font.BOLD, 14));
        lblNavTiketSaya.setBounds(24, 191, 131, 30);
        panelSidebar.add(lblNavTiketSaya);

        JLabel lblNavProfilSaya = new JLabel("Profil Saya");
        lblNavProfilSaya.setForeground(Color.WHITE);
        lblNavProfilSaya.setFont(new Font("Poppins", Font.BOLD, 14));
        lblNavProfilSaya.setBounds(24, 232, 131, 30);
        lblNavProfilSaya.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavProfilSaya.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new ProfilInterface().setVisible(true); // Pass user
                dispose();
            }
        });
        panelSidebar.add(lblNavProfilSaya);

        JLabel lblNavLogout = new JLabel("Logout");
        lblNavLogout.setForeground(Color.WHITE);
        lblNavLogout.setFont(new Font("Poppins", Font.BOLD, 14));
        lblNavLogout.setBounds(24, 586, 131, 30);
        lblNavLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new LoginInterface().setVisible(true);
                dispose();
            }
        });
        panelSidebar.add(lblNavLogout);
        
        // --- Main Content Area ---
        // A single panel to hold all ticket content, which will be placed in a JScrollPane
        ticketContainerPanel = new JPanel();
        ticketContainerPanel.setBackground(contentPane.getBackground());
        ticketContainerPanel.setLayout(null); // We will manually place ticket images inside this panel

        // A JScrollPane to make the list of tickets scrollable if it gets too long
        scrollPane = new JScrollPane(ticketContainerPanel);
        scrollPane.setBounds(333, 26, 660, 600); // Main area for tickets
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(contentPane.getBackground());
        // Increase scroll speed
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        contentPane.add(scrollPane);
    }
}