package plic.arbre.ecriture;

import plic.LabelMaker;
import plic.exceptions.AnalyseSemantiqueException;

public class EcritureChaine extends Ecriture {

	private LabelMaker lablemaker = LabelMaker.getInstance();
	private int compteur;
	
	private String chaine;
	
	public EcritureChaine(String s){
		super();
		chaine = s;
		compteur = lablemaker.getStringLabel();
	}
	
	@Override
	public String toMips() {
		StringBuilder sb = new StringBuilder();
		sb.append(".data\n");
		sb.append("string" + compteur + ":\t.asciiz " + chaine + "\n");
		sb.append(".text\n");
		sb.append("\tli\t$v0, 4\n");
		sb.append("\tla\t$a0, string" + compteur + "\n");
		sb.append("\tsyscall\n");
		sb.append("\tla\t$a0, newline\n");
		sb.append("\tsyscall\n");
		
		return sb.toString();
	}

	@Override
	public void verify() throws AnalyseSemantiqueException {
		// TODO Auto-generated method stub

	}

}
