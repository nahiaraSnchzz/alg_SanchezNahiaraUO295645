package algestudiante.pFinal;

import java.util.ArrayList;
import java.util.List;

public class CuadradoNumericoTodas extends CuadradoNumericoBase {
	// calcule para una entrada de tablero dada todas las soluciones posibles

	private int numSoluciones;
	private List<String[][]> resultados;
	private String[][] solActual;

	public CuadradoNumericoTodas(String[][] t) {
		
		resultados = new ArrayList<String[][]>();
		table = new String[t.length][t[0].length];
		
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t.length; j++) {
				this.table[i][j] = t[i][j];
			}
		}
		
		this.solucion = new String[t.length][t[0].length];

	}

	@Override
	public void backtrackingRecursivo(int nivel, int f, int c) {
		// Finaliza el proceso si se completa la tabla
		if (esSolucion(f, c)) {
			if (diagonalPrincipalCero()) {	
				// comprueba si la columna se lleno de manera correcta
				if (comprobarColumnas() && comprobarFilas()) {
					
					guardarSolucion();
					numSoluciones++;
					
					
					
					if (getNumberOfSolutions() == 1) {
						solActual = new String[table.length][table[0].length];
						solActual = getSol();
						printTable(solActual, "Primera solución");
					}
					
				}
			}
			
			
		} else {
			// si acabamos de saltar de fila y estamos dentro del tablero
			if (c == 0 && f > 0 && f < table.length - 1) {
				// si la fila anterior se lleno de manera correcta
				if (!comprobarFila(f - 2)) {
					// vuelve a la iteración anterior
					return;
				}
			}
			
			// calcula la siguiente pos
			int[] siguientePosicion = siguientePosiblePosicion(f, c);

			for (int number = -5; number < 6; number++) {
				
				// pone el valor actual en la tabla
				table[f][c] = Integer.toString(number);

				backtrackingRecursivo(nivel + 1, siguientePosicion[0], siguientePosicion[1]);

			}
			// restaurar
			table[f][c] = "?";
		}

	}

	// devuelve el numero de soluciones
	public int getNumberOfSolutions() {
		return numSoluciones;
	}

	@Override
	protected void guardarSolucion() {

		String[][] r = new String[table.length][table.length];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				r[i][j] = table[i][j];
			}
		}
		resultados.add(r);

	}
	
	// devuelve la primera solucion encontrada
	@Override
	protected String[][] getSol() {
		return resultados.get(0);

	}
	

	private boolean diagonalPrincipalCero() {
		
		ArrayList<String> elementosDiagonal = new ArrayList<String>();
		
		for (int i=0; i < table.length-2; i+=2) {
			for (int j=0; j < table[i].length-2; j+=2) {
				
				if (i==j) {
					elementosDiagonal.add(table[i][j]);
				}
				
			}
		}
		
		int resultadoEsperado = 0;
		int resultado = 0;
		
		for (int i = 0 ; i < elementosDiagonal.size(); i++) {
			resultado += Integer.parseInt(elementosDiagonal.get(i));
		}
		
		if (resultadoEsperado == resultado) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * Print any two-dimensional table with a title via console
	 * @param table
	 * @param title
	 */
	private void printTable(String[][] table, String title) {
		if (title != null)
			System.out.printf("NUMERIC SQUARE - %s\n", title);
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (table[i][j] == null)
					System.out.printf("%5s", "");
				else
					System.out.printf("%5s", table[i][j]);
			}
			System.out.printf("\n\n");
		}
	}

}
