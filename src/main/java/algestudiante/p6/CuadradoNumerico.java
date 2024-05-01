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
		// Si la tabla está completa
		if (esSolucion(f, c)) {
			// comprueba si las columnas y filas se llenaron de manera correcta
			if (comprobarColumnas() && comprobarFilas()) {
				
				this.esSolucion = true;
				guardarSolucion();
			}
			
		} else {
			// si acabamos de saltar de fila y es una celda valida
			if (c == 0 && f > 0 && f < table.length - 1) {
				// se comprueba la fila anterior
				if (!comprobarFila(f - 2)) {
					// vuelve a la iteración anterior
					return;
				}
			}
			// calcula la siguiente posible posicion
			int[] siguientePosicion = siguientePosiblePosicion(f, c);
			
			for (int number = 0; number < 10; number++) {
				if (!esSolucion) {
					// se pone el numero en la celda
					table[f][c] = Integer.toString(number);
					
					backtrackingRecursivo(nivel + 1, siguientePosicion[0], siguientePosicion[1]);

				}
			}
			// restaurar
			table[f][c] = "?";
		}
	}
	
	// devuelve el numero de soluciones
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


