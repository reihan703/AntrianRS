package rumahSakit;

import java.sql.*;

public class PembagianAntrian {
	HalamanUtamaPsn psn = new HalamanUtamaPsn();
	FrameSP sp = new FrameSP();
	Connection con = Connectionn.dbConnect();
	String NamaD, IDPsn; 
	
	public String dokter(int antrian, int ID1, int ID2) {
		if (antrian % 2 != 0) {
			try {
				String sql = "Select NamaDepan,NamaBelakang from biodokter where ID_Dokter = '"+ID1+"'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String NamaDepan = rs.getString("NamaDepan");
					String NamaBelakang = rs.getString("NamaBelakang");
					this.NamaD = NamaDepan + " " + NamaBelakang;
				}
			} catch (Exception e) {
			}
			return NamaD;

		} else {
			try {
				Statement stmt = con.createStatement();
				String sql = "Select NamaDepan,NamaBelakang from biodokter where ID_Dokter = '"+ID2+"'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String NamaDepan = rs.getString("NamaDepan");
					String NamaBelakang = rs.getString("NamaBelakang");
					this.NamaD = NamaDepan + " " + NamaBelakang;
				}
			} catch (Exception e) {
			}
			return NamaD;
		}
	}
	
	public void insertPsnDr(int antrian, int ID1, int ID2) {
		if (antrian%2 != 0) {
			try {
			String sql2 = "insert into pasien_dokter (ID_Pasien, ID_Dokter) values (?,?)";
			PreparedStatement pst = con.prepareStatement(sql2);
			pst.setString(1, IDPsn);
			pst.setInt(2, ID1);
			pst.executeUpdate();
			pst.close();
			}
			catch(Exception e) {
				
			}
		}

		else {
			try {
				String sql2 = "insert into pasien_dokter (ID_Pasien, ID_Dokter) values (?,?)";
				PreparedStatement pst = con.prepareStatement(sql2);
				pst.setString(1, IDPsn);
				pst.setInt(2, ID2);
				pst.executeUpdate();
				}
				catch(Exception e) {
					
				}
		}
	}
}
