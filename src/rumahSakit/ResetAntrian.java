package rumahSakit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class ResetAntrian extends JFrame {

	private JPanel contentPane;
	HalamanUtamaPsn hp = new HalamanUtamaPsn();
	FrameSP sp = new FrameSP();
	Connection con = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResetAntrian frame = new ResetAntrian();
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
	public ResetAntrian() {
		con=Connectionn.dbConnect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Antrian DU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hp.resetDU();
				try {
					String sql = "delete from antrian_du";
					Statement st =con.createStatement();
					st.executeUpdate(sql);
					
				} catch(Exception f) {System.out.println("Table is empty");}
			}
		});
		btnNewButton.setBounds(56, 45, 111, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Antrian CU");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hp.resetCU();
				try {
					String sql = "delete from antrian_cu";
					Statement st =con.createStatement();
					st.executeUpdate(sql);
					
				} catch(Exception f) {System.out.println("Table is empty");}
			}
		});
		btnNewButton_1.setBounds(56, 79, 111, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Antrian Lab");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hp.resetLab();
				try {
					String sql = "delete from antrian_lab";
					Statement st =con.createStatement();
					st.executeUpdate(sql);
					
				} catch(Exception f) {System.out.println("Table is empty");}
			}
		});
		btnNewButton_2.setBounds(56, 113, 111, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Antrian SP Mata");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sp.resetMT();
				try {
					String sql = "delete from antrian_mt";
					Statement st =con.createStatement();
					st.executeUpdate(sql);
					
				} catch(Exception f) {System.out.println("Table is empty");}
			}
		});
		btnNewButton_3.setBounds(223, 45, 146, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Antrian SP Jantung");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "delete from antrian_jt";
					Statement st =con.createStatement();
					st.executeUpdate(sql);
					
				} catch(Exception f) {System.out.println("Table is empty");}
			}
		});
		btnNewButton_4.setBounds(223, 79, 146, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Antrian SP Darah");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "delete from antrian_dr";
					Statement st =con.createStatement();
					st.executeUpdate(sql);
					
				} catch(Exception f) {System.out.println("Table is empty");}
			}
		});
		btnNewButton_5.setBounds(223, 113, 146, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Close");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_6.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton_6);
	}

}
