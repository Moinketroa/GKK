package plic.arbre.expression.binaire.comparaison;

import plic.LabelMaker;
import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Egal extends Comparaison {
	private LabelMaker lablemaker = LabelMaker.getInstance();
	private int compteur;
	
    public Egal(Expression gauche, Expression droite) {
        super(gauche, droite);
        compteur = lablemaker.getEgalLabel();
    }
    
    @Override
    public String operateur() {
        return " == ";
    }

	@Override
	public String toMips() {
		this.verify();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("#Comparaison égal à\n");
		
		if (this.gauche.estConstante() && this.droite.estConstante()) {
			/* Cas droite et gauche constantes */
			sb.append("li $v0, " + gauche.toMips() + "\n");
			sb.append("beq $v0, $v0, " + droite.toMips() + ", vraiEgal" + compteur + "\n");
		} else if (this.droite.estConstante()){
			/* Cas droite constante */
			sb.append(this.gauche.toMips() + "\n");
			sb.append("beq $v0, $v0, " + droite.toMips() + ", vraiEgal" + compteur + "\n");
		} else if (this.gauche.estConstante()){
			/* Cas gauche constante */
			sb.append(this.droite.toMips() + "\n");
			sb.append("beq $v0, $v0, " + gauche.toMips() + ", vraiEgal" + compteur + "\n");
		}else {
			/* Cas gauche et droite sont des expressions */
			sb.append(this.gauche.toMips() + "\n");
			sb.append("sw $v0, ($sp)\n");
			sb.append("addi $sp, $sp, -4\n");
			sb.append(this.droite.toMips() + "\n");
			sb.append("addi $sp, $sp, 4\n");
			sb.append("lw $t8, ($sp)\n");
			sb.append("beq $v0, $v0, $t8, vraiEgal" + compteur + "\n");
		}
		
		/* Si non égal : on charge faux dans v0 */
		sb.append("\t li $v0, 0\n");
		sb.append("\tj finEgal" + compteur + "\n");
		/* Si égal : on charge vrai dans v0 */
		sb.append("vraiEgal" + compteur + " :\t li $v0, 1\n");
		sb.append("finEgal" + compteur + " :\n");
		
		return sb.toString();
	}
    
	public void verify() throws AnalyseSemantiqueException{
    	if ((gauche.estBooleen() && droite.estEntiere()) || (droite.estBooleen() && gauche.estEntiere())){
    		throw new AnalyseSemantiqueException(ligne, "Egal sur 2 expressions différentes");
    	}
    }
	
}
