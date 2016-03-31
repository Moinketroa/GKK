package plic.arbre.expression.binaire.comparaison;

import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

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
		this.verify();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("#Comparaison inférieur à\n");
		
		if (this.gauche.estConstante() && this.droite.estConstante()) {
			/* Cas droite et gauche constantes */
			int g = Integer.parseInt(gauche.toMips());
			int d = Integer.parseInt(droite.toMips());
		
			if (g < d)
				sb.append("li $v0, " + 1 + "\n");
			else 
				sb.append("li $v0, " + 0 + "\n");
			
		} else if (this.droite.estConstante()){
			/* Cas droite constante */
			sb.append(this.gauche.toMips() + "\n");
			sb.append("slt $v0, $v0, " + this.droite.toMips() + "\n");
		} else if (this.gauche.estConstante()){
			/* Cas gauche constante */
			sb.append(this.droite.toMips() + "\n");
			sb.append("slt $v0, $v0, " + this.gauche.toMips() + "\n");
			sb.append("sub $v0,$zero,$v0\n");
		}else {
			/* Cas gauche et droite sont des expressions */
			sb.append(this.gauche.toMips() + "\n");
			sb.append("sw $v0, ($sp)\n");
			sb.append("addi $sp, $sp, -4\n");
			sb.append(this.droite.toMips() + "\n");
			sb.append("addi $sp, $sp, 4\n");
			sb.append("lw $t8, ($sp)\n");
			sb.append("slt $v0, $v0, $t8\n");
			sb.append("sub $v0,$zero,$v0\n");
		}
		
		return sb.toString();
	}
    
	public void verify() throws AnalyseSemantiqueException{
    	if (!(gauche.estEntiere() && droite.estEntiere())){
    		throw new AnalyseSemantiqueException(ligne, "Inferieur sur 2 expressions incompatibles");
    	}
    }
}
