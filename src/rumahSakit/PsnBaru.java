package rumahSakit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.util.regex.*;

public class PsnBaru extends JFrame {

	private JPanel contentPane;
	private JTextField textField, textField_1, textField_2, textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ImageIcon image = new ImageIcon("Pasien Baru1.png");
	private String gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PsnBaru frame = new PsnBaru();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	/**
	 * Create the frame.
	 */
	public PsnBaru() {
		con = Connectionn.dbConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(192, 149, 189, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(192, 193, 189, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(192, 240, 189, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(192, 280, 189, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JRadioButton Pria = new JRadioButton("Pria");
		buttonGroup.add(Pria);
		Pria.setBounds(192, 319, 109, 23);
		contentPane.add(Pria);
		
		JRadioButton Wanita = new JRadioButton("Wanita");
		buttonGroup.add(Wanita);
		Wanita.setBounds(192, 345, 109, 23);
		contentPane.add(Wanita);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "insert into biopasien (NamaDepan, NamaBelakang, TglLahir, Gender, AlamatP) values (?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, textField.getText());
					boolean b = Pattern.matches("^[a-zA-Z]{1,51}$", textField.getText());
					if(b == false) {
						JOptionPane.showMessageDialog(null, "Only characters in nama depan text field");
						con.rollback();
					}
					pst.setString(2, textField_1.getText());
					boolean b1= Pattern.matches("^[a-zA-Z]{1,51}$", textField_1.getText());
					if(b1 == false) {
						JOptionPane.showMessageDialog(null, "Only characters in nama belakang text field");
						con.rollback();
					}
					pst.setString(3, textField_2.getText());
					boolean b2 = Pattern.matches("^(?:(?:31(-)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(-)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(-)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(-)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", textField_2.getText());
					if(b2 == false) {
						JOptionPane.showMessageDialog(null, "dd-mm-yyyy date format");
						con.rollback();
					}
					if(Pria.isSelected()) {
						gender = "P";
					}
					else if(Wanita.isSelected()) {
						gender = "W";
					}
					pst.setString(4, gender);
					pst.setString(5, textField_3.getText());
					pst.executeUpdate();
					
					if(b==true&&b1==true&&b2==true) {
						JOptionPane.showMessageDialog(null, "Registered");
						String sql2 = "SELECT ID FROM biopasien ORDER BY ID DESC LIMIT 1 ";
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(sql2);
						while (rs.next()) {
							int ID = rs.getInt("ID");
							JOptionPane.showMessageDialog(null, "Your ID is " +ID);
						}
						rs.close();
						DaftarPsn psn = new DaftarPsn();
						psn.setVisible(true);
						setVisible(false);
					}
	
				}
				catch(Exception ex) {JOptionPane.showMessageDialog(null, "Check again");
				}
				
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(541, 184, 109, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaftarPsn dp = new DaftarPsn();
				dp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setFocusable(false);;
		btnNewButton_1.setBounds(541, 259, 109, 39);
		contentPane.add(btnNewButton_1);
		
		JLabel bg = new JLabel("New label");
		bg.setIcon(image);
		bg.setBounds(0, -5, 684, 521);
		contentPane.add(bg);
	}
}
