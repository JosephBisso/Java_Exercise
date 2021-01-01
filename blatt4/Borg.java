import java.util.Scanner;

public class Borg {
	public static void main(String[] args) {
		
		int intArgs = -69;
		
		if (!(args.length > 0)) {
			System.out.println("Geben Sie eine Zahl ein: ");
			Scanner sc = new Scanner(System.in);
			intArgs = sc.nextInt();
		} else {
			intArgs = Integer.parseInt(args[0]);
		}
		
		Borg borgSchiff = new Borg(intArgs);
		borgSchiff.printShip();
		borgSchiff.versorgungsleitung();
		borgSchiff.printShip();
		
	}
	
	private int groesseRahmen;
	private int[][] arrayRaumschiff;
	private int anzVerbindungselement = 1;
	String saemtlicheBewegungen = "";
	
	
	public Borg(int groesseRahmen) {
		this.groesseRahmen = groesseRahmen;
		
		int sizeRahmen = groesseRahmen + 2;
		arrayRaumschiff = new int[sizeRahmen][sizeRahmen];
		
		for (int i = 0; i < sizeRahmen; i++) {
			for (int j = 0; j < sizeRahmen; j++) {
				if (i > 0 && i < sizeRahmen - 1) {
					if (j > 0 && j < sizeRahmen - 1) {
						arrayRaumschiff[i][j] = (int) ' ';
					} else {
						arrayRaumschiff[i][0] = (int) '|';
						arrayRaumschiff[i][sizeRahmen-1] = (int) '|';
					} 
				} else {
					arrayRaumschiff[0][j] = (int) '-';
					arrayRaumschiff[sizeRahmen-1][j] = (int) '-';
				}
			}
		}
	}
	
	public void printShip() {
		int size = arrayRaumschiff.length;
		String[] ship = new String[size];
		
		for (int i = 0; i < size; i++) {
			ship[i] = "";
			for (int j = 0; j < size; j++) {
			ship[i] += ((char) arrayRaumschiff[i][j]) + " "; 
			}
			System.out.println(ship[i]);
		}
	}
	
	public void versorgungsleitung() {
		versorgungsleitung(1, 1, "");
	}
	
	private void versorgungsleitung(int x, int y, String aktuelleRichtung) {
		char richtung = zufaelligeRichtung(aktuelleRichtung);
		int xP = x,
		yP = y;
		System.out.println("Start");
		
		if (x == 1 && y ==1 && saemtlicheBewegungen != "") {
			System.out.println("Die Borg ist bereit für den kampf");
			return;
		}
		if (saemtlicheBewegungen == "") {
			arrayRaumschiff[1][1] = (int) '-';
			richtung =  zufaelligeRichtung();
		}
		if ( richtung == 'k') {
			
			if (((--anzVerbindungselement) < 0) || anzVerbindungselement >= saemtlicheBewegungen.length()) {
				System.out.println("Die Borg ist bereit für den kampf");
				return;
			}
			char letzteBewegung = saemtlicheBewegungen.charAt(anzVerbindungselement);
			
			while (letzteBewegung == 'o') {
				xP ++;
			}
			while (letzteBewegung == 'u') {
				xP --;
			}
			while (letzteBewegung == 'l') {
				yP ++;
			}
			while (letzteBewegung == 'r') {
				yP --;
			}
			
			versorgungsleitung(xP, yP, "");
			
		} else {
			richtung = zufaelligeRichtung();
			System.out.println("richtung = " + richtung);
		}
	
		boolean bereitsbenutzt = false,
		leitungPlaziert = false;

		int leitung = -69;
		
		if (richtung != 'k') {
			for (int i = 0; i < aktuelleRichtung.length(); i++) {
				if (aktuelleRichtung.charAt(i) == richtung) {
					bereitsbenutzt = true;
					System.out.println(1);
				}
			}
			if (!bereitsbenutzt) {
				aktuelleRichtung += richtung;
				System.out.println(2);
			}
			System.out.println("aktuelleRichtung =" + aktuelleRichtung);
			switch (richtung) {
				case 'o' : {
					leitung = (int) '|';
						if (fieldValid(xP - 1, yP) && fieldValid(xP - 2, yP)) {
							arrayRaumschiff[--xP][yP] = leitung;
							
							if (anzVerbindungselement % 7 == 0) {
								arrayRaumschiff[xP][yP] = 'o';
							}
							
							arrayRaumschiff[--xP][yP] = leitung;
							leitungPlaziert = true;
							anzVerbindungselement ++;
							saemtlicheBewegungen += 'o';
							aktuelleRichtung = "";
						} else {
							richtung = zufaelligeRichtung(aktuelleRichtung);
							leitungPlaziert = false;
						}
					break;
				}
				case 'u' : {
					leitung = (int) '|';
						if (fieldValid(xP + 1, yP) && fieldValid(xP + 2, yP)) {
							arrayRaumschiff[++xP][yP] = leitung;
							
							if (anzVerbindungselement % 7 == 0) {
								arrayRaumschiff[xP][yP] = 'o';
							}
							
							arrayRaumschiff[++xP][yP] = leitung;
							leitungPlaziert = true;
							anzVerbindungselement ++;
							saemtlicheBewegungen += 'u';
							aktuelleRichtung = "";
						} else {
							richtung = zufaelligeRichtung(aktuelleRichtung);
							leitungPlaziert = false;
						}
					break;
				}
				case 'l' : {
					leitung = (int) '-';
						if (fieldValid(xP, yP - 1) && fieldValid(xP, yP - 2)) {
							arrayRaumschiff[xP][--yP] = leitung;
							
							if (anzVerbindungselement % 7 == 0) {
								arrayRaumschiff[xP][yP] = 'o';
							}
							
							arrayRaumschiff[xP][--yP] = leitung;
							leitungPlaziert = true;
							anzVerbindungselement++;
							saemtlicheBewegungen += 'l';
							aktuelleRichtung = "";
						} else {
							richtung = zufaelligeRichtung(aktuelleRichtung);
							leitungPlaziert = false;
						}
					break;
				}
				case 'r' : {
					leitung = (int) '-';
						if (fieldValid(xP, yP + 1) && fieldValid(xP, yP + 2)) {
							arrayRaumschiff[xP][++yP] = leitung;
							
							if (anzVerbindungselement % 7 == 0) {
								arrayRaumschiff[xP][yP] = 'o';
							}
							
							arrayRaumschiff[xP][++yP] = leitung;
							leitungPlaziert = true;
							anzVerbindungselement++;
							saemtlicheBewegungen += 'r';
							aktuelleRichtung = "";
						} else {
							richtung = zufaelligeRichtung(aktuelleRichtung);
							leitungPlaziert = false;
						}
					break;
				}
			}
			
			System.out.println(3);
			System.out.println("aktuelleRichtung =" + aktuelleRichtung);
			System.out.println("saemtlicheBewegungen =" + saemtlicheBewegungen);
			System.out.println("richtung = " + richtung);
			versorgungsleitung(xP, yP, aktuelleRichtung);
		}
	}
	
