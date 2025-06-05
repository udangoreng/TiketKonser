package tiketKonser;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Cursor;

public class DashboardAdminInterface extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblAdminGreeting;
    private Admin currentAdmin;
    private JLabel lblConcertCountValue;
    private JLabel lblOrderCountValue;
    private JPanel latestKonserDisplayPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin testAdmin = new Admin(1, "Admin123", "Admin123", "admin01", "SuperAdmin");
                    DashboardAdminInterface frame = new DashboardAdminInterface(testAdmin);
                    frame.setVisible(true);
                    frame.setSize(1024, 678);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DashboardAdminInterface() {
        initComponents();
        updateDashboardData();
    }

    public DashboardAdminInterface(Admin admin) {
        this();
        this.currentAdmin = admin;
        updateAdminGreeting();
    }
    
    private void updateAdminGreeting() {
        if (this.currentAdmin != null && this.lblAdminGreeting != null) {
            lblAdminGreeting.setText("Hi, " + this.currentAdmin.getNama());
        } else if (this.lblAdminGreeting != null) {
            lblAdminGreeting.setText("Hi, Admin");
        }
    }

    private void updateDashboardData() {
        if (lblConcertCountValue != null) {
            ArrayList<Konser> konserList = Konser.getAllKonser();
            lblConcertCountValue.setText(String.valueOf(konserList.size()));
        }
        if (lblOrderCountValue != null) {
            ArrayList<Order> orderList = Order.getAllOrder();
            lblOrderCountValue.setText(String.valueOf(orderList.size()));
        }
        if (latestKonserDisplayPanel != null) {
            populateLatestKonser();
        }
    }
    
    private void populateLatestKonser() {
        latestKonserDisplayPanel.removeAll(); 

        ArrayList<Konser> allKonser = Konser.getAllKonser();
        List<Konser> displayList = new ArrayList<>();
        
        int count = 0;
        for (int i = allKonser.size() - 1; i >= 0 && count < 3; i--) {
            displayList.add(allKonser.get(i));
            count++;
        }

        if (displayList.isEmpty()) {
            JLabel noKonserMsg = new JLabel("Belum ada konser terbaru.");
            noKonserMsg.setForeground(Color.LIGHT_GRAY);
            noKonserMsg.setFont(new Font("Poppins", Font.PLAIN, 13));
            latestKonserDisplayPanel.add(noKonserMsg);
        } else {
            int itemWidth = 180;
            int itemHeight = 250;
            int imgWidth = itemWidth - 40;
            int imgHeight = 180;

            for (Konser konser : displayList) {
                JPanel konserItemPanel = new JPanel();
                konserItemPanel.setLayout(new BoxLayout(konserItemPanel, BoxLayout.Y_AXIS));
                konserItemPanel.setBackground(new Color(35, 30, 34));
                konserItemPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(81, 20, 101), 2),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
                ));
                konserItemPanel.setPreferredSize(new Dimension(itemWidth, itemHeight)); 
                konserItemPanel.setMaximumSize(new Dimension(itemWidth, itemHeight));
                konserItemPanel.setMinimumSize(new Dimension(itemWidth, itemHeight));

                konserItemPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                konserItemPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        System.out.println("Admin clicked on latest konser: " + konser.getNamaKonser());
                    }
                });

                JLabel imgLabel = new JLabel();
                imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                imgLabel.setPreferredSize(new Dimension(imgWidth, imgHeight)); 
                imgLabel.setMaximumSize(new Dimension(imgWidth, imgHeight));
                imgLabel.setOpaque(true);
                imgLabel.setBackground(Color.DARK_GRAY);
                imgLabel.setForeground(Color.WHITE);
                imgLabel.setHorizontalAlignment(JLabel.CENTER);
                imgLabel.setFont(new Font("Poppins", Font.ITALIC, 10));
                imgLabel.setText("Gambar tidak ada"); 
                try {
                     ImageIcon icon = new ImageIcon("./img/" + konser.getFilepathGambar());
                     Image image = icon.getImage().getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);
                     imgLabel.setIcon(new ImageIcon(image));
                     imgLabel.setText("");
                } catch (Exception ex) {
                    System.err.println("Could not load image for " + konser.getNamaKonser() + ": " + konser.getFilepathGambar());
                }
                konserItemPanel.add(imgLabel);
                konserItemPanel.add(Box.createRigidArea(new Dimension(0, 8)));

                JLabel namaKonserLabel = new JLabel("<html><div style='text-align:center;width:" + (itemWidth - 40) + "px'>" + konser.getNamaKonser() + "</div></html>");
                namaKonserLabel.setForeground(Color.WHITE);
                namaKonserLabel.setFont(new Font("Poppins", Font.BOLD, 14));
                namaKonserLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                konserItemPanel.add(namaKonserLabel);
                konserItemPanel.add(Box.createRigidArea(new Dimension(0, 5)));
                namaKonserLabel.setMinimumSize(new Dimension(itemWidth - 30, 15)); 
                namaKonserLabel.setPreferredSize(new Dimension(itemWidth - 30, 35));
                namaKonserLabel.setMaximumSize(new Dimension(itemWidth - 30, 40));

                JLabel tanggalKonserLabel = new JLabel(konser.getTanggalKonser());
                tanggalKonserLabel.setForeground(Color.LIGHT_GRAY);
                tanggalKonserLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
                tanggalKonserLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                konserItemPanel.add(tanggalKonserLabel);
                konserItemPanel.add(namaKonserLabel);
                konserItemPanel.add(Box.createRigidArea(new Dimension(0, 8)));
                
                latestKonserDisplayPanel.add(konserItemPanel);
                if (displayList.indexOf(konser) < displayList.size() -1) { 
                    latestKonserDisplayPanel.add(Box.createRigidArea(new Dimension(40, 0))); // Increased spacing
                }
            }
        }
        latestKonserDisplayPanel.revalidate();
        latestKonserDisplayPanel.repaint();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(26, 21, 24));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelSidebar = new JPanel();
        panelSidebar.setBounds(0, 0, 264, 678);
        panelSidebar.setLayout(null);
        panelSidebar.setBackground(new Color(81, 20, 101));
        contentPane.add(panelSidebar);

        lblAdminGreeting = new JLabel("Hi, Admin");
        lblAdminGreeting.setForeground(Color.WHITE);
        lblAdminGreeting.setFont(new Font("Poppins", Font.BOLD, 20));
        lblAdminGreeting.setBounds(36, 42, 200, 30);
        panelSidebar.add(lblAdminGreeting);

        JLabel lblNavDashboard = new JLabel("Dashboard");
        lblNavDashboard.setForeground(new Color(200, 200, 255));
        lblNavDashboard.setFont(new Font("Poppins Medium", Font.BOLD, 14));
        lblNavDashboard.setBounds(36, 151, 124, 30);
        panelSidebar.add(lblNavDashboard);

        JLabel lblNavKelolaKonser = new JLabel("Kelola Konser");
        lblNavKelolaKonser.setForeground(Color.WHITE);
        lblNavKelolaKonser.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNavKelolaKonser.setBounds(36, 192, 168, 40);
        lblNavKelolaKonser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavKelolaKonser.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
                new ManageKonserInterface().setVisible(true);
            }
        });
        panelSidebar.add(lblNavKelolaKonser);

        JLabel lblNavKelolaOrder = new JLabel("Kelola Order");
        lblNavKelolaOrder.setForeground(Color.WHITE);
        lblNavKelolaOrder.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNavKelolaOrder.setBounds(36, 233, 168, 40);
        lblNavKelolaOrder.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavKelolaOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
                new ManageOrderInterface().setVisible(true);
            }
        });
        panelSidebar.add(lblNavKelolaOrder);

        JLabel lblNavLogout = new JLabel("Logout");
        lblNavLogout.setForeground(Color.WHITE);
        lblNavLogout.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNavLogout.setBounds(36, panelSidebar.getHeight() - 70, 168, 40);
        lblNavLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
                new LoginInterface().setVisible(true);
            }
        });
        panelSidebar.add(lblNavLogout);

        JPanel panelJumlahKonser = new JPanel();
        panelJumlahKonser.setBorder(new LineBorder(new Color(81, 20, 101), 2, true));
        panelJumlahKonser.setBackground(new Color(40, 35, 39));
        panelJumlahKonser.setBounds(295, 47, 220, 100);
        contentPane.add(panelJumlahKonser);
        panelJumlahKonser.setLayout(null);

        JLabel lblTitleJumlahKonser = new JLabel("Jumlah Konser");
        lblTitleJumlahKonser.setForeground(Color.WHITE);
        lblTitleJumlahKonser.setFont(new Font("Poppins", Font.BOLD, 16));
        lblTitleJumlahKonser.setBounds(15, 10, 190, 25);
        panelJumlahKonser.add(lblTitleJumlahKonser);

        lblConcertCountValue = new JLabel("0");
        lblConcertCountValue.setForeground(new Color(200, 200, 220));
        lblConcertCountValue.setFont(new Font("Poppins", Font.BOLD, 32));
        lblConcertCountValue.setBounds(15, 40, 190, 45);
        panelJumlahKonser.add(lblConcertCountValue);

        JPanel panelJumlahOrder = new JPanel();
        panelJumlahOrder.setBorder(new LineBorder(new Color(81, 20, 101), 2, true));
        panelJumlahOrder.setBackground(new Color(40, 35, 39));
        panelJumlahOrder.setBounds(545, 47, 220, 100);
        contentPane.add(panelJumlahOrder);
        panelJumlahOrder.setLayout(null);

        JLabel lblTitleJumlahOrder = new JLabel("Jumlah Order");
        lblTitleJumlahOrder.setForeground(Color.WHITE);
        lblTitleJumlahOrder.setFont(new Font("Poppins", Font.BOLD, 16));
        lblTitleJumlahOrder.setBounds(15, 10, 190, 25);
        panelJumlahOrder.add(lblTitleJumlahOrder);
        
        lblOrderCountValue = new JLabel("0");
        lblOrderCountValue.setForeground(new Color(200, 200, 220));
        lblOrderCountValue.setFont(new Font("Poppins", Font.BOLD, 32));
        lblOrderCountValue.setBounds(15, 40, 190, 45);
        panelJumlahOrder.add(lblOrderCountValue);

        JLabel lblTitleKonserTerbaru = new JLabel("Konser Terbaru :");
        lblTitleKonserTerbaru.setForeground(Color.WHITE);
        lblTitleKonserTerbaru.setFont(new Font("Poppins", Font.BOLD, 18));
        lblTitleKonserTerbaru.setBounds(295, 170, 227, 39);
        contentPane.add(lblTitleKonserTerbaru);
        
        latestKonserDisplayPanel = new JPanel();
        latestKonserDisplayPanel.setBackground(contentPane.getBackground());
        latestKonserDisplayPanel.setLayout(new BoxLayout(latestKonserDisplayPanel, BoxLayout.X_AXIS));        latestKonserDisplayPanel.setBounds(295, 
                                           lblTitleKonserTerbaru.getY() + lblTitleKonserTerbaru.getHeight() + 10,
                                           670,
                                           280);
        latestKonserDisplayPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        contentPane.add(latestKonserDisplayPanel);
    }
}
