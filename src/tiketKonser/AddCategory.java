package tiketKonser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AddCategory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int count;
	private ArrayList<JTextField> nameFields = new ArrayList<>();
	private ArrayList<JTextField> priceFields = new ArrayList<>();
	private ArrayList<JTextField> seatFields = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public AddCategory(String loopCount) {
		this.count = Integer.valueOf(loopCount);

        setTitle("Add Category");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 427, 600);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 424, 678);
        scrollPane.setOpaque(false);
        contentPane.add(scrollPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(26, 21, 24));
        scrollPane.setViewportView(panel);
        panel.setPreferredSize(new Dimension(424, count * 160 + 150));
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Tambah Kategori : ");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 14));
        lblNewLabel.setBounds(132, 11, 200, 22);
        panel.add(lblNewLabel);

        int baseY = 40;

        // Dynamic fields based on count
        for (int i = 0; i < count; i++) {
            int yOffset = baseY + i * 140;

            JLabel nameLabel = new JLabel("Nama Kategori " + (i + 1) + ":");
            nameLabel.setForeground(Color.WHITE);
            nameLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
            nameLabel.setBounds(20, yOffset, 200, 25);
            panel.add(nameLabel);

            JTextField nameField = new JTextField();
            nameField.setBounds(20, yOffset + 25, 340, 27);
            nameFields.add(nameField);
            panel.add(nameField);

            JLabel priceLabel = new JLabel("Harga:");
            priceLabel.setForeground(Color.WHITE);
            priceLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
            priceLabel.setBounds(20, yOffset + 60, 140, 25);
            panel.add(priceLabel);

            JTextField priceField = new JTextField();
            priceField.setBounds(20, yOffset + 85, 140, 27);
            priceFields.add(priceField);            
            panel.add(priceField);

            JLabel seatLabel = new JLabel("Jumlah Seat:");
            seatLabel.setForeground(Color.WHITE);
            seatLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
            seatLabel.setBounds(220, yOffset + 60, 140, 25);
            panel.add(seatLabel);

            JTextField seatField = new JTextField();
            seatField.setBounds(220, yOffset + 85, 140, 27);
            seatFields.add(priceField);
            panel.add(seatField);
        }

        // Save Button
        JButton saveButton = new JButton("Simpan");
        saveButton.setBounds(275, baseY + count * 150 - 30, 90, 30);
        saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Kategori> kategoriList = new ArrayList<>();

				for (int i = 0; i < count; i++) {
					String nama = nameFields.get(i).getText();
					String hargaStr = priceFields.get(i).getText();
					String jumlahStr = seatFields.get(i).getText();

					if (nama.isEmpty() || hargaStr.isEmpty() || jumlahStr.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Semua field kategori ke-" + (i + 1) + " harus diisi!");
						return;
					}

					try {
						double harga = Double.parseDouble(hargaStr);
						int jumlah = Integer.parseInt(jumlahStr);

						kategoriList.add(new Kategori(nama, jumlah, harga));
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Harga dan Jumlah harus berupa angka! (Kategori ke-" + (i + 1) + ")");
						return;
					}
				}

				Konser konser = Konser.getLastAddedKonser();
				if (konser != null) {
					konser.setKategori(kategoriList);
					JOptionPane.showMessageDialog(null, "Kategori berhasil ditambahkan ke konser.");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Gagal menemukan konser yang baru dibuat.");
				}
			}
		});
        panel.add(saveButton);
    }

//     Optional main method to test this class
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            AddCategory frame = new AddCategory("4");
            frame.setVisible(true);
        });
    }
}