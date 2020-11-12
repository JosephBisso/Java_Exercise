public class RateSpiel{	
	public static void main(String[] args){		
		
		int vZahl = 0,
		    arg = args.length,
			aVersuch = -6969; //Nice
		
		if (arg!=0){
			vZahl = Integer.parseInt(args[0]);
		}
		
		aVersuch = computerRaten(vZahl);
		
		if (aVersuch == 1){
			System.out.println("\nEs wurde ein einziger (1) Versuch benoetigt, um die Zahl zu raten. Du könntest heute auch im Lotto gewinnen!!");	
		}
		else {
			System.out.println("\nEs wurden "+ aVersuch + " Versuche benoetigt, um die Zahl zu raten");	
		}	
	}

	
    static int computerRaten(int vZahl){
		
	    double dZahl = 100 * Math.random();
	    int zZahl = (int) dZahl,
    	    c = 0,
	    	uGrenze = 0,
		    oGrenze = 100;
			
			if (vZahl == zZahl){
				return 1;
			}
			else{	
		        while (vZahl != zZahl){
			        c++;
			  
			    double dZahl2 = 100 * Math.random();
	            zZahl = (int) dZahl2;			
		        }
			}
			
		return c;
	}
}
