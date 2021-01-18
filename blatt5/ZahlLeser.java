import java.util.*;

/** Klasse aus Aufgabe 12
*/
public class ZahlLeser {
	
	public static void main (String[] args) {
		
		try {
			
			Scanner sc = new Scanner(args[0]);
			int zahl = sc.nextInt();
			
			//Es wird jetzt geprüft ob die Zahl kleiner als 10 ist
			istKleinerAlsZehn(zahl);
			
			System.out.println("\nSie haben die Zahl " + zahl + " eingegeben");
		
		//Falls nichts eingegeben wurde
		} catch (ArrayIndexOutOfBoundsException abe) {
			
			int zahl = 69;
			System.out.println("\n§§§ Sie haben vergessen eine Zahl einzugeben. " 
								+ "Es wird die NICE Defautl-Zahl " + zahl + " initialisiert §§§");
								
		//Falls ein String oder ander Zeichen eingegeben wurde
		} catch (InputMismatchException i) {
			
			int zahl = 420;
			System.out.println("\n$$$ Das von Ihnen eingegeben Zeichen ist keine Zahl. Nur Zahlen sind erlaubt!. " 
								+ "Es wird die FANTASTIC Defautl-Zahl " + zahl + " initialisiert $$$");
								
		//Falls eingegeben Zahl groesser als 10 ist						
		} catch (ArithmeticException ae) {
			
			int zahl = 10;
			System.out.println("\n" + ae.getMessage() + "*** Es wird die Defautl-Zahl " + zahl + " initialisiert ***");
		}
	}

/** Methode zum Prüfen ob die Zahl größer als 10 ist. 
  * throws eine Exception, falls dies der Fall ist.
  * @param zahl ist zu prüfende Zahl
*/
	public static void istKleinerAlsZehn (int zahl) {
		if (zahl <= 10) return ;	
		throw new ArithmeticException("### Zahl ist groesser als 10 ###\n");
	} 
}