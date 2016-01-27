package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Expression extends ArbreAbstrait {
    
    protected Expression() {
        super() ;
    }

    public abstract String toMips();
    
    public abstract void verify() throws AnalyseSemantiqueException;
    
    public boolean estConstante(){
    	return false;
    }
    
    public boolean estBooleen(){
    	return false;
    }
    
    public boolean estEntiere(){
    	return false;
    }
}
