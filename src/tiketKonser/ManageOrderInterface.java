package tiketKonser;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import java.awt.Cursor;

public class ManageOrderInterface extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable orderTable;
    private DefaultTableModel tableModel;
    private JLabel lblAdminGreeting;
    private Admin currentAdmin;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin testAdmin = new Admin(1, "Admin123", "Admin123", "admin01", "SuperAdmin");
                    ManageOrderInterface frame = new ManageOrderInterface(testAdmin);
                    frame.setSize(1024, 678);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ManageOrderInterface() {
        initComponents();
        loadOrderData();
        updateAdminGreeting();
    }

    public ManageOrderInterface(Admin admin) {
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

    private void loadOrderData() {
        if (tableModel == null) return;
        
        tableModel.setRowCount(0);

        ArrayList<Order> orderList = Order.getAllOrder();

        int rowNum = 1;
        for (Order order : orderList) {
            String userName = "User (ID: " + order.getUserId() + ")";
            User user = User.searchUserById(order.getUserId());
            if (user != null) userName = user.getNama();

            String konserName = "Konser (ID: " + order.getKonserId() + ")";
            Konser konser = Konser.searchKonserById(order.getKonserId());
            if (konser != null) konserName = konser.getNamaKonser();

            tableModel.addRow(new Object[]{
                    rowNum++,
                    order.getOrderId(),
                    userName,
                    konserName,
                    order.getTotal(),
                    order.getStatusBayar()
            });
        }
    }

    private void handleRowClick(int selectedRow) {
        if (selectedRow < 0) return;
        
        int orderId = (int) tableModel.getValueAt(selectedRow, 1);
        Order selectedOrder = Order.getOrderById(orderId);
        
        if (selectedOrder == null) {
            JOptionPane.showMessageDialog(this, "Error: Tidak dapat menemukan detail untuk order yang dipilih.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User user = User.searchUserById(selectedOrder.getUserId());
        Konser konser = Konser.searchKonserById(selectedOrder.getKonserId());
        String userName = (user != null) ? user.getNama() : "Unknown User (ID: " + selectedOrder.getUserId() + ")";
        String konserName = (konser != null) ? konser.getNamaKonser() : "Unknown Concert (ID: " + selectedOrder.getKonserId() + ")";

        String message = String.format(
            "<html><b>Detail Order:</b><br><br>" +
            "<b>Order ID:</b> %d<br>" +
            "<b>User:</b> %s<br>" +
            "<b>Konser:</b> %s<br>" +
            "<b>Total:</b> Rp %,.0f<br>" +
            "<b>Status Saat Ini:</b> %s<br><br>" +
            "Pilih aksi untuk order ini:</html>",
            selectedOrder.getOrderId(), userName, konserName, selectedOrder.getTotal(), selectedOrder.getStatusBayar()
        );

        Object[] options = {"Tandai Terbayar", "Batalkan Pesanan", "Tutup"};
        
        int choice = JOptionPane.showOptionDialog(this, message, "Manage Order ID: " + orderId,
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

        switch (choice) {
            case 0: 
                selectedOrder.setStatusBayar("Terbayar");
                JOptionPane.showMessageDialog(this, "Status order #" + orderId + " telah diubah menjadi 'Terbayar'.", "Update Sukses", JOptionPane.INFORMATION_MESSAGE);
                loadOrderData();
                break;
            case 1: 
                int confirmCancel = JOptionPane.showConfirmDialog(this, "Anda yakin ingin membatalkan order ini?", "Konfirmasi Pembatalan", JOptionPane.YES_NO_OPTION);
                if (confirmCancel == JOptionPane.YES_OPTION) {
                    selectedOrder.setStatusBayar("Dibatalkan");
                    JOptionPane.showMessageDialog(this, "Status order #" + orderId + " telah diubah menjadi 'Dibatalkan'.", "Update Sukses", JOptionPane.INFORMATION_MESSAGE);
                    loadOrderData();
                }
                break;
            default:
                break;
        }
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBackground(new Color(26, 21, 24));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelSidebar = new JPanel();
        panelSidebar.setLayout(null);
        panelSidebar.setBackground(new Color(81, 20, 101));
        panelSidebar.setBounds(0, 0, 264, 678);
        contentPane.add(panelSidebar);

        lblAdminGreeting = new JLabel("Hi, Admin");
        lblAdminGreeting.setForeground(Color.WHITE);
        lblAdminGreeting.setFont(new Font("Poppins", Font.BOLD, 20));
        lblAdminGreeting.setBounds(36, 42, 200, 30);
        panelSidebar.add(lblAdminGreeting);

        JLabel lblNavDashboard = new JLabel("Dashboard");
        lblNavDashboard.setForeground(Color.WHITE);
        lblNavDashboard.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNavDashboard.setBounds(36, 134, 124, 30);
        lblNavDashboard.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavDashboard.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
                DashboardAdminInterface adminFrame = new DashboardAdminInterface(currentAdmin);
                adminFrame.setSize(1024, 678);
                adminFrame.setLocationRelativeTo(null);
                adminFrame.setVisible(true);
            }
        });
        panelSidebar.add(lblNavDashboard);

        JLabel lblNavKelolaKonser = new JLabel("Kelola Konser");
        lblNavKelolaKonser.setForeground(Color.WHITE);
        lblNavKelolaKonser.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        lblNavKelolaKonser.setBounds(36, 175, 168, 40);
        lblNavKelolaKonser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNavKelolaKonser.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
                ManageKonserInterface konserFrame = new ManageKonserInterface(currentAdmin);
                konserFrame.setSize(1024, 678);
                konserFrame.setLocationRelativeTo(null);
                konserFrame.setVisible(true);
            }
        });
        panelSidebar.add(lblNavKelolaKonser);

        JLabel lblNavKelolaOrder = new JLabel("Kelola Order");
        lblNavKelolaOrder.setForeground(new Color(200, 200, 255));
        lblNavKelolaOrder.setFont(new Font("Poppins Medium", Font.BOLD, 14));
        lblNavKelolaOrder.setBounds(36, 216, 168, 40);
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

        JLabel lblTitleManageOrder = new JLabel("Manage Order");
        lblTitleManageOrder.setForeground(Color.WHITE);
        lblTitleManageOrder.setFont(new Font("Poppins", Font.BOLD, 24));
        lblTitleManageOrder.setBounds(302, 38, 300, 39);
        contentPane.add(lblTitleManageOrder);

        String[] columnNames = {"No.", "Order ID", "User", "Konser", "Total", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        
        orderTable = new JTable(tableModel);
        orderTable.setFont(new Font("Poppins", Font.PLAIN, 12));
        orderTable.setForeground(new Color(220, 220, 220));
        orderTable.setBackground(new Color(40, 35, 39));
        orderTable.setGridColor(new Color(81, 20, 101));
        orderTable.setRowHeight(25);
        orderTable.setSelectionBackground(new Color(100, 60, 120));
        orderTable.setSelectionForeground(Color.WHITE);

        // Add the MouseListener to the table
        orderTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = orderTable.getSelectedRow();
                handleRowClick(selectedRow);
            }
        });

        JTableHeader header = orderTable.getTableHeader();
        header.setFont(new Font("Poppins", Font.BOLD, 14));
        header.setForeground(Color.WHITE);
        header.setBackground(new Color(60, 20, 80));
        header.setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(orderTable);
        scrollPane.getViewport().setBackground(new Color(26, 21, 24));
        scrollPane.setBounds(302, 90, 1024 - 302 - 30, 678 - 90 - 60);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(81,20,101)));
        contentPane.add(scrollPane);
    }
}