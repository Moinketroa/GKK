package plic.arbre.expression.binaire.comparaison;

import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Egal extends Comparaison {
	private int compteur = 1;  	
	
    public Egal(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " == ";
    }

	@Override
	public String toMips() {
		this.verify();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("#Comparaison égal à\n");
		
		sb.append(super.toMips());
		
		sb.append("\t beq $v0, $t8, vraiEgal" + compteur + "\n");
		/* Si non égal : on charge faux dans v0 */
		sb.append("\t li $v0, 0\n");
		sb.append("\tj finEgal" + compteur + "\n");
		/* Si égal : on charge vrai dans v0 */
		sb.append("vraiEgal" + compteur + " :\t li $v0, 1\n");
		sb.append("finEgal" + compteur + " :\n");
		
		compteur++;
		return sb.toString();
	}
    
	public void verify() throws AnalyseSemantiqueException{
    	if ((gauche.estBooleen() && droite.estEntiere()) || (droite.estBooleen() && gauche.estEntiere())){
    		throw new AnalyseSemantiqueException("Egal sur 2 expressions différentes");
    	}
    }
	
}
