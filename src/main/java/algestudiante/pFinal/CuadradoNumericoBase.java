package algestudiante.pFinal;

public abstract class CuadradoNumericoBase {
	
	protected String[][] table;
	protected String[][] solucion;
	
	
	// metodo principal de backtracking
	public void backtracking() {
		// si la primera pos no es interrogante
		if (!table[0][0].equals("?")) {
			// busca la siguiente posicion con interrogante
			int[] nex = siguientePosiblePosicion(0, 0);
			backtrackingRecursivo(0, nex[0], nex[1]);
		} else
			backtrackingRecursivo(0, 0, 0);

	}
	
	public boolean esSolucion(int f, int c) {
		// si estamos en la ultima posicion de la tabla, entonces esta completa.
		if (f >= table.length) {
			return true;
		} else
			return false;

	}
	
	// calcula la siguiente posicion
	protected int[] siguientePosiblePosicion(int f, int c) {
		// si le sumamos dos columnas y no hay más celdas posibles, saltamos de fila
		if (c + 2 >= table.length - 2) {
			f = f + 2;
			c = 0;
		// si no, se avanza en la columna
		} else {
			c = c + 2;
		}
		
		// si la fila es menor que el numero de filas del tablero
		if (f < table.length) {
			// si no hay interrogante busca otra pos
			if (!table[f][c].equals("?")) {
				return siguientePosiblePosicion(f, c);
			}
		}
		return new int[] { f, c };

	}

	protected boolean comprobarFilas() {
		for (int f = 0; f < table.length-1; f=f+2) {
			if (!comprobarFila(f)) {
				return false;
			}
		}
		return true;
	}

	protected boolean comprobarFila(int f) {

		int resultadoOficial = Integer.parseInt(table[f][table[f].length - 1]);
		int resultado = Integer.parseInt(table[f][0]);

		for (int c = 1; c < table.length - 3; c = c + 2) {

			switch (table[f][c]) {

			case "+":
				resultado += Integer.parseInt(table[f][c + 1]);
				break;
			case "-":
				resultado -= Integer.parseInt(table[f][c + 1]);
				break;
			case "*":
				resultado *= Integer.parseInt(table[f][c + 1]);
				break;
			case "/":
				// si el denominador es distinto de 0
				if (Integer.parseInt(table[f][c + 1]) != 0) {
					// si el resto es mayor de cero
					if (resultado % Integer.parseInt(table[f][c + 1]) > 0) {
						return false;
					} else
						resultado = resultado / Integer.parseInt(table[f][c + 1]);
				}
				else return false;
				break;

			}

		}
		if (resultadoOficial == resultado) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean comprobarColumna(int c) {

		int resultadoOficial = Integer.parseInt(table[table.length - 1][c]);
		int resultado = Integer.parseInt(table[0][c]);

		for (int f = 1; f < table.length - 3; f = f + 2) {

			switch (table[f][c]) {

			case "+":
				resultado += Integer.parseInt(table[f + 1][c]);
				break;
			case "-":
				resultado -= Integer.parseInt(table[f + 1][c]);
				break;
			case "*":
				resultado *= Integer.parseInt(table[f + 1][c]);
				break;
			case "/":
				// si el denominador es 0
				if (Integer.parseInt(table[f + 1][c]) != 0) {
					// si el resto no es cero
					if (resultado % Integer.parseInt(table[f + 1][c]) > 0) {
						return false;
					} else
						resultado = resultado / Integer.parseInt(table[f + 1][c]);
				}
				else return false;
				break;
			}
		}
		if (resultadoOficial == resultado) {
			return true;
		} else {
			return false;
		}
	}

	
	protected boolean comprobarColumnas() {

		for (int c = 0; c < table[0].length-2; c=c+2) {
			if (!comprobarColumna(c)) {
				return false;
			}
		}

		return true;

	}

	public abstract void backtrackingRecursivo(int a,int b,int c);
	public abstract int getNumberOfSolutions();
	protected abstract String[][] getSol();
	protected abstract void guardarSolucion();
}
