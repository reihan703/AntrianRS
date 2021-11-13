package rumahSakit;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpsiStaff extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpsiStaff frame = new OpsiStaff();
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
	public OpsiStaff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Tabel Pasien");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPatient lp = new ListPatient();
				lp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 100, 158, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tabel Dokter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListDokter ld = new ListDokter();
				ld.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(247, 100, 148, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAwal fa = new FrameAwal();
				fa.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(163, 134, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
