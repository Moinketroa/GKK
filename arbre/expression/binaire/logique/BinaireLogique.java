package plic.arbre.expression.binaire.logique;

import plic.arbre.expression.Expression;
import plic.arbre.expression.binaire.Binaire;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireLogique extends Binaire {

    protected BinaireLogique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    public boolean estBooleen(){
    	return true;
    }
    
    public void verify() throws AnalyseSemantiqueException{
    	if (!(gauche.estBooleen() && droite.estBooleen())){
    		throw new AnalyseSemantiqueException(ligne, "Binaire Logique sur 2 expressions incompatibles");
    	}
    }
}
