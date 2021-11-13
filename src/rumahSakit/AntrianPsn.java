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
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AntrianPsn extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AntrianPsn frame = new AntrianPsn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con = null;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public AntrianPsn() {
		con = Connectionn.dbConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Antrian DU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "Select * from antrian_du";
					Statement st =con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch(Exception f) {System.out.println(f);}
			}
		});
		btnNewButton.setBounds(434, 140, 102, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Antrian CU");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "Select * from antrian_cu";
					Statement st =con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch(Exception f) {System.out.println(f);}
			}
		});
		btnNewButton_1.setBounds(434, 174, 102, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Antrian Lab");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "Select * from antrian_lab";
					Statement st =con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch(Exception f) {System.out.println(f);}
			}
		});
		btnNewButton_2.setBounds(434, 208, 102, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Antrian SP Mata");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "Select * from antrian_mt";
					Statement st =con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch(Exception f) {System.out.println(f);}
			}
		});
		btnNewButton_3.setBounds(386, 36, 150, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Antrian SP Darah");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "Select * from antrian_dr";
					Statement st =con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch(Exception f) {System.out.println(f);}
			}
		});
		btnNewButton_4.setBounds(386, 72, 150, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Antrian SP Jantung");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "Select * from antrian_jt";
					Statement st =con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch(Exception f) {System.out.println(f);}
			}
		});
		btnNewButton_5.setBounds(386, 106, 150, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Back");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPatient lp = new ListPatient();
				lp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_6.setBounds(447, 305, 89, 23);
		contentPane.add(btnNewButton_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 25, 349, 271);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
