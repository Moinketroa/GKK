package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Constante extends Expression {

    protected String cste ;
    
    protected Constante(String texte) {
    	super();
        cste = texte ;
    }

    public void verify(){
    	return;
    }
    
    @Override
    public String toString() {
        return cste ;
    }

    public boolean estConstante(){
    	return true;
    }
}
