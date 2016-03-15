package plic.arbre.condition;

import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

public class Condition extends ArbreAbstrait {

	protected ArbreAbstrait blocSi;
	protected ArbreAbstrait blocSinon;
	
	protected Expression condition;
	
	public Condition(Expression e, ArbreAbstrait bsi, ArbreAbstrait bsinn){
		super();
		
		condition = e;
		blocSi = bsi;
		blocSinon = bsinn;
	}
	
	@Override
	public String toMips() {
		// TODO Auto-generated method stub
		// le label des si est deja fait
		// si blocSi ou blocSinon est null alors le bloc n'existe pas, pas besoin de le faire en mips
		return null;
	}

	public void verify() throws AnalyseSemantiqueException {
		//regarder si condition est bien logique
	}
}
