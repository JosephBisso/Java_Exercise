import java.lang.Math;
import java.util.Date;

public class Simulation{
	public static void main(String[] args){
		
		int randomgehegeAnzahl = (int)((5*Math.random())+9);
		Zoo zoo = new Zoo(1000, 5000, randomgehegeAnzahl);
		
		Loewe[] loewen = new Loewe[6];
		Elefant[] elefanten = new Elefant[6];
		
		String namen[] = {"El Phenomeno", "De Pedro", "De Castro", "De Ceno", "Jean", "Pierre", "Star", "Brad Pit", "All Might", "Deku", "6ix9ine", "Area51"}; 
		System.out.println("\n");
		
		for(int i=0; i<6; i++){
			
			double randomHunger = 10*Math.random()+1;
			double randomDurst = 50*Math.random()+1;
			int randomGroesse = (int)(20*Math.random())%4+1;
			
			if (i==5){
				loewen[i] = new Loewe(namen[i], randomHunger, randomGroesse);
				elefanten[i] = new Elefant(namen[6+i], randomHunger, randomGroesse);
			}
			else{
				loewen[i] = new Loewe(namen[i], randomHunger, randomDurst, randomGroesse);
				elefanten[i] = new Elefant(namen[6+i], randomHunger, randomDurst, randomGroesse);
			}
			zoo.neuesTier(loewen[i]);
			zoo.neuesTier(elefanten[i]);		
		}
		
		int zeit = 0;
		Tier[] gehege = zoo.getGehege();
		boolean[] verflegung = new boolean[2];
		
		System.out.println("\nDie Simulation wird für "+gehege.length+" Gehege im Zoo durchgeführt...");
a:		while(true){
b:			for(Tier tier: gehege){
				if(tier == null) continue b;
				verflegung[0]= zoo.fuetter(tier);
				verflegung[1]= zoo.traenken(tier);
			
				if (verflegung[0] & verflegung[1]){
					zeit++;
					continue b;
				}
				else if(!verflegung[0] & !verflegung[1]){
					System.out.println("Die Simulation wurde gestoppt. Nach " +zeit+ " Tagen soll eine neue Verflegung wegen Futter- und Wassermangel organisiert werden.");
					break a;
				}
				else if(!verflegung[0]){
					System.out.println("Die Simulation wurde gestoppt. Nach " +zeit+ " Tagen soll eine neue Verflegung wegen Futtermangel organisiert werden.");
					break a;
				}
				else if(!verflegung[1]){
					System.out.println("Die Simulation wurde gestoppt. Nach " +zeit+ " Tagen soll eine neue Verflegung wegen Wassermangel organisiert werden.");
					break a;
				}
			}
		}
		System.out.println("Ender der Simulation.");
		
		
		
	}
}