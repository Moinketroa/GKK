package plic.arbre.expression.binaire.comparaison;

import plic.LabelMaker;
import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Different extends Comparaison {
	private LabelMaker lablemaker = LabelMaker.getInstance();
	private int compteur;
	
    public Different(Expression gauche, Expression droite) {
        super(gauche, droite);
        compteur = lablemaker.getDiffLabel();
    }

    @Override
    public String operateur() {
        return " != ";
    }

	@Override
	public String toMips() {
		this.verify();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("#Comparaison différent de\n");
		
		sb.append(super.toMips());
		
		sb.append("\t beq $v0, $t8, fauxDiff" + compteur + "\n");
		/* Si non égal : on charge vrai dans v0 */
		sb.append("\t li $v0, 1\n");
		sb.append("\tj finDiff" + compteur + "\n");
		/* Si égal : on charge faux dans v0 */
		sb.append("fauxDiff" + compteur + " :\t li $v0, 0\n");
		sb.append("finDiff" + compteur + " :\n");
		
		compteur++;
		return sb.toString();
	}
	
	public void verify() throws AnalyseSemantiqueException{
    	if ((gauche.estBooleen() && droite.estEntiere()) || (droite.estBooleen() && gauche.estEntiere())){
    		throw new AnalyseSemantiqueException(ligne, "Different sur 2 expressions différentes");
    	}
    }
  
}
