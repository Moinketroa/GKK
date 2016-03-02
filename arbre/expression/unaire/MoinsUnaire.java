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
        return "-" ;
    }

	@Override
	public String toMips() {
		this.verify();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("#Moins Unaire\n");
		
		if(this.expression.estConstante()){
			sb.append("li $v0, " + this.expression.toMips() + "\n");
		}
		else {
			sb.append(this.expression.toMips() + "\n");
		}
		sb.append("sub $v0,$zero,$v0\n");
		return sb.toString();
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
