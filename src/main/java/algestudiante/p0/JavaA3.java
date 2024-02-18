package algestudiante.p0;

import java.util.ArrayList;

public class JavaA3 {
	
	public static void main(String[] args) {
		System.out.println("TIEMPOS ALGORITMO 3:");
		long t1, t2;
		ArrayList<Integer> lPrimos;
		for (int n = 10_000; n <= 1_280_000; n *= 2) {
			t1 = System.currentTimeMillis();
			lPrimos = listadoPrimos(n);
			t2 = System.currentTimeMillis();
			System.out.println("n = " + n + " *** tiempo = " + (t2-t1) + " milisegundos");
		}
	}
	
	public static boolean primoA3 (int m) {
		for (int i=2; i < m/2*m+1 ; i++) {
			if (m%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<Integer> listadoPrimos (int n){
		ArrayList<Integer> lSal = new ArrayList<Integer>();
		for (int i=0; i < n+1; i++) {
			if (primoA3(i)) {
				lSal.add(i);
			}
		}
		return lSal;
	}

}


