package tiketKonser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class AddKonserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel lblNewLabel_1_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1_2;
	private JTextArea textArea;
	private JLabel lblDeskripsiKonser;
	private JTextArea textArea_1;
	private JLabel lblLokasiKonser;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddKonserInterface frame = new AddKonserInterface();
					frame.setVisible(true);
					frame.setSize(424, 678);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddKonserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 708);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(26, 21, 24));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 424, 678);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(26, 21, 24));
		panel.setSize(424, 678);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Nama Konser :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel.setBounds(60, 48, 100, 22);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Tambah Konser");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Poppins Medium", Font.BOLD, 18));
		lblNewLabel_1.setBounds(117, 11, 151, 28);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(60, 81, 280, 30);
		panel.add(textField);
		
		lblNewLabel_1_1 = new JLabel("Waktu :");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(229, 124, 132, 22);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(229, 157, 111, 30);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(60, 157, 132, 30);
		panel.add(textField_2);
		
		lblNewLabel_1_2 = new JLabel("Tanggal :");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(60, 124, 132, 22);
		panel.add(lblNewLabel_1_2);
		
		textArea = new JTextArea();
		textArea.setBounds(60, 341, 280, 165);
		panel.add(textArea);
		
		lblDeskripsiKonser = new JLabel("Deskripsi Konser :");
		lblDeskripsiKonser.setForeground(Color.WHITE);
		lblDeskripsiKonser.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblDeskripsiKonser.setBounds(60, 308, 118, 22);
		panel.add(lblDeskripsiKonser);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(60, 237, 280, 50);
		panel.add(textArea_1);
		
		lblLokasiKonser = new JLabel("Lokasi Konser :");
		lblLokasiKonser.setForeground(Color.WHITE);
		lblLokasiKonser.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblLokasiKonser.setBounds(60, 198, 118, 28);
		panel.add(lblLokasiKonser);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(60, 559, 132, 30);
		panel.add(textField_4);
		
		JLabel lblKategoriKonser = new JLabel("Jumlah Kategori :");
		lblKategoriKonser.setForeground(Color.WHITE);
		lblKategoriKonser.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblKategoriKonser.setBounds(60, 528, 132, 22);
		panel.add(lblKategoriKonser);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.setBounds(229, 559, 118, 28);
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String value = textField_4.getText();
	                new AddCategory(value);
	                dispose();
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(null, "Please enter a valid integer.");
	            }
	        }
	    });
		panel.add(btnSimpan);
	}
}
