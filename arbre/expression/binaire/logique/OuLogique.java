package plic.arbre.expression.binaire.logique;

import plic.arbre.expression.Expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class OuLogique extends BinaireLogique {

    public OuLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " ou " ;
    }

	@Override
	public String toMips() {
StringBuilder sb = new StringBuilder();
		
		sb.append(super.toMips());
		
		/* Empile droite */
		sb.append("\t sw $t8, 0($sp)\n");
		sb.append("\t addi $sp, $sp, -4\n");
		/* Test de la valeur de gauche ( == 1) */
		sb.append("\t li $t8, 1\n");
		sb.append("\t beq $v0, $t8, binaireVrai\n");
		sb.append("\t lw $v0, 4($sp)\n");
		/* Test de la valeur de droite ( == 1) */
		sb.append("\t beq $v0, $t8, binaireVrai\n");
		/* Faux */
		sb.append("binaireFaux : \t li $v0, 0\n");
		sb.append("\t j binaireFin\n");
		/* Vrai */
		sb.append("binaireVrai : \t li $v0, 1\n");
		sb.append("binaireFin : \t addi $sp, $sp, 4\n");
		
		
		return sb.toString();
	}

}
