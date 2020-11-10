

public class Calculator{
	public static void main (String[] args){
		String Operator = "",
		       ersteZahl = "",
			   zweiteZahl = "";
			   
        int    zahl1 = 0,
		       zahl2 = 0,
		       zahl3 = 0;
			   
		boolean withSpaces = false;
			   			   
        if (args[0].contains("+")||args[0].contains("-")){
			withSpaces = false;
			}
		else{
			withSpaces = true;
			}
		
		if (withSpaces){			
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
		}
		else{
			String[] index ; //Nice
			String stOp = args[0];
			char[] Op = stOp.toCharArray();
			
			if (stOp.contains("+")){
                System.out.println("Addition wird ausgefüht...");
			    index = stOp.split("\\+");
				
				ersteZahl = index[0];
				zweiteZahl = index[1];
				
				zahl1 = Integer.parseInt(ersteZahl);
		        zahl2 = Integer.parseInt(zweiteZahl);
				zahl3 = zahl1 + zahl2;
			}
			else if (stOp.contains("-")){
				System.out.println("Substraktion wird ausgefüht...");
			    index = stOp.split("-");
				
				ersteZahl = index[0];
				zweiteZahl = index[1];
				
				zahl1 = Integer.parseInt(ersteZahl);
		        zahl2 = Integer.parseInt(zweiteZahl);
				zahl3 = zahl1 - zahl2;
			}
		}
		
		
		System.out.println("Das Ergebnis ist: "+ zahl3 );
	}
}