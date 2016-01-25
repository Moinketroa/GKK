package plic.arbre.expression.binaire.comparaison;

import plic.arbre.expression.Expression;
import plic.arbre.expression.binaire.Binaire;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Comparaison extends Binaire {
     
    protected Comparaison(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

}
