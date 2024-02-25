package algestudiante.p2;

public class Insercion2 {
	

static int []v;


/* Ordenacion por el metodo de Insercion */
public static void insercion2 (int[] a, int inferior, int superior) 
{
	int n= a.length;
	for (int i=inferior+1;i<=superior;i++) 
	{
		int x=a[i];
		int j=i-1;
		while (j>=inferior && x<a[j])
		{ 
			a[j+1]=a[j];
			j=j-1;
		}
		a[j+1]=x;
	}  // for
}

public static void main (String arg [] )
{
	int n=Integer.parseInt(arg[0]);  //tamanno del problema  
	int inferior=Integer.parseInt(arg[1]);  // posicion inferior
	int superior=Integer.parseInt(arg[2]);  // posicion superior
	v = new int[n] ;

	Vector.ordenDirecto(v);
	System.out.println ("VECTOR A ORDENAR ES");
	Vector.escribe(v);	
	insercion2(v, inferior, superior);
	System.out.println ("VECTOR ORDENADO ES");
	Vector.escribe (v);

	Vector.ordenInverso(v);
	System.out.println ("VECTOR A ORDENAR ES");
	Vector.escribe(v);	
	insercion2(v, inferior, superior);
	System.out.println ("VECTOR ORDENADO ES");
	Vector.escribe(v);

	Vector.ordenAleatorio(v);
	System.out.println ("VECTOR A ORDENAR ES");
	Vector.escribe(v);	
	insercion2(v, inferior, superior);
	System.out.println ("VECTOR ORDENADO ES");
	Vector.escribe(v);
} // fin de main
	  

}
