package tiketKonser;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNama;
	private JTextField txtEmail;
	private JPasswordField txtPassword;

	public static void main(String[] args) {
		 EventQueue.invokeLater(() -> {
	            try {
	                RegisterInterface frame = new RegisterInterface();
	                frame.setSize(1024, 678);
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
		});
	}

	public RegisterInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 678);
		setUndecorated(true); // Tanpa border/frame OS

		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 20, 24)); // Warna background utama (kanan)
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(81, 20, 101));
		panel.setBounds(0, 0, 510, 849);
		panel.setLayout(null);
		contentPane.add(panel);

		JLabel lblNewLabel_10 = new JLabel();
		lblNewLabel_10.setBounds(0, 0, 510, 704);
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\hasnatyam\\Downloads\\download (1).jpg"));
		
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

		// Label Register
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("SansSerif", Font.BOLD, 36)); // Font diperbesar
		lblRegister.setBounds(595, 56, 200, 50); // Disesuaikan
		contentPane.add(lblRegister);

		// Nama
		JLabel lblNama = new JLabel("Nama:");
		lblNama.setForeground(Color.WHITE);
		lblNama.setFont(new Font("SansSerif", Font.PLAIN, 18)); // Font diperbesar
		lblNama.setBounds(550, 147, 100, 25); // Disesuaikan
		contentPane.add(lblNama);

		txtNama = new JTextField();
		txtNama.setBounds(549, 177, 400, 40); // Disesuaikan
		txtNama.setBackground(Color.DARK_GRAY);
		txtNama.setForeground(Color.WHITE);
		txtNama.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		contentPane.add(txtNama);

		// Email
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 18)); // Font diperbesar
		lblEmail.setBounds(550, 243, 100, 25); // Disesuaikan
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(550, 266, 400, 40); // Disesuaikan
		txtEmail.setBackground(Color.DARK_GRAY);
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		contentPane.add(txtEmail);

		// Password
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 18)); // Font diperbesar
		lblPassword.setBounds(550, 327, 150, 25); // Disesuaikan
		contentPane.add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(549, 362, 400, 40); // Disesuaikan
		txtPassword.setBackground(Color.DARK_GRAY);
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		contentPane.add(txtPassword);

		// Tombol Register
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.setBounds(550, 425, 400, 45); // Disesuaikan
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setBackground(new Color(128, 0, 255)); // ungu
		btnRegister.setFocusPainted(false);
		btnRegister.setFont(new Font("SansSerif", Font.BOLD, 18)); // Font diperbesar
		contentPane.add(btnRegister);

		// Sudah punya akun
		JLabel lblLogin = new JLabel("Sudah punya akun? Login");
		lblLogin.setForeground(Color.LIGHT_GRAY);
		lblLogin.setFont(new Font("SansSerif", Font.PLAIN, 14)); // Font diperbesar
		lblLogin.setBounds(550, 481, 250, 20);
		lblLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblLogin.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new LoginInterface().setVisible(true);
		    	dispose();
		    }
		});
		contentPane.add(lblLogin);
	}
}
