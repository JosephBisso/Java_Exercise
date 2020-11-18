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
		
		System.out.println("\nCounter Indey beträgt "+ counterIndex +", und indexZeichen "+ indexZeichen+"\nhTabelle.length beträgt"+ hTabelle.length);
		
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
	
}