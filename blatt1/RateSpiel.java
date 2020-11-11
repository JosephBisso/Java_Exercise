import java.util.Scanner;

public class RateSpiel{	
	public static void main(String[] args){		
		
		int vZahl = 0,
		    arg = args.length,
			aVersuch = -6969; //Nice
		
		if (arg==0){
			System.out.println(" Sie haben vergessen ein Zahl zu geben!\nGeben Sie jetzt bitte eine Zahl ein: ");
			
			Scanner sc = new Scanner(System.in);
			vZahl = sc.nextInt();
		}
		else{
			vZahl = Integer.parseInt(args[0]);
		}
		
		aVersuch = computerRaten(vZahl);
		
		System.out.println("\nEs wurden "+ aVersuch + " Versuche benötigt, um die Zahl zu raten");	
			
	}

	
    static int computerRaten(int vZahl){
		
	    double dZahl = 100 * Math.random();
	    int zZahl = (int) dZahl,
    	    c = 0,
	    	uGrenze = 0,
		    oGrenze = 100;
			
		    while (vZahl != zZahl){
			    c++;
			
			    if (vZahl<zZahl){
				    oGrenze = zZahl;
				    zZahl = (zZahl + uGrenze) / 2;
			    }  
			    if (vZahl>zZahl){
				    uGrenze = zZahl;
				    zZahl = (zZahl + oGrenze) / 2;
			    }
		    }
			
		return c;
	}
}
