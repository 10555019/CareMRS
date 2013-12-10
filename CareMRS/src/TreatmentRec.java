import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.LinkedList;


public class TreatmentRec implements Serializable{
	private GregorianCalendar time = new GregorianCalendar();
	private LinkedList<Treatment> treatment = new LinkedList<Treatment>();
	private String doctorID;
	private String condition;
	private String remarks;
	private float discount, totalPrice;
	private boolean payment;

	public TreatmentRec(Db db,Patient patient,String doctorID){
		this.doctorID = doctorID;
		GregorianCalendar currentTime = new GregorianCalendar();
		time = currentTime; //set treatment time
		//set discuont
		discount = 1;
		int ch, cm, nh1, nm1, nh2, nm2;
		ch = currentTime.get(11);
		cm = currentTime.get(12);
		nh1 = db.getClinic().getNonHr(0);
		nm1 = db.getClinic().getNonMin(0);
		nh2 = db.getClinic().getNonHr(1);
		nm2 = db.getClinic().getNonMin(1);
		if ((ch>nh1) || (ch<nh2) || ((ch==nh1) && (cm>nm1)) || ((ch==nh2) && (cm<nm2))){
			discount = db.getClinic().getDiscount(2);
			condition = "Non-Peak hour Discount";
		}
		if (patient!=null){
			if (patient.getAge()<18){
				discount = db.getClinic().getDiscount(1);
				condition = "Children Discount";
			} else if (patient.getAge()>50){
				discount = db.getClinic().getDiscount(0);
				condition = "Eldery Discount";

			}
		}
	}

	public String getDoctorID(){
		return doctorID;
	}
	
	public String getDate(){
		String day, month, year;
		day = Integer.toString(time.get(5));
		if (day.length()==1)
			day = "0" + day;
		month = Integer.toString(time.get(2)+1);
		if (month.length()==1)
			month = "0" + month;
		year = Integer.toString(time.get(1));
		return day + "/" + month + "/" + year;
	}
	
	public String getTime(){
		String hr, min;
		hr = Integer.toString(time.get(11));
		if (hr.length()==1)
			hr = "0" + hr;
		min = Integer.toString(time.get(12));
		if (min.length()==1)
			min = "0" + min;
		return hr + ":" + min;
	}
	
	public int getTreatmentSize(){
		return treatment.size();
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}
	

	public void addTreatment(Treatment treatment){
		this.treatment.add(treatment);
	}

	public Treatment getTreatment(int index){
		try{
			return treatment.get(index);
		} catch (IndexOutOfBoundsException e){
		}
		return null;
	}
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
