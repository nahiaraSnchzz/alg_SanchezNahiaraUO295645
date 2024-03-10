package algestudiante.p3;

import algestudiante.p2.Vector;

public class Mezcla {

	private static int[] a;
	private static int[] b;

	public static int[] mezcla(int a[]) {
		b = new int[a.length];
		merge(a, 0, a.length - 1);

		return a;
	}

	public static void merge(int[] a, int iz, int de) {

		if (iz < de) {
			int mitad = (iz + de) / 2;
			merge(a, iz, mitad);
			merge(a, mitad + 1, de);
			combinar(a, b, iz, mitad, mitad + 1, de);
		}
	}

	private static void combinar(int[] a, int[] b, int p1, int u1, int p2, int u2) {

		if (p1 > u1 || p2 > u2)
			return;

		for (int k = p1; k < u2+1; k++) {
			b[k] = a[k];
		}

		int i1 = p1;
		int i2 = p2;

		for (int i = p1; i < u2+1; i++) {
			if (b[i1] <= b[i2]) {
				a[i] = b[i1];
				if (i1 < u1) {
					i1++;
				}
				else {
					b[i1] = Integer.MAX_VALUE;
				}
			} else {
				a[i] = b[i2];
				if (i2 < u2) {
					i2++;
				}
				else {
					b[i2] = Integer.MAX_VALUE;
				}
			}
		}
	}

	

	public static void main(String arg[]) {
		Integer n = Integer.parseInt(arg[0]);

		a = new int[n];

		Vector.ordenDirecto(a);
		System.out.println("VECTOR A ORDENAR ES");
		Vector.escribe(a);
		mezcla(a);
		System.out.println("VECTOR ORDENADO ES");
		Vector.escribe(a);

		Vector.ordenInverso(a);
		System.out.println("VECTOR A ORDENAR ES");
		Vector.escribe(a);
		mezcla(a);
		System.out.println("VECTOR ORDENADO ES");
		Vector.escribe(a);

		Vector.ordenAleatorio(a);
		System.out.println("VECTOR A ORDENAR ES");
		Vector.escribe(a);
		mezcla(a);
		System.out.println("VECTOR ORDENADO ES");
		Vector.escribe(a);
	}

}
