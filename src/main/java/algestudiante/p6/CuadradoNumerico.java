package algestudiante.p6;

public class CuadradoNumerico extends CuadradoNumericoBase {
	// calcule para una entrada de tablero dada una soluci n de la forma m s
	// eficiente posible

	private boolean esSolucion;

	public CuadradoNumerico(String[][] t) {
		
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
			// comprueba si las columnas y filas se llenaron de manera correcta

			if (comprobarColumnas() && comprobarFilas()) {
				//System.out.println("Solucion encontrada");

				this.esSolucion = true;
				guardarSolucion();
			}
		} else {
			if (c == 0 && f > 0 && f < table.length - 1) {
				if (!comprobarFila(f - 2)) {
					return;
				}
			}

			int[] siguientePosicion = siguientePosiblePosicion(f, c);

			for (int number = 0; number < 10; number++) {
				if (!esSolucion) {
					table[f][c] = Integer.toString(number);

					backtrackingRecursivo(nivel + 1, siguientePosicion[0], siguientePosicion[1]);

				}
			}
			// restaurar
			table[f][c] = "?";
		}
	}
	public int getNumberOfSolutions()
	{
		return 0;
	}



	@Override
	protected void guardarSolucion() {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				solucion[i][j] = table[i][j];
			}
		}
	}



	@Override
	protected String[][] getSol() {
		return solucion;
	}
	

}


