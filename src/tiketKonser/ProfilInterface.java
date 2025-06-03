package tiketKonser;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ProfilInterface extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ProfilInterface frame = new ProfilInterface();
                frame.setSize(1024, 678);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ProfilInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 678); // Ukuran frame tetap
        contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 20, 24)); // warna latar belakang utama
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel Sidebar
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 300, 678); // Disesuaikan
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(81, 20, 101)); // Warna sidebar tetap
        contentPane.add(panel_1);

        JLabel lblHiUsername = new JLabel("Hi, Username");
        lblHiUsername.setForeground(Color.WHITE);
        lblHiUsername.setFont(new Font("Poppins", Font.BOLD, 20));
        lblHiUsername.setBounds(24, 55, 200, 30);
        lblHiUsername.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHiUsername.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new DashboardInterface().setVisible(true);
		    	dispose();
		    }
		});
        panel_1.add(lblHiUsername);

        JLabel lblLihatKonser = new JLabel("Lihat Konser");
        lblLihatKonser.setForeground(Color.WHITE);
        lblLihatKonser.setFont(new Font("Poppins", Font.BOLD, 14));
        lblLihatKonser.setBounds(24, 120, 150, 30);
        lblLihatKonser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblLihatKonser.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new DaftarKonserInterface().setVisible(true);
		    	dispose();
		    }
		});
        panel_1.add(lblLihatKonser);

        JLabel lblTiketSaya = new JLabel("Tiket Saya");
        lblTiketSaya.setForeground(Color.WHITE);
        lblTiketSaya.setFont(new Font("Poppins", Font.BOLD, 14));
        lblTiketSaya.setBounds(24, 170, 150, 30);
        lblTiketSaya.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblTiketSaya.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new TiketSayaInterface().setVisible(true);
		    	dispose();
		    }
		});
        panel_1.add(lblTiketSaya);

        JLabel lblProfilSaya = new JLabel("Profil Saya");
        lblProfilSaya.setForeground(Color.WHITE);
        lblProfilSaya.setFont(new Font("Poppins", Font.BOLD, 14));
        lblProfilSaya.setBounds(24, 220, 150, 30);
        panel_1.add(lblProfilSaya);

        JLabel lblLogout = new JLabel("Logout");
        lblLogout.setForeground(Color.WHITE);
        lblLogout.setFont(new Font("Poppins", Font.BOLD, 14));
        lblLogout.setBounds(24, 550, 150, 30);
        lblLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblLogout.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new LoginInterface().setVisible(true);
		    	dispose();
		    }
		});
        panel_1.add(lblLogout);

        JLabel lblTitle = new JLabel("Profil Saya");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Poppins", Font.BOLD, 28));
        lblTitle.setBounds(350, 30, 300, 50); // Disesuaikan
        contentPane.add(lblTitle);

        // Panel Profil
        JPanel panelProfil = new JPanel();
        panelProfil.setBounds(350, 100, 600, 500); // Disesuaikan
        panelProfil.setLayout(null);
        panelProfil.setBackground(new Color(41, 25, 45)); // Warna panel profil tetap
        panelProfil.setBorder(new LineBorder(new Color(130, 70, 180), 2, true));
        contentPane.add(panelProfil);

        // Foto Profil Placeholder
        JLabel lblFoto = new JLabel();
        lblFoto.setBounds(230, 20, 140, 140);
        lblFoto.setOpaque(true);
        lblFoto.setBackground(new Color(130, 70, 180));
        lblFoto.setBorder(new LineBorder(Color.WHITE, 2, true));
        panelProfil.add(lblFoto);

        // Menambahkan logo profil ke kotak gambar
        try {
            URL url = new URL("https://drive.google.com/uc?export=view&id=1pOJwNaFtThjUVk2CK2-QqZFDjzdLSMaA");
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(url).getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
            lblFoto.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
            lblFoto.setText("Gambar gagal dimuat");
            lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
            lblFoto.setForeground(Color.WHITE);
        }

        // Label + Kotak Keterangan
        String[] labels = { "Nama", "Tempat, Tanggal Lahir", "Jenis Kelamin", "Email", "No. HP" };
        String[] data = { 
            "Samsul", 
            "Jakarta, 1 Januari 1990", 
            "Laki-Laki", 
            "Samsul@example.com", 
            "+62 812 3456 7890" 
        }; // Contoh data
        int y = 160; // Memulai lebih tinggi agar muat semua
        for (int i = 0; i < labels.length; i++) {
            JLabel lbl = new JLabel(labels[i]);
            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("Poppins", Font.PLAIN, 12)); // Ukuran font lebih kecil
            lbl.setBounds(50, y, 200, 20); // Disesuaikan
            panelProfil.add(lbl);

            JPanel dataPanel = new JPanel();
            dataPanel.setBounds(50, y + 20, 480, 30); // Lebar lebih kecil, tinggi lebih pendek
            dataPanel.setBackground(new Color(60, 35, 70));
            dataPanel.setLayout(null);
            dataPanel.setBorder(new LineBorder(new Color(130, 70, 180), 1, true));
            panelProfil.add(dataPanel);

            JLabel dataLabel = new JLabel(data[i]);
            dataLabel.setForeground(Color.WHITE);
            dataLabel.setFont(new Font("Poppins", Font.BOLD, 12)); // Ukuran font lebih kecil
            dataLabel.setBounds(10, 2, 460, 25); // Disesuaikan
            dataPanel.add(dataLabel);

            y += 60; // Jarak antar elemen lebih pendek
        }
    }
}
