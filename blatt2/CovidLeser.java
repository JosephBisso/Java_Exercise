import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
   
public class CovidLeser{
	public static void main(String[] args){
		
		int nZeile = 8953,
			nSpalte = 11;
		String[][] sCovid = new String [nZeile][nSpalte];
		
		File file = new File("RKI_COVID19.csv");
		Scanner fileReader = null;
		try{
			fileReader = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (int i=0; i<nZeile;i++){
			
			if (fileReader.hasNextLine()){
				
				String[] sNextLine = fileReader.nextLine().split(",");
				
				for(int j=0; j<nSpalte;j++){
					
					sCovid[i][j] = sNextLine[j];
				}
			}
		}
		
		int gesWerte = 0;
		
		for(int j=0; j<nSpalte; j++){
			
			if(sCovid[0][j].contains("AnzahlGenesen")){
				
				for(int i=1; i<nZeile;i++){
					
					gesWerte += Integer.parseInt(sCovid[i][j]);
				} 
			} 
		}
		
		
		String aussage = "Die Anzahl der genesenen Personen in Niedersachsen mit Meldedatum im November beträgt: ";
		System.out.println(aussage + gesWerte);
	}
}