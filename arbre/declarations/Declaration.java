package plic.arbre.declarations;

import plic.arbre.ArbreAbstrait;
import plic.exceptions.AnalyseSemantiqueException;

public abstract class Declaration extends ArbreAbstrait{
	
	String nom,type,status;
	
	protected Declaration(String nom,String type,String status){
		super();
		this.nom = nom;
		this.type = type;
		this.status = status;
	}
	
	public abstract String toMips();
	
	public abstract void verify() throws AnalyseSemantiqueException;
}
