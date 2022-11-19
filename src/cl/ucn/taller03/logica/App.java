package cl.ucn.taller03.logica;

import cl.ucn.taller03.ventanas.Inicio;

public class App {
	
	public static void main(String[] args) {
		
		ejecutarPaginaInicio();
	}

	private static void ejecutarPaginaInicio() {
		
		Inicio ventanaPrincipal = new Inicio();
		ventanaPrincipal.setVisible(true);
		
	}

}
