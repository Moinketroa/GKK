package plic.arbre.expression.unaire;

import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {
    
    public MoinsUnaire(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return "- " ;
    }

	@Override
	public String toMips() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean estEntiere(){
		return true;
	}

	@Override
	public void verify() throws AnalyseSemantiqueException {
		if (!expression.estEntiere()){
			throw new AnalyseSemantiqueException("Moins Unaire sur expression booléenne");
		}
	}
}
