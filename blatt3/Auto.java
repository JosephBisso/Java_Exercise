package Autos;

public class Auto{
	
	private String farbe;
	public double geschwingdigkeit;
	
	public Auto(String farbe, double geschwingdigkeit){	
		this.farbe = farbe;
		this.geschwingdigkeit = geschwingdigkeit;
	}
	
	private String getFarbe(){
		return this.farbe;
	}
	
	public int compareTo(Auto auto){
		if (this.geschwingdigkeit>auto.geschwingdigkeit){return 420;}
		if (this.geschwingdigkeit<auto.geschwingdigkeit){return -69;} //nice
		return 0;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj==null) return false;
		if(obj.getClass() != getClass()) return false;
		
		Auto auto = (Auto)obj;
		if (!(this.geschwingdigkeit == auto.geschwingdigkeit & this.getFarbe().equals(auto.getFarbe())))return false;
		
		return true;
	}
}