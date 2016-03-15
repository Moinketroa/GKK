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
		this.verify();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("#Non Logique\n");
		
		if(this.expression.estConstante()){
			sb.append("li $v0, " + this.expression.toMips() + "\n");
		}
		else {
			sb.append(this.expression.toMips() + "\n");
		}
		sb.append("not $v0, $v0\n");
		sb.append("addi $v0, $v0, 2\n");
			
		return sb.toString();
	}

	public boolean estBooleen(){
		return true;
	}

	@Override
	public void verify() throws AnalyseSemantiqueException {
		if (!expression.estBooleen()){
			throw new AnalyseSemantiqueException(ligne, "Non Logique sur expression entière");
		}
	}
}
