import java.lang.Math;

public class Loewe extends Tier{
	
	public Loewe(String name, double hunger, double durst, int groesse){
		super(name, hunger, durst, groesse);
	}
	
	public Loewe(String name, double hunger, double durst){
		super(name, hunger, durst);	
	}
	
	private String berechneRuf(){
		
		int random = (int)(100*Math.random());
		
		if (random%6==0 || random%9==0) return "...";
		
		return "Grooooooooaaaaaar";
	}
	
	public String toString(){
		return berechneRuf();
	}
}