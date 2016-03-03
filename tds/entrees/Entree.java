package plic.tds.entrees;

public abstract class Entree {
	protected String nom;
	
	public String toString(){
		return nom;
	}
	
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		// object must be Test at this point
		Entree test = (Entree)obj;
		
		int res = nom.compareTo(test.toString());
		
		if (res == 0)
			return true;
		else 
			return false;
	}	
	
	public int hashCode(){
		return nom.hashCode();
	}
}
