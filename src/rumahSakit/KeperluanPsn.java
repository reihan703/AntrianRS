package rumahSakit;
import java.sql.*;

import javax.swing.JOptionPane;

public class KeperluanPsn {
	Connection con = Connectionn.dbConnect();
	
	public void keperluan (String ID, String IDKeperluan) {
		try {
			String sql = "Insert into keperluan_pasien (ID_Pasien, ID_Keperluan) values (?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ID);
			pst.setString(2, IDKeperluan);
			pst.executeUpdate();
			pst.close();
		}
			catch(Exception f) {JOptionPane.showMessageDialog(null, "keperluan failed");
			}
	}
}
