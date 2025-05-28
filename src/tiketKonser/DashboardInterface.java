package tiketKonser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class DashboardInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardInterface frame = new DashboardInterface();
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
	public DashboardInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 596);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(26, 21, 24));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(81, 20, 101));
		panel.setBounds(0, 0, 250, 678);
		panel.setSize(250, 678);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hi, ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(36, 42, 45, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_1.setBounds(65, 42, 175, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Lihat Konser");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(36, 134, 168, 40);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tiket Saya");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(36, 175, 168, 40);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Profil Saya");
		lblNewLabel_3_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_2.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(36, 215, 168, 40);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Logout");
		lblNewLabel_3_3.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(36, 470, 168, 40);
		panel.add(lblNewLabel_3_3);
		lblNewLabel_3_3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	dispose();
		        new LoginInterface().setVisible(true);
		    }
		});
		
		JLabel lblNewLabel_2 = new JLabel("Terbaru dari Kami :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 18));
		lblNewLabel_2.setBounds(260, 45, 227, 39);
		contentPane.add(lblNewLabel_2);
	}
}
