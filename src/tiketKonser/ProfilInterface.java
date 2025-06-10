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
    private JTextField txtNama, txtTempatLahir, txtEmail, txtNoHP;
    private JComboBox<String> cbHari, cbBulan, cbTahun;
    private JComboBox<String> cbJenisKelamin;

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
        setBounds(100, 100, 1024, 678);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 20, 24));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel Sidebar
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 300, 678);
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(81, 20, 101));
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
        lblTitle.setBounds(350, 30, 300, 50);
        contentPane.add(lblTitle);

        // Panel Profil
        JPanel panelProfil = new JPanel();
        panelProfil.setBounds(350, 100, 600, 500);
        panelProfil.setLayout(null);
        panelProfil.setBackground(new Color(41, 25, 45));
        panelProfil.setBorder(new LineBorder(new Color(130, 70, 180), 2, true));
        contentPane.add(panelProfil);

        // Foto Profil Placeholder
        JLabel lblFoto = new JLabel();
        lblFoto.setBounds(230, 20, 140, 140);
        lblFoto.setOpaque(true);
        lblFoto.setBackground(new Color(130, 70, 180));
        lblFoto.setBorder(new LineBorder(Color.WHITE, 2, true));
        panelProfil.add(lblFoto);

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

        // Form Input Fields
        int y = 180;
        
        // Nama
        JLabel lblNama = new JLabel("Nama");
        lblNama.setForeground(Color.WHITE);
        lblNama.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblNama.setBounds(50, y, 200, 20);
        panelProfil.add(lblNama);
        
        txtNama = new JTextField();
        txtNama.setBounds(50, y + 20, 480, 30);
        txtNama.setBackground(new Color(60, 35, 70));
        txtNama.setForeground(Color.WHITE);
        txtNama.setBorder(new LineBorder(new Color(130, 70, 180), 1, true));
        txtNama.setFont(new Font("Poppins", Font.PLAIN, 12));
        panelProfil.add(txtNama);
        y += 60;
        
        // Tempat Lahir
        JLabel lblTempatLahir = new JLabel("Tempat Lahir");
        lblTempatLahir.setForeground(Color.WHITE);
        lblTempatLahir.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblTempatLahir.setBounds(50, y, 200, 20);
        panelProfil.add(lblTempatLahir);
        
        txtTempatLahir = new JTextField();
        txtTempatLahir.setBounds(50, y + 20, 480, 30);
        txtTempatLahir.setBackground(new Color(60, 35, 70));
        txtTempatLahir.setForeground(Color.WHITE);
        txtTempatLahir.setBorder(new LineBorder(new Color(130, 70, 180), 1, true));
        txtTempatLahir.setFont(new Font("Poppins", Font.PLAIN, 12));
        panelProfil.add(txtTempatLahir);
        y += 60;
        
        // Tanggal Lahir
        JLabel lblTanggalLahir = new JLabel("Tanggal Lahir");
        lblTanggalLahir.setForeground(Color.WHITE);
        lblTanggalLahir.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblTanggalLahir.setBounds(50, y, 200, 20);
        panelProfil.add(lblTanggalLahir);
        
        JPanel panelTanggalLahir = new JPanel();
        panelTanggalLahir.setBounds(50, y + 20, 480, 30);
        panelTanggalLahir.setBackground(new Color(60, 35, 70));
        panelTanggalLahir.setBorder(new LineBorder(new Color(130, 70, 180), 1, true));
        panelTanggalLahir.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 2));
        
        // Hari
        cbHari = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            cbHari.addItem(String.format("%02d", i));
        }
        cbHari.setBackground(new Color(60, 35, 70));
        cbHari.setForeground(Color.WHITE);
        panelTanggalLahir.add(cbHari);
        
        // Bulan
        cbBulan = new JComboBox<>();
        String[] months = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", 
                          "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        for (String month : months) {
            cbBulan.addItem(month);
        }
        cbBulan.setBackground(new Color(60, 35, 70));
        cbBulan.setForeground(Color.WHITE);
        panelTanggalLahir.add(cbBulan);
        
        // Tahun
        cbTahun = new JComboBox<>();
        for (int i = 2023; i >= 1900; i--) {
            cbTahun.addItem(String.valueOf(i));
        }
        cbTahun.setBackground(new Color(60, 35, 70));
        cbTahun.setForeground(Color.WHITE);
        panelTanggalLahir.add(cbTahun);
        
        panelProfil.add(panelTanggalLahir);
        y += 60;
        
        // Jenis Kelamin
        JLabel lblJenisKelamin = new JLabel("Jenis Kelamin");
        lblJenisKelamin.setForeground(Color.WHITE);
        lblJenisKelamin.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblJenisKelamin.setBounds(50, y, 200, 20);
        panelProfil.add(lblJenisKelamin);
        
        cbJenisKelamin = new JComboBox<>();
        cbJenisKelamin.addItem("Laki-Laki");
        cbJenisKelamin.addItem("Perempuan");
        cbJenisKelamin.setBounds(50, y + 20, 480, 30);
        cbJenisKelamin.setBackground(new Color(60, 35, 70));
        cbJenisKelamin.setForeground(Color.WHITE);
        cbJenisKelamin.setBorder(new LineBorder(new Color(130, 70, 180), 1, true));
        panelProfil.add(cbJenisKelamin);
        y += 60;
        
        // Email
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblEmail.setBounds(50, y, 200, 20);
        panelProfil.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(50, y + 20, 480, 30);
        txtEmail.setBackground(new Color(60, 35, 70));
        txtEmail.setForeground(Color.WHITE);
        txtEmail.setBorder(new LineBorder(new Color(130, 70, 180), 1, true));
        txtEmail.setFont(new Font("Poppins", Font.PLAIN, 12));
        panelProfil.add(txtEmail);
        y += 60;
        
        // No HP
        JLabel lblNoHP = new JLabel("No. HP");
        lblNoHP.setForeground(Color.WHITE);
        lblNoHP.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblNoHP.setBounds(50, y, 200, 20);
        panelProfil.add(lblNoHP);
        
        txtNoHP = new JTextField();
        txtNoHP.setBounds(50, y + 20, 480, 30);
        txtNoHP.setBackground(new Color(60, 35, 70));
        txtNoHP.setForeground(Color.WHITE);
        txtNoHP.setBorder(new LineBorder(new Color(130, 70, 180), 1, true));
        txtNoHP.setFont(new Font("Poppins", Font.PLAIN, 12));
        panelProfil.add(txtNoHP);
        
        // Button Simpan
        JButton btnSimpan = new JButton("Simpan Profil");
        btnSimpan.setBounds(220, y + 70, 150, 40);
        btnSimpan.setBackground(new Color(130, 70, 180));
        btnSimpan.setForeground(Color.WHITE);
        btnSimpan.setFont(new Font("Poppins", Font.BOLD, 14));
        btnSimpan.setBorder(new LineBorder(new Color(100, 50, 150), 2, true));
        btnSimpan.addActionListener(e -> simpanProfil());
        panelProfil.add(btnSimpan);
    }
    
    private void simpanProfil() {
        String nama = txtNama.getText();
        String tempatLahir = txtTempatLahir.getText();
        String tanggalLahir = cbHari.getSelectedItem() + " " + cbBulan.getSelectedItem() + " " + cbTahun.getSelectedItem();
        String jenisKelamin = (String) cbJenisKelamin.getSelectedItem();
        String email = txtEmail.getText();
        String noHP = txtNoHP.getText();
        
        // Validasi sederhana
        if (nama.isEmpty() || tempatLahir.isEmpty() || email.isEmpty() || noHP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap isi semua field!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Simpan data (di sini bisa ditambahkan logika penyimpanan ke database)
        JOptionPane.showMessageDialog(this, 
            "Profil berhasil disimpan!\n\n" +
            "Nama: " + nama + "\n" +
            "Tempat, Tanggal Lahir: " + tempatLahir + ", " + tanggalLahir + "\n" +
            "Jenis Kelamin: " + jenisKelamin + "\n" +
            "Email: " + email + "\n" +
            "No. HP: " + noHP,
            "Sukses", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}