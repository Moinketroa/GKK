package plic.arbre.affectations;

import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Expression;

public class Affectation extends ArbreAbstrait{
	protected Expression acces, exp;
	
	
	public Affectation(Expression acces, Expression exp){
		super();
		this.acces = acces;
		this.exp = exp;
	}
	
	@Override
	public String toMips() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
