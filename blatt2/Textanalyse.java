import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Textanalyse{
	public static void main(String[] args){
		
		int aZeichen = 189; // Alle in einem Text eingebbare Zeichen (Englisch, Deutsch, Französisch, Lateisch) des extended ASCII charts (sämtlichen GrossBuchstaben) ausgeschlossen. Source:https://www.commfront.com/pages/ascii-chart
		int hZeichen = 2;
		
		int[][] hTabelle = new int [aZeichen][hZeichen];
		
		File file = new File ("Text.txt");
		Scanner fileReader = null;
		try{
			fileReader = new Scanner(file);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		int counterIndex = 0,
		    indexZeichen = 0;
		
		while (fileReader.hasNextLine()){
		
			char[] zeichenKette = fileReader.nextLine().toCharArray();
			
a:			for (char Zeichen : zeichenKette){	

			if (Character.isAlphabetic(Zeichen)){
					
					Zeichen = Character.toLowerCase(Zeichen);
				}

				if (!symbolInArray(hTabelle, Zeichen)){
					
					hTabelle[counterIndex][0] = Zeichen;
					hTabelle[counterIndex][1] = 1;
					counterIndex++;
				}
				else{
					
					indexZeichen = findSymbol(hTabelle, Zeichen);
					
					hTabelle[indexZeichen][1]++;
				}
			}
			
		}
		
		sortArray(hTabelle);
		
		boolean alleZeichen = printArray(hTabelle);
		
		if (!alleZeichen){
			
			System.out.println("\nMehrere ZAHLEN und/oder andere (SONDER-)ZEICHEN wurden nicht während der Ausgabe berücksichtigt!! Wollen Sie sie trozdem sehen?\nja oder nein?");
		
			Scanner sc = new Scanner(System.in);
			String antwort = sc.nextLine();
		
			if (antwort.equals("ja") || antwort.equals("j") || antwort.equals("1")){
			
				printArray(hTabelle, alleZeichen);
			}
		}
	
	}

	
	private static boolean symbolInArray(int[][] hTabelle, char Zeichen){
		
		for(int i=0; i<hTabelle.length; i++){
			
			if(hTabelle[i][0] == (int)Zeichen){
				
				return true;
			} 
		}
		
		return false;
		
	}
	
	private static int findSymbol(int[][] hTabelle, char Zeichen){
		
		for(int i=0; i<hTabelle.length; i++){
			
			if(hTabelle[i][0] == (int)Zeichen){
				
				return i;
			}
		}
		
		return -6969; //NiceNice
	}
	
	private static void sortArray(int[][] hTabelle){
		
		int[] zwischenWert = new int [2];
		
		for(int i=0; i<hTabelle.length;i++){
			
			for(int j=0; j<2; j++){
				
				zwischenWert[j] = hTabelle[i][j];
			}
			
			int k = i-1;
			
			while(k>=0 && zwischenWert[1] < hTabelle[k][1]){
				
				for(int j=0; j<2; j++){
				
				    hTabelle[k+1][j] = hTabelle[k][j];	
				}			
				k--;
			}
			
			for(int j=0; j<2; j++){
				
				hTabelle[k+1][j] = zwischenWert[j];
			}	
		}
		
	}	
	
	private static boolean printArray(int[][] hTabelle){
		
		int counter = 0,
			counterOnlyLetter = 0;
		
		for(int i=0; i<hTabelle.length; i++){
			
			if(!(hTabelle[i][1]>=1)){
				
				counter++;
			}
		}
		
		System.out.println("\nDie Zeichen in Ihrem Text-Datei wurde auf Haufigkeit analysiert, und hiert folgt das Ergebnis.\n\n(Buchstaben | Haeufigkeit)");
		for(int i=(hTabelle.length-1);i>=counter;i--){
			
			if(Character.isAlphabetic(hTabelle[i][0])){
				
				counterOnlyLetter++;
				System.out.println("          "+(char)hTabelle[i][0]+" | "+hTabelle[i][1]);
			}
		}
		
		if (counterOnlyLetter!=hTabelle.length-counter){
			
			return false;
		}
		
		return true;
		
	}
	
	private static void printArray(int[][] hTabelle, boolean alle){
		
		alle = !alle;
		
		int counter = 0,
			counterNoLetterorDigit = 0;
		
		for(int i=0; i<hTabelle.length; i++){
			
			if(!(hTabelle[i][1]>=1)){
				
				counter++;
			}
		}
		
		System.out.println("\nHier folgt das Ergebnis für alle Zeichen in Ihrem Text.\n\n(Zeichen | Haeufigkeit)");
		for(int i=(hTabelle.length-1);i>=counter;i--){

			System.out.println("       "+(char)hTabelle[i][0]+" | "+hTabelle[i][1]);
		}
		
	}
}