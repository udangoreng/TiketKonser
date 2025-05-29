package tiketKonser;

import java.awt.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DaftarKonserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				DaftarKonserInterface frame = new DaftarKonserInterface();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public DaftarKonserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 678);
		setLocationRelativeTo(null); // Center the frame

		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 20, 24));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Sidebar panel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(81, 20, 101));
		panel.setBounds(0, 0, 311, 678);
		panel.setLayout(null);
		contentPane.add(panel);

		JLabel lblHiUsername = new JLabel("Hi, Username");
		lblHiUsername.setForeground(Color.WHITE);
		lblHiUsername.setFont(new Font("Poppins", Font.BOLD, 20));
		lblHiUsername.setBounds(24, 55, 146, 30);
		panel.add(lblHiUsername);

		JLabel lblLihatKonser = new JLabel("Lihat Konser");
		lblLihatKonser.setForeground(Color.WHITE);
		lblLihatKonser.setFont(new Font("Poppins", Font.BOLD, 14));
		lblLihatKonser.setBounds(24, 149, 131, 30);
		panel.add(lblLihatKonser);

		JLabel lblTiketSaya = new JLabel("Tiket Saya");
		lblTiketSaya.setForeground(Color.WHITE);
		lblTiketSaya.setFont(new Font("Poppins", Font.BOLD, 14));
		lblTiketSaya.setBounds(24, 191, 131, 30);
		panel.add(lblTiketSaya);

		JLabel lblProfilSaya = new JLabel("Profil Saya");
		lblProfilSaya.setForeground(Color.WHITE);
		lblProfilSaya.setFont(new Font("Poppins", Font.BOLD, 14));
		lblProfilSaya.setBounds(24, 232, 131, 30);
		panel.add(lblProfilSaya);

		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("Poppins", Font.BOLD, 14));
		lblLogout.setBounds(24, 586, 131, 30);
		panel.add(lblLogout);

		// Judul konser
		JLabel lblTitle = new JLabel("Semua Konser");
		lblTitle.setFont(new Font("Poppins", Font.BOLD, 28));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(340, 30, 400, 40);
		contentPane.add(lblTitle);

		// Panel untuk gambar konser
		JPanel panelGambar = new JPanel();
		panelGambar.setBounds(340, 90, 650, 530);
		panelGambar.setBackground(new Color(25, 20, 24));
		panelGambar.setLayout(new GridLayout(2, 3, 15, 15));
		contentPane.add(panelGambar);

		// Data gambar dan nama artis
		String[] imageUrls = {
			"https://drive.google.com/uc?export=view&id=1_plVFV5K2Bo6WRLbGOgLka81362RGonC",
			"https://drive.google.com/uc?export=view&id=1pHAVA98KoPhmVHSQD1IB4An4XYk4_5La",
			"https://drive.google.com/uc?export=view&id=13kqGpmdGYcscWLV4Km9vZJbg1E7JsGKQ",
			"https://drive.google.com/uc?export=view&id=1eAxLkHegiuXVzWdqOFMDbXxRliZ5OXmk",
			"https://drive.google.com/uc?export=view&id=1jv2aqHNRXd33grE76ZREYlO41hCN28u3",
			"https://drive.google.com/uc?export=view&id=1Pii7LHpNLltOTSjMokEjX4DnzjSUdXhq"
		};

		String[] artistNames = {
			"Bruno Mars", "Hindia", "Taylor Swift", "Tulus", "Justin Bieber", "Fiersa Besari"
		};

		for (int i = 0; i < imageUrls.length; i++) {
			JPanel itemPanel = new JPanel();
			itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
			itemPanel.setBackground(new Color(25, 20, 24));

			try {
				URL url = new URL(imageUrls[i]);
				ImageIcon icon = new ImageIcon(url);
				Image image = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
				JLabel imageLabel = new JLabel(new ImageIcon(image));
				imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				itemPanel.add(imageLabel);
			} catch (Exception e) {
				JLabel errorLabel = new JLabel("Gagal memuat gambar");
				errorLabel.setForeground(Color.WHITE);
				errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				itemPanel.add(errorLabel);
			}

			JLabel nameLabel = new JLabel(artistNames[i]);
			nameLabel.setForeground(Color.WHITE);
			nameLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
			nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			itemPanel.add(Box.createVerticalStrut(5));
			itemPanel.add(nameLabel);

			JButton detailButton = new JButton("Detail");
			detailButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			detailButton.setBackground(new Color(81, 20, 101));
			detailButton.setForeground(Color.WHITE);
			detailButton.setFocusPainted(false);
			detailButton.setFont(new Font("Poppins", Font.PLAIN, 12));
			detailButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			detailButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

			// Contoh aksi ketika tombol diklik
			int index = i;
			detailButton.addActionListener(e -> {
				JOptionPane.showMessageDialog(this, "Detail konser: " + artistNames[index]);
			});

			itemPanel.add(Box.createVerticalStrut(5));
			itemPanel.add(detailButton);

			panelGambar.add(itemPanel);
		}
	}
}
