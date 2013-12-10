import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Clinic implements Serializable{
	private boolean[][] openHr = new boolean[7][2];
	private GregorianCalendar[] session = new GregorianCalendar[4];
	private LinkedList<TreatmentMeta> treatmentMeta = new LinkedList<TreatmentMeta>();
	private String[] description = new String[3];
	private int[] requirement = new int[2];
	private String[] specialArrangement = new String[3];
	private float[] discount = new float[3];
	private GregorianCalendar[] nonPeakHr = new GregorianCalendar[4];
	
	public Clinic(){
		session[0] = new GregorianCalendar();
		session[1] = new GregorianCalendar();
		session[2] = new GregorianCalendar();
		session[3] = new GregorianCalendar();
		nonPeakHr[0] = new GregorianCalendar();
		nonPeakHr[1] = new GregorianCalendar();
		nonPeakHr[2] = new GregorianCalendar();
		nonPeakHr[3] = new GregorianCalendar();
	}
	
	public float getDiscount(int index){
		return discount[index];
	}
	
	public void setDiscount(int index, float discount){
		this.discount[index]=discount;
	}

	public void setOpenHr(int i, int j, boolean k){
		openHr[i][j]=k;
	}
	
	public boolean getOpenHr(int i, int j){
		return openHr[i][j];
	}
	
	public void setSession(int i, String time){
		int hr, min;
		hr = Integer.parseInt(time.substring(0,2));
		min = Integer.parseInt(time.substring(3,5));
		session[i].set(0,0,0,hr,min);
	}
	
	public String getSession(int i){
		String hr, min;
		try{
			hr = Integer.toString(session[i].get(11));
			if (hr.length()==1)
				hr = "0" + hr;
			min = Integer.toString(session[i].get(12));
			if (min.length()==1)
				min = "0" + min;
			return hr + ":" + min;
		} catch(NullPointerException e){
		}
		return null;
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
