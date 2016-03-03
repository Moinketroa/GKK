package plic.arbre.declarations;

import plic.exceptions.AnalyseSemantiqueException;
import plic.tds.TDS;
import plic.tds.entrees.EntreeVar;
import plic.tds.symboles.SymboleEntier;

public class DeclarationConstante extends Declaration {
	
// Classe faisant la meme chose que DeclarationChamp donc a revoir si utile
	public DeclarationConstante(String nom,String type,String status ) {
		super(nom,type,status);
	}

	@Override
	public String toMips() {
		TDS.getInstance().ajouter(new EntreeVar(nom),new SymboleEntier(type,status));
		return null;
	}

	@Override
	public void verify() throws AnalyseSemantiqueException {
		// TODO Auto-generated method stub

	}

}
