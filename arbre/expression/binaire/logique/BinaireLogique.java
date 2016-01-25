package plic.arbre.expression.binaire.logique;

import plic.arbre.expression.Expression;
import plic.arbre.expression.binaire.Binaire;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireLogique extends Binaire {

    protected BinaireLogique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
}
