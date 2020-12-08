/**Dies ist der Klasse Zoo aus der Aufgabe 9.*/
public class Zoo {
	
	private double essen;
	private double wasser;
	private int gehegeanzahl;
	private Tier[] gehege;
	
	/**Dies ist der Konstruktoren der Klasse Zoo. Es werden @param essen , 
	 *@param wasser und 
	 *@param gehegeanzahl übergeben und initialisiert
	*/
	public Zoo(int essen, int wasser, int gehegeanzahl) {
		this.essen = essen;
		this.wasser = wasser;
		this.gehegeanzahl = gehegeanzahl;
		gehege = new Tier[gehegeanzahl];
	}
	
	/**Diese Methode fügt ein neues @param tier in ein Gehege hinzu, wenn es noch freie Gehege gibt.
	 *Wenn nicht dann gibt sie eine Meldung
	*/
	public void neuesTier(Tier tier) {
		
		for (int i = 0; i < gehegeanzahl; i++) {
			
			if (gehege[i] == null) {				
				gehege[i] = tier;
				return;
			}
		}
		
		String meldung1 = "**Alle Gehege im Zoo sind besetzt. Der neue " + tier.getClass().getName() + " nammens '" + tier.getName(),
		       meldung2 = "' kann nicht in den Zoo einziehen.";
		System.out.println(meldung1 + meldung2);		
	}
	
	/**Diese methode @return die Menge von Futter in dem Zoo*/
	public double getEssen() {	
		return essen;
	}
	
	/**Diese methode @return die Menge von Wasser in dem Zoo*/
	public double getWasser() {
		return wasser;
	}
	
	/**Diese methode füttert das @param tier und 
	 *@return true, wenn dies gelingt und false wenn nicht
	*/
	public boolean fuetter(Tier tier) {
		double essMenge = tier.essen();
		if (essen >= essMenge) {
			essen -= essMenge;
			return true;
		}
		
		return false;
	}
	
	/**Diese methode tränkt das @param tier und 
	 *@return true, wenn dies gelingt und false wenn nicht
	*/
	public boolean traenken(Tier tier) {
		double trinkMenge = tier.trinken();
		if (wasser >= trinkMenge) {
			wasser -= trinkMenge;
			return true;
		}
		
		return false;
	}
	
	/**Diese methode @return die Liste der Gehege in dem Zoo*/
	public Tier[] getGehege() {
		return gehege;
	}
}
