package tiketKonser;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class DetailStageKonserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailStageKonserInterface frame = new DetailStageKonserInterface();
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
	public DetailStageKonserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 743);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(26, 21, 24));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		ImageIcon originalIcon = new ImageIcon("./img/stage.jpg");

		// Resize gambar ke ukuran yang lebih kecil, misalnya 300x200
		Image scaledImage = originalIcon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(scaledImage);

		lblNewLabel.setIcon(resizedIcon);
<<<<<<< HEAD
		lblNewLabel.setBounds(23, 79, 506, 383); // Sesuaikan ukuran bounds dengan ukuran gambar baru
=======
		lblNewLabel.setBounds(23, 69, 541, 393); // Sesuaikan ukuran bounds dengan ukuran gambar baru
>>>>>>> dec973fc6069113a5eb52e08a85b3f099c9266fc
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Stage Konser Bruno Mars");
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 25));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(190, 11, 339, 62);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
<<<<<<< HEAD
		ImageIcon icon = new ImageIcon("./img/detailStage.jpg");
        Image scaledImage1 = icon.getImage().getScaledInstance(500, 100, Image.SCALE_SMOOTH);
		lblNewLabel_2.setIcon(new ImageIcon(scaledImage1));
		lblNewLabel_2.setBounds(23, 502, 508, 163);
=======
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hasnatyam\\Downloads\\download (3).jpg"));
		lblNewLabel_2.setBounds(21, 498, 567, 180);
>>>>>>> dec973fc6069113a5eb52e08a85b3f099c9266fc
		contentPane.add(lblNewLabel_2);
		
		 // ComboBox metode pembayaran
        JComboBox<String> comboBoxMetode = new JComboBox<>();
        comboBoxMetode.setFont(new Font("Poppins", Font.PLAIN, 14));
        comboBoxMetode.setBounds(598, 515, 250, 30);
        comboBoxMetode.addItem("Kategori - Harga");
        comboBoxMetode.addItem("Gold VIP Package - Rp 7.650.000");
        comboBoxMetode.addItem("Cat 1 - Rp 6.000.000 ");
        comboBoxMetode.addItem("Silver VIP Package - Rp 5.150.000");
        comboBoxMetode.addItem("Festival A - Rp 3.500.000");
        comboBoxMetode.addItem("Festival B - Rp 2.750.000 ");
        comboBoxMetode.addItem("Cat 2 - Rp 3.500.000");
        comboBoxMetode.addItem("Cat 3 - Rp 2.750.000");
        comboBoxMetode.addItem("Cat 4 - Rp 1.750.000");
        comboBoxMetode.addItem("Cat 5 - Rp 1.450.000");
        comboBoxMetode.addItem("Cat 6 - Rp 1.250.000");
        comboBoxMetode.addItem("Cat 7 - Rp 950.000 ");
        contentPane.add(comboBoxMetode);
        
        JLabel lblNewLabel_3 = new JLabel("Pilih Kategori Seat");
        lblNewLabel_3.setFont(new Font("Poppins", Font.PLAIN, 13));
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setBounds(598, 502, 167, 14);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Deskripsi:");
        lblNewLabel_4.setFont(new Font("Poppins", Font.PLAIN, 13));
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setBounds(23, 484, 118, 14);
        contentPane.add(lblNewLabel_4);
        
        JButton btnNewButton = new JButton("Pesan");
        btnNewButton.setFont(new Font("Poppins", Font.BOLD, 13));
        btnNewButton.setBounds(873, 515, 89, 30);
        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MetodePembayaranInterface().setVisible(true);
			}
		});
        contentPane.add(btnNewButton);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Supaya tidak bisa diedit
        textArea.setBackground(new Color(26, 21, 24)); // Warna latar belakang
        textArea.setForeground(Color.WHITE); // Warna teks
        textArea.setFont(new Font("Poppins", Font.PLAIN, 13)); // Font agar rapi dan sejajar
        textArea.setBounds(588, 69, 387, 418);

        // Isi teks deskripsi tiket
        textArea.setText(
            "⭐ VIP Packages:\n" +
            "GOLD VIP PACKAGE   - IDR 7,650,000\n" +
            "SILVER VIP PACKAGE - IDR 5,150,000\n\n" +

            "🎤 Festival:\n" +
            "FESTIVAL A         - IDR 3,500,000\n" +
            "FESTIVAL B         - IDR 2,750,000\n\n" +

            "🪑 Seating:\n" +
            "CAT 1              - IDR 6,000,000\n" +
            "CAT 2              - IDR 3,500,000\n" +
            "CAT 3              - IDR 2,750,000\n" +
            "CAT 4              - IDR 1,750,000\n" +
            "CAT 5              - IDR 1,450,000\n" +
            "CAT 6              - IDR 1,250,000\n" +
            "CAT 7              - IDR 950,000\n\n" +

            "Catatan:\n" +
            "- Harga belum termasuk pajak & biaya layanan.\n" +
            "- CAT 6 & 7 memiliki pandangan terbatas.\n" +
            "- Tempat duduk bisa berubah menjelang acara.\n"
        );

        contentPane.add(textArea);

	}
}