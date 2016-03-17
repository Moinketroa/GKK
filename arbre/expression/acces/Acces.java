package plic.arbre.expression.acces;

import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;
import plic.tds.TDS;
import plic.tds.entrees.EntreeVar;
import plic.tds.symboles.Symbole;

public class Acces extends Expression {

	public static TDS tds = TDS.getInstance();
	
	String i;
	int deplacement;
	
	public Acces(String idf){
		i = idf;
	}
	
	public boolean estEntiere() { return true; };
	
	public boolean estBooleen() { return false; };
	
	@Override
	public String toMips() throws AnalyseSemantiqueException {
		verify();
		
		System.out.println("lele");
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\tli $s7, " + (deplacement - 4) + "\n");
		sb.append("\tlw $v0, ($s7)\n");
		
		return sb.toString();
	}

	@Override
	public void verify() throws AnalyseSemantiqueException {
		Symbole var = tds.identifier(new EntreeVar(i));
		
		System.out.println("ll");
		
		if (var == null)
			throw new AnalyseSemantiqueException(ligne, "Variable " + i + " non déclarée");
		
		deplacement = var.getDeplacement();
	}

}
