package rumahSakit;

import java.sql.*;

public class Connectionn {
	  Connection conn = null;
	
	public static Connection dbConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rumahsakit","root","");
			return conn;
		} catch (Exception e) {

			System.out.println("test");
			e.printStackTrace();
			return null;
		}
		
	}
}
