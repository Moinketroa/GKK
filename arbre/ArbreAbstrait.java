package plic.arbre;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class ArbreAbstrait {
	
	protected int ligne;
	
    protected ArbreAbstrait() {}
    
    public void setLigne(int l){
    	ligne = l;
    }
    
    public abstract String toMips();
    
}
