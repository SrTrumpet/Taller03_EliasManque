package cl.ucn.taller03.logica;

public class App {
	
	public static void main(String[] args) {
		
		Sistema sist = new SistemaRobot();
		ejecutarPaginaInicio(sist);
		
	}

	private static void ejecutarPaginaInicio(Sistema sist) {
		sist.iniciarApp();
	}

}
