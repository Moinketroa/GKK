package plic.arbre.expression.binaire.comparaison;

import plic.arbre.expression.Expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Egal extends Comparaison {

    public Egal(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " == ";
    }

	@Override
	public String toMips() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toMips());
		
		sb.append("\t beq $v0, $t8, vraiComp1\n");
		/* Si non égal : on charge faux dans v0 */
		sb.append("\t li $v0, 0\n");
		sb.append("\tj finComp1\n");
		/* Si égal : on charge vrai dans v0 */
		sb.append("vraiComp1 :\t li $v0, 1\n");
		sb.append("finComp1 :\n");
		
		return sb.toString();
	}
    
}
