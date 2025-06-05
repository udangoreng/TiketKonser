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
		setBounds(100, 100, 1043, 678);

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
		
		// Label Register
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setForeground(new Color(255, 255, 255));
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Poppins", Font.BOLD, 35)); // Font diperbesar
		lblRegister.setBounds(664, 103, 200, 50); // Disesuaikan
		contentPane.add(lblRegister);

		// Nama
		JLabel lblNama = new JLabel("Nama:");
		lblNama.setForeground(Color.WHITE);
		lblNama.setFont(new Font("Poppins", Font.PLAIN, 18)); // Font diperbesar
		lblNama.setBounds(550, 177, 100, 25); // Disesuaikan
		contentPane.add(lblNama);

		txtNama = new JTextField();
		txtNama.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		txtNama.setBounds(550, 199, 400, 40); // Disesuaikan
		txtNama.setBackground(Color.DARK_GRAY);
		txtNama.setForeground(Color.WHITE);
		txtNama.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		contentPane.add(txtNama);

		// Email
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Poppins", Font.PLAIN, 18)); // Font diperbesar
		lblEmail.setBounds(550, 262, 100, 25); // Disesuaikan
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		txtEmail.setBounds(550, 284, 400, 40); // Disesuaikan
		txtEmail.setBackground(Color.DARK_GRAY);
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		contentPane.add(txtEmail);

		// Password
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Poppins", Font.PLAIN, 18)); // Font diperbesar
		lblPassword.setBounds(550, 348, 150, 25); // Disesuaikan
		contentPane.add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		txtPassword.setBounds(550, 367, 400, 40); // Disesuaikan
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
		btnRegister.setBounds(550, 452, 400, 45); // Disesuaikan
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBackground(new Color(128, 0, 255)); // ungu
		btnRegister.setFocusPainted(false);
		btnRegister.setFont(new Font("Poppins", Font.BOLD, 18)); // Font diperbesar
		btnRegister.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		        String nama = txtNama.getText();
		        String email = txtEmail.getText();
		        String password = new String(txtPassword.getPassword());

		        if (nama.isEmpty() || email.isEmpty() || password.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Semua field harus diisi!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        if (User.isEmailExist(email)) {
		            JOptionPane.showMessageDialog(null, "Email sudah terdaftar!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
				User.register(nama, email, password);
		        JOptionPane.showMessageDialog(null, "Register Berhasil! Harap Login Untuk Memulai Aplikasi", "Registrasi Sukses", JOptionPane.INFORMATION_MESSAGE);
//		        User.getAllUsers();

		        new LoginInterface().setVisible(true);
		        dispose();
		    }
		});
		contentPane.add(btnRegister);

		// Sudah punya akun
		JLabel lblLogin = new JLabel("Sudah punya akun? Login");
		lblLogin.setForeground(Color.LIGHT_GRAY);
		lblLogin.setFont(new Font("Poppins", Font.PLAIN, 18)); // Font diperbesar
		lblLogin.setBounds(550, 508, 250, 20);
		lblLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblLogin.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new LoginInterface().setVisible(true);
		    	dispose();
		    }
		});
		contentPane.add(lblLogin);
		
		ImageIcon originalIcon = new ImageIcon("C:\\Users\\hasnatyam\\eclipse-workspace\\TiketKonser\\img\\StagePass-removebg-preview.png");

		// Resize image
		Image originalImage = originalIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(150, 100, Image.SCALE_SMOOTH);

		// Masukkan image yang sudah diresize ke dalam JLabel
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(resizedImage));
		lblNewLabel.setBounds(885, 11, 134, 65);
		contentPane.add(lblNewLabel);
	}
}
