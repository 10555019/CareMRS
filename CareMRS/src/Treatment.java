import java.util.ArrayList;


public class Treatment {
	private String type;
	private ArrayList<String> parts = new ArrayList<String>();
	private float price;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public void addParts(String parts){
		this.parts.add(parts);
	}
	
	public String getParts(int index){
		try{
			return parts.get(index);
		} catch (IndexOutOfBoundsException e){
		}
		return null;
	}
	
	public int getPartsSize(){
		return parts.size();
	}
	
}
