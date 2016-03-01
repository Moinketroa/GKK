package plic.arbre.expression.binaire.comparaison;

import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Different extends Comparaison {

    public Different(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " != ";
    }

	@Override
	public String toMips() {
		this.verify();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toMips());
		
		

		return sb.toString();
	}
	
	public void verify() throws AnalyseSemantiqueException{
    	if ((gauche.estBooleen() && droite.estEntiere()) || (droite.estBooleen() && gauche.estEntiere())){
    		throw new AnalyseSemantiqueException("Different sur 2 expressions différentes");
    	}
    }
  
}
