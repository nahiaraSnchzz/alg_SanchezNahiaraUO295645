package algestudiante.p5;

import java.util.ArrayList;
import java.util.List;

public class PatternMatching {
	
	char[][] tableroCaracteres;
	Boolean[][] tablero;
	String texto;
	String patron;

	public PatternMatching(String text) {

		texto = text;

	}

	public Boolean checkPattern(String patron) {
		
		tablero = new Boolean[texto.length()+1][patron.length()+1];
		tableroCaracteres = new char[texto.length()+1][patron.length()+1];
		this.patron = patron;
		inicializarTableroCaracteres();
		
		for (int i = 1; i < patron.length()+1; i++) {
			for (int j = 1; j < patron.length()+1; j++) {
				
				// caso base
				if (i == 1 && j == 1) {
					tablero[i][j] = true;
				}
				else if (i == 1 && tablero[i][j] != true) {
					tablero[i][j] = false;
				}
				
				else if (j == 1 && tablero[i][j] != true) {
					tablero[i][j] = false;
				}
				
				
				
			}
			
		}
		return null;

	}
	
	private void inicializarTableroCaracteres() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j=0; j < tablero[i].length; j++) {
				if ((i == 0 && j == 0) || (i == 0 && j == 1) || (i == 1 && j == 0)) {
					tableroCaracteres[i][j] = ' ';
				}
				else if ((i == 0 && j != 0)) {
					tableroCaracteres[i][j] = 't';
				}
				else if ((i != 0 && j == 0)) {
					tableroCaracteres[i][j] = 'p';
				}
				else {
					tableroCaracteres[i][j] = 'b';
				}
			}
		}
	}

	public void printsTable() {
		for (int i = 0; i < tableroCaracteres.length; i++) {
			for (int j=0; j < tableroCaracteres[i].length; j++) {
				
				if (tableroCaracteres[i][j] == ' ') {
					System.out.print("   ");
				}
				else if (tableroCaracteres[i][j] == 't') {
					System.out.print(texto.charAt(i - 2) + "  ");
				}
				else if (tableroCaracteres[i][j] == 'p') {
					System.out.print(patron.charAt(i - 2) + "  ");
				}
				else {
					System.out.print("f  ");
				}
			}
		}

	}

}
