package plic.arbre.ecriture;

import plic.arbre.ArbreAbstrait;
import plic.exceptions.AnalyseSemantiqueException;

public abstract class Ecriture extends ArbreAbstrait {
	
	protected Ecriture() {
        super() ;
    }

    public abstract String toMips();
    
    public abstract void verify() throws AnalyseSemantiqueException;

}
