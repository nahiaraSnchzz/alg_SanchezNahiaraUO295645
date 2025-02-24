// ESQUEMA GENERAL RAMIFICA Y PODA

package algestudiante.util;


import java.util.ArrayList;

/**
* Clase principal genérica que implementa la técnica de Ramificación y poda
*/
public class RamificaYPoda 
{
	public static final boolean TRAZA = false;	// Activa / desactiva traza por pantalla
	
	protected ColaPrioridad cola;	// nodos pendientes de expandir 
	protected Estado nodoRaiz;		// contiene el nodo inicial

	protected int cotaPoda;			// valor de la cota de poda
	
	protected Estado mejorSolucion;	// para guardar el nodo de la mejor solución (aplicable a probl. optimización

	/**
	 * Constructor
	 */
	public RamificaYPoda(boolean comprobarRepetido) 
	{
		cola = new ColaPrioridad(comprobarRepetido);		//crea Monticulo vacío
	}

	/**
	 * Método principal que implementa la ejecución de la técnica Ramifica y poda
	 * @param nodoRaiz	Le pasamos el nodo raíz para el problema que queremos resolver
	 */
	public void ramificaYPoda(Estado nodoRaiz) 
	{ 
		cola.insertar(nodoRaiz); 

		cotaPoda = nodoRaiz.valorInicialPoda();		// Inicializa cota a un valor inicial, por defecto +infinito (no poda)

		// Procesamos los estados de la cola
		// mientras la cola no está vacía y el mejor estado no está por encima de la cota de poda 
		while (!cola.vacia() && cola.estimacionMejor() < cotaPoda)	
		{
			Estado actual = cola.sacarMejorNodo();		// recuperamos el estado m s prometedor
			
			/**/if (TRAZA){
				System.out.println("--> Sacar mejor nodo de la cola de prioridad");
				System.out.println(actual);				
			}

			ArrayList<Estado> hijos = actual.expandir(); 	// expandimos todos los hijos válidos del estado acutal
			// expandir devuelve todos los hijos validos

			// Recorre todos los hijos creados comprobando que están por debajo de la cota de poda
			for (Estado estadoHijo : hijos)
			{				
				if (estadoHijo.getHeuristico() <= cotaPoda)  // ¿Está por debajo de la cota? 
					if (estadoHijo.solucion())				// ¿Es una solución al problema?
					{
						// si es solución y no la hemos podado, seguro que es mejor que la anterior
						mejorSolucion = estadoHijo;
						cotaPoda= estadoHijo.getHeuristico();	// Establecemos la cota al valor de la nueva soluci n
						
						/**/if (TRAZA) {
							System.out.println("*** Nueva solución mejor");
							System.out.println("Nueva cota de poda: "+cotaPoda+"\n");
						}
					}
					else
						// si no es solución a la cola de prioridad, pendiente de desarrollar
						cola.insertar(estadoHijo);		
			}
		} //while
	}


	public Estado getNodoRaiz() 
	{
		return nodoRaiz;
	}

	public Estado getMejorSolucion() {
		return mejorSolucion;
	}

	public void mostrarTrazaSolucion() 
	{
		System.out.println("**************************************************************");
		System.out.println("Camino para alcanzar la mejor soluci n");
		if (mejorSolucion==null) 
		{
			System.out.println("Original:");
			System.out.println(nodoRaiz);
			System.out.println("NO HAY SOLUCION");
		} 
		else
		{
			//camino de los nodos desde el mejor hasta raíz
			ArrayList<Estado> resultado= cola.rutaHastaRaiz(mejorSolucion);

			for (int i = 1;i<=resultado.size();i++)
			{
				if (i==1)
				{
					System.out.println("Estado inicial (nodo raíz):");
					System.out.println(resultado.get(resultado.size()-i));
				}
				else
				{
					System.out.println("Nivel " + (i-1)+ ":");
					System.out.println(resultado.get(resultado.size()-i));
				}
			}
			System.out.println("\nSolución de "+mejorSolucion.getProfundidad()+" pasos");	
		}
	}
}
