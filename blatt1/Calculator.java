import java.util.regex.Pattern;

public class Calculator{
	public static void main (String[] args){
		String Operator = "", //Nice
		       ersteZahl = "",
			   zweiteZahl = "";
			   
        int    zahl1 = 0,
		       zahl2 = 0,
		       zahl3 = 0;
			   
			   
		ersteZahl = args[0];
		Operator = args[1];
		zweiteZahl = args[2];
		
		zahl1 = Integer.parseInt(ersteZahl);
		zahl2 = Integer.parseInt(zweiteZahl);
		
        if (Operator.contains("+")){
			System.out.println("Addition wird ausgefüht...");
			zahl3 = zahl1 + zahl2;
			}
		else if (Operator.contains("-")) { 
			System.out.println("Subtraktion wird ausgefüht...");
			zahl3 = zahl1 - zahl2;
			}
		
		
		System.out.println("Das Ergebnis ist: "+ zahl3 );
	}
}