package algestudiante.p2;

public class RapidoInsercionTiempos {
	

/* Esta clase mide tiempos del metodo RapidoInsercion
para los 3 supuestos de orden incial (aleatorio) */


static int []v;

public static void main (String[] args)
{
long t1,t2;
String opcion=args[0];
int k = Integer.parseInt(args[1]);


	v=new int [16_000_000];
	Vector.ordenAleatorio(v);
		
  	t1 = System.currentTimeMillis();
	
  	// aqui se meteria un bucle que sume repeticiones.
  	// el problema es que el vector v se ordena en la primera repeticion y se modifica.
  	// si se pide el tiempo, quizas la idea menos mala es clonar v en cada repeticion. Aunque aplicamos una sobrecarga (.clone)
	RapidoInsercion.rapido2(v,k);
         
	t2 = System.currentTimeMillis();

  	System.out.println (16_000_000+"\t"+(t2-t1));


}
}
