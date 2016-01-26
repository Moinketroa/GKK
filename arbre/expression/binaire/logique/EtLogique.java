package plic.arbre.expression.binaire.logique;

import plic.arbre.expression.Expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class EtLogique extends BinaireLogique {

    public EtLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " et " ;
    }

	@Override
	public String toMips() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toMips());
		
		sb.append("\t bne $v0, $t8, binaireFaux\n");
		/* Si les deux ne sont pas égaux : on jumpe vers faux */
		sb.append("\t li $t8, 1\n");
		sb.append("\t bne $v0, $t8, binaireFaux\n");
		/* Si gauche n'est pas 1 : on jumpe vers faux */
		sb.append("binaireVrai : \t li $v0, 1\n");
		sb.append("\t j binaireFin\n");	
		sb.append("binaireFaux : \t li $v0, 0\n");
		sb.append("binaireFin : \t\n");
		
		return sb.toString();
	}

}
