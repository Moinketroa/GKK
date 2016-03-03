package plic.arbre.affectations;

import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;
import plic.tds.TDS;
import plic.tds.entrees.*;

public class Affectation extends ArbreAbstrait{
	
	protected Expression acces, exp;
	
	
	public Affectation(Expression acces, Expression exp){
		super();
		this.acces = acces;
		this.exp = exp;
	}
	
	@Override
	public String toMips() {
		verify();
		
		StringBuilder sb = new StringBuilder();
		
		if (exp.estConstante()){
			sb.append(acces.toMips());
			
			sb.append("\tli $v0, " + exp.toString() + "\n");
			sb.append("\tsw $v0, ($s7)\n");
		} else {
			sb.append(exp.toMips());
			sb.append("\tmove $t8, $v0\n");
		
			sb.append(acces.toMips());
			
			sb.append("\tmove $v0, $t8\n");
			sb.append("\tsw $v0, ($s7)\n");
		}
		
		return sb.toString();
	}

	public void verify() throws AnalyseSemantiqueException {
		if (!exp.estEntiere())
			throw new AnalyseSemantiqueException("Affectation : les deux opérandes n'ont pas le meme type");
	}
	
}
