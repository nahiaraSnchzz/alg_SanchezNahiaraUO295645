package algestudiante.p7;
import java.util.ArrayList;

import algestudiante.util.Estado;
import algestudiante.util.RamificaYPoda;



/**
 * Estado Asignaci n Agentes - Tareas Hereda de la clase Estado
 */
public class CuadradoNumericoRamifica extends Estado {
	// Datos comunes a todos los estados, por eso los declaramos "static"
	private static int n; // Tama o del problema, n m. agentes y n m. tareas
	// Estado
	private String[][] table;
	private String[][] solucion;
	private boolean esSolucion;

	private int x, y;

	/**
	 * Constructor para crear el estado inicial, Establecemos los datos y
	 * condiciones iniciales del problema
	 * 
	 * Sirve para crear el estado inicial
	 */
	public CuadradoNumericoRamifica(String[][] table) {
		super();

		n = table.length;
		this.table = new String[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.table[i][j] = table[i][j];
			}
		}

		// Inicializa variables que usabamos en backtracking (si hay)
		this.esSolucion = false;
		this.solucion = new String[table.length][table[0].length];

		x = 0;
		y = 0; // posicion que tiene que rellenar el hijo

	}

	/**
	 * Constructor para crear un estado a partir del padre
	 * 
	 * Es el utilizado en el metodo expandir.
	 */
	public CuadradoNumericoRamifica(CuadradoNumericoRamifica padre, int valor, int x, int y) {
		super();
		// copiamos toda la informacion del padre

		profundidad = padre.profundidad;
		idPadre = padre.getId();
		this.table = new String[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.table[i][j] = padre.table[i][j];
			}
		}
		this.x = x;
		this.y = y;
		table[x][y] = String.valueOf(valor);
		// añade lo correspondiente a este hijo
		// rellenar la siguiente celda del cuadado numerico

		profundidad++;
		calcularValorHeuristico();

	}

	private int[] siguienteCeldaParaRellenar(int f, int c) {
		if (c + 2 >= table.length - 2) {
			f = f + 2;
			c = 0;
		} else {
			c = c + 2;
		}
		if (f < table.length) {
			if (!table[f][c].equals("?")) {
				return siguienteCeldaParaRellenar(f, c);
			}
		}
		return new int[] { f, c };
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("VALOR HEURISTICO = " + valorHeuristico + "\n-----------------------------------\n");
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (table[i][j] == null)
					sb.append("\t");
				else
					sb.append(table[i][j] + "\t");
			}
			sb.append("\n\n");
		}
		return sb.toString();
	}

	/**
	 * ESTA SEMANA NO. PARA LA SEMANA QUE VIENE SIN HEURISTICOS Calcula el valor del
	 * heur stico y lo guarda
	 */
	@Override
	public void calcularValorHeuristico() {
		int contador = 0;

		for (int i = 0; i < n - 2; i += 2) {
			boolean tieneInterrogacion = false;
			for (int j = 0; j < n - 2; j += 2) {
				if (table[i][j].equals("?")) {
					contador++;
					tieneInterrogacion = true;
				}
				if (contador == 0 && i == n - 3 && j > 0) {
					if (comprobarColumna(j - 2)) {
						;
					} else {
						valorHeuristico = Integer.MAX_VALUE;
					}
				}
			}
			if (!tieneInterrogacion) {
				if (comprobarFila(i))
					;
				else {
					valorHeuristico = Integer.MAX_VALUE;
				}
			}
		}
		if (valorHeuristico != Integer.MAX_VALUE)
			valorHeuristico = contador;
	}

	@Override
	public ArrayList<Estado> expandir() {
		ArrayList<Estado> listaHijos = new ArrayList<Estado>();
		int[] si = { x, y };
		if (!table[x][y].equals("?")) {
			si = siguienteCeldaParaRellenar(x, y);
		}

		int fila = si[0];
		int columna = si[1];
		if (fila < n - 2)
			for (int j = 0; j < 10; j++) {
				Estado estadoHijo = new CuadradoNumericoRamifica(this, j, fila, columna);
				// si el tablero esta completo y correcto:
				listaHijos.add(estadoHijo);
				if (RamificaYPoda.TRAZA) {
					System.out.println("Nivel: " + profundidad + " - Hijo: " + j);
					System.out.println(estadoHijo);
				}
			}
		return listaHijos;

	}

	private void guardarSolucion() {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				solucion[i][j] = table[i][j];
			}
		}
	}

	public String[][] getSol() {
		return solucion;
	}

	@Override
	public boolean solucion() {
		if (x == n - 3 && y == n - 3)
			if (comprobarFilas() && comprobarColumnas()) {
				return true;
			}
		return false;
	}

	private boolean isSol() {
		// si estamos en la ultima posicion de la tabla, entonces esta completa.
		if (x >= table.length) {
			return true;
		} else
			return false;
	}

	protected boolean comprobarFilas() {
		for (int f = 0; f < table.length - 2; f = f + 2) {
			if (!comprobarFila(f)) {
				return false;
			}
		}
		return true;
	}

	protected boolean comprobarFila(int f) {
		if (table[f][0].equals("?"))
			return false;
		int resultadoOficial = Integer.parseInt(table[f][n - 1]);
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
				if (Integer.parseInt(table[f][c + 1]) != 0) {
					if (resultado % Integer.parseInt(table[f][c + 1]) > 0) {
						return false;
					} else
						resultado = resultado / Integer.parseInt(table[f][c + 1]);
				} else
					return false;
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
				if (Integer.parseInt(table[f + 1][c]) != 0) {
					if (resultado % Integer.parseInt(table[f + 1][c]) > 0) {
						return false;
					} else
						resultado = resultado / Integer.parseInt(table[f + 1][c]);
				} else
					return false;
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

		for (int c = 0; c < table[0].length - 2; c = c + 2) {
			if (!comprobarColumna(c)) {
				return false;
			}
		}

		return true;

	}

//	@Override
//	public String toString()
//	{
//		StringBuffer sb = new StringBuffer("===============\n");
////		for (int i=0; i<solParcial.length; i++) 
////		{
////			if (solParcial[i] != -1)
////				sb.append("AL TRABAJADOR "+i+" SE LE ASIGNA LA TAREA "+solParcial[i]+"\n");
////			else
////				sb.append("LA TAREA "+i+" NO HA SIGO ASIGNADA TODAVIA\n");
////		}
//		sb.append("Valor heuristico = " + valorHeuristico + "\n");
//		sb.append("===============\n");
//		return sb.toString();
//	}

	/**
	 * Imprime el tablero
	 * 
	 * @param table for printing
	 * @param title
	 */
	private void printTable(String[][] table, String title) {
		if (title != null)
			System.out.printf("CUADRADO NUMERICO RAMIFICA - %s\n", title);
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

