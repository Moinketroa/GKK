package plic.tds.symboles;

import plic.arbre.expression.Expression;

public abstract class Symbole {
	protected int deplacement;
	protected String statut, type;
	protected int taille;
	
	
	public Symbole(String statut, String type){
		super();
		this.statut = statut;
		this.type = type;
	}
	
	public void setDeplacement(int d){
		deplacement = d;
	}
	
	public int getDeplacement(){
		return deplacement;
	}
	
	public int getTailleSymbole(){
		return (taille * -1);
	}
}
