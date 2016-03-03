package plic.arbre;

import java.util.ArrayList;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArrayList<ArbreAbstrait> bdi;
    
    public BlocDInstructions() {
        super() ;
        this.bdi = new ArrayList<>();
    }
    
    public void ajouter(ArbreAbstrait a) {
        bdi.add(a);
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for (ArbreAbstrait expr : bdi){
    		if (expr == null)
    			sb.append("");
    		sb.append(expr.toString()) ;
    	}
    	
    	return sb.toString();
    }

	@Override
	public String toMips() {
		StringBuilder sb = new StringBuilder();
    	for (ArbreAbstrait expr : bdi){
    		if (expr == null)
    			sb.append("");
    		sb.append(expr.toMips()) ;
    	}
    	
    	return sb.toString();
	}

}
