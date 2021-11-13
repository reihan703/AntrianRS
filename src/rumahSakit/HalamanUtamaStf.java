package rumahSakit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;

public class HalamanUtamaStf extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private ImageIcon image = new ImageIcon("Halaman Utama Staff.png");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HalamanUtamaStf frame = new HalamanUtamaStf();
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
	public HalamanUtamaStf() {
		con = Connectionn.dbConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(250, 168, 267, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(250, 237, 267, 20);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt =con.createStatement();
					String sql = "Select * from login where Username ='"+textField.getText()+"' and Password ='"+passwordField.getText()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						OpsiStaff os = new OpsiStaff();
						os.setVisible(true);
						setVisible(false);
					}
					else if (textField.getText().isEmpty() == true) {
						JOptionPane.showMessageDialog(null, "Insert Username", "Error", JOptionPane.WARNING_MESSAGE);
					}
					else if (passwordField.getText().isEmpty() == true) {
						JOptionPane.showMessageDialog(null, "Insert Password", "Error", JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Wrong Username or Password");
					}
				} catch(Exception f) {System.out.println(f);}
				
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(250, 284, 120, 35);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameAwal fa = new FrameAwal();
				setVisible(false);
				fa.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(397, 284, 120, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(image);
		lblNewLabel_2.setBounds(0, 0, 684, 471);
		contentPane.add(lblNewLabel_2);
	}
}
