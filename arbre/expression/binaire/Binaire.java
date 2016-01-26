package plic.arbre.expression.binaire;

import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Binaire extends Expression {
    
    protected Expression gauche ;
    protected Expression droite ;

    protected Binaire(Expression gauche, Expression droite) {
        super();
        this.gauche = gauche;
        this.droite = droite;
    }
    
    public abstract String operateur() ;

    @Override
    public String toString() {
        return "(" + gauche + operateur() + droite + ")" ;
    }

    public void verify() throws AnalyseSemantiqueException{
    	if (!(gauche.estBooleen() && droite.estBooleen())){
    		throw new AnalyseSemantiqueException("Binaire Logique ou Comparaison sur 2 expressions incompatibles");
    	}
    }
    
}
