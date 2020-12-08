/**Dies ist die Klasse Tier aus der Aufgabe 9. Sie ist abstract!*/
public abstract class Tier {
	
	protected String name;
	protected double hunger;
	protected double durst;
	protected int groesse;
	
	/**Dies ist einer der Konstruktoren der Klasse Tier. Es werden @param name , 
	 *@param hunger , 
	 *@param durst und 
	 *@param groesse übergeben und initialisiert
	*/
	protected Tier(String name, double hunger, double durst, int groesse) {
		this.name = name;
		this.hunger = hunger;
		this.durst = durst;
		this.groesse = groesse;		
	}
	
	/**Dies ist der 2. Konstruktor der Klasse Elefant. Es werden @param name , 
	 *@param hunger und 
	 *@param durst übergeben und initialisiert. Es wird groesse = 1
	 *gesetzt
	*/
	protected Tier(String name, double hunger, double durst) {
		this(name, hunger, durst, 1);	
	}
	
	/**Diese Methode @return die benögte Wasser Menge des Tiers
	*/
	public double trinken() {
		return durst * groesse;
	}
	
	/**Diese Methode @return die benögte Futter Menge des Tiers
	*/
	public double essen() {
		return hunger * groesse;
	}
	
	/**Diese Methode @return den default Ruf für alle Tiere
	*/
	public String toString() {
		return "Trö";
	}
	
	/**Diese Methode @return den Namen des Tiers
	*/
	public String getName() {
		return name;
	}
}