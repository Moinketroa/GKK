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
		return this.cste;
	}

	public boolean estBooleen(){
		return true;
	}
}
