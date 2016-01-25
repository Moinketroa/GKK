package plic.arbre.expression.binaire;

import plic.arbre.expression.Expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Div extends BinaireArithmetique {

    public Div(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " / ";
    }

	@Override
	public String toMips() {
		StringBuilder sb = new StringBuilder();
		
		
		/* Cas gauche et droite sont des expressions */
		sb.append(this.gauche.toMips());
		sb.append("sw $v0, ($sp)");
		sb.append("addi $sp, $sp, -4");
		sb.append(this.droite.toMips());
		sb.append("addi $sp, $sp, 4");
		sb.append("lw $t8, ($sp)");
		sb.append("div $v0, $t8");
		sb.append("mflo $v0");
		
		return sb.toString();
	}
    
}
