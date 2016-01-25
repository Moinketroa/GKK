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
		
		if (this.gauche.estConstante() && this.droite.estConstante()) {
			/* Cas droite et gauche constantes */
			sb.append("li $v0, " + this.gauche.toMips() + "\n");
			sb.append("li $t8, " + this.droite.toMips() + "\n");
			sb.append("div $v0, $t8\n");
			sb.append("mflo $v0");
		} else if (this.droite.estConstante()){
			/* Cas droite constante */
			sb.append(this.gauche.toMips() + "\n");
			sb.append("li $t8, " + this.droite.toMips() + "\n");
			sb.append("div $v0, $t8\n");
			sb.append("mflo $v0");
		} else {
			/* Cas gauche et droite sont des expressions */
			sb.append(this.gauche.toMips());
			sb.append("sw $v0, ($sp)");
			sb.append("addi $sp, $sp, -4");
			sb.append(this.droite.toMips());
			sb.append("addi $sp, $sp, 4");
			sb.append("lw $t8, ($sp)");
			sb.append("div $v0, $t8");
			sb.append("mflo $v0");
		}
		
		return sb.toString();
	} 
}
