package algestudiante.p3;

import static org.junit.Assert.*;

import org.junit.Test;

import algestudiante.p2.Vector;

public class TestMezcla {

	@Test
	public void mezcla1() {
		int[] v = new int[10];
		
		Vector.ordenDirecto(v);
		System.out.println ("Vector a ordenar es: ");
		Vector.escribe(v);
		
		int[] vMezcla = Mezcla.mezcla(v);
		
		System.out.println ("Vector ordenado es: ");
		Vector.escribe(v);
		
		assertEquals(v,vMezcla);
	}
	
	
	@Test
	public void mezcla2() {
		
		int[] v = new int[10];
		
		Vector.ordenInverso(v);
		System.out.println ("Vector a ordenar es: ");
		Vector.escribe(v);
		
		int[] vMezcla = Mezcla.mezcla(v);
		
		System.out.println ("Vector ordenado es: ");
		Vector.escribe(v);
		
		assertEquals(v,vMezcla);
	}
	
	@Test
	public void mezcla3() {
		
		int[] v = new int[10];
		
		Vector.ordenAleatorio(v);
		System.out.println ("Vector a ordenar es: ");
		Vector.escribe(v);
		
		int[] vMezcla = Mezcla.mezcla(v);
		
		System.out.println ("Vector ordenado es: ");
		Vector.escribe(v);
		
		assertEquals(v,vMezcla);
	}
	
	@Test
	public void mezcla4() {
		
		int[] v = new int[0];
		
		Vector.ordenDirecto(v);
		System.out.println ("Vector a ordenar es: ");
		Vector.escribe(v);
		
		int[] vMezcla = Mezcla.mezcla(v);
		
		System.out.println ("Vector ordenado es: ");
		Vector.escribe(v);
		
		assertEquals(v,vMezcla);
	}
	
	@Test
	public void mezcla5() {
		
		int[] v = new int[0];
		
		Vector.ordenInverso(v);
		System.out.println ("Vector a ordenar es: ");
		Vector.escribe(v);
		
		int[] vMezcla = Mezcla.mezcla(v);
		
		System.out.println ("Vector ordenado es: ");
		Vector.escribe(v);
		
		assertEquals(v,vMezcla);
	}
	
	@Test
	public void mezcla6() {
		
		int[] v = new int[0];
		
		Vector.ordenAleatorio(v);
		System.out.println ("Vector a ordenar es: ");
		Vector.escribe(v);
		
		int[] vMezcla = Mezcla.mezcla(v);
		
		System.out.println ("Vector ordenado es: ");
		Vector.escribe(v);
		
		assertEquals(v,vMezcla);
	}
	


}
