package tiketKonser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class DetailKonserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailKonserInterface frame = new DetailKonserInterface();
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
	public DetailKonserInterface() {
		setBackground(new Color(81, 20, 101));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1224, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(26, 21, 24));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(81, 20, 101));
		panel.setBounds(0, 0, 255, 661);
		panel.setSize(250,678);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hi, Username");
		lblNewLabel.setBounds(44, 51, 149, 22);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(26, 21, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new DashboardInterface().setVisible(true);
		    	dispose();
		    }
		});
		
		JLabel lblNewLabel_1 = new JLabel("Lihat Konser");
		lblNewLabel_1.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(26, 21, 24));
		lblNewLabel_1.setBounds(44, 200, 153, 31);
		lblNewLabel_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new DaftarKonserInterface().setVisible(true);
		    	dispose();
		    }
		});
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tiket Saya");
		lblNewLabel_2.setBackground(new Color(26, 21, 24));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(44, 242, 138, 22);
		lblNewLabel_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new TiketSayaInterface().setVisible(true);
		    	dispose();
		    }
		});
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Profil Saya");
		lblNewLabel_3.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_3.setBackground(new Color(26, 21, 24));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(44, 275, 133, 31);
		lblNewLabel_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new ProfilInterface().setVisible(true);
		    	dispose();
		    }
		});
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("LogOut");
		lblNewLabel_4.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(26, 21, 24));
		lblNewLabel_4.setBounds(44, 593, 79, 22);
		lblNewLabel_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new LoginInterface().setVisible(true);
		    	dispose();
		    }
		});
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("BRUNO MARS - JAKARTA INTERNASIONAL  STADIUM");
		lblNewLabel_5.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(272, 27, 554, 62);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(271, 88, 350, 450);

		ImageIcon icon = new ImageIcon("C:\\Users\\hasnatyam\\Downloads\\download.jpg");
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(350, 450, Image.SCALE_SMOOTH);
		lblNewLabel_6.setIcon(new ImageIcon(newImg));

		contentPane.add(lblNewLabel_6);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(647, 88, 478, 372);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Poppins", Font.PLAIN, 13));
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(new Color(26, 21, 24));
		textArea.setText(
		    "🎤 Konser Bruno Mars - Jakarta 2024\n\n" +
		    "📅 Tanggal: 13-14 September 2024\n" +
		    "🕗 Waktu: 20:00 WIB (pintu dibuka 18:00 WIB)\n" +
		    "📍 Lokasi:\n" +
		    "Jakarta International Stadium (JIS)\n" +
		    "Jl. Sunter Permai Raya, Tanjung Priok, Jakarta Utara\n\n" +
		    "👨‍🎤 Artis:\n" +
		    "Bruno Mars & The Hooligans\n\n" +
		    "Tentang Artis\n"+
		    "Bruno Mars (nama asli: Peter Gene Hernandez) adalah penyanyi, penulis lagu, dan produser musik asal Amerika Serikat yang dikenal dengan gaya retro dan funky. Kariernya melejit sejak 2010 dan ia dikenal sebagai salah satu performer terbaik secara live.\n\n"+
		    "Genre: Pop, Funk, R&B\n" +
		    "Hits: Uptown Funk, 24K Magic, Just The Way You Are, When I Was Your Man\n\n"
		);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("pesan tiket");
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DetailStageKonserInterface().setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(1015, 515, 142, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Kategori seat:");
		lblNewLabel_7.setBackground(new Color(26, 21, 24));
		lblNewLabel_7.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(647, 473, 98, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("klick for more info");
		lblNewLabel_8.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblNewLabel_8.setForeground(new Color(0, 128, 255));
		lblNewLabel_8.setBackground(new Color(26, 21, 24));
		lblNewLabel_8.setBounds(742, 473, 137, 14);
		contentPane.add(lblNewLabel_8);
	}
}