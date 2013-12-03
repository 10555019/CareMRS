import java.util.Date;

public class Clinic {
	private static boolean[][] openHr = new boolean[7][2];
	private static String[] typeOfTreatment = new String[4];
	private float[] feePerPart = new float[4];
	private boolean[] bodyParts = new boolean[4];
	private String[] description = new String[3];
	private int[] requirement = new int[2];
	private String[] specialArrangment = new String[3];
	private float[] discount = new float[3];
	private Date[] nonPeakHr = new Date[4];
	
	public static void setOpenHour(int i, int j, boolean k){
		openHr[i][j]=k;
	}
	
	public static void setTypeOfTreatment(int i, String tot){
		typeOfTreatment[i]=tot;
	}
}
