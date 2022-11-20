package cl.ucn.taller03.logica;

import java.util.ArrayList;
import java.util.List;

import cl.ucn.taller03.dominio.Arma;
import cl.ucn.taller03.dominio.Brazo;
import cl.ucn.taller03.dominio.Pierna;
import cl.ucn.taller03.dominio.Pieza;
import cl.ucn.taller03.dominio.Torax;
import cl.ucn.taller03.ventanas.Inicio;

public class SistemaRobot implements Sistema {

	private List<Pieza> listaPiezas;
	private Inicio app;
	private Sistema sist;

	public SistemaRobot() {
		listaPiezas = new ArrayList<Pieza>();

	}

	@Override
	public void iniciarApp(Sistema sist) {
		this.sist = sist;
		app = new Inicio(sist);
		app.setVisible(true);
	}

	@Override
	public void guardarPieza(String info) {

		String[] datos = info.split(",");
		String nombre = datos[0];
		String tipoDePieza = datos[2];

		int vidaExtra = generarVidaExtra(datos[1]);
		int dañoExtra = generarDañoExtra(datos[1]);

		Pieza buscar = verificarPieza(nombre);

		if (buscar == null) {
			// CREAR Y GUARDAR EL ARMA
			// INGRESADA/////////////////////////////////////////////////
			if (datos.length == 3) {
				int daño = Integer.parseInt(datos[1]);
				int velocidadAtaque = Integer.parseInt(datos[2]);

				Pieza nuevaArma = new Arma(nombre, daño, velocidadAtaque);
				listaPiezas.add(nuevaArma);

				// CREA Y GUARDA PIERNAS/////////////////////////////////////////////////
			} else if (tipoDePieza.equals("P")) {

				// nombre
				String rareza = datos[1];
				// tipo de pieza
				int velocidad = Integer.parseInt(datos[3]);

				Pieza nuevaPierna = new Pierna(nombre, velocidad);

				nuevaPierna.añadirMasVidaBase(vidaExtra);
				nuevaPierna.setRareza(rareza);
				nuevaPierna.setAtaqueExtra(dañoExtra);

				listaPiezas.add(nuevaPierna);
				
				// CREA Y GUARDA BRAZOS/////////////////////////////////////////////////
			}else if(tipoDePieza.equals("B")) {
				
				//nombre
				String rareza = datos[1];
				//tipo de pieza
				int ataque = Integer.parseInt(datos[3]);
				
				Pieza nuevoBrazo = new Brazo(nombre,ataque);
				
				nuevoBrazo.añadirMasVidaBase(vidaExtra);
				nuevoBrazo.setRareza(rareza);
				nuevoBrazo.setAtaqueExtra(dañoExtra);
				
				listaPiezas.add(nuevoBrazo);
				
				// CREA Y GUARDA TORAX/////////////////////////////////////////////////
			}else if(tipoDePieza.equals("T")) {
				
				//nombre
				String rareza = datos[1];
				//tipo de pieza
				int vida = Integer.parseInt(datos[3]);
				
				Pieza nuevoTorax = new Torax(nombre,vida);
				
				nuevoTorax.añadirMasVidaBase(vidaExtra);
				nuevoTorax.setRareza(rareza);
				nuevoTorax.setAtaqueExtra(dañoExtra);
				
				listaPiezas.add(nuevoTorax);
				
			}
		}

		mostrarLista();
		System.out.println("Tamaño = " + listaPiezas.size());
	}

	private int generarDañoExtra(String tipoDePieza) {
		if (tipoDePieza.equals("PP")) {
			return 200;
		} else if (tipoDePieza.equals("PE")) {
			return 100;
		} else {
			return 0;
		}
	}

	// Verifica si la pieza existe y devolvera un no nulo si lo encuentra
	private Pieza verificarPieza(String nombre) {
		for (Pieza p : listaPiezas) {
			if (p.getNombre().equals(nombre)) {
				return p;
			}
		}
		return null;
	}

	// Generar estadisticas nuevas
	private int generarVidaExtra(String tipo) {
		if (tipo.equals("PP")) {
			return 3000;
		} else if (tipo.equals("PE")) {
			return 2000;
		} else {
			return 1000;
		}
	}

	public void mostrarLista() {
		System.out.println(listaPiezas.toString());
	}

}
