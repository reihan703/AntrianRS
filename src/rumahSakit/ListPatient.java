package rumahSakit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ListPatient extends JFrame {

	private JPanel contentPane;
	JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPatient frame = new ListPatient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection con = null;
	private JTextField textFieldDepan;
	private JTextField textFieldBelakang;
	private JTextField editID;
	private JTextField editAlamat;
	/**
	 * Create the frame.
	 */
	public ListPatient() {
		con=Connectionn.dbConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 555, 386);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Daftar Pasien");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "Select * from biopasien";
					Statement st =con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
//					while (rs.next()) {
//						String namaDepan = rs.getString("NamaDepan");
//						String namaBelakang = rs.getString("NamaBelakang");
//						
//					String tbData[]= {namaDepan, namaBelakang};
//					DefaultTableModel tbl = (DefaultTableModel)table.getModel();
//					tbl.addRow(tbData);}
					
				} catch(Exception f) {System.out.println(f);}
			}
		});
		btnNewButton.setBounds(10, 27, 137, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpsiStaff os = new OpsiStaff();
				os.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(731, 424, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Antrian ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AntrianPsn ap = new AntrianPsn();
				ap.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(157, 27, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Reset Antrian");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetAntrian ra = new ResetAntrian();
				ra.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(256, 27, 121, 23);
		contentPane.add(btnNewButton_3);
		
		textFieldDepan = new JTextField();
		textFieldDepan.setBounds(674, 61, 124, 20);
		contentPane.add(textFieldDepan);
		textFieldDepan.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nama Depan");
		lblNewLabel.setBounds(575, 62, 89, 14);
		contentPane.add(lblNewLabel);
		
		textFieldBelakang = new JTextField();
		textFieldBelakang.setColumns(10);
		textFieldBelakang.setBounds(674, 92, 124, 20);
		contentPane.add(textFieldBelakang);
		
		JLabel lblNamaBelakang = new JLabel("Nama Belakang");
		lblNamaBelakang.setBounds(575, 93, 89, 14);
		contentPane.add(lblNamaBelakang);
		
		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "Select * from biopasien where NamaDepan='"+textFieldDepan.getText()+"' and NamaBelakang = '"+textFieldBelakang.getText()+"'";
					Statement st =con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch(Exception f) {System.out.println(f);}
			}
		});
		btnNewButton_4.setBounds(709, 123, 89, 23);
		contentPane.add(btnNewButton_4);
		
		editID = new JTextField();
		editID.setBounds(674, 206, 124, 20);
		contentPane.add(editID);
		editID.setColumns(10);
		
		editAlamat = new JTextField();
		editAlamat.setBounds(674, 237, 124, 20);
		contentPane.add(editAlamat);
		editAlamat.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(575, 209, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Alamat");
		lblNewLabel_2.setBounds(575, 240, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_5 = new JButton("Update");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "UPDATE biopasien SET AlamatP = ? WHERE ID = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, editAlamat.getText());
					pst.setInt(2, Integer.valueOf(editID.getText()));
					pst.executeUpdate();
					btnNewButton.doClick();
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(709, 272, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Edit");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				String ID =String.valueOf(model.getValueAt(row, 0));
				String alamat = String.valueOf(model.getValueAt(row, 5));
				editID.setText(ID);
				editAlamat.setText(alamat);
			}
		});
		btnNewButton_6.setBounds(476, 27, 89, 23);
		contentPane.add(btnNewButton_6);
	}
}
