package plic.arbre.expression.unaire;

import plic.arbre.expression.Expression;

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
		StringBuilder sb = new StringBuilder();
		if(this.expression.estConstante()){
			sb.append("li $v0, " + this.expression.toMips() + "\n");
		}
		else {
			sb.append(this.expression.toMips() + "\n");
		}
		sb.append("sub $v0,$zero,$v0\n");
		sb.append("\t si:\n");
		sb.append("beqz $v0,sinon\n");   
		sb.append("li $v0,1\n");   
		sb.append("j finsi\n");   
		sb.append("\t sinon:\n");
		sb.append("li $v0,0\n");
		sb.append("\t finsi:\n");
			
		return sb.toString();
	}

	public boolean estBinaire(){
		return true;
	}
}
