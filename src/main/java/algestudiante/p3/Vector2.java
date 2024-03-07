package algestudiante.p3;

import java.util.Random ;

/*
Clase de utilidad, que genera para un vector los 3 ordenes
Tambien escribe el contenido de un vector
*/

public class Vector2
{

/*  Este metodo devuelve valores ya ordenados */
public static void ordenDirecto (int[]a)
{
	int n= a.length;
	for(int i=0;i<n;i++) a[i]=i;
}

/*  Este metodo retorna valores ordenados en orden inverso */
public static void ordenInverso (int[]a)
{
	int n= a.length;
	for(int i=0;i<n;i++) a[i]=n-i-1;
}     


/*  Este metodo retorna valores aleatorios a un vector de enteros, 
    utiliza para ello la clase Random del paquete java.util */
public static void ordenAleatorio (int[]a)
{
	Random r= new Random ();
	int n= a.length;
	for(int i=0;i<n;i++)
   		a[i]=r.nextInt(100_000_000);
		// p.e valores entre 0 y 99_999
}     

/*  Este metodo escribe los componentes del vector	 */
public static void escribe (int[]a)
{
	int n= a.length;
	System.out.print("(");
	for (int i=0; i<n; i++ )
		System.out.print(a[i]+", ");
	System.out.println(")");
}    


}
