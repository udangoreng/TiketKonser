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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.BorderFactory;

public class ManageKonserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageKonserInterface frame = new ManageKonserInterface();
					frame.setVisible(true);
					frame.setSize(1024, 678);				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageKonserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 678);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(26, 21, 24));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 20, 101));
		panel.setBounds(0, 0, 264, 760);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Hi, ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel.setBounds(36, 42, 45, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Kelola Konser");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(36, 178, 168, 40);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Kelola Order");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(36, 219, 168, 40);
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	dispose();
		        new ManageOrderInterface().setVisible(true);
		    }
		});
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_3 = new JLabel("Logout");
		lblNewLabel_3_3.setForeground(Color.WHITE);
		lblNewLabel_3_3.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(36, 464, 168, 40);
		lblNewLabel_3_3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	dispose();
		        new LoginInterface().setVisible(true);
		    }
		});
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_1 = new JLabel("Admin");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_1.setBounds(67, 42, 175, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Dashboard");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(35, 147, 124, 30);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	dispose();
		        new DashboardAdminInterface().setVisible(true);
		    }
		});
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Manage Konser");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 18));
		lblNewLabel_2.setBounds(302, 38, 227, 39);
		contentPane.add(lblNewLabel_2);
		
		String[] columnNames = {"No", "Konser ID", "Konser", "Tanggal/Waktu", "Lokasi", "Aksi"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		model.addRow(new Object[]{"1", "Alice", "30", "Engineering"});
        model.addRow(new Object[]{"2", "Bob", "25", "Design"});
        model.addRow(new Object[]{"3", "Charlie", "28", "HR"});
        JTable table = new JTable(model);
		table.setFont(new Font("Poppins", Font.PLAIN, 12));
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(26, 21, 24));
		table.setBounds(302, 119, 661, 480);
		JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Poppins", Font.BOLD, 14));
        header.setForeground(Color.WHITE);
        header.setBackground(new Color(26, 21, 24));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(new Color(26, 21, 24));
        scrollPane.setBounds(302, 119, 661, 480);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        contentPane.add(scrollPane);
	}

}
