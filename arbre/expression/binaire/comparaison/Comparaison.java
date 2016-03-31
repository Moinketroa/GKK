package plic.arbre.expression.binaire.comparaison;

import plic.arbre.expression.Expression;
import plic.arbre.expression.binaire.Binaire;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Comparaison extends Binaire {
     
    protected Comparaison(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    public boolean estBooleen(){
    	return true;
    }
    
}
