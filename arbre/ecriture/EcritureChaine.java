package plic.arbre.ecriture;

import plic.exceptions.AnalyseSemantiqueException;

public class EcritureChaine extends Ecriture {

	private String chaine;
	
	public EcritureChaine(String s){
		super();
		chaine = s;
	}
	
	@Override
	public String toMips() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t.data\n");
		sb.append("string\t.asciiz \"" + chaine + "\"\n");
		sb.append("\t.text\n");
		sb.append("\tli\t$v0, 4\n");
		sb.append("\tla\t$a0, string\n");
		sb.append("syscall\n");
		
		return sb.toString();
	}

	@Override
	public void verify() throws AnalyseSemantiqueException {
		// TODO Auto-generated method stub

	}

}
