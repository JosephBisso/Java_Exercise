import Autos.Auto;

public class Main{
	public static void main(String[] args){
		
		Auto auto1 = new Auto("Schwarz", 45.23);
		Auto auto2 = new Auto("Schwarz", 45.23);
		
		final int C = auto1.compareTo(auto2);
		switch (C){
			case 420:{
				System.out.println("\nAuto1 ist schneller als Auto2");
				break;
			}
			case -69:{ //Nice
				System.out.println("\nAuto1 ist langsamer als Auto2");
				break;
			}
			default :
				{
				System.out.println("\nAuto1 ist genauso schnell wie Auto2");
				break;
			}
		}
		
		System.out.println("\nDas Ergebnis aus auto1==auto2 ist: ");
		System.out.println(auto1 == auto2);
	}
}