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
	private int schritte = 1;
	String saemtlicheBewegungen = "";
	
	
	public Borg(int groesseRahmen) {
		this.groesseRahmen = groesseRahmen;
		
		int sizeRahmen = groesseRahmen;
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
		
		if (x == 1 & y ==1 & saemtlicheBewegungen != "") {
			System.out.println("\n***Die Borg ist bereit für den kampf :***");
			System.out.println("***Die finale Reihefolge der Bewegungen war : " + saemtlicheBewegungen);
			return;
		}
		if (saemtlicheBewegungen == "") {
			arrayRaumschiff[1][1] = (int) '-';
			richtung =  zufaelligeRichtung();
		}
		if ( richtung == 'k') {
			if (anzVerbindungselement > saemtlicheBewegungen.length()) {
				int diff = anzVerbindungselement - saemtlicheBewegungen.length();
				anzVerbindungselement -= diff;
			}
			if (anzVerbindungselement <= 0) {
				System.out.println("\n**Die Borg ist bereit für den kampf :**");
				System.out.println("**Die finale Reihefolge der Bewegungen war : " + saemtlicheBewegungen);
				return;
			}
			char letzteBewegung = saemtlicheBewegungen.charAt(--anzVerbindungselement);
			switch (letzteBewegung) {
				case 'o' : {
					xP = xP + 2;
					break;
				}
				case 'u' : {
					xP = xP - 2;
					break;
				}
				case 'l' : {
					yP = yP + 2;
					break;
				}
				case 'r' : {
					yP = yP - 2;
					break;
				}
			}	
			
			versorgungsleitung(xP, yP, "");
		}	
		
		boolean bereitsbenutzt = false;

		int leitung = -69;
		xP = x;
		yP = y;
		
		if (richtung != 'k') {
			for (int i = 0; i < aktuelleRichtung.length(); i++) {
				if (aktuelleRichtung.charAt(i) == richtung) {
					bereitsbenutzt = true;
				}
			}
			if (!bereitsbenutzt) {
				aktuelleRichtung += richtung;
			}
			switch (richtung) {
				case 'o' : {
					leitung = (int) '|';
						if (fieldValid(xP - 1, yP) & fieldValid(xP - 2, yP)) {
							arrayRaumschiff[--xP][yP] = leitung;
							
							if (schritte % 7 == 0) {
								arrayRaumschiff[xP][yP] = 'o';
							}
							
							arrayRaumschiff[--xP][yP] = leitung;
							anzVerbindungselement ++;
							schritte++;
							
							if (saemtlicheBewegungen.length() >= anzVerbindungselement) {
								System.out.println("\n*Die Reihefolge der Bewegungen war : " + saemtlicheBewegungen + 
													" . In allen Richtung geht's nicht mehr. Es wird zurückgegangen");
								saemtlicheBewegungen = saemtlicheBewegungen.substring(0, anzVerbindungselement - 1);
							}
							
							saemtlicheBewegungen += 'o';
							aktuelleRichtung = "";
						} else {
							richtung = zufaelligeRichtung(aktuelleRichtung);
						}
					break;
				}
				case 'u' : {
					leitung = (int) '|';
						if (fieldValid(xP + 1, yP) & fieldValid(xP + 2, yP)) {
							arrayRaumschiff[++xP][yP] = leitung;
							
							if (schritte % 7 == 0) {
								arrayRaumschiff[xP][yP] = 'o';
							}
							
							arrayRaumschiff[++xP][yP] = leitung;
							anzVerbindungselement ++;
							schritte++;
							
							if (saemtlicheBewegungen.length() >= anzVerbindungselement) {
								System.out.println("\n*Die Reihefolge der Bewegungen war : " + saemtlicheBewegungen + 
													" . In allen Richtung geht's nicht mehr. Es wird zurückgegangen");
								saemtlicheBewegungen = saemtlicheBewegungen.substring(0, anzVerbindungselement - 1);
							}
							
							saemtlicheBewegungen += 'u';
							aktuelleRichtung = "";
						} else {
							richtung = zufaelligeRichtung(aktuelleRichtung);
						}
					break;
				}
				case 'l' : {
					leitung = (int) '-';
						if (fieldValid(xP, yP - 1) & fieldValid(xP, yP - 2)) {
							arrayRaumschiff[xP][--yP] = leitung;
							
							if (schritte % 7 == 0) {
								arrayRaumschiff[xP][yP] = 'o';
							}
							
							arrayRaumschiff[xP][--yP] = leitung;
							anzVerbindungselement++;
							schritte++;
							
							if (saemtlicheBewegungen.length() >= anzVerbindungselement) {
								System.out.println("\n*Die Reihefolge der Bewegungen war : " + saemtlicheBewegungen + 
													" . In allen Richtung geht's nicht mehr. Es wird zurückgegangen");
								saemtlicheBewegungen = saemtlicheBewegungen.substring(0, anzVerbindungselement - 1);
							}
							
							saemtlicheBewegungen += 'l';
							aktuelleRichtung = "";
						} else {
							richtung = zufaelligeRichtung(aktuelleRichtung);
						}
					break;
				}
				case 'r' : {
					leitung = (int) '-';
						if (fieldValid(xP, yP + 1) & fieldValid(xP, yP + 2)) {
							arrayRaumschiff[xP][++yP] = leitung;
							
							if (schritte % 7 == 0) {
								arrayRaumschiff[xP][yP] = 'o';
							}
							
							arrayRaumschiff[xP][++yP] = leitung;
							anzVerbindungselement++;
							schritte++;
							
							if (saemtlicheBewegungen.length() >= anzVerbindungselement) {
								System.out.println("\n*Die Reihefolge der Bewegungen war : " + saemtlicheBewegungen + 
													" . In allen Richtung geht's nicht mehr. Es wird zurückgegangen");
								saemtlicheBewegungen = saemtlicheBewegungen.substring(0, anzVerbindungselement - 1);
							}
							
							saemtlicheBewegungen += 'r';
							aktuelleRichtung = "";
						} else {
							richtung = zufaelligeRichtung(aktuelleRichtung);
						}
					break;
				}
			}
			
			versorgungsleitung(xP, yP, aktuelleRichtung);
		}
	}
	
	private boolean fieldValid(int x, int y) {
		if ((x >= this.groesseRahmen) || (y >= this.groesseRahmen)) {
			return false;
		} else if (x < 0 || y < 0) {
			return false;
		} else if (arrayRaumschiff[x][y] == (int) ' ') {
			return true;
		}
		return false;
	}
	
	private char zufaelligeRichtung() {
		int zufallZahl = (int) (Math.random() * 100) + 1 ;
		
		if (zufallZahl < 25) {
			return 'o';
		} else if (zufallZahl >= 25 & zufallZahl <50) {
			return 'u';
		} else if (zufallZahl >= 50 & zufallZahl < 75) {
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
				freieRichtungen[index++] = richtung;
			}
		}
		
		int zufallZahl = (int) (Math.random() * 100) + 1 ;
		
		switch (anzBlockierteRichtungen) {
			case 1 : {
				if (zufallZahl < 33) {
					return freieRichtungen[0];
				} else if (zufallZahl >= 33 & zufallZahl <66) {
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