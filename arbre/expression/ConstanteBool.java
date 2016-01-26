package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {
    
    public ConstanteBool(String texte) {
        super(texte) ;
    }

	@Override
	public String toMips() {
		this.verify();
		if(this.cste.equals("vrai")){
			return "1";
		}
		else{
			return "0";
		}
	}

	public boolean estBooleen(){
		return true;
	}
}
