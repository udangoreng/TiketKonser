package tiketKonser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddCategory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int count;

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
            panel.add(nameField);

            JLabel priceLabel = new JLabel("Harga:");
            priceLabel.setForeground(Color.WHITE);
            priceLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
            priceLabel.setBounds(20, yOffset + 60, 140, 25);
            panel.add(priceLabel);

            JTextField priceField = new JTextField();
            priceField.setBounds(20, yOffset + 85, 140, 27);
            panel.add(priceField);

            JLabel seatLabel = new JLabel("Jumlah Seat:");
            seatLabel.setForeground(Color.WHITE);
            seatLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
            seatLabel.setBounds(220, yOffset + 60, 140, 25);
            panel.add(seatLabel);

            JTextField seatField = new JTextField();
            seatField.setBounds(220, yOffset + 85, 140, 27);
            panel.add(seatField);
        }

        // Save Button
        JButton saveButton = new JButton("Simpan");
        saveButton.setBounds(275, baseY + count * 150 - 30, 90, 30);
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