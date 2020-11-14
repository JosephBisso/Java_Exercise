import java.util.Scanner;

public class RateSpiel{
	public static void main(String[] args){
		int arg = args.length,
		    gZahl = 0;			
		
		if (arg == 0){
		 	System.out.println("\nEs wird jetzt eine Zufallszahl generiert. Versuchen Sie diese Zahl zu raten!\nGeben dafür eine Zahl ein:");
			int zRZahl = (int) (100 * Math.random());
			
			do{
			    Scanner sc = new Scanner (System.in);
			    gZahl = sc.nextInt();
			
	    		int error = selberRaten(gZahl, zRZahl);
			
				if (error==1){
					System.out.println("\nPech gehabt!\nDie zu ratende Zahl ist größer als die von Ihnen eingegebene Zahl. \nGeben Sie eine groessere Zahl ein:");
				}
				else if (error==2){
					System.out.println("\nPech gehabt!\nDie zu ratende Zahl ist kleiner als die von Ihnen eingegebene Zahl. \nGeben Sie eine kleinere Zahl ein:");
				}
				else if (error==0){
					break;
				}

			}
			
			while(gZahl != zRZahl);
			if (gZahl == zRZahl){
				System.out.println("\nBravo!! Sie haben die Zahl richtig erraten. Sie bekommen innerhalb von 2 Woche eine Belohnung von 1 Cent auf Ihren Konto überwiesen.");
			}
			
			
			
		}
		
		
		
        
	}
	
	static int selberRaten (int gZahl, int zRZahl){		
		if (gZahl < zRZahl){
			return 1;
		}
		if (gZahl > zRZahl){
			return 2;
		}	
		else {
			return 0;
		} 
	}
}