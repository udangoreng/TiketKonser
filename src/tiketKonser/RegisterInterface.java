package tiketKonser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;

public class RegisterInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterInterface frame = new RegisterInterface();
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
	public RegisterInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(194, 23, 1, 16);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_3 = new JLabel("Nama :");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_3.setBounds(401, 267, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email :");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_4.setBounds(401, 313, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password :");
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_5.setBounds(401, 357, 92, 16);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(590, 303, 190, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(590, 263, 190, 26);
		contentPane.add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(590, 353, 187, 26);
		contentPane.add(passwordField);
		
		lblNewLabel = new JLabel("Register");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setBounds(540, 213, 164, 24);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton.setBounds(511, 418, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblStagepass = new JLabel("StagePass");
		lblStagepass.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 25));
		lblStagepass.setBounds(511, 163, 164, 24);
		contentPane.add(lblStagepass);
		
		JLabel lblNewLabel_5_1 = new JLabel("confirm password");
		lblNewLabel_5_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_5_1.setBounds(669, 379, 111, 16);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Sudah punya akun? LogIn");
		lblNewLabel_5_1_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_5_1_1.setBounds(482, 446, 164, 16);
		contentPane.add(lblNewLabel_5_1_1);
	}
}
