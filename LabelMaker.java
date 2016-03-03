package plic;

public class LabelMaker {
	
	private static LabelMaker lm = new LabelMaker();
	
	private LabelMaker(){}
	
	private int stringLabel = 0;
	private int diffLabel = 0;
	private int egalLabel = 0;
	
	public static LabelMaker getInstance(){
		return lm;
	}
	
	public int getStringLabel(){
		int val = stringLabel;
		stringLabel++;
		return val;
	}
	
	public int getDiffLabel(){
		int val = diffLabel;
		diffLabel++;
		return val;
	}
	public int getEgalLabel(){
		int val = egalLabel;
		egalLabel++;
		return val;
	}
}
