package rumahSakit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;

public class FrameSP extends JFrame {

	private JPanel contentPane;
	private static int mt, jt, dr;
	private JButton btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3;
	private ImageIcon image = new ImageIcon("Frame SP.png");
	String nama, ID;
	KeperluanPsn kp = new KeperluanPsn();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSP frame = new FrameSP();
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
	public FrameSP() {
		con = Connectionn.dbConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("Darah");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PembagianAntrian pa = new PembagianAntrian();
				pa.IDPsn = ID;
				SetLabel sl = new SetLabel();
				sl.setLabel(String.valueOf(setDR()), pa.dokter(setDR1(),9,10), "Spesialis Darah");
				sl.show();
				pa.insertPsnDr(dr,9,10);
				setVisible(false);
				kp.keperluan(ID, "4");
				
				try {
					String sql = "Insert into antrian_dr (nama, antrian) values (?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, nama);
					pst.setInt(2, dr);
					pst.executeUpdate();
					pst.close();
				}
					catch(Exception f) {JOptionPane.showMessageDialog(null, "antrian failed");
					}
				
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(286, 317, 111, 51);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Jantung");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PembagianAntrian pa = new PembagianAntrian();
				pa.IDPsn = ID;
				SetLabel sl = new SetLabel();
				sl.setLabel(String.valueOf(setJT()), pa.dokter(setJT1(),7,8), "Spesialis Jantung");
				sl.show();
				pa.insertPsnDr(jt, 7, 8);
				setVisible(false);
				kp.keperluan(ID, "5");
				
				try {
					String sql = "Insert into antrian_jt (nama, antrian) values (?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, nama);
					pst.setInt(2, jt);
					pst.executeUpdate();
					pst.close();
				}
					catch(Exception f) {JOptionPane.showMessageDialog(null, "antrian failed");
					}
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(286, 250, 111, 51);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("Mata");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PembagianAntrian pa = new PembagianAntrian();
				pa.IDPsn = ID;
				SetLabel sl = new SetLabel();
				sl.setLabel(String.valueOf(setMT()), pa.dokter(setMT1(),7,8), "Spesialis Mata");
				sl.show();
				pa.insertPsnDr(mt, 5, 6);
				setVisible(false);
				kp.keperluan(ID, "6");
				
				try {
					String sql = "Insert into antrian_mt (nama, antrian) values (?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, nama);
					pst.setInt(2, mt);
					pst.executeUpdate();
					pst.close();
				}
					catch(Exception f) {JOptionPane.showMessageDialog(null, "antrian failed");
					}
			}
		});
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBounds(286, 177, 111, 51);
		contentPane.add(btnNewButton_2);

		btnNewButton_3 = new JButton("Cancel");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameAwal fa = new FrameAwal();
				dispose();
				fa.setVisible(true);
			}
		});
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setBounds(585, 335, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(image);
		lblNewLabel_1.setBounds(0, 0, 684, 471);
		contentPane.add(lblNewLabel_1);
	}
	
	int setDR() {
		dr++;
		return dr;
	}

	int setDR1() {
		return dr;
	}
	int setJT() {
		jt++;
		return jt;
	}

	int setJT1() {
		return jt;
	}
	int setMT() {
		mt++;
		return mt;
	}

	int setMT1() {
		return mt;
	}
	
	void resetMT() {
		mt=0;
	}
	void resetJT() {
		jt=0;
	}
	void resetDR() {
		dr=0;
	}

}
