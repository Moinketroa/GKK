package plic.exceptions;

public class AnalyseSemantiqueException extends AnalyseException {

	public AnalyseSemantiqueException(int l, String m) {
		super("ERREUR SEMANTIQUE :\n\t" + "ligne : " + l + " : " + m);
	}

}
