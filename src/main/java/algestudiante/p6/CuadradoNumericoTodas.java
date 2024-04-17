package algestudiante.p6;

import java.util.ArrayList;
import java.util.List;

public class CuadradoNumericoTodas extends CuadradoNumericoBase {
	// calcule para una entrada de tablero dada todas las soluciones posibles

	private int numSoluciones;
	private List<String[][]> resultados;

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
			// comprueba si la columna se lleno de manera correcta

			if (comprobarColumnas() && comprobarFilas()) {
				//System.out.println("Solucion encontrada");
				guardarSolucion();
				numSoluciones++;
			}
		} else {
			if (c == 0 && f > 0 && f < table.length - 1) {
				if (!comprobarFila(f - 2)) {
					return;
				}
			}

			int[] siguientePosicion = siguientePosiblePosicion(f, c);

			for (int number = 0; number < 10; number++) {

				table[f][c] = Integer.toString(number);

				backtrackingRecursivo(nivel + 1, siguientePosicion[0], siguientePosicion[1]);

			}
			// restaurar
			table[f][c] = "?";
		}

	}

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

	@Override
	protected String[][] getSol() {
		return resultados.get(0);

	}

}
