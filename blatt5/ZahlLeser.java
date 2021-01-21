import java.util.*;

/** Klasse aus Aufgabe 12
*/
public class ZahlLeser {
	
	public static void main (String[] args) {
		
		int zahl = 0;
		try {
			
			Scanner sc = new Scanner(args[0]);
			zahl = sc.nextInt();
			
			istKleinerAlsZehn(zahl);
			
			System.out.println("\nSie haben die Zahl " + zahl + " eingegeben");
		
		} catch (ArrayIndexOutOfBoundsException abe) {
			
			zahl = 3;
			System.out.println("\n§§§ Sie haben vergessen eine Zahl einzugeben. " 
								+ "Es wird die NICE Defautl-Zahl " + zahl + " initialisiert §§§");
								
		} catch (InputMismatchException i) {
			
			zahl = 4;
			System.out.println("\n$$$ Das von Ihnen eingegeben Zeichen ist keine Zahl. Nur Zahlen sind erlaubt!. " 
								+ "Es wird die FANTASTIC Defautl-Zahl " + zahl + " initialisiert $$$");
													
		} catch (IllegalArgumentException ie) {
			
			zahl = 10;
			System.out.println("\n" + ie.getMessage() + "*** Es wird die Defautl-Zahl " + zahl + " initialisiert ***");
		}
		
		try {
			int ergebnis = twentyBy(zahl);
			System.out.println("\n20 dividiert durch " + zahl + " gleich " + ergebnis);
		} catch (ArithmeticException e) {
			System.out.println("\nßßß Keine Division durch Null möglich ßßß");
		}
	}

/** Methode zum Prüfen ob die Zahl größer als 10 ist. 
  * throws eine Exception, falls dies der Fall ist.
  * @param zahl ist zu prüfende Zahl
*/
	public static void istKleinerAlsZehn (int zahl) {
		if (zahl <= 10) return ;	
		throw new IllegalArgumentException("### Zahl ist groesser als 10 ###\n");
	} 
	
/** Methode aus Aufgabe 13. Es wird die Zahl durch 20 dividiert 
  * @param zahl ist zu dividierende Zahl
*/
	public static int twentyBy (int zahl) {
		return 20 / zahl;
	} 

}