package algestudiante.p3;

public class Sustraccion4 {

	static long cont;

	// Complejidad: a = 1, b = 1, k = 2
	public static void rec4(int n) {
		if (n <= 0)
			cont++;
		else {
			for (int i = 0; i < n; i++)// O(n)
				cont++; 
			
			rec4(n - 1);
			
			for (int i = 0; i < n; i++)
				for (int j=0; j < i; j++) // O(n**2)
					cont++; 
		}
	}

	public static void main(String arg[]) {
		long t1, t2, cont;
		int nVeces = Integer.parseInt(arg[0]);
		for (int n = 100; n <= 1024000; n *= 2) {

			t1 = System.currentTimeMillis();

			for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
				cont = 0;
				rec4(n);
			}

			t2 = System.currentTimeMillis();

			System.out.println(" n=" + n + "**TIEMPO=" + (t2 - t1) + "**nVeces=" + nVeces);
		} // for
	} // main
} // class
