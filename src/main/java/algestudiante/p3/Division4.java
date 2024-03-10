package algestudiante.p3;

public class Division4 {

	static long cont;

// a = 1 , b = 3, k =2
	public static void rec4(int n) {
		if (n <= 0)
			cont++;
		else {
			for (int i = 1; i < n; i++)
				for (int j = 1; j < i; j++)
					cont++; // O(n)
			rec4(n / 3);
		}

	}

	public static void main(String arg[]) {
		long t1, t2, cont;
		int nVeces = Integer.parseInt(arg[0]);

		for (int n = 1000; n <= 1024000000; n *= 2) {
			t1 = System.currentTimeMillis();

			for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
				cont = 0;
				rec4(n);
			}

			t2 = System.currentTimeMillis();

			System.out.println(" n=" + n + "**TIEMPO=" + (t2 - t1) + "**nVeces=" + nVeces);
		} // for
	} // main

}
