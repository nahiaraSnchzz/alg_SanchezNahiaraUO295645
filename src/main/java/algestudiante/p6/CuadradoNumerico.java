package algestudiante.p6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CuadradoNumerico {
	// calcule para una entrada de tablero dada una solución de la forma más
	// eficiente posible

	private String[][] table;
	private String[][] numTable;
	private String[][] tableroFichero;
	private int tamano;
	private int size;

	public void Main() {
		loadData("test00.txt");
		printTable();
	}

	public void loadData(String fileName) {

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(fileName));
			String tamano = reader.readLine();
			this.tamano = Integer.parseInt(tamano);
			size = Integer.parseInt(tamano) * 2 + 1;

			table = new String[size][size];
			tableroFichero = new String[size][size];
			numTable = new String[this.tamano+1][this.tamano+1];

			while (reader.ready()) {

				String[] parts = reader.readLine().split(" ");

				for (int i = 0; i < tableroFichero.length; i++) {

					for (int j = 0; j < parts.length; j++) {

						tableroFichero[i][j] = parts[j];
					}
					if (i + 1 < tableroFichero.length) {
						parts = reader.readLine().split(" ");

					}
				}
			}

			 createTable();

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

	void createTable() {
		
		for (int i = 0; i < table.length; i++) {
			int count = 0;
			for (int j = 0; j < table[i].length; j++) {

				if ((tableroFichero[i][tableroFichero[i].length - 1]) == null) {

					if (table[i][j] == null && j == tableroFichero[0].length-1){
						table[i][j] = " ";
					}
					
					if (table[i][j] == null) {
						table[i][j] = tableroFichero[i][count];
						table[i][j + 1] = " ";
						count++;

					}

				} else {

					table[i][j] = tableroFichero[i][j];
				}
			}
		}

	}
	
	
	public void convertNum() {
		
		for (int i = 0; i <table.length; i++) {
			int m = 0;
			for (int j = 0; j < table[i].length; j++) {
				if (table[i][j] == "?") {
					numTable[i][m] = table[i][j];
					m++;
				}
			}
		}
	}

	void printTable() {
		int t = 0;
		int p = 0;
		System.out.println();
		System.out.println();

		for (int i = 0; i < table.length; i++) {

			for (int j = 0; j < table[i].length; j++) {

				System.out.print(table[i][j] + "          ");
			}
			System.out.println();
			System.out.println();
		}

		System.out.println();
		System.out.println();

	}

}
