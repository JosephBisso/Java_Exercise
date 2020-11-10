import java.util.Scanner;

public class Calculator{
	public static void main (String[] args){
		double zahl1 = 0,
		       zahl2 = 0,
			   zahl3 = 0;
			   
		System.out.println("Geben Sie 2 Zahlen ein:\n");
		System.out.println("Erste Zahl:  ");
		Scanner scz1 = new Scanner(System.in);
		zahl1 = scz1.nextInt();
		System.out.println("\nZweite Zahl:  ");
		Scanner scz2 = new Scanner(System.in);
		zahl2 = scz2.nextInt();
		
        System.out.println("\nWelche Rechenoperation soll ausgeführt werden?\n Addition (+): 1 , Subtraktion (-): 2 ;");
		Scanner sc = new Scanner(System.in);
		int Operator = sc.nextInt();

        if (Operator == 1){
			System.out.println("Addition wird ausgefüht");
			zahl3 = zahl1 + zahl2;
			}
		else if (Operator ==2) { 
			System.out.println("Subtraktion wird ausgefüht");
			zahl3 = zahl1 - zahl2;
			}
		
		
		System.out.println("Das Ergebnis ist: "+ zahl3 );
	}
}