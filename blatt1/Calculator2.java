

public class Calculator2{
	public static void main (String[] args){
		String Operator = "",
		       ersteZahl = "",
			   zweiteZahl = "",
			   aussageOp = "xxx wird durchgeführt...",
			   stOperation = "";
	    String[] Operatoren = {"+", "-", "*", "/"};
	    String[] Operationen ={"Addition", "Substraktion", "Multiplikation", "Division"};
			   
        double zahl1 = 0,
		       zahl2 = 0,
		       zahl3 = 0;
			   
		boolean withSpaces = true;
		
		for (int i=0; i<4; i++){
            if (args[0].contains(Operatoren[i])){
			    zahl3++;
			}
		}
		if (zahl3>=1){
			withSpaces = false;
		}
		
		zahl3 = 0;
		
		if (withSpaces){			
		    ersteZahl = args[0];
		    Operator = args[1];
		    zweiteZahl = args[2];
		
		    zahl1 = Integer.parseInt(ersteZahl);
		    zahl2 = Integer.parseInt(zweiteZahl);
			
            switch (Operator){
				case "+": {
					System.out.println(aussageOp.replace("xxx", Operationen[0]));
					stOperation = Operationen[0];
					break;
				}
				case "-": {
					System.out.println(aussageOp.replace("xxx", Operationen[1]));
					stOperation = Operationen[1];
					break;
				}
				case "*": {
					System.out.println(aussageOp.replace("xxx", Operationen[2]));
					stOperation = Operationen[2];
					break;
				}
				case "/": {
					System.out.println(aussageOp.replace("xxx", Operationen[3]));
					stOperation = Operationen[3];
					break;
				}
			}
		}	
		
		else{
			String[] index = new String[3];
			String stOp = args[0];
			char[] Op = stOp.toCharArray();
			
			for (int i=0; i<4; i++){
                if (stOp.contains(Operatoren[i])){
				    stOperation = Operationen[i];
			    }
			}
			
			switch (stOperation){
				case "Addition": {
					System.out.println(aussageOp.replace("xxx", Operationen[0]));
					
					index = stOp.split("\\"+Operatoren[0]);
					break;
				}
				case "Substraktion": {
					System.out.println(aussageOp.replace("xxx", Operationen[1]));
					
					index = stOp.split(Operatoren[1]);
					break;
				}
				case "Multiplikation": {
					System.out.println(aussageOp.replace("xxx", Operationen[2]));
					
					index = stOp.split("\\"+Operatoren[2]);
					break;
				}
				case "Division": {
					System.out.println(aussageOp.replace("xxx", Operationen[3]));
					
					index = stOp.split(Operatoren[3]);
					break;
				}
			}

			ersteZahl = index[0];
			zweiteZahl = index[1];
				
				zahl1 = Integer.parseInt(ersteZahl);
		        zahl2 = Integer.parseInt(zweiteZahl);
			
			
		}
		
		switch (stOperation){
			case "Addition":{
				zahl3 = zahl1 + zahl2;
				break;
			}
			case "Substraktion":{
				zahl3 = zahl1 - zahl2;
				break;
			}
			case "Multiplikation":{
				zahl3 = zahl1 * zahl2;
				break;
			}
			case "Division":{
				zahl3 = zahl1 / zahl2;
				break;
			}
		}
		
		System.out.println("Das Ergebnis ist: "+ zahl3 );
	}
}