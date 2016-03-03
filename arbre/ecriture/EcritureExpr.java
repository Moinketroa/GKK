package plic.arbre.ecriture;

import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

public class EcritureExpr extends Ecriture {

	Expression exp;
	
	public EcritureExpr(Expression e) {
		super();
		exp = e;
	}
	
	@Override
	public String toMips() {
		StringBuilder sb = new StringBuilder();
		sb.append(exp.toMips());
		
		sb.append("\tmove $a0, $v0\n");
		sb.append("\t li $v0, 1\n");
		sb.append("\tsyscall\n");
		sb.append("\tli\t$v0, 4\n");
		sb.append("\tla\t$a0, newline\n");
		sb.append("\tsyscall\n");
		
		return sb.toString();
	}

	@Override
	public void verify() throws AnalyseSemantiqueException {
		// TODO Auto-generated method stub

	}

}
