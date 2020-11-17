import java.util.Scanner;

public class FizzBuzz{
	public static void main(String[] args){
		
		int n = -6969, //NiceNice
		    arg = args.length;
		
		if (arg==0){
			System.out.println("Sie haben vergessen eine Zahl einzugeben.\nGeben Sie jetzt eine Zahl ein:");
			
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();			
		}
		else {
		    n = Integer.parseInt(args[0]);
		}
		
		int[] aZahl = new int [n];
		String[] sZahl = new String[n];
		
		String auflistung = "";
		
		for (int i=0; i<n; i++){
			
			aZahl[i] = i+1 ;
			sZahl[i] = Integer.toString(aZahl[i]);
			
			if (aZahl[i]%3==0 & !(aZahl[i]%5==0)){
				sZahl[i] = "Fizz";
			}
			else if (!(aZahl[i]%3==0) & aZahl[i]%5==0){
				sZahl[i] = "Buzz";
			}
			else if (aZahl[i]%3==0 & aZahl[i]%5==0){
				sZahl[i] = "Fizz-Buzz";
			}
			
			if (i!=n-1){
			    auflistung += (sZahl[i] + ",");
			}
			else{
				auflistung += sZahl[i];
			}
		}
		
		System.out.println(auflistung);
		
	} 
}