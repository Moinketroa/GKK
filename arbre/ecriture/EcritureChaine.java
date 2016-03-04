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
		
		String ts[] = chaine.split("\n");

		StringBuilder newchaine = new StringBuilder();
		
		for (String s : ts){
			newchaine.append(s);
			newchaine.append("\\n");
		}
		
		newchaine.delete(newchaine.length() - 3, newchaine.length());
		
		System.out.println(newchaine.toString());
		
		sb.append(".data\n");
		sb.append("string" + compteur + ":\t.asciiz " + newchaine.toString() + "\"\n");
		sb.append(".text\n");
		sb.append("\tli\t$v0, 4\n");
		sb.append("\tla\t$a0, string" + compteur + "\n");
		sb.append("\tsyscall\n");
		
		return sb.toString();
	}

	@Override
	public void verify() throws AnalyseSemantiqueException {
		// TODO Auto-generated method stub

	}

}
