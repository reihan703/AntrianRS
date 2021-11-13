package rumahSakit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Terdaftar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private ImageIcon image = new ImageIcon("Pasien Terdaftar.png");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Terdaftar frame = new Terdaftar();
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
	public Terdaftar() {
		con=Connectionn.dbConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaftarPsn dp = new DaftarPsn();
				dp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(551, 295, 102, 42);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(316, 167, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Masuk");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt =con.createStatement();
					String sql = "Select * from biopasien where ID ='"+textField.getText()+"' and NamaDepan ='"+textField_1.getText()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						HalamanUtamaPsn psn = new HalamanUtamaPsn();
						psn.setVisible(true);
						setVisible(false);
						String ID = textField.getText();
						String nama = textField_1.getText();
						psn.ID = ID;
						psn.nama = nama;
					}
					else if (textField.getText().isEmpty() == true) {
						JOptionPane.showMessageDialog(null, "Insert ID", "Error", JOptionPane.WARNING_MESSAGE);
					}
					else if (textField_1.getText().isEmpty() == true) {
						JOptionPane.showMessageDialog(null, "Insert Nama Depan", "Error", JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "ID and Nama Depan combination does not match");
					}
				} catch(Exception f) {System.out.println(f);}
			}
		});
		btnNewButton_1.setBounds(300, 295, 102, 42);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(316, 232, 182, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel bg = new JLabel("New label");
		bg.setIcon(image);
		bg.setBounds(0, -5, 684, 521);
		contentPane.add(bg);
	}

}
