import java.util.Scanner;

public class Bonus_RateSpiel{
	public static void main(String[] args){
		int arg = args.length,
		    gZahl = 0,
			counter = 0,
		    zRZahl = selberRaten();
		String pech = "\nPech gehabt!\nDie zu ratende Zahl ist xxx als die von Ihnen eingegebene Zahl. \nGeben Sie eine yyy Zahl ein:";
		
		int vZahl = 0,
			aVersuch = -6969; //NiceNice
		
		if (arg!=0){
			vZahl = Integer.parseInt(args[0]);
			aVersuch = computerRaten(vZahl);
		
		    if (aVersuch == 1){
			    System.out.println("\nEs wurde ein einziger (1) Versuch benoetigt, um die Zahl zu raten. Du könntest heute auch im Lotto gewinnen!!");	
		    }
		    else {
			    System.out.println("\nEs wurden "+ aVersuch + " Versuche benoetigt, um die Zahl zu raten");	
		    }
		}	
			
		if (arg == 0){				
		 	System.out.println("\nEs wird jetzt eine Zufallszahl generiert. Versuchen Sie diese Zahl zu raten!\nGeben dafür eine Zahl ein:");
			
			Scanner sc = new Scanner (System.in);
			gZahl = sc.nextInt();
			int[] kGZahl= {0,0,0,0,0,0,0,0,0,0} ;
			kGZahl[0] = gZahl;
			
			while(gZahl!= zRZahl){
				counter++;
				if (counter ==5){
					int max = kGZahl[0],
					    min = kGZahl[0];
					for(int kgZahl : kGZahl){
						if(kgZahl > max){max = kgZahl;}
						if(kgZahl < min){min = kgZahl;}
					}	
					
					int uZRZahl = (int)(zRZahl-6); 
					if (uZRZahl<0){uZRZahl=0;}
					if (uZRZahl < min & min < zRZahl){uZRZahl = min;}
					if (uZRZahl<50 & zRZahl >50){uZRZahl=50;}
					
					int oZRZahl = (int)(zRZahl+9);
					if (oZRZahl>100){oZRZahl=100;}
					if (oZRZahl > max & max > zRZahl) {oZRZahl = max;}
					if (oZRZahl>50 & zRZahl <50){oZRZahl=50;}
					
					System.out.println("\n\n!!!WICHTIGER HINWEIS: DIE ZAHL LIEGT ZWISCHEN " + uZRZahl + " UND " + oZRZahl+ "!!!\n");
				}
				if (counter == 7){
					System.out.println("\nSie haben 10 Fehlversuche nacheinander unternommen. Wollen Sie weiter versuchen?\n ja oder nein");
					Scanner scjn = new Scanner(System.in);
					String jn = scjn.next();
					if (jn.matches("ja")){
						
						counter = 0;
						System.out.println("Geben Sie eine Zahl ein");
						
						Scanner sc3 = new Scanner (System.in);
			            gZahl = sc3.nextInt();
						continue;
				    }
					else{
						System.out.println("\nDie zu ratende Zahl war "+ zRZahl);
						break;
					}	
				}
				
                if (gZahl >= zRZahl-2 && gZahl <= zRZahl+2 ){
					pech = pech + "(Sie sind ganz nah dran)";
				}   
				
				if (gZahl < zRZahl){
					System.out.println(pech.replace("xxx", "groesser").replace("yyy", "groessere"));
					
					if (gZahl <50 & zRZahl>50){
						System.out.println("(Hinweis: x € [50;100])\n");
					}
					if (gZahl >50 & zRZahl<50){
						System.out.println("(Hinweis: x € [0;50])\n");
					}
					if (gZahl<50 & zRZahl <50){
						System.out.println("(Sie liegen Richtig: x € [0;50])\n");
					}
					if (gZahl>50 & zRZahl>50){
						System.out.println("(Sie liegen Richtig: x € [50;100])\n");
					}
				}
				else{
					System.out.println(pech.replace("xxx", "kleiner").replace("yyy", "kleinere"));
					
					if (gZahl <50 & zRZahl>50){
						System.out.println("(Hinweis: x € [50;100])\n");
					}
					if (gZahl >50 & zRZahl<50){
						System.out.println("(Hinweis: x € [0;50])\n");
					}
					if (gZahl<50 & zRZahl <50){
						System.out.println("(Sie liegen Richtig: x € [0;50])\n");
					}
					if (gZahl>50 & zRZahl>50){
						System.out.println("(Sie liegen Richtig: x € [50;100])\n");
					}
				}

				Scanner sc2 = new Scanner (System.in);
			    gZahl = sc2.nextInt();
				kGZahl[counter] = gZahl;
				pech = "\nPech gehabt!\nDie zu ratende Zahl ist xxx als die von Ihnen eingegebene Zahl. \nGeben Sie eine yyy Zahl ein:";

			}
			
			if (gZahl == zRZahl){
				System.out.println("\nBravo!! Sie haben die Zahl richtig erraten ;). Sie bekommen innerhalb von 2 Wochen eine Belohnung von 1 Cent auf Ihren Konto überwiesen.");
			}
			
		}
	}		
	
	static int selberRaten (){
		double zahl = 100 * Math.random();
		int zZahl = (int)zahl;
		
		return zZahl; 
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
			  
			    	if (vZahl < zZahl){
						oGrenze = zZahl;
						zZahl = (uGrenze + zZahl)/2; 
					}
					if (vZahl > zZahl){
						uGrenze = zZahl;
						zZahl = (oGrenze + zZahl)/2;
					}
		        }
			}
			
		return c;
	}
}
