package plic.arbre.declarations;

import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

public abstract class Declaration {
	
	protected Declaration(){
		super();
	}
	
	public abstract String toMips();
	
	public abstract void verify() throws AnalyseSemantiqueException;
}
