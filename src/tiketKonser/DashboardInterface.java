package tiketKonser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.Image;

public class DashboardInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel lblHiUsername;
    private User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardInterface frame = new DashboardInterface();
					frame.setVisible(true);
					frame.setSize(1024, 678);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    /**
     * Default constructor: Initializes components.
     * Called when no user is passed (e.g., direct execution via main).
     */
    public DashboardInterface() {
        initComponents(); // Call a common method to initialize GUI components
        // lblHiUsername will retain its default text "Hi, Username" set in initComponents
    }

    /**
     * Constructor that accepts a User object.
     * This should be called after a successful login.
     * @param user The currently logged-in User object.
     */
    public DashboardInterface(User user) {
        this(); // Calls the default constructor to set up the GUI (initComponents)
        this.currentUser = user;

        if (this.currentUser != null) {
            lblHiUsername.setText("Hi, " + this.currentUser.getNama());
        } else {
            // Fallback if user is null, though ideally LoginInterface prevents this
            lblHiUsername.setText("Hi, Guest");
        }
    }

    /**
     * Initializes all GUI components.
     * This method is called by both constructors.
     */
    private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1047, 596);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(26, 21, 24));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(81, 20, 101));
		panel.setBounds(0, 0, 250, 678);
		panel.setSize(250, 678);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblHiUsername = new JLabel("Hi, Username"); // Default text
        lblHiUsername.setForeground(Color.WHITE);
        lblHiUsername.setFont(new Font("Poppins", Font.BOLD, 20));
        lblHiUsername.setBounds(24, 55, 250, 30); // Ensure width is sufficient
        panel.add(lblHiUsername);
		
		JLabel lblNewLabel_3 = new JLabel("Lihat Konser");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(36, 134, 168, 40);
		lblNewLabel_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	DaftarKonserInterface konser = new DaftarKonserInterface(currentUser);
                konser.setSize(1024, 678);
                konser.setVisible(true);
		    	dispose();
		    }
		});
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tiket Saya");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(36, 192, 168, 40);
		lblNewLabel_3_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new TiketSayaInterface().setVisible(true);
		    	dispose();
		    }
		});
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Profil Saya");
		lblNewLabel_3_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_2.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(36, 254, 168, 40);
		lblNewLabel_3_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new ProfilInterface().setVisible(true);
		    	dispose();
		    }
		});
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Logout");
		lblNewLabel_3_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_3.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(36, 470, 168, 40);
		panel.add(lblNewLabel_3_3);
		lblNewLabel_3_3.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		lblNewLabel_3_3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	new LoginInterface().setVisible(true);
		    	dispose();
		    }
		});
		
		JLabel lblNewLabel_2 = new JLabel("Terbaru dari Kami :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 18));
		lblNewLabel_2.setBounds(291, 45, 227, 39);
		contentPane.add(lblNewLabel_2);
		
		// Load gambar asli
		ImageIcon originalIcon = new ImageIcon("./img/StagePass-removebg-preview.png");

		// Resize gambar ke ukuran yang sesuai label (250 x 156)
		Image resizedImage = originalIcon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);

		// Buat JLabel dan set gambar hasil resize
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(resizedImage));
		lblNewLabel.setBounds(876, 7, 147, 77);
		contentPane.add(lblNewLabel);
		
		ImageIcon disc1 = new ImageIcon("./img/poster1.jpg");
        Image disc1img = disc1.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        JLabel lbldisc1 = new JLabel("");
        lbldisc1.setIcon(new ImageIcon(disc1img));
        lbldisc1.setBounds(521, 102, 200, 300);
        contentPane.add(lbldisc1);
        
        ImageIcon disc2 = new ImageIcon("./img/poster2.jpg");
        Image disc2img = disc2.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        JLabel lbldisc2 = new JLabel("");
        lbldisc2.setIcon(new ImageIcon(disc2img));
        lbldisc2.setBounds(779, 102, 200, 300);
        contentPane.add(lbldisc2);
        
        ImageIcon disc3 = new ImageIcon("./img/poster3.jpg");
        Image disc3img = disc3.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        JLabel lbldisc3 = new JLabel("");
        lbldisc3.setIcon(new ImageIcon(disc3img));
        lbldisc3.setBounds(278, 102, 200, 300);
        contentPane.add(lbldisc3);
	}
}
