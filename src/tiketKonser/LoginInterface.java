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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
		setBounds(100, 100, 1029, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(640, 345, 218, 27);
		contentPane.add(passwordField);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(640, 293, 218, 27);
		contentPane.add(textPane);
		
		JLabel lblNewLabel = new JLabel("Email :");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(570, 293, 129, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1.setBounds(539, 343, 118, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LogIn");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_2.setBounds(691, 235, 136, 53);
		contentPane.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember me");
		chckbxNewCheckBox.setBounds(639, 398, 219, 27);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(640, 417, 218, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("forgot password");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(752, 377, 173, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Don't have account?");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(640, 469, 201, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SignUp");
		lblNewLabel_5.setForeground(new Color(0, 128, 255));
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(778, 469, 49, 14);
		contentPane.add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 192));
		panel.setBounds(-22, 0, 510, 849);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("StagePass");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(213, 215, 255, 44);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		
		JLabel lblNewLabel_7 = new JLabel("WELCOME TO ");
		lblNewLabel_7.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(140, 125, 246, 122);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Dari Layar ke Panggung");
		lblNewLabel_8.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_8.setBounds(121, 305, 318, 26);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Semua Dimulai di Stagepass");
		lblNewLabel_9.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_9.setBounds(94, 342, 345, 62);
		panel.add(lblNewLabel_9);
	}
}
