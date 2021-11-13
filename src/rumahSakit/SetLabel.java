package rumahSakit;

public class SetLabel {
	
	HalamanUtamaPsn psn = new HalamanUtamaPsn();
	PembagianAntrian ant = new PembagianAntrian();
	FrameSP sp = new FrameSP();
	ResultSP result = new ResultSP();
	String antrian, dokter, keperluan;
	
	public void setLabel(String antrian, String dokter, String keperluan) {
		result.labelNama.setText("Dr. "+dokter);
		result.labelAntrian.setText(antrian);
		result.labelKeperluan.setText(keperluan);
	}
	
	public void show() {
		result.setVisible(true);
	}
}
	
class SetLabelLab extends SetLabel{
	public void setLabel() {
		antrian = String.valueOf(psn.setLab());
		keperluan = "Lab";
		result.labelNama.setText("-");
		result.labelAntrian.setText(antrian);
		result.labelKeperluan.setText(keperluan);
	}
}

