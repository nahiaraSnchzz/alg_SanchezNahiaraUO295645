package algestudiante.p12;

public class Bucle6 {
	

public static long bucle6(int n)
{
	long cont = 0;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= i; j++)
			for (int k = 1; k <= j; k++)
				for (int m = 1; m <= k; m*=2)
					cont++;
	return cont;

}

public static void main(String arg[]) 
{
	long c = 0;
	long t1, t2;

	int nVeces = Integer.parseInt(arg[0]);

	System.out.println("n\ttiempo\trepeticiones\tcontador");

	for (int n = 100; n <= 819200; n *= 2) 
	{
	t1 = System.currentTimeMillis();

	for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) 
		c = bucle6(n);
			

	t2 = System.currentTimeMillis();

	System.out.println(n+"\t"+(t2-t1)+"\t"+nVeces+"\t\t"+c);		

	} // for

} // main


}
