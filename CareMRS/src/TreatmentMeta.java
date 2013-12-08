import java.io.Serializable;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;


public class TreatmentMeta implements Serializable{
	private String type;
	private int fpp;
	private boolean bodyPart;
	
	public TreatmentMeta(String type, int fpp, boolean bodyPart){
		this.type = type;
		this.fpp = fpp;
		this.bodyPart = bodyPart;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFpp() {
		return fpp;
	}

	public void setFpp(int fpp) {
		this.fpp = fpp;
	}

	public boolean isBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(boolean bodyPart) {
		this.bodyPart = bodyPart;
	}

	public static void addCombo(Db db, JComboBox<String> comboBox){
		int index = 0;
		if (db.getClinic().getTreatmentMetaSize()>0){
			while (db.getClinic().getTreatmentMeta(index)!=null){
				comboBox.addItem(db.getClinic().getTreatmentMeta(index).getType());
				index++;
			}
		}
	}
	
	public static void addTable(Db db, DefaultTableModel defaultTableModel){
		String tmpYN;
		int index = 0;
		if (db.getClinic().getTreatmentMetaSize()>0){
			while (db.getClinic().getTreatmentMeta(index)!=null){
				if (db.getClinic().getTreatmentMeta(index).isBodyPart())
					tmpYN = "Y";
				else
					tmpYN = "N/A";
				defaultTableModel.addRow(new Object[]{db.getClinic().getTreatmentMeta(index).getType(),db.getClinic().getTreatmentMeta(index).getFpp(),tmpYN});
				index++;
			}
		}
	}
}

