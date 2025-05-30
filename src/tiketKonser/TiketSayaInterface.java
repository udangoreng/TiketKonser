package tiketKonser;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TiketSayaInterface extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TiketSayaInterface frame = new TiketSayaInterface();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TiketSayaInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 678);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 20, 24));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(81, 20, 101));
        panel.setBounds(0, 0, 311, 678);
        contentPane.add(panel);

        JLabel lblHiUsername_1 = new JLabel("Hi, Username");
        lblHiUsername_1.setForeground(Color.WHITE);
        lblHiUsername_1.setFont(new Font("Poppins", Font.BOLD, 20));
        lblHiUsername_1.setBounds(24, 55, 146, 30);
        lblHiUsername_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHiUsername_1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new DashboardInterface().setVisible(true);
		    	dispose();
		    }
		});
        panel.add(lblHiUsername_1);

        JLabel lblHiUsername = new JLabel(" Lihat Konser");
        lblHiUsername.setForeground(Color.WHITE);
        lblHiUsername.setFont(new Font("Poppins", Font.BOLD, 14));
        lblHiUsername.setBounds(18, 149, 101, 30);
        lblHiUsername.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHiUsername.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new DaftarKonserInterface().setVisible(true);
		    	dispose();
		    }
		});
        panel.add(lblHiUsername);

        JLabel lblTiketSaya = new JLabel("Tiket Saya");
        lblTiketSaya.setForeground(Color.WHITE);
        lblTiketSaya.setFont(new Font("Poppins", Font.BOLD, 14));
        lblTiketSaya.setBounds(24, 191, 131, 30);
        panel.add(lblTiketSaya);

        JLabel lblProfilSaya = new JLabel("Profil Saya");
        lblProfilSaya.setForeground(Color.WHITE);
        lblProfilSaya.setFont(new Font("Poppins", Font.BOLD, 14));
        lblProfilSaya.setBounds(24, 232, 131, 30);
        lblProfilSaya.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblProfilSaya.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new ProfilInterface().setVisible(true);
		    	dispose();
		    }
		});
        panel.add(lblProfilSaya);

        JLabel lblLogout = new JLabel("Logout");
        lblLogout.setForeground(Color.WHITE);
        lblLogout.setFont(new Font("Poppins", Font.BOLD, 14));
        lblLogout.setBounds(24, 586, 131, 30);
        lblLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblLogout.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new LoginInterface().setVisible(true);
		    	dispose();
		    }
		});
        panel.add(lblLogout);

        JLabel lblTicketActive = new JLabel("Ticket Active");
        lblTicketActive.setForeground(Color.WHITE);
        lblTicketActive.setFont(new Font("Poppins", Font.BOLD, 28));
        lblTicketActive.setBounds(333, 26, 217, 53);
        contentPane.add(lblTicketActive);

        // Gambar pertama
        try {
            URL imageUrl = new URL("https://drive.google.com/uc?export=view&id=1um6Pi4AMmo5OZdMCwVJ2Z9ApP6Pix7NL");
            ImageIcon icon = new ImageIcon(ImageIO.read(imageUrl));
            Image scaledImage = icon.getImage().getScaledInstance(450, 200, Image.SCALE_SMOOTH);
            JLabel lblImage = new JLabel(new ImageIcon(scaledImage));
            lblImage.setBounds(332, 79, 450, 200);
            contentPane.add(lblImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblHistory = new JLabel("History");
        lblHistory.setForeground(Color.WHITE);
        lblHistory.setFont(new Font("Poppins", Font.BOLD, 28));
        lblHistory.setBounds(333, 290, 217, 53);
        contentPane.add(lblHistory);

        // Gambar kedua (di bawah History)
        try {
            URL imageUrl = new URL("https://drive.google.com/uc?export=view&id=1l5R0YeUzxOW0CEhATBjua_SgNL51RPvH");
            ImageIcon icon = new ImageIcon(ImageIO.read(imageUrl));
            Image scaledImage = icon.getImage().getScaledInstance(400, 120, Image.SCALE_SMOOTH);
            JLabel lblSecondImage = new JLabel(new ImageIcon(scaledImage));
            lblSecondImage.setBounds(333, 343, 400, 120);
            contentPane.add(lblSecondImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Gambar ketiga (di bawah gambar kedua)
        try {
            URL imageUrl = new URL("https://drive.google.com/uc?export=view&id=1bE4x0mP5pDctFnV_-o3cd_IsAhSYCeRM");
            ImageIcon icon = new ImageIcon(ImageIO.read(imageUrl));
            Image scaledImage = icon.getImage().getScaledInstance(400, 120, Image.SCALE_SMOOTH);
            JLabel lblThirdImage = new JLabel(new ImageIcon(scaledImage));
            lblThirdImage.setBounds(333, 473, 400, 120);
            contentPane.add(lblThirdImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
