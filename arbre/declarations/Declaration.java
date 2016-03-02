package plic.arbre.declarations;

import plic.arbre.ArbreAbstrait;
import plic.exceptions.AnalyseSemantiqueException;

public abstract class Declaration extends ArbreAbstrait{
	
	protected Declaration(){
		super();
	}
	
	public abstract String toMips();
	
	public abstract void verify() throws AnalyseSemantiqueException;
}
