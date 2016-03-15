package plic.arbre.expression.binaire.comparaison;

import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Superieur extends Comparaison {

    public Superieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " > ";
    }

	@Override
	public String toMips() {
		this.verify();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("#Comparaison supérieur à\n");
		
		sb.append(super.toMips());
		
		sb.append("slt $v0, $t8, $v0\n");
		
		return sb.toString();
	}
    
	public void verify() throws AnalyseSemantiqueException{
    	if (!(gauche.estEntiere() && droite.estEntiere())){
    		throw new AnalyseSemantiqueException(ligne, "Superieur sur 2 expressions incompatibles");
    	}
    }
}
