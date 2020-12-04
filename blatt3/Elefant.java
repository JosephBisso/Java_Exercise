public class Elefant extends Tier{
	
	public Elefant(String name, double hunger, double durst, int groesse){
		super(name, hunger, durst, groesse);
	}
	
	public Elefant(String name, double hunger, double durst){
		super(name, hunger, durst);	
	}
	
	public String toString(){
		String antwort = "";
		if (super.groesse>=2){
			antwort =  super.toString() + "Töröö";
		} 
		return antwort;
	}	
}