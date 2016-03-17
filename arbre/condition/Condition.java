package plic.arbre.condition;

import plic.LabelMaker;
import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

public class Condition extends ArbreAbstrait {
	
	private LabelMaker lablemaker = LabelMaker.getInstance();
	private int compteur;

	protected ArbreAbstrait blocSi;
	protected ArbreAbstrait blocSinon;
	
	protected Expression condition;
	
	public Condition(Expression e, ArbreAbstrait bsi, ArbreAbstrait bsinn){
		super();
		
		condition = e;
		blocSi = bsi;
		blocSinon = bsinn;
		
		compteur = lablemaker.getSiLabel();
	}
	
	@Override
	public String toMips() {
		
		verify();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\t#Condition\n");
		
		if (condition.estConstante()){
			sb.append("\t li $v0, " + condition.toMips() + "\n");
		} else {
			sb.append(condition.toMips());
		}
			
		if (blocSi == null){
			if (blocSinon == null)
				return sb.toString();
			sb.append("\t beq $v0, 1, fsi" + compteur + "\n");
		} else {
			sb.append("\t beq $v0, 1, si" + compteur + "\n");
		}
		
		sb.append("\t#sinon:\n");
		
		if (blocSinon == null){
			sb.append("\t j fsi" + compteur + "\n");
		} else {
			sb.append(blocSinon.toMips());
			sb.append("\t j fsi" + compteur + "\n");
		}
		
		sb.append("\t si" + compteur + " :\n");
		sb.append(blocSi.toMips());
		sb.append("\t fsi" + compteur + " :\n");
		
		return sb.toString();
	}

	public void verify() throws AnalyseSemantiqueException {
		if (!(condition.estBooleen())){
			throw new AnalyseSemantiqueException(ligne, "La condition n'est pas une expression logique");
		}
	}
}
