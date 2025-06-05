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

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DashboardAdminInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardAdminInterface frame = new DashboardAdminInterface();
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
	public DashboardAdminInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1043, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(26, 21, 24));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 264, 760);
		panel.setLayout(null);
		panel.setBackground(new Color(81, 20, 101));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Hi, ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel.setBounds(36, 42, 45, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Kelola Konser");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(36, 192, 168, 40);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	dispose();
		        new ManageKonserInterface().setVisible(true);
		    }
		});
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Kelola Order");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(36, 233, 168, 40);
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
		lblNewLabel_1.setBounds(67, 42, 175, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 20));
		
		JLabel lblNewLabel_4 = new JLabel("Dashboard");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(36, 151, 124, 30);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(81, 20, 101), 1, true));
		panel_1_1.setBackground(new Color(26, 21, 24));
		panel_1_1.setBounds(537, 47, 165, 98);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Jumlah Order");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 11, 125, 34);
		panel_1_1.add(lblNewLabel_2_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(81, 20, 101), 1, true));
		panel_1_1_1.setBackground(new Color(26, 21, 24));
		panel_1_1_1.setBounds(333, 47, 165, 98);
		contentPane.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Jumlah Konser");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 11, 125, 34);
		panel_1_1_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Konser Terbaru :");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Poppins", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(333, 183, 227, 39);
		contentPane.add(lblNewLabel_2_2);
		
		// Load gambar asli
		ImageIcon originalIcon = new ImageIcon("./img/StagePass-removebg-preview.png");

		// Resize gambar ke 180x183
		Image resizedImage = originalIcon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);

		// Masukkan gambar hasil resize ke JLabel
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(resizedImage));
		lblNewLabel_5.setBounds(882, 11, 125, 82);
		contentPane.add(lblNewLabel_5);
	}
}
