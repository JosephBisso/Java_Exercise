import Autos.Auto;

public class Main{
	public static void main(String[] args){
		
		Auto auto1 = new Auto("Schwarz", 45.23);
		Auto auto2 = new Auto("Rot", 36.97);
		
		final int C = auto1.compareTo(auto2);
		switch (C){
			case 420:{
				System.out.println("Auto1 ist schneller als Auto2");
				break;
			}
			case -69:{
				System.out.println("Auto1 ist langsamer als Auto2");
				break;
			}
			default :
				{
				System.out.println("Auto1 ist genauso schnell wie Auto2");
				break;
			}
		}
	}
}