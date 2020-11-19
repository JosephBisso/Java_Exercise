import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Textanalyse{
	public static void main(String[] args){
		
		int aZeichen = 189; // Alle in einem Text eingebbare Zeichen des extended ASCII charts (sämtlichen GrossBuchstaben) ausgeschlossen. Source:https://www.commfront.com/pages/ascii-chart
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
		
			char[] zeichenKette = fileReader.nextLine().toLowerCase().toCharArray();
			
a:			for (char Zeichen : zeichenKette){	

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
		
		
	    int[] auflistung = new int [10];
	
		System.out.println("\nDie originale ersten 10 Einträge sind: " );
        for(int i=0; i<10; i++){
			auflistung[i] = hTabelle[i][1];
			System.out.println((char)hTabelle[i][0] + " : " +auflistung[i]);

		}
		
	    hTabelle = sortArray(hTabelle, counterIndex);

		System.out.println("\nDie 10 Häaufigkeit sind: " );
        for(int i=0; i<10; i++){
			auflistung[i] = hTabelle[counterIndex-i-1][1];
			System.out.println((char)hTabelle[counterIndex-i-1][0] + " : " +auflistung[i]);

		}
		
		System.out.println("\nDie ersten 10 Einträge sind: " );
        for(int i=0; i<10; i++){
			auflistung[i] = hTabelle[i][1];
			System.out.println((char)hTabelle[i][0] + " : " +auflistung[i]);

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
	
	private static int[][] sortArray(int[][] hTabelle, int aEintraege){
		
		int[][] Tabelle = hTabelle;
		int[] zwischenWert = new int [2],
		      maxWerte = new int [3];
		int max = -420,
		    m = -1;
			
		for(int i =0; i<aEintraege;i++){
			
			if(Tabelle[i][1]>=max){
				
				max = Tabelle[i][1];
				
				for(int j=0;j<2;j++){
					maxWerte[j]= Tabelle[i][j];
					m = i;
					maxWerte[2] = m;
				}
			}
			
			if (i==aEintraege-1){
				
				for(int j=0;j<2;j++){
					
					zwischenWert[j]= Tabelle[i][j];
				    Tabelle[i][j] = maxWerte[j];
					Tabelle[m][j] = zwischenWert[j];
				}
			}
		}	
		
		int k =0;
		
		
		return Tabelle;
		
	}	
}