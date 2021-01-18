import java.util.Scanner;

public class ZahlLeser {
	
	public static void main (String[] args) {
		
		try {
			
			Scanner sc = new Scanner(args[0]);
			int zahl = sc.nextInt();
			
			System.out.println("\nSie haben die Zahl " + zahl + " eingegeben");
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
	}
}