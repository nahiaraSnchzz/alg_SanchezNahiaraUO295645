package algestudiante.p7;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import algestudiante.util.RamificaYPoda;

public class NumericSquareTestOne {
	private static String PATH= "src/main/java/algestudiante/p6/";
	private String[][] table;
	
	@Test
	public void test0() {
		String name = "test00.txt";
		loadData(PATH + name);
		RamificaYPoda problemaAsig = new RamificaYPoda(false);
		CuadradoNumericoRamifica estado = new CuadradoNumericoRamifica(table);
		long inicio = System.currentTimeMillis();
		problemaAsig.ramificaYPoda(estado);
		long fin = System.currentTimeMillis();
		
		assertNotNull(problemaAsig.getMejorSolucion());
		System.out.println(name + " 	TIEMPO = " + (fin-inicio));
		System.out.println(problemaAsig.getMejorSolucion());
		
	}
	
	@Test
	public void test1() {
		String name = "test01.txt";
		loadData(PATH + name);
		RamificaYPoda problemaAsig = new RamificaYPoda(false);
		CuadradoNumericoRamifica estado = new CuadradoNumericoRamifica(table);
		long inicio = System.currentTimeMillis();
		problemaAsig.ramificaYPoda(estado);
		long fin = System.currentTimeMillis();
		
		assertNotNull(problemaAsig.getMejorSolucion());
		System.out.println(name + " 	TIEMPO = " + (fin-inicio));
		System.out.println(problemaAsig.getMejorSolucion());
	}
	
	@Test
	public void test2() {
		String name = "test02.txt";
		loadData(PATH + name);
		RamificaYPoda problemaAsig = new RamificaYPoda(false);
		CuadradoNumericoRamifica estado = new CuadradoNumericoRamifica(table);
		long inicio = System.currentTimeMillis();
		problemaAsig.ramificaYPoda(estado);
		long fin = System.currentTimeMillis();
		
		assertNotNull(problemaAsig.getMejorSolucion());
		System.out.println(name + " 	TIEMPO = " + (fin-inicio));
		System.out.println(problemaAsig.getMejorSolucion());

	}
	
	@Test
	public void test3() {
		String name = "test03.txt";
		loadData(PATH + name);
		RamificaYPoda problemaAsig = new RamificaYPoda(false);
		CuadradoNumericoRamifica estado = new CuadradoNumericoRamifica(table);
		long inicio = System.currentTimeMillis();
		problemaAsig.ramificaYPoda(estado);
		long fin = System.currentTimeMillis();
		
		assertNotNull(problemaAsig.getMejorSolucion());
		System.out.println(name + " 	TIEMPO = " + (fin-inicio));
		System.out.println(problemaAsig.getMejorSolucion());
	}
	
	@Test
	public void test4() {
		String name = "test04.txt";
		loadData(PATH + name);
		RamificaYPoda problemaAsig = new RamificaYPoda(false);
		CuadradoNumericoRamifica estado = new CuadradoNumericoRamifica(table);
		long inicio = System.currentTimeMillis();
		problemaAsig.ramificaYPoda(estado);
		long fin = System.currentTimeMillis();
		
		assertNotNull(problemaAsig.getMejorSolucion());
		System.out.println(name + " 	TIEMPO = " + (fin-inicio));
		System.out.println(problemaAsig.getMejorSolucion());
	}
	
	@Test
	public void test5() {
		String name = "test05.txt";
		loadData(PATH + name);
		RamificaYPoda problemaAsig = new RamificaYPoda(false);
		CuadradoNumericoRamifica estado = new CuadradoNumericoRamifica(table);
		long inicio = System.currentTimeMillis();
		problemaAsig.ramificaYPoda(estado);
		long fin = System.currentTimeMillis();
		
		assertNotNull(problemaAsig.getMejorSolucion());
		System.out.println(name + " 	TIEMPO = " + (fin-inicio));
		System.out.println(problemaAsig.getMejorSolucion());
	}
	
	@Test
	public void test6() {
		String name = "test06.txt";
		loadData(PATH + name);
		RamificaYPoda problemaAsig = new RamificaYPoda(false);
		CuadradoNumericoRamifica estado = new CuadradoNumericoRamifica(table);
		long inicio = System.currentTimeMillis();
		problemaAsig.ramificaYPoda(estado);
		long fin = System.currentTimeMillis();
		
		assertNotNull(problemaAsig.getMejorSolucion());
		System.out.println(name + " 	TIEMPO = " + (fin-inicio));
		System.out.println(problemaAsig.getMejorSolucion());
	}
	
	@Test
	public void test7() {
		String name = "test07.txt";
		loadData(PATH + name);
		RamificaYPoda problemaAsig = new RamificaYPoda(false);
		CuadradoNumericoRamifica estado = new CuadradoNumericoRamifica(table);
		long inicio = System.currentTimeMillis();
		problemaAsig.ramificaYPoda(estado);
		long fin = System.currentTimeMillis();
		
		assertNotNull(problemaAsig.getMejorSolucion());
		System.out.println(name + " 	TIEMPO = " + (fin-inicio));
		System.out.println(problemaAsig.getMejorSolucion());
	}

	/**
	 * Load data from file and store in array with operations and results
	 * @param file
	 */
	private void loadData(String file) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			int i = 0;
			int size = Integer.valueOf(reader.readLine());
			this.table = new String[size*2+1][size*2+1]; //the number of rows and columns are twice + 1 the number of operations in each direction
			while (reader.ready()) { //each line
				String[] parts = reader.readLine().split(" ");
				int j = 0; //columns
				for (String part : parts) {
					this.table[i][j] = part; 
					if ((i%2 == 1)||(i == size*2)) //to separate operators in odd rows (i%2 == 1) and in the last row (i == size*2)
						j++; //we skip an extra column to create the table
					j++;
				}
				i++; //next line
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * Converts a table including numbers, operations and results to a table with only numbers but in String format
	 * @param sol table with operations and results
	 * @return numTable converted to only numeric values
	 */
	private String[][] convertNum(String[][] sol) {
		int numSize= sol.length/2;  // number table size
		String[][] numTable= new String[numSize][numSize];
		
		int a= 0; int b= 0;  // number table index
		for (int i = 0; i < sol.length-2; i+= 2) {  // sol.length-2 because we don't convert the result
			for (int j = 0; j < sol.length-2; j+= 2) {
				if (sol[i][j] != null) {
					numTable[a][b]= sol[i][j];
					b++;
				}
			}
			a++; b= 0;
		}

		return numTable;
	}
	
	/**
	 * Print any two-dimensional table with a title via console
	 * @param table for printing
	 * @param title
	 */
	private void printTable(String[][] table, String title) {
		if (title != null)
			System.out.printf("NUMERIC SQUARE - %s\n", title);
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (table[i][j] == null)
					System.out.printf("%5s", "");
				else
					System.out.printf("%5s", table[i][j]);
			}
			System.out.printf("\n\n");
		}
	}


}
