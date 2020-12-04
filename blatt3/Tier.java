public abstract class Tier{
	
	protected String name;
	protected double hunger;
	protected double durst;
	protected int groesse;
	
	protected Tier(String name, double hunger, double durst, int groesse){
		this.name = name;
		this.hunger = hunger;
		this.durst = durst;
		this.groesse = groesse;		
	}
	
	protected Tier(String name, double hunger, double durst){
		this(name, hunger, durst, 1);	
	}
	
	public double trinken(){
		return durst*groesse;
	}
	
	public double essen(){
		return hunger*groesse;
	}
	
	public String toString(){
		return "Trö";
	}
	
	public String getName(){
		return name;
	}
}