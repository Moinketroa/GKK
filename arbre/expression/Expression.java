package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;

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
    
    public boolean estConstante(){
    	return false;
    }
    
    public boolean estBinaire(){
    	return false;
    }
    
    public boolean estEntiere(){
    	return false;
    }
}
