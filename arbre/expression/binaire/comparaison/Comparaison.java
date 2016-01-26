package plic.arbre.expression.binaire.comparaison;

import plic.arbre.expression.Expression;
import plic.arbre.expression.binaire.Binaire;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Comparaison extends Binaire {
     
    protected Comparaison(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    public String toMips(){
    	StringBuilder sb = new StringBuilder();
    	
    	if (this.gauche.estConstante() && this.droite.estConstante()) {
			/* Cas droite et gauche constantes */
			sb.append("comp:\t li $v0, " + this.gauche.toMips() + "\n");
			sb.append("\t li $t8, " + this.droite.toMips() + "\n");
		} else if (this.droite.estConstante()){
			/* Cas droite constante */
			sb.append("comp:\t " + this.gauche.toMips() + "\n");
			sb.append("\t li $t8, " + this.droite.toMips() + "\n");
		} else if (this.gauche.estConstante()){
			/* Cas gauche constante */
			sb.append("comp:\t " + this.droite.toMips() + "\n");
			sb.append("\t move $t8, $v0\n");
			sb.append("\t li $v0, " + this.gauche.toMips() + "\n");
		} else {
			/* Cas gauche et droite sont des expressions */
			sb.append("comp:\t " + this.droite.toMips() + "\n");
			sb.append("\t move $t8, $v0\n");
			sb.append("\t " + this.gauche.toMips() + "\n");
		}
    	
    	return sb.toString();
    }
    
    public boolean estBinaire(){
    	return true;
    }
}
