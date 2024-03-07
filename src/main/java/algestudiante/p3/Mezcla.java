package algestudiante.p3;

import algestudiante.p2.Vector;

public class Mezcla {
	
	private static int[] v;
	private static int[] b;
	
	public static void mezcla(int v[]) {
		b = new int[v.length];
		merge (v, 0, v.length-1);
	}
	
	public static void merge (int[] v, int iz, int de) {
			
		if (iz < de) {
			int mitad = (iz+de)/2;
			merge (v,iz,mitad);
			merge (v,mitad+1, de);
			combinar(v,iz, mitad, mitad+1, de);
		}
	}
	
	private static void combinar(int[] v, int iz, int mitad, int mitadMas, int de) {
		
		if (! (iz > mitad || mitadMas > de)) {
			
			for (int k = iz; k < de; k++) {
				b[k] = v[k];
			}
			
			int i1 = iz;
			int i2 = mitad+1;
			
			for (int i=iz; i < de; i++) {
				if (b[i1] <= b[i2]) {
					v[i] = b[i1];
					if (!(i1 < mitad)) {
						b[i1] = Integer.MAX_VALUE;
					}
				}
				else {
					v[i] = b[i2];
					if (!(i2 < de)) {
						b[i2] = Integer.MAX_VALUE;
					}
				}
			}
		}
	}
	
	public static void main (String arg[]) {
		int n = Integer.parseInt(arg[0]);
		v = new int [n];
		
		Vector.ordenDirecto(v);
		System.out.println ("VECTOR A ORDENAR ES");
		Vector.escribe(v);	
		mezcla(v);
		System.out.println ("VECTOR ORDENADO ES");
		Vector.escribe (v);

		Vector.ordenInverso(v);
		System.out.println ("VECTOR A ORDENAR ES");
		Vector.escribe(v);	
		mezcla(v);
		System.out.println ("VECTOR ORDENADO ES");
		Vector.escribe(v);

		Vector.ordenAleatorio(v);
		System.out.println ("VECTOR A ORDENAR ES");
		Vector.escribe(v);	
		mezcla(v);
		System.out.println ("VECTOR ORDENADO ES");
		Vector.escribe(v);
	}

}
