import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

public class Clinic implements Serializable{
	private boolean[][] openHr = new boolean[7][2];
	private LinkedList<TreatmentMeta> treatmentMeta = new LinkedList<TreatmentMeta>();
	private String[] description = new String[3];
	private int[] requirement = new int[2];
	private String[] specialArrangement = new String[3];
	private float[] discount = new float[3];
	private Date[] nonPeakHr = new Date[4];
	
	public float getDiscount(int index){
		return discount[index];
	}
	
	public void setDiscount(int index, float discount){
		this.discount[index]=discount;
	}

	public void setOpenHour(int i, int j, boolean k){
		openHr[i][j]=k;
	}

	public void addTreatmentMeta(TreatmentMeta treatmentMeta){
		this.treatmentMeta.add(treatmentMeta);
	}
	
	public void deleteTreatmentMeta(int index){
		treatmentMeta.remove(index);
	}

	public TreatmentMeta getTreatmentMeta(int index){
		try{
			return treatmentMeta.get(index);
		} catch (IndexOutOfBoundsException e){
		}
		return null;
	}
	
	public int searchType(String type){
		for (int i = 0; i<treatmentMeta.size(); i++){
			if (type.equals(treatmentMeta.get(i).getType()))
				return i;
		}
		return -1;
	}

	public int getTreatmentMetaSize(){
		return treatmentMeta.size();
	}
	
	public void setSpecialArrangement(int i, String sa){
		specialArrangement[i]=sa;
	}
}
