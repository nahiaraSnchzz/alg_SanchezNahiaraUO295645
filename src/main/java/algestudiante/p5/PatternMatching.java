package algestudiante.p5;

public class PatternMatching {

	char[][] tableroCaracteres;
	Boolean[][] tablero;
	String texto;
	String patron;

	public PatternMatching(String text) {

		texto = text;

	}

	public Boolean checkPattern(String patron) {

		tablero = new Boolean[texto.length() +1][patron.length()+1];
		tableroCaracteres = new char[tablero.length+1][tablero[0].length+1];
		this.patron = patron;
		int falso = 0;

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {

				// caso base
				if (i == 0 && j == 0) {
					tablero[i][j] = true;
					
				} else if (i == 0 && j>0) {
					tablero[i][j] = false;
				}

				else if (j == 0 && i >0) {
					tablero[i][j] = false;
				}
				if (i > 0 && j > 0) {
					// coinciden
					if (texto.charAt(i - 1) == patron.charAt(j - 1) && tablero[i - 1][j - 1] == true) {
						tablero[i][j] = true;
					}
					// no coinciden
					else {
						tablero[i][j] = false;
					}

					// Otros casos:

					if (patron.charAt(j - 1) == '?') {
						if (tablero[i - 1][j - 1] == true) {
							tablero[i][j] = true;
						} else if (tablero[i][j - 1] == true) {
							tablero[i][j] = true;
						} else {
							tablero[i][j] = false;
						}
					} else if (patron.charAt(j - 1) == '*') {
						if (tablero[i - 1][j - 1] == true) {
							tablero[i][j] = true;
						} else if (tablero[i][j - 1] == true) {
							tablero[i][j] = true;
						} else if (tablero[i - 1][j] == true) {
							tablero[i][j] = true;
						} else {
							tablero[i][j] = false;
						}

					}
				}
				
				
				

			}

		}
		
		inicializarTableroCaracteres();
		
		return tablero[tablero.length-1][tablero[0].length-1];
	}

	private void inicializarTableroCaracteres() {
		for (int i = 0; i < tableroCaracteres.length; i++) {
			for (int j = 0; j < tableroCaracteres[i].length; j++) {
				if ((i == 0 && j == 0) || (i == 0 && j == 1) || (i == 1 && j == 0)) {
					tableroCaracteres[i][j] = ' ';
				} else if ((i == 0 && j != 0)) {
					tableroCaracteres[i][j] = 'p';
				} else if ((i != 0 && j == 0)) {
					tableroCaracteres[i][j] = 't';
				} else {
					tableroCaracteres[i][j] = 'b';
				}
			}
		}
	}

	public void printsTable() {
		
		int t = 0;
		int p = 0;
		System.out.println();
		System.out.println();
		
		for (int i = 0; i < tableroCaracteres.length; i++) {
			
			for (int j = 0; j < tableroCaracteres[i].length; j++) {
				
				if (tableroCaracteres[i][j] == ' ') {
					System.out.print("    ");
				} 
				else if (tableroCaracteres[i][j] == 't') {
					System.out.print(texto.charAt(t) + "   ") ;
					t++;
				} else if (tableroCaracteres[i][j] == 'p') {
					System.out.print(patron.charAt(p) + "   ");
					p++;
				} else {
					if (tablero[i-1][j-1].booleanValue() == true) {
						System.out.print("T   ");
					} else {
						System.out.print("F   ");
					}

				}
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();

	}

}
