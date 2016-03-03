package plic.arbre.affectations;

import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Expression;
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
		//Récuperer le décalage de acces avec la TDS (identifier)
		StringBuilder sb = new StringBuilder();
		sb.append(exp.toMips());
		sb.append("\n");
		//comment utiliser l'acces ????? 
		sb.append("sw $v0,"+ TDS.getInstance().identifier(new EntreeVar(acces)).getDeplacement()+ "($s7)\n");
		return sb.toString();
	}

	
}
