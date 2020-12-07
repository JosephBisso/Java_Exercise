/**Dies ist der Klasse Loewe aus der Aufgabe 9. Sie Eigenschaften von der Klasse Tier*/
public class Loewe extends Tier {
	
	/**Dies ist einer der Konstruktoren der Klasse Loewe. Es werden @param name , 
	 *@param hunger , 
	 *@param durst und 
	 *@param groesse übergeben und initialisiert
	*/
	public Loewe(String name, double hunger, double durst, int groesse) {
		super(name, hunger, durst, groesse);
	}
	
	/**Dies ist der 2. Konstruktor der Klasse Elefant. Es werden @param name , 
	 *@param hunger und 
	 *@param durst übergeben und initialisiert. Es wird groesse = 1
	 *gesetzt
	*/
	public Loewe(String name, double hunger, double durst) {
		super(name, hunger, durst);	
	}
	
	/**Diese Methode berechne den Ruf des Loewen nach seiner 'Stimmung'
	 *@return ... oder Grooar, jeweils falls der Loewe schlecht (Zufallzahl gerade) 
	 *oder gut (Zufallzahl ungerade) gelaunt ist
	*/
	private String berechneRuf() {
		
		int random = (int) (100 * Math.random());
		
		if (random % 2 == 0) {
			return "...";
		}
		return "Grooooooooaaaaaar";
	}
	
	/**Diese Methode @return das Ergebnis aus der Methode berechneRuf()
	*/
	public String toString() {
		return berechneRuf();
	}
}