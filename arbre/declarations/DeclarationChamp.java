package plic.arbre.declarations;

import plic.exceptions.AnalyseSemantiqueException;
import plic.tds.TDS;
import plic.tds.symboles.*;
import plic.tds.entrees.*;

public class DeclarationChamp extends Declaration{


	public DeclarationChamp(String nom,String type,String status ) {
		super(nom,type,status);
	}
	
	@Override
	public String toMips() {
		//TDS.getInstance().ajouter(new EntreeVar(nom),new SymboleEntier(type,status));
		return null;
	}

	@Override
	public void verify() throws AnalyseSemantiqueException {
		// TODO Auto-generated method stub

	}

}
