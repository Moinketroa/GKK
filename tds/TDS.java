package plic.tds;

import java.util.HashMap;

import plic.exceptions.DoubleDeclarationException;
import plic.tds.entrees.Entree;
import plic.tds.symboles.Symbole;

public class TDS{
	private static TDS instance = new TDS();
	private int deplacement = 0;
	private HashMap<Entree, Symbole> dict = new HashMap<>();
	
	private TDS(){
	}
	
	public static TDS getInstance(){
		return instance;
	}
	
	public void ajouter(Entree e, Symbole s){
		if (dict.containsKey(e)) throw new DoubleDeclarationException(e.toString());
		s.setDeplacement(deplacement);
		deplacement += 4;
		dict.put(e, s);
	}
	
	public Symbole identifier(Entree e){
		if (!dict.containsKey(e)) return null;
		return dict.get(e);
	}
	
	public int getTailleZoneDesVariables(){
		return deplacement;
	}
}