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
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
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
	public LoginInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1171, 737);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(26, 21, 24));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(731, 344, 218, 27);
		contentPane.add(passwordField);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(731, 293, 218, 27);
		textPane.setBorder(BorderFactory.createLineBorder(getForeground()));
		contentPane.add(textPane);
		
		JLabel lblNewLabel = new JLabel("Email :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 15));
		lblNewLabel.setBounds(664, 293, 129, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 15));
		lblNewLabel_1.setBounds(632, 343, 118, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LogIn");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_2.setBounds(794, 227, 136, 53);
		contentPane.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember me");
		chckbxNewCheckBox.setBackground(new Color(26, 21, 24));
		chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Poppins", Font.PLAIN, 11));
		chckbxNewCheckBox.setBounds(730, 399, 219, 27);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DashboardInterface().setVisible(true);
			}
		});
		btnNewButton.setBounds(731, 418, 218, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("forgot password");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(851, 377, 173, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Don't have account?");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(741, 469, 136, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SignUp");
		lblNewLabel_5.setForeground(new Color(0, 128, 255));
		lblNewLabel_5.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(870, 470, 49, 14);
		contentPane.add(lblNewLabel_5);
		
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
		lblNewLabel_7.setBounds(30, 88, 400, 50); 
		lblNewLabel_7.setFont(new Font("Poppins", Font.BOLD, 30));
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		layeredPane.add(lblNewLabel_7, Integer.valueOf(1));

		JLabel lblNewLabel_6 = new JLabel("StagePass");
		lblNewLabel_6.setBounds(202, 121, 400, 44);
		lblNewLabel_6.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		layeredPane.add(lblNewLabel_6, Integer.valueOf(1));

		JLabel lblNewLabel_8 = new JLabel("Dari Layar ke Panggung");
		lblNewLabel_8.setBounds(30, 206, 400, 26);
		lblNewLabel_8.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_8.setForeground(new Color(0, 0, 0));
		layeredPane.add(lblNewLabel_8, Integer.valueOf(1));

		JLabel lblNewLabel_9 = new JLabel("Semua Dimulai di Stagepass");
		lblNewLabel_9.setBounds(30, 243, 400, 26);
		lblNewLabel_9.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		layeredPane.add(lblNewLabel_9, Integer.valueOf(1));
	}
}
