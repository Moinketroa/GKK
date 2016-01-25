package plic.arbre.expression.binaire.comparaison;

import plic.arbre.expression.Expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Inferieur extends Comparaison {

    public Inferieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " < ";
    }

	@Override
	public String toMips() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toMips());
		
		sb.append("\t sub $v0, $v0, $t8");
		
		sb.append("\t bltz $v0, vraiComp1\n");
		/* Si supérieur : on charge faux dans v0 */
		sb.append("\t li $v0, 0\n");
		sb.append("\tj finComp1\n");
		/* Si inférieur : on charge vrai dans v0 */
		sb.append("vraiComp1 :\t li $v0, 1\n");
		sb.append("finComp1 :\n");
		
		return sb.toString();
	}
    
}