	private boolean fieldValid(int x, int y) {
		if (arrayRaumschiff[x][y] == (int) ' ') {
			return true;
		}
		return false;
	}
	
	private char zufaelligeRichtung() {
		int zufallZahl = (int) (Math.random() * 100) + 1 ;
		
		if (zufallZahl < 25) {
			return 'o';
		} else if (zufallZahl >= 25 && zufallZahl <50) {
			return 'u';
		} else if (zufallZahl >= 50 && zufallZahl < 75) {
			return 'l';
		} else {
			return 'r';
		}
	}
	
	private char zufaelligeRichtung(String stringBlockierteRichtungen) {
		
		if (stringBlockierteRichtungen.length() == 0) {
			return zufaelligeRichtung();
		}
		if (stringBlockierteRichtungen.length() == 4) {
			return 'k';
		}
		String richtungen = "oulr";
		int anzBlockierteRichtungen = stringBlockierteRichtungen.length();
		
		for(int j = 0; j < anzBlockierteRichtungen; j++) {
			for (char richtung : richtungen.toCharArray()) {
				if (richtung == stringBlockierteRichtungen.charAt(j)) {
					richtungen = richtungen.replace(richtung, '+');
				} 
			}
		}
		char[] freieRichtungen = new char[4 - anzBlockierteRichtungen];
		int index = 0;
		for (char richtung : richtungen.toCharArray()) {
			if (Character.isLetter(richtung)) {
				System.out.println(4);
				System.out.println("richtung = " + richtung);
				freieRichtungen[index++] = richtung;
			}
		}
		
		int zufallZahl = (int) (Math.random() * 100) + 1 ;
		
		switch (anzBlockierteRichtungen) {
			case 1 : {
				if (zufallZahl < 33) {
					return freieRichtungen[0];
				} else if (zufallZahl >= 33 && zufallZahl <66) {
					return freieRichtungen[1];
				} else {
					return freieRichtungen[2];
				}
			}
			case 2 : {
				if (zufallZahl < 50) {
					return freieRichtungen[0];
				} else {
					return freieRichtungen[1];
				}
			}
			case 3 : {
				return freieRichtungen[0];
			}
		}
		return 'k';
	}

}