package plic.arbre;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArbreAbstrait expr ;
    
    public BlocDInstructions() {
        super() ;
    }
    
    public void ajouter(ArbreAbstrait a) {
        expr = a ;
    }
    
    @Override
    public String toString() {
    	if (expr == null)
			return "";
        return expr.toString() ;
    }

	@Override
	public String toMips() {
		if (expr == null)
			return "";
		return expr.toMips();
	}

}
