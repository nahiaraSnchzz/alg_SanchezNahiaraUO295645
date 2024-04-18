// PROBLEMA 1: ASIGNACION n TRABAJADORES-n TAREAS
// RESUELTO POR RAMIFICA Y PODA

package algestudiante.p7;

import algestudiante.util.RamificaYPoda;

/**
 * Clase principal para el problema de Asignaci�n de agentes - tareas
 * Herada de RamificaYPoda 
 */
class PruebaAsignacion 
{	

	public static void main(String[] args) 
	{
		System.out.println("Problema de Agentes - tareas /// Ramificaci�n y poda");
		
		// Creamos una instancia para resolver el problema
		RamificaYPoda problemaAsigna = new RamificaYPoda(false); 

		// Ejecutamos el m�todo que va recorriendo el espacio de soluciones con ramifica y poda
		problemaAsigna.ramificaYPoda(new EstadoAsigna()); 
		
		// Soluci�n final
		System.out.println("Soluci�n �ptima del problema $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(problemaAsigna.getMejorSolucion());

		if (RamificaYPoda.TRAZA)
			problemaAsigna.mostrarTrazaSolucion(); 
	}

}

