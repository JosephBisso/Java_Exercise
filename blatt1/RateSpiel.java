import java.util.Scanner;

public class RateSpiel{
	public static void main(String[] args){
		int arg = args.length,
		    gZahl = 0,
		    zRZahl = selberRaten();
		
		if (arg == 0){				
		 	System.out.println("\nEs wird jetzt eine Zufallszahl generiert. Versuchen Sie diese Zahl zu raten!\nGeben dafür eine Zahl ein:");
			
			Scanner sc = new Scanner (System.in);
			gZahl = sc.nextInt();
			
			while(gZahl!= zRZahl){
				if (gZahl < zRZahl){
					System.out.println("\nPech gehabt!\nDie zu ratende Zahl ist größer als die von Ihnen eingegebene Zahl. \nGeben Sie eine groessere Zahl ein:");
				}
				else{
					System.out.println("\nPech gehabt!\nDie zu ratende Zahl ist kleiner als die von Ihnen eingegebene Zahl. \nGeben Sie eine kleinere Zahl ein:");
				}

				Scanner sc2 = new Scanner (System.in);
			    gZahl = sc2.nextInt();

			}
			
			if (gZahl == zRZahl){
				System.out.println("\nBravo!! Sie haben die Zahl richtig erraten. Sie bekommen innerhalb von 2 Woche eine Belohnung von 1 Cent auf Ihren Konto überwiesen.");
			}
			
		}
		
		
		
        
	}
	
	static int selberRaten (){
		double zahl = 100 * Math.random();
		int zZahl = (int)zahl;
		
		return zZahl; 
	}
}