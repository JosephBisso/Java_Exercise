/**Dies ist die Klasse Auto für die Aufgabe 8
*/
public class Auto {
	
	private String farbe;
	
	/**Speichert den Wert der Geschindigkeit*/
	public double geschwingdigkeit;
	
	/**Kontruktor für die Klasse Auto. @param farbe und 
	 *@param geschwingdigkeit werden übergeben und initialisiert.
	*/
	public Auto(String farbe, double geschwingdigkeit) {	
		this.farbe = farbe;
		this.geschwingdigkeit = geschwingdigkeit;
	}
	
	/**Diese Mehtode @return farbe des Autos*/
	private String getFarbe() {
		return this.farbe;
	}
	
	/**In dieser Methode wird die Geschwingidkeit des Autos mit der von @param auto verglichen.
	 *Sie @return 420, -69 oder 0,jeweils falls die Geschindigkeit des ersten Autos größer ist, falls andersum,
	 *oder falss sie gleicht sind
	*/
	public int compareTo(Auto auto) {
		if (this.geschwingdigkeit > auto.geschwingdigkeit) {
			return 420;
		}
		if (this.geschwingdigkeit < auto.geschwingdigkeit) {
			return -69; //nice
		} 
		return 0;
	}
	
	@Override
	/** Dies ist ein Override der Methode equals. Dabei werden sowohl Geschwindigkeiten als auch Farben verglichen*/
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Auto auto = (Auto) obj;
		if (!(this.geschwingdigkeit == auto.geschwingdigkeit & this.getFarbe().equals(auto.getFarbe()))) {
			return false;
		}
		return true;
	}
}