package algestudiante.p0;

import java.util.ArrayList;

public class JavaA1 {
	
	public static void main(String[] args) {
		long t1, t2;
		ArrayList<Integer> lPrimos;
		for (int n = 10_000; n <= 1_280_000; n *= 2) {
			t1 = System.currentTimeMillis();
			lPrimos = listadoPrimos(n);
			t2 = System.currentTimeMillis();
			System.out.println("n = " + n + " *** tiempo = " + (t2-t1) + "milisegundos");
		}
	}

	private static ArrayList<Integer> listadoPrimos(int n) {
		ArrayList<Integer> lSal = new ArrayList<Integer>();
		for (int i = 2; i < n+1; i++) {
			if (JavaA1v0.primoA1(n)) {
				lSal.add(i);
			}
		}
		return lSal;
	}

}
