package plic.arbre.expression.binaire;

import plic.arbre.expression.Expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Mult extends BinaireArithmetique {

    public Mult(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
  
    @Override
    public String operateur() {
        return " * ";
    }

	@Override
	public String toMips() {
		this.verify();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("#Multiplication\n");
		
		if (this.gauche.estConstante() && this.droite.estConstante()) {
			/* Cas droite et gauche constantes */
			sb.append("li $v0, " + this.gauche.toMips() + "\n");
			sb.append("li $t8, " + this.droite.toMips() + "\n");
			sb.append("mult $v0, $t8\n");
			sb.append("mflo $v0\n");
		}else if (this.gauche.estConstante()){
			/* Cas gauche constante */
			sb.append(this.droite.toMips() + "\n");
			sb.append("li $t8,"+this.gauche.toMips() + "\n");
			sb.append("mult $v0, $t8\n");
			sb.append("mflo $v0\n");
		}else if (this.droite.estConstante()){
			/* Cas droite constante */
			sb.append(this.gauche.toMips() + "\n");
			sb.append("li $t8, " + this.droite.toMips() + "\n");
			sb.append("mult $v0, $t8\n");
			sb.append("mflo $v0\n");
		} else {
			/* Cas gauche et droite sont des expressions */
			sb.append(this.gauche.toMips()+"\n");
			sb.append("sw $v0, ($sp)\n");
			sb.append("addi $sp, $sp, -4\n");
			sb.append(this.droite.toMips()+"\n");
			sb.append("addi $sp, $sp, 4\n");
			sb.append("lw $t8, ($sp)\n");
			sb.append("mult $v0, $t8\n");
			sb.append("mflo $v0\n");
		}
		
		return sb.toString();
	}

}
