package plic.arbre.expression.unaire;

import plic.arbre.expression.Expression;

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
		StringBuilder sb = new StringBuilder();
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
}
