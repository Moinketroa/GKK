package plic.arbre.expression.binaire;

import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {

    protected BinaireArithmetique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    public boolean estEntiere(){
    	return true;
    }
    
    public void verify() throws AnalyseSemantiqueException {
    	if (!(gauche.estEntiere() && droite.estEntiere())){
    		throw new AnalyseSemantiqueException(ligne, "Binaire Arithmetique sur 2 expressions incompatibles");
    	}
    }
}
