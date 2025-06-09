package tiketKonser;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Cursor; // Added

public class ManageKonserInterface extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;
    
    // Admin related fields
    private Admin currentAdmin;
    private JLabel lblAdminGreeting; // For "Hi, [AdminName]"

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin testAdmin = new Admin(1, "adminTest", "pass", "test@admin.com", "Tester Admin");
                    ManageKonserInterface frame = new ManageKonserInterface(testAdmin);
                    frame.setSize(1024, 678);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Default constructor.
     */
    public ManageKonserInterface() {
        initComponents();
        refreshTable(); // Initial table load
        updateAdminGreeting(); // Set default greeting
    }

    /**
     * Constructor that accepts an Admin object.
     * @param admin The currently logged-in Admin object.
     */
    public ManageKonserInterface(Admin admin) {
        this(); // Calls default constructor which calls initComponents and refreshTable
        this.currentAdmin = admin;
        updateAdminGreeting(); // Update greeting with actual admin name
    }

    private void updateAdminGreeting() {
        if (this.currentAdmin != null && this.lblAdminGreeting != null) {
            lblAdminGreeting.setText("Hi, " + this.currentAdmin.getNama());
        } else if (this.lblAdminGreeting != null) {
            lblAdminGreeting.setText("Hi, Admin"); // Default if no admin
        }
    }

    private void refreshTable() {
        if (tableModel == null) { // Ensure tableModel is initialized
             String[] columnNames = {"No", "Konser ID", "Konser", "Tanggal", "Waktu", "Lokasi"};
             tableModel = new DefaultTableModel(columnNames, 0);
             if(table != null) table.setModel(tableModel); // Set model if table already exists
        }
        tableModel.setRowCount(0); // Clear existing rows

        ArrayList<Konser> konserList = Konser.getAllKonser();
        int no = 1;
        if (konserList != null) {
            for (Konser k : konserList) {
                tableModel.addRow(new Object[] {
                    no++,
                    k.getKonserId(),
                    k.getNamaKonser(),
                    k.getTanggalKonser(),
                    k.getWaktuKonser(),
                    k.getLokasiKonser()
                });
            }
        }
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Frame size set by main or calling window
        // setBounds(100, 100, 1024, 678); 

        contentPane = new JPanel();
        contentPane.setBackground(new Color(26, 21, 24));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelSidebar = new JPanel(); // Renamed for clarity
        panelSidebar.setLayout(null);
        panelSidebar.setBackground(new Color(81, 20, 101));
        panelSidebar.setBounds(0, 0, 264, 678); // Standard height
        contentPane.add(panelSidebar);

        // Consolidated Admin Greeting Label
        lblAdminGreeting = new JLabel("Hi, Admin"); // Default text, assigned to instance field
        lblAdminGreeting.setForeground(Color.WHITE);
        lblAdminGreeting.setFont(new Font("Poppins", Font.BOLD, 20));
        lblAdminGreeting.setBounds(36, 42, 200, 30); // Adjusted width
        panelSidebar.add(lblAdminGreeting);

        JLabel lblNavDashboard = new JLabel("Dashboard"); // Was lblNewLabel_4
        lblNavDashboard.setForeground(Color.WHITE);
        lblNavDashboard.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNavDashboard.setBounds(36, 134, 124, 30); // Adjusted Y to match ManageOrder
        lblNavDashboard.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavDashboard.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
                DashboardAdminInterface admin = new DashboardAdminInterface(currentAdmin);
                admin.setSize(1024, 678);
                admin.setVisible(true);
            }
        });
        panelSidebar.add(lblNavDashboard);
        
        JLabel lblNavKelolaKonser = new JLabel("Kelola Konser"); // Was lblNewLabel_3
        lblNavKelolaKonser.setForeground(new Color(200, 200, 255)); // Highlight as active
        lblNavKelolaKonser.setFont(new Font("Poppins Medium", Font.BOLD, 14)); // Bold
        lblNavKelolaKonser.setBounds(36, 175, 168, 40); // Adjusted Y
        panelSidebar.add(lblNavKelolaKonser);
        
        JLabel lblNavKelolaOrder = new JLabel("Kelola Order"); // Was lblNewLabel_3_1
        lblNavKelolaOrder.setForeground(Color.WHITE);
        lblNavKelolaOrder.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNavKelolaOrder.setBounds(36, 216, 168, 40); // Adjusted Y
        lblNavKelolaOrder.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavKelolaOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	dispose();
                ManageOrderInterface order = new ManageOrderInterface(currentAdmin);
                order.setSize(1024, 678);
                order.setVisible(true);
            }
        });
        panelSidebar.add(lblNavKelolaOrder);
        
        JLabel lblNavLogout = new JLabel("Logout"); // Was lblNewLabel_3_3
        lblNavLogout.setForeground(Color.WHITE);
        lblNavLogout.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNavLogout.setBounds(36, panelSidebar.getHeight() - 70, 168, 40); // Position near bottom
        lblNavLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
                new LoginInterface().setVisible(true);
            }
        });
        panelSidebar.add(lblNavLogout);
        
        JLabel lblTitleManageKonser = new JLabel("Manage Konser"); // Was lblNewLabel_2
        lblTitleManageKonser.setForeground(Color.WHITE);
        lblTitleManageKonser.setFont(new Font("Poppins", Font.BOLD, 24)); // Increased font
        lblTitleManageKonser.setBounds(302, 38, 300, 39); // Adjusted width
        contentPane.add(lblTitleManageKonser);
        
        // Table Setup
        String[] columnNames = {"No", "Konser ID", "Nama Konser", "Tanggal", "Waktu", "Lokasi"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
               return false; // Make table cells non-editable
            }
        };
        
        table = new JTable(tableModel);
        table.setFont(new Font("Poppins", Font.PLAIN, 12));
        table.setForeground(new Color(220, 220, 220));
        table.setBackground(new Color(40, 35, 39));
        table.setGridColor(new Color(81, 20, 101));
        table.setRowHeight(25);
        table.setSelectionBackground(new Color(100, 60, 120));
        table.setSelectionForeground(Color.WHITE);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Poppins", Font.BOLD, 14));
        header.setForeground(Color.WHITE);
        header.setBackground(new Color(60, 20, 80));
        header.setReorderingAllowed(false);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(new Color(26, 21, 24));
        scrollPane.setBounds(302, 119, 1024 - 302 - 30, 678 - 119 - 80); // Dynamic sizing
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(81,20,101)));
        contentPane.add(scrollPane);
        
        JButton addButton = new JButton("Tambah Konser");
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        addButton.setBackground(new Color(80, 21, 101));
        addButton.setBounds(scrollPane.getX() + scrollPane.getWidth() - 155 - 165 , 75, 155, 33); // Positioned near refresh
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(false);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddKonserInterface().setVisible(true);
            }
        });
        contentPane.add(addButton);
        
        JButton btnRefreshTabel = new JButton("Refresh Tabel");
        btnRefreshTabel.setForeground(Color.WHITE);
        btnRefreshTabel.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        btnRefreshTabel.setFocusPainted(false);
        btnRefreshTabel.setBorderPainted(false);
        btnRefreshTabel.setBackground(new Color(80, 21, 101));
        btnRefreshTabel.setBounds(scrollPane.getX() + scrollPane.getWidth() - 155, 75, 155, 33);
        btnRefreshTabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRefreshTabel.addActionListener(e -> refreshTable());
        contentPane.add(btnRefreshTabel);
    }
}