package cl.ucn.taller03.logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cl.ucn.taller03.dominio.Arma;
import cl.ucn.taller03.dominio.Pieza;
import cl.ucn.taller03.ventanas.Inicio;

public class SistemaRobot implements Sistema{

	private List<Pieza> listaPiezas;
	private Inicio app;
	
	public SistemaRobot() {
		listaPiezas = new ArrayList<Pieza>();
		app = new Inicio();
	}
	
	@Override
	public void iniciarApp() {
		app.setVisible(true);
	}

	@Override
	public void leerArchivos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarPieza(String info) {
		
		String[] datos = info.split(",");
		String tipoPieza = datos[0];
		
		
		if(tipoPieza.equals("P")) {
			
		}else if(datos.length == 3) {
			Pieza arma = new Arma(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]));
			listaPiezas.add(arma);
			System.out.println(listaPiezas.toString()  );
		}
		
	}
	
	

}
