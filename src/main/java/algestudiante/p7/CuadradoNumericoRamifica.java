package algestudiante.p7;

import java.util.ArrayList;
import java.util.Arrays;

import algestudiante.util.Estado;
import algestudiante.util.RamificaYPoda;


/**
 * Estado Asignaci�n Agentes - Tareas
 * Hereda de la clase Estado
 */
public class CuadradoNumericoRamifica extends Estado 
{
	// Datos comunes a todos los estados, por eso los declaramos "static"
	private static int n;				// Tama�o del problema, n�m. agentes y n�m. tareas
	// Estado
	private String[][] table;				
	
	private int x,y;
	/**
	 * Constructor para crear el estado inicial,
	 * Establecemos los datos y condiciones iniciales del problema
	 * 
	 * Sirve para crear el estado inicial
	 */
	public CuadradoNumericoRamifica(String[][] table) {
		super();
		
		n = table.length;
		
		
		for (int i=0; i< table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				this.table[i][j] = table[i][j];
			}
		}
		

		// Inicializa variables que usabamos en backtracking (si hay)
		
		
	}

	/**
	 * Constructor para crear un estado a partir del padre
	 * 
	 * Es el utilizado en el metodo expandir.
	 */
	public CuadradoNumericoRamifica(CuadradoNumericoRamifica padre,int j) {
		super();
		// copiamos toda la informacion del padre	
		
		profundidad = padre.profundidad;
		idPadre = padre.getId();
		
		// añade lo correspondiente a este hijo
		// rellenar la siguiente celda del cuadado numerico
		
		int[] pos = siguienteCeldaParaRellenar(padre.x, padre.y); // posicion que relleno el padre
		x = pos[0]; 
		y = pos[1]; // posicion que tiene que rellenar el hijo
		
		table[x][y] = ""+j;
		profundidad++;
		calcularValorHeuristico();
		
	}

	private int[] siguienteCeldaParaRellenar(int x2, int y2) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ESTA SEMANA NO. PARA LA SEMANA QUE VIENE SIN HEURISTICOS
	 * Calcula el valor del heur�stico y lo guarda
	 */
	@Override
	public void calcularValorHeuristico() {
		valorHeuristico = 10;		
	}

	/**
	 * Calcula el valor m�nimo por columnas
	 * @param profundidad	para saber cuantas tareas est�n ya asignadas
	 * @param j				para saber que tarea se asigna en este paso
	 * @return				valor m�nimo por columnas
	 */
	private int minimoColumna(int profundidad, int j) {
//		int minValorColumna=Integer.MAX_VALUE;
//		for (int i= profundidad; i<n; i++)
//			// calculamos el m�nimo de columnas
//			if (costes[i][j] < minValorColumna)
//				minValorColumna= costes[i][j];
//		return minValorColumna;
	}

	@Override
	public ArrayList<Estado> expandir() {
		ArrayList<Estado> listaHijos= new ArrayList<Estado>();
		
		for (int j=0; j < 10; j++) {
			Estado estadoHijo = new CuadradoNumericoRamifica(this,j);
			if (estadoHijo.isValid()) {
				listaHijos.add(estadoHijo);
				
				if (RamificaYPoda.TRAZA) {
					System.out.println("Nivel: "+ profundidad + " - Hijo: " + j);
					System.out.println(estadoHijo);
				}
			}
		}
		
	}

	@Override
	public boolean solucion() {
		// ya estan rellenos todos los huecos y se validan todas las operaciones
		// (las que queden por evaluar) tanto por filas como por columnas.
		if (isSol() && compruebaFilas() && compruebaColumna())
			return true;
		else
			return false;
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
