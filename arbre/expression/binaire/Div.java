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
		this.verify();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("#Division\n");
		
		if (this.gauche.estConstante() && this.droite.estConstante()) {
			/* Cas droite et gauche constantes */
			sb.append("#Division gauche et droite constantes\n");
			sb.append("li $v0, " + this.gauche.toMips() + "\n");
			sb.append("li $t8, " + this.droite.toMips() + "\n");
			sb.append("div $v0, $t8\n");
			sb.append("mflo $v0\n");
		}else if (this.gauche.estConstante()){
			/* Cas gauche constante */
			sb.append("#Division gauche constante\n");
			sb.append(this.droite.toMips() + "\n");
			sb.append("li $t8,"+this.gauche.toMips() + "\n");
			sb.append("mult $v0, $t8\n");
			sb.append("mflo $v0\n");
		}else if (this.droite.estConstante()){
			/* Cas droite constante */
			sb.append("#Division droite constante\n");
			sb.append(this.gauche.toMips() + "\n");
			sb.append("li $t8, " + this.droite.toMips() + "\n");
			sb.append("div $v0, $t8\n");
			sb.append("mflo $v0\n");
		} else {
			/* Cas gauche et droite sont des expressions */
			sb.append("#Division gauche et droite expressions\n");
			sb.append(this.gauche.toMips()+"\n");
			sb.append("sw $v0, ($sp)\n");
			sb.append("addi $sp, $sp, -4\n");
			sb.append(this.droite.toMips()+"\n");
			sb.append("addi $sp, $sp, 4\n");
			sb.append("lw $t8, ($sp)\n");
			sb.append("div $t8, $v0\n");
			sb.append("mflo $v0\n");
		}
		
		return sb.toString();
	} 
}
