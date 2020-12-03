package Autos;

public class Auto{
	
	private String farbe;
	public double geschwingdigkeit;
	
	public Auto(String farbe, double geschwingdigkeit){	
		this.farbe = farbe;
		this.geschwingdigkeit = geschwingdigkeit;
	}
	
	public String getFarbe(){
		return this.farbe;
	}
	
	public int compareTo(Auto auto){
		if (this.geschwingdigkeit>auto.geschwingdigkeit){return 420;}
		if (this.geschwingdigkeit<auto.geschwingdigkeit){return -69;} //nice
		return 0;
	}
}