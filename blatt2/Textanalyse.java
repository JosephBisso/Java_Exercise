import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Textanalyse{
	public static void main(String[] args){
		
		int aZeichen = 100; // Alle Buchstaben des Alphabet + äöüß und alle Sonderzeichen (wie @), ausser GrossBuchstaben
		int hZeichen = 2;
		
		int[][] hTabelle = new int [aZeichen][hZeichen];
		
		File file = new File ("Text.txt");
		Scanner fileReader = null;
		try{
			fileReader = new Scanner(file);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		int counterIndex = 0;
		
		while (fileReader.hasNextLine()){
		
			char[] zeichenKette = fileReader.nextLine().toLowerCase().toCharArray();
			
a:			for (char Zeichen : zeichenKette){	

				if (!symbolInArray(hTabelle, Zeichen)){
					
					hTabelle[counterIndex][0] = Zeichen;
					hTabelle[counterIndex][1] = 1;
					counterIndex++;
				}
				else{
					
					int indexZeichen = findSymbol(hTabelle, Zeichen);
					
					hTabelle[indexZeichen][1]++;
				}
			}
			
		}
		
		
		
	}
	
	private static boolean symbolInArray(int[][] hTabelle, char Zeichen){
		
		for(int i=0; i<28; i++){
			
			if(hTabelle[i][0] == (int)Zeichen){
				
				return true;
			} 
		}
		
		return false;
		
	}
	
	private static int findSymbol(int[][] hTabelle, char Zeichen){
		
		for(int i=0; i<28; i++){
			
			if(hTabelle[i][0] == (int)Zeichen){
				
				return i;
			}
		}
		
		return -6969; //NiceNice
	}
	
}