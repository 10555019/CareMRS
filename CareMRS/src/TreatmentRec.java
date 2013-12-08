import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;


public class TreatmentRec {
	private GregorianCalendar time;
	private LinkedList<Treatment> treatment = new LinkedList<Treatment>();
	private String doctorID;
	private String condition;
	private String remarks;
	private float discount, totalPrice;
	private boolean payment;

	public TreatmentRec(String doctorID){
		this.doctorID = doctorID;
		GregorianCalendar currentTime = new GregorianCalendar();
		time = currentTime;
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
