package plic.arbre.expression.binaire.logique;

import plic.arbre.expression.Expression;
import plic.arbre.expression.binaire.Binaire;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireLogique extends Binaire {

    protected BinaireLogique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    public String toMips(){
    	StringBuilder sb = new StringBuilder();
    	
    	if (this.gauche.estConstante() && this.droite.estConstante()) {
			/* Cas droite et gauche constantes */
    		sb.append("li $v0, " + this.gauche.toMips() + "\n");
			sb.append("li $t8, " + this.droite.toMips() + "\n");
		} else if (this.droite.estConstante()){
			/* Cas droite constante */
			sb.append(this.gauche.toMips() + "\n");
			sb.append("li $t8, " + this.droite.toMips() + "\n");
		} else if (this.gauche.estConstante()){
			/* Cas gauche constante */
			sb.append(this.droite.toMips() + "\n");
			sb.append("move $t8, $v0\n");
			sb.append("li $v0, " + this.gauche.toMips() + "\n");		
		} else {
			/* Cas gauche et droite sont des expressions */
			sb.append(this.droite.toMips() + "\n");
			sb.append("move $t8, $v0\n");
			sb.append(this.gauche.toMips() + "\n");
		}
    	
    	return sb.toString();
    }
    
    public boolean estBooleen(){
    	return true;
    }
    
    public void verify() throws AnalyseSemantiqueException{
    	if (!(gauche.estBooleen() && droite.estBooleen())){
    		throw new AnalyseSemantiqueException(ligne, "Binaire Logique sur 2 expressions incompatibles");
    	}
    }
}
