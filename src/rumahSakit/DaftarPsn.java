package rumahSakit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DaftarPsn extends JFrame {

	private JPanel contentPane;
	private ImageIcon image = new ImageIcon("Halaman Awal.png");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DaftarPsn frame = new DaftarPsn();
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
	public DaftarPsn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Pasien Baru");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PsnBaru Psn = new PsnBaru();
				setVisible(false);
				Psn.setVisible(true);
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(182, 211, 111, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sudah Terdaftar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Terdaftar dft = new Terdaftar();
				dft.setVisible(true);
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(390, 211, 132, 51);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(image);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(0, 0, 684, 471);
		contentPane.add(lblNewLabel);
		
		
	}
}
