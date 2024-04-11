package algestudiante.p6;

public class p {

	public static void main(String[] args) {
		CuadradoNumerico cuadradoNumerico = new CuadradoNumerico();
		cuadradoNumerico.loadData("src/main/java/algestudiante/p6/test00.txt");
		cuadradoNumerico.createTable();
		cuadradoNumerico.printTable();
	}

}
