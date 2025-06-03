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

		// Panel kiri (ungu)
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(80, 20, 101)); // Warna ungu
		leftPanel.setBounds(0, 0, 400, 678); // Disesuaikan
		leftPanel.setLayout(null);
		contentPane.add(leftPanel);

		// Logo / Judul
		JLabel lblStagePass = new JLabel("StagePass");
		lblStagePass.setForeground(Color.WHITE);
		lblStagePass.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 48)); // Font diperbesar
		lblStagePass.setBounds(100, 300, 250, 60); // Disesuaikan
		leftPanel.add(lblStagePass);

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
