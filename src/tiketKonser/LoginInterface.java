package tiketKonser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class LoginInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInterface frame = new LoginInterface();
					frame.setSize(1024, 678);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1035, 737);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(26, 21, 24));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBounds(556, 301, 400, 40);
		contentPane.add(passwordField);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		textPane.setForeground(new Color(255, 255, 255));
		textPane.setBackground(Color.DARK_GRAY);
		textPane.setBounds(556, 227, 400, 40);
		textPane.setBorder(BorderFactory.createLineBorder(getForeground()));
		contentPane.add(textPane);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 18));
		lblNewLabel_1.setBounds(556, 278, 118, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LogIn");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 30));
		lblNewLabel_2.setBounds(705, 127, 136, 53);
		contentPane.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember me");
		chckbxNewCheckBox.setBackground(new Color(26, 21, 24));
		chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Poppins", Font.PLAIN, 15));
		chckbxNewCheckBox.setBounds(556, 351, 164, 40);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				        String email = textPane.getText();
				        String password = new String(passwordField.getPassword());

				        User user = User.login(email, password);
				        if (user != null) {
				            if (user instanceof Admin) {
				                Admin admin = (Admin) user;
				                JOptionPane.showMessageDialog(null, "Login Admin Berhasil! Selamat datang, " + admin.getNama());
				                DashboardAdminInterface adminIn = new DashboardAdminInterface();
				                adminIn.setSize(1024, 678);
				                adminIn.setVisible(true);
				                
				            } else {
				                JOptionPane.showMessageDialog(null, "Login User Berhasil! Selamat datang, " + user.getNama());
				                DashboardInterface dashboard= new DashboardInterface(user);
				            	dashboard.setSize(1024, 678);
				            	dashboard.setVisible(true);
				            }
				            dispose();
				        } else {
				            JOptionPane.showMessageDialog(null, "Email atau password salah.");
				        }

			}
		});
		btnNewButton.setBounds(556, 391, 400, 40);
		btnNewButton.setBackground(new Color(81, 20, 101));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("forgot password");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(826, 341, 173, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Don't have account?");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(556, 433, 164, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SignUp");
		lblNewLabel_5.setForeground(new Color(0, 128, 255));
		lblNewLabel_5.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(719, 427, 95, 27);
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new RegisterInterface().setVisible(true);
		    	dispose();
		    }
		});
		contentPane.add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(81, 20, 101));
		panel.setBounds(0, 0, 510, 849);
		panel.setLayout(null);
		contentPane.add(panel);

		JLabel lblNewLabel_10 = new JLabel();
		lblNewLabel_10.setBounds(0, 0, 510, 704);
		lblNewLabel_10.setIcon(new ImageIcon("./img/mainLogin.jpg"));
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 510, 704);
		layeredPane.setLayout(null);
		panel.add(layeredPane);
		layeredPane.add(lblNewLabel_10, Integer.valueOf(0));

		JLabel lblNewLabel_7 = new JLabel("WELCOME TO ");
		lblNewLabel_7.setBounds(34, 30, 400, 50); 
		lblNewLabel_7.setFont(new Font("Poppins", Font.BOLD, 35));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		layeredPane.add(lblNewLabel_7, Integer.valueOf(1));

		JLabel lblNewLabel_6 = new JLabel("StagePass");
		lblNewLabel_6.setBounds(227, 69, 400, 44);
		lblNewLabel_6.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		layeredPane.add(lblNewLabel_6, Integer.valueOf(1));

		JLabel lblNewLabel_8 = new JLabel("Dari Layar ke Panggung");
		lblNewLabel_8.setBounds(45, 585, 400, 26);
		lblNewLabel_8.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		layeredPane.add(lblNewLabel_8, Integer.valueOf(1));

		JLabel lblNewLabel_9 = new JLabel("Semua Dimulai di Stagepass");
		lblNewLabel_9.setBounds(45, 609, 400, 26);
		lblNewLabel_9.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		layeredPane.add(lblNewLabel_9, Integer.valueOf(1));
		
		JLabel lblNewLabel_11 = new JLabel("Email:");
		lblNewLabel_11.setFont(new Font("Poppins", Font.BOLD, 18));
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(556, 214, 95, 14);
		contentPane.add(lblNewLabel_11);
		
		// Buat ImageIcon dari file gambar
		ImageIcon originalIcon = new ImageIcon("./img/StagePass-removebg-preview.png");

		// Ambil Image dari ImageIcon
		Image originalImage = originalIcon.getImage();

		// Resize Image ke ukuran yang kamu inginkan (contoh: 291 x 172)
		Image resizedImage = originalImage.getScaledInstance(150, 100, Image.SCALE_SMOOTH);

		// Buat JLabel dan set gambar yang sudah di-resize
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(resizedImage));
		lblNewLabel.setBounds(882, 11, 129, 73);
		contentPane.add(lblNewLabel);

	}
}