package algestudiante.p11;

public class Vector6 {
	

static int []v;
static int []w;

public static void main (String arg [] )
{
	int repeticiones = Integer.parseInt (arg[0]);	// veces que se repite la operaci�n, nada que ver con n

	long t1,t2;

	System.out.println("repeticiones = "+ repeticiones);
	System.out.println ("Tama�o\tTiempo");   
	for ( int n= 10000; n<= 81_920_000; n*=2) // n se va duplicando   
	{
		v = new int [n] ;
		w = new int [n];
		Vector1.rellena (v);
		Vector1.rellena (w);

		t1=System.currentTimeMillis();

		int s= 0;
		// hay que repetir todo el proceso a medir (lo que que estaba entre t1 y t2) 
		for (int r= 1; r<=repeticiones; r++)
		{  	
			s= Vector1.coincidencias1(v,w);
		}

		t2=System.currentTimeMillis();
		System.out.println (n+"\t"+(t2-t1));   

	} // fin de for
		
	System.out.println("\nFin de la medici�n de tiempos *****");

} // fin de main

}
