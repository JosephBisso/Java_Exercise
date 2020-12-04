import java.lang.Math;

public class Simulation{
	public static void main(String[] args){
		
		int randomgehegeAnzahl = (int)((5*Math.random())+8);
		Zoo zoo69 = new Zoo(1000, 5000, randomgehegeAnzahl);
		
		Loewe[] loewen = new Loewe[6];
		Elefant[] elefanten = new Elefant[6];
		Tier[] tiere = new Tier[12];
		
		String namen[] = {"El Phenomeno", "De Pedro", "De Castro", "De Ceno", "Jean", "Pierre", "Star", "Brad Pit", "All Might", "Deku", "6ix9ine", "Area51"}; 
		
a:		for(int i=0; i<6; i++){
			
			double randomHunger = 10*Math.random()+1;
			double randomDurst = 50*Math.random()+1;
			int randomGroesse = (int)(20*Math.random())%4;
			
			if (i==5){
				loewen[i] = new Loewe(namen[i], randomHunger, randomGroesse);
				elefanten[i] = new Elefant(namen[6+i], randomHunger, randomGroesse);
				break a;
			}
			
			loewen[i] = new Loewe(namen[i], randomHunger, randomDurst, randomGroesse);
			elefanten[i] = new Elefant(namen[6+i], randomHunger, randomDurst, randomGroesse);
		}
		
		int counter = 0;
		int iCounter = 0;
		while (counter<11 & iCounter<6){
			tiere[counter++] = loewen[iCounter];
			tiere[counter++] = elefanten[iCounter++];
			
		}
		for(int i=0; i<12; i++){
			zoo69.neuesTier(tiere[i]);
		}
		
		
		
	}
}