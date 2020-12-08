/**Dies ist die Klasse Elefant aus der Aufgabe 9. Sie Eigenschaften von der Klasse Tier*/
public class Elefant extends Tier {
	
	/**Dies ist einer der Konstruktoren der Klasse Elefant. Es werden @param name , 
	 *@param hunger , 
	 *@param durst und 
	 *@param groesse übergeben und initialisiert
	*/
	public Elefant(String name, double hunger, double durst, int groesse) {
		super(name, hunger, durst, groesse);
	}
	
	/**Dies ist der 2. Konstruktor der Klasse Elefant. Es werden @param name , 
	 *@param hunger und 
	 *@param durst übergeben und initialisiert. Es wird groesse = 1
	 *gesetzt
	*/
	public Elefant(String name, double hunger, double durst) {
		super(name, hunger, durst);	
	}
	
	/**Diese Methode @return den Default Aufruf aus der Klasse Tier, falls
	 *groesse < 2 und fügt einen weiteren Ausdruck falls groesse >= 2
	*/
	public String toString() {
		String antwort = super.toString();
		if (super.groesse >= 2) {
			antwort += " Töröö";
		} 
		return antwort;
	}	
}