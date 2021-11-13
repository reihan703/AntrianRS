package rumahSakit;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultSP extends JFrame {

	private JPanel contentPane;
	JLabel labelNama, labelAntrian, labelKeperluan;
	private ImageIcon image = new ImageIcon("Result.png");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultSP frame = new ResultSP();
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
	public ResultSP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Keperluan");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_2.setBounds(192, 193, 95, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nama Doktor");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_3.setBounds(192, 227, 95, 14);
		contentPane.add(lblNewLabel_3);

		labelKeperluan = new JLabel("New label3");
		labelKeperluan.setBounds(297, 194, 230, 14);
		contentPane.add(labelKeperluan);

		labelNama = new JLabel("New label2");
		labelNama.setBounds(297, 228, 230, 14);
		contentPane.add(labelNama);

		JLabel lblNewLabel_6 = new JLabel("Nomor Antrian");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_6.setBounds(192, 259, 95, 14);
		contentPane.add(lblNewLabel_6);

		labelAntrian = new JLabel("New label4");
		labelAntrian.setBounds(297, 260, 77, 14);
		contentPane.add(labelAntrian);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAwal fa = new FrameAwal();
				setVisible(false);
				fa.setVisible(true);
			}
		});
		btnNewButton.setBounds(530, 322, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(image);
		lblNewLabel_8.setBounds(0, 0, 684, 471);
		contentPane.add(lblNewLabel_8);
	}

}

