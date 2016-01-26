package plic.arbre.expression.unaire;

import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return " non " ;
    }

	@Override
	public String toMips() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean estBooleen(){
		return true;
	}

	@Override
	public void verify() throws AnalyseSemantiqueException {
		if (!expression.estBooleen()){
			throw new AnalyseSemantiqueException("Non Logique sur expression entière");
		}
	}
}
