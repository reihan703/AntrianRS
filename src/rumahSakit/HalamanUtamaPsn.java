package rumahSakit;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.sql.*;

public class HalamanUtamaPsn extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3;
	private static int du, lab, cu;
	private ImageIcon image = new ImageIcon("HalamanUtamaPsn.png");
	String ID, nama;
	KeperluanPsn kp = new KeperluanPsn();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HalamanUtamaPsn frame = new HalamanUtamaPsn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con = null;
	/**
	 * Create the frame.
	 */
	public HalamanUtamaPsn() {
		con = Connectionn.dbConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("Dokter Umum");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					PembagianAntrian pa = new PembagianAntrian();
					pa.IDPsn = ID;
					SetLabel sl = new SetLabel();
					sl.setLabel(String.valueOf(setDU()), pa.dokter(setDU1(),1,2), "Dokter Umum");
					sl.show();
					pa.insertPsnDr(setDU1(),1, 2);
					setVisible(false);
					kp.keperluan(ID, "1");
					
					try {
						String sql = "Insert into antrian_du (nama, antrian) values (?,?)";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, nama);
						pst.setInt(2, du);
						pst.executeUpdate();
						pst.close();
					}
						catch(Exception f) {JOptionPane.showMessageDialog(null, "antrian failed");
						}
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(202, 208, 160, 40);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Dokter Spesialis");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					FrameSP Sp = new FrameSP();
					setVisible(false);
					Sp.setVisible(true);
					Sp.ID = ID;
					Sp.nama = nama;
				
			}
		});
		btnNewButton_1.setBounds(202, 263, 160, 40);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("Lab");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					SetLabelLab sl = new SetLabelLab();
					sl.setLabel();
					sl.show();
					setVisible(false);
					kp.keperluan(ID, "2");
					
					try {
						String sql = "Insert into antrian_lab (nama, antrian) values (?,?)";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, nama);
						pst.setInt(2, lab);
						pst.executeUpdate();
						pst.close();
					}
						catch(Exception f) {JOptionPane.showMessageDialog(null, "antrian failed");
						}
			}
		});
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBounds(416, 263, 160, 40);
		contentPane.add(btnNewButton_2);

		btnNewButton_3 = new JButton("Check Up");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					PembagianAntrian pa = new PembagianAntrian();
					pa.IDPsn = ID;
					SetLabel sl = new SetLabel();
					sl.setLabel(String.valueOf(setCU()), pa.dokter(setCU1(),3,4), "Check Up");
					sl.show();
					pa.insertPsnDr(setCU1(), 3, 4);
					setVisible(false);
					kp.keperluan(ID, "3");
					
					try {
						String sql = "Insert into antrian_cu (nama, antrian) values (?,?)";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, nama);
						pst.setInt(2, cu);
						pst.executeUpdate();
						pst.close();
					}
						catch(Exception f) {JOptionPane.showMessageDialog(null, "antrian failed");
						}
				
			}
		});
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setBounds(416, 208, 160, 40);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_6 = new JButton("Cancel");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameAwal fa = new FrameAwal();
				setVisible(false);
				fa.setVisible(true);
			}
		});
		btnNewButton_6.setFocusable(false);
		btnNewButton_6.setBounds(346, 328, 89, 23);
		contentPane.add(btnNewButton_6);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(image);
		lblNewLabel_2.setBounds(0, -35, 684, 506);
		contentPane.add(lblNewLabel_2);

	}

	int setDU() {
		du++;
		return du;
	}

	int setDU1() {
		return du;
	}

	int setLab() {
		lab++;
		return lab;
	}

	int setCU() {
		cu++;
		return cu;
	}

	int setCU1() {
		return cu;
	}
	
	void resetDU() {
		du=0;
	}
	void resetCU() {
		cu=0;
	}
	void resetLab() {
		lab=0;
	}
}
