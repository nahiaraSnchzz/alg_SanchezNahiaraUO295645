package algestudiante.p7;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import algestudiante.util.RamificaYPoda;


// PROBLEMA 1: ASIGNACION n TRABAJADORES-n TAREAS
// RESUELTO POR RAMIFICA Y PODA



/**
 * Clase principal para el problema de Asignaciï¿½n de agentes - tareas
 * Herada de RamificaYPoda 
 */
class PruebaAsignacion 
{	
	private static String[][] table;
	public static void main(String[] args) 
	{
		System.out.println("Cuadrado magico /// Ramificación y poda");
		
		// Creamos una instancia para resolver el problema
		RamificaYPoda problemaAsigna = new RamificaYPoda(false); 
		loadData("src/main/java/algestudiante/p6/test03.txt");
		// Ejecutamos el mï¿½todo que va recorriendo el espacio de soluciones con ramifica y poda
		problemaAsigna.ramificaYPoda(new CuadradoNumericoRamifica(table)); 
		
		// Solucion final
		System.out.println("Solución óptima del problema $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(problemaAsigna.getMejorSolucion());

		if (RamificaYPoda.TRAZA)
			problemaAsigna.mostrarTrazaSolucion(); 
	}
	private static  void loadData(String file) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			int i = 0;
			int size = Integer.valueOf(reader.readLine());
			table = new String[size*2+1][size*2+1]; //the number of rows and columns are twice + 1 the number of operations in each direction
			while (reader.ready()) { //each line
				String[] parts = reader.readLine().split(" ");
				int j = 0; //columns
				for (String part : parts) {
					table[i][j] = part; 
					if ((i%2 == 1)||(i == size*2)) //to separate operators in odd rows (i%2 == 1) and in the last row (i == size*2)
						j++; //we skip an extra column to create the table
					j++;
				}
				i++; //next line
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

