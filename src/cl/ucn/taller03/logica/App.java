package cl.ucn.taller03.logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {

		Sistema sist = new SistemaRobot();
		Scanner leer = null;

		leerArchivos(leer, sist);
		ejecutarPaginaInicio(sist);

	}

	private static void leerArchivos(Scanner leer, Sistema sist) throws FileNotFoundException {

		leer = new Scanner(new File("src\\cl\\ucn\\taller03\\txt\\piezas.txt"));

		while (leer.hasNextLine()) {
			String linea = leer.nextLine();
			sist.guardarPieza(linea);
		}
		
		leer = new Scanner(new File("src\\cl\\ucn\\taller03\\txt\\robots.txt"));
		
		while(leer.hasNextLine()) {
			String linea = leer.nextLine();
			sist.guardarRobot(linea);
		}
		
		leer = new Scanner(new File("src\\cl\\ucn\\taller03\\txt\\combates.txt"));
		
		while(leer.hasNextLine()) {
			String linea = leer.nextLine();
			sist.guardarCombates(linea);
		}

	}

	private static void ejecutarPaginaInicio(Sistema sist) {
		sist.iniciarApp(sist);
	}

}
