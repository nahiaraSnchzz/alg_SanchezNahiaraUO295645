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

	/**
	 * Constructor para crear el estado inicial,
	 * Establecemos los datos y condiciones iniciales del problema
	 */
	public CuadradoNumericoRamifica(String[][] table) {
		super();
		
		n = table.length;
		
		
		for (int i=0; i< table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				this.table[i][j] = table[i][j];
			}
		}
		

		// Inicializa variables de cada estado
		solParcial = new int[n];
		for (int i=0;i<solParcial.length;i++)
			solParcial[i] = -1;//sin asignaciones inicialmente
		
		tareaConTrabajador=new boolean[solParcial.length];
		for (int i= 0; i<n; i++)
			tareaConTrabajador[i]= false;
		
	}

	/**
	 * Constructor para crear un estado a partir del padre
	 */
	public CuadradoNumericoRamifica(CuadradoNumericoRamifica padre,int j) {
		super();
		// copiamos toda la informacion del padre		
		solParcial= Arrays.copyOf(padre.solParcial,n);
		tareaConTrabajador= Arrays.copyOf(padre.tareaConTrabajador,n);
		profundidad= padre.profundidad;
		idPadre= padre.getId();
		
		// ESTAS DOS LINEAS CAMBIAN (estara el dame la siguiente casilla a evaluar)
		// añade lo correspondiente a este hijo (le asigna el nuevo valor, j)
		solParcial[profundidad] =j;		// profundidad se corresponde con el primer agente sin asignar
		tareaConTrabajador[j]= true;	// marcamos la tarea como asignada
		
		
		profundidad++;
		calcularValorHeuristico();
		
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
		int minValorColumna=Integer.MAX_VALUE;
		for (int i= profundidad; i<n; i++)
			// calculamos el m�nimo de columnas
			if (costes[i][j] < minValorColumna)
				minValorColumna= costes[i][j];
		return minValorColumna;
	}

	@Override
	public ArrayList<Estado> expandir() {
		ArrayList<Estado> listaHijos= new ArrayList<Estado>();
		
		int fila = -1;
		int columna = -1;
		
		for (int i=0; i < table.length; i++	) {
			for (int j=0; j < table[i].length; j++) {
				if (table[i][j].equals("?")) {
					fila = i;
					columna = j;
					break;
				}
			}
			if (columna != -1) {
				break;
			}
		}
		
		if (fila == -1 && columna == -1) {
			return listaHijos;
		}

		
		for (int numero = 0; numero < 10; numero++)
			if (esSolucion(fila,columna))  // Crea hijo s�lo para tareas NO asignadas
			{
				if (comprobarColumnas() && comprobarFilas()) {
					Estado estadoHijo= new CuadradoNumericoRamifica(this,j); 
					listaHijos.add(estadoHijo);
				}
				
				
					
			}

		return listaHijos;
	}

	@Override
	public boolean solucion() {
		if (isSol() && ??)
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
