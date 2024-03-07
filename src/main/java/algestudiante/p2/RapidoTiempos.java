package algestudiante.p2;

public class RapidoTiempos {
	

/* Esta clase mide tiempos del metodo Rapido
para los 3 supuestos de orden incial (ordenado, inverso y aleatorio) */


static int []v;

public static void main (String arg [])
{
long t1,t2;
String opcion=arg[0];

	
for (int n= 250_000; n<=1_000_000_000; n*= 2)
{
	v=new int [n];

   	if (opcion.compareTo("ordenado")==0)
		Vector.ordenDirecto(v);
   	else if (opcion.compareTo("inverso")==0)
		Vector.ordenInverso(v);
   	else
		Vector.ordenAleatorio(v);
		
  	t1 = System.currentTimeMillis();
	
  	// aqui se meteria un bucle que sume repeticiones.
  	// el problema es que el vector v se ordena en la primera repeticion y se modifica.
  	// si se pide el tiempo, quizas la idea menos mala es clonar v en cada repeticion. Aunque aplicamos una sobrecarga (.clone)
	Rapido.rapido(v);
         
	t2 = System.currentTimeMillis();

  	System.out.println (n+"\t"+(t2-t1));
}
}

}
