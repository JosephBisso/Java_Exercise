public class Zoo {
	
	private double essen;
	private double wasser;
	private int gehegeanzahl;
	private Tier[] gehege;
	
	public Zoo(int essen, int wasser, int gehegeanzahl) {
		this.essen = essen;
		this.wasser = wasser;
		this.gehegeanzahl = gehegeanzahl;
		gehege = new Tier [gehegeanzahl];
	}
	
	public void neuesTier(Tier tier) {
		
		for(int i = 0; i < gehegeanzahl; i++) {
			
			if (gehege[i] == null) {				
				gehege[i] = tier;
				return;
			}
		}
		
		System.out.println("**Alle Gehege im Zoo sind besetzt. Der neue " + tier.getClass().getName() + " nammens '" + tier.getName() + "' kann nicht in den Zoo einziehen.");		
	}
	
	public double getEssen() {	
		return essen;
	}
	
	public double getWasser() {
		return wasser;
	}
	
	public boolean fuetter(Tier tier) {
		double essMenge = tier.essen();
		if (essen >= essMenge) {
			essen -= essMenge;
			return true;
		}
		
		return false;
	}
	
	public boolean traenken(Tier tier) {
		double trinkMenge = tier.trinken();
		if (wasser >= trinkMenge) {
			wasser -= trinkMenge;
			return true;
		}
		
		return false;
	}
	
	public Tier[] getGehege() {
		return gehege;
	}
}
