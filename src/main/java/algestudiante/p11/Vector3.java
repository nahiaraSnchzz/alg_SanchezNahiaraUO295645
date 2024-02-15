package algestudiante.p11;

/** Esta clase utiliza los m�todos est�ticos de la clase Vector1.
 *  Sirve para medir tiempos con distintos tama�os del problema,
 *  increment�ndolos autom�ticamente
 */
public class Vector3
{
static int []v;

public static void main (String arg [] )
{
	long t1,t2;

	System.out.println ("Tama�o\tTiempo\tResultado");   
	for ( int n=10000; n<= 81_920_000; n*=2) // n se va incrementando (*2)
	{
		System.out.print (n+"\t");
		v = new int [n] ;
		Vector1.rellena (v);

		// Medida del tiempo de la operaci�n suma()
		t1=System.currentTimeMillis();
		int s=Vector1.suma (v);
		t2=System.currentTimeMillis();
		System.out.println ((t2-t1)+"\t");   

        } // fin de for de tama�o del problema
		
	System.out.println("\nFin de la medici�n de tiempos *****");

} // fin de main

} // fin de clase
