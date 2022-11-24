package cl.ucn.taller03.logica;

import java.util.ArrayList;
import java.util.List;

import cl.ucn.taller03.dominio.Arma;
import cl.ucn.taller03.dominio.Brazo;
import cl.ucn.taller03.dominio.Cabeza;
import cl.ucn.taller03.dominio.Equipo;
import cl.ucn.taller03.dominio.Pierna;
import cl.ucn.taller03.dominio.Pieza;
import cl.ucn.taller03.dominio.Piloto;
import cl.ucn.taller03.dominio.Robot;
import cl.ucn.taller03.dominio.RobotAlien;
import cl.ucn.taller03.dominio.RobotHumano;
import cl.ucn.taller03.dominio.Torax;
import cl.ucn.taller03.ventanas.Inicio;

public class SistemaRobot implements Sistema {

	private List<Pieza> listaPiezas;
	private List<Piloto> listaPilotos;
	private List<Equipo> listaEquipos;
	private List<Robot> listaRobots;
	private List<String> registroCombates;
	private Inicio app;

	public SistemaRobot() {
		listaPiezas = new ArrayList<Pieza>();
		listaRobots = new ArrayList<Robot>();
		listaPilotos = new ArrayList<Piloto>();
		listaEquipos = new ArrayList<Equipo>();
	}

	@Override
	public void iniciarApp(Sistema sist) {
		app = new Inicio(sist);
		app.setVisible(true);
	}

	@Override
	public void guardarPieza(String info) {

		String[] datos = info.split(",");
		String nombre = datos[0];
		String tipoDePieza = datos[2];

		int vidaExtra = generarVidaExtra(datos[1]);// Define un extra de puntos de vida dependiendo la rareza de la
													// pieza
		int dañoExtra = generarDañoExtra(datos[1]);// Define un extra de ataque dependiendo la rareza de la pieza

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
			} else if (tipoDePieza.equals("B")) {

				// nombre
				String rareza = datos[1];
				// tipo de pieza
				int ataque = Integer.parseInt(datos[3]);

				Pieza nuevoBrazo = new Brazo(nombre, ataque);

				nuevoBrazo.añadirMasVidaBase(vidaExtra);
				nuevoBrazo.setRareza(rareza);
				nuevoBrazo.setAtaqueExtra(dañoExtra);

				listaPiezas.add(nuevoBrazo);

				// CREA Y GUARDA TORAX/////////////////////////////////////////////////
			} else if (tipoDePieza.equals("T")) {

				// nombre
				String rareza = datos[1];
				// tipo de pieza
				int vida = Integer.parseInt(datos[3]);

				Pieza nuevoTorax = new Torax(nombre, vida);

				nuevoTorax.añadirMasVidaBase(vidaExtra);
				nuevoTorax.setRareza(rareza);
				nuevoTorax.setAtaqueExtra(dañoExtra);

				listaPiezas.add(nuevoTorax);

				// CREA Y GUARDA UNA CABEZA //////////////////////////////////////////
			} else if (tipoDePieza.equals("C")) {

				// nombre = datos[0]
				String rareza = datos[1];
				// tipo de pieza = datos[2]
				int velocidad = Integer.parseInt(datos[3]);
				int vida = Integer.parseInt(datos[4]);

				Pieza nuevaCabeza = new Cabeza(nombre, velocidad, vida);

				nuevaCabeza.añadirMasVidaBase(vidaExtra);
				nuevaCabeza.setRareza(rareza);
				nuevaCabeza.setAtaqueExtra(dañoExtra);

				listaPiezas.add(nuevaCabeza);
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

	@Override
	public void guardarRobot(String linea) {

		String[] datos = linea.split(",");

		String nombreRobot = datos[0];
		String tipoRobot = datos[6];

		// Se crean al piloto y al Equipo a la vez

		if (tipoRobot.equals("A")) {

			String claseRobot = datos[7];
			int[] powerUp = puntosExtrasVidaDaño(claseRobot);

			if (verificarRobot(nombreRobot) == null) {
				Robot nuevo = new RobotAlien(nombreRobot, claseRobot, powerUp[0], powerUp[1]);
				designarPiezasRobot(nuevo, datos);
				listaRobots.add(nuevo);
			}
		} else if (tipoRobot.equals("H")) {

			String nombrePiloto = datos[7];
			String nombreEquipo = datos[8];

			Piloto nuevoPiloto = verificarPiloto(nombrePiloto);
			Equipo nuevoEquipo = verificarEquipo(nombreEquipo);

			Robot nuevo = verificarRobot(nombreRobot);

			if (nuevo == null) {

				Robot nuevoRobot = new RobotHumano(nombreRobot);

				if (nuevoPiloto == null) {
					nuevoPiloto = new Piloto(nombrePiloto);
					nuevoPiloto.getLista().agregarRobot(nuevoRobot);

				} else {
					nuevoPiloto.getLista().agregarRobot(nuevoRobot);
				}

				if (nuevoEquipo == null) {
					nuevoEquipo = new Equipo(nombreEquipo);
					nuevoEquipo.getLista().agregarRobot(nuevoRobot);
				} else {
					nuevoEquipo.getLista().agregarRobot(nuevoRobot);
				}

				nuevoPiloto.setEquipo(nuevoEquipo);
				nuevoEquipo.setPiloto(nuevoPiloto);

				RobotHumano setearRobot = (RobotHumano) nuevoRobot;
				setearRobot.setEquipoMantencion(nuevoEquipo);
				setearRobot.setNombrePiloto(nuevoPiloto);

				designarPiezasRobot(nuevoRobot, datos);

				listaRobots.add(nuevoRobot);
				listaPilotos.add(nuevoPiloto);
				listaEquipos.add(nuevoEquipo);

			} else {

				RobotHumano setearRobot = (RobotHumano) nuevo;

				if (nuevoPiloto == null) {
					nuevoPiloto = new Piloto(nombrePiloto);
					nuevoPiloto.getLista().agregarRobot(setearRobot);

				} else {
					nuevoPiloto.getLista().agregarRobot(setearRobot);
				}

				if (nuevoEquipo == null) {
					nuevoEquipo = new Equipo(nombreEquipo);
					nuevoEquipo.getLista().agregarRobot(setearRobot);
				} else {
					nuevoEquipo.getLista().agregarRobot(setearRobot);
				}

				nuevoPiloto.setEquipo(nuevoEquipo);
				nuevoEquipo.setPiloto(nuevoPiloto);

				setearRobot.setEquipoMantencion(nuevoEquipo);
				setearRobot.setNombrePiloto(nuevoPiloto);

				listaRobots.add(setearRobot);
			}

		}

		System.out.println(listaRobots.toString());

	}

	private Equipo verificarEquipo(String nombreEquipo) {
		for (Equipo p : listaEquipos) {
			if (p.getNombreEquipo().equals(nombreEquipo)) {
				return p;
			}
		}
		return null;
	}

	private Piloto verificarPiloto(String nombre) {
		for (Piloto p : listaPilotos) {
			if (p.getPiloto().equals(nombre)) {
				return p;
			}
		}
		return null;
	}

	private Pieza buscarPiezas(String nombre) {
		for (Pieza p : listaPiezas) {
			if (p.getNombre().equals(nombre)) {
				return p;
			}
		}
		return null;
	}

	private boolean verificarNull(Object o) {
		return o != null;
	}

	private Robot verificarRobot(String nombre) {
		for (Robot r : listaRobots) {
			if (r.getNombre().equals(nombre)) {
				return r;
			}
		}
		return null;
	}

	// PUNTOS EXTRAS POR CLASE DE ROBOT ALIEN

	private int[] puntosExtrasVidaDaño(String clase) {

		int[] powerUp = new int[2];

		if (clase.equals("SS+")) {
			powerUp[0] = 5000;
			powerUp[1] = 500;
		} else if (clase.equals("S+")) {
			powerUp[0] = 3000;
			powerUp[1] = 400;
		} else if (clase.equals("S")) {
			powerUp[0] = 2000;
			powerUp[1] = 300;
		} else if (clase.equals("A")) {
			powerUp[0] = 1000;
			powerUp[1] = 200;
		} else if (clase.equals("B")) {
			powerUp[0] = 500;
			powerUp[1] = 100;
		}

		return powerUp;
	}

	// METODO QUE CREA UN ROBOT

	// METODO QUE RECIBA A UN ROBOT Y LE DESIGNE LAS PIEZAS

	private void designarPiezasRobot(Robot robot, String[] datos) {
		for (int i = 1; i < 6; i++) {
			String buscarPieza = datos[i];
			Pieza encontrada = buscarPiezas(buscarPieza);
			if (verificarNull(encontrada)) {
				if (!verificarUsoPieza(encontrada)) {
					robot.getLista().agregarPieza(encontrada);
				}
			}
		}
	}

	// METODO QUE RECORRE TODAS LAS LISTAS DE ROBOT Y SU LISTA INTERNA POR SI
	// ENCUENTRA LA PIEZA Y VERIFICAR SI ESTA EN USO O NO

	private boolean verificarUsoPieza(Pieza p) {
		for (Robot r : listaRobots) {
			if (r.getLista().verificarExiste(p)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String bucarListaRobotsPorPiloto(String text) {

		Piloto buscarPilot = buscarPiloto(text);

		if (buscarPilot == null) {
			return "Piloto no encontrado!";
		} else {
			return generarListaStringRobots(buscarPilot);
		}

	}

	private String generarListaStringRobots(Piloto p) {

		String lineaString = "Nombre del Piloto: " + p.getPiloto() + " \n";

		for (int i = 0; i < p.getLista().getCantidad(); i++) {
			lineaString += ("Robot [" + (i + 1) + "] " + p.getLista().index(i).getNombre() + "\n");
		}

		return lineaString;

	}

	private Piloto buscarPiloto(String nombre) {
		for (Piloto p : listaPilotos) {
			if (p.getPiloto().equalsIgnoreCase(nombre)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public String buscarListaRobotPorEquipo(String text) {
		Equipo buscarEquipo = buscarEquipoRobot(text);

		if (buscarEquipo == null) {
			return "Equipo no encotrado";
		} else {
			return generarListaStringRobotsEquipo(buscarEquipo);
		}
	}

	private String generarListaStringRobotsEquipo(Equipo buscarEquipo) {

		String datosString = "Nombre del equipo: " + buscarEquipo.getNombreEquipo() + "\n";

		for (int i = 0; i < buscarEquipo.getLista().getCantidad(); i++) {

			datosString += "Robot[" + (i + 1) + "]" + buscarEquipo.getLista().index(i).getNombre() + "\n";

		}
		return datosString;

	}

	private Equipo buscarEquipoRobot(String text) {
		for (Equipo e : listaEquipos) {
			if (e.getNombreEquipo().equalsIgnoreCase(text)) {
				return e;
			}
		}
		return null;
	}

	@Override
	public void guardarCombates(String linea) {
		registroCombates.add(linea);
	}

	// CREAR UN METODO QUE DIGA SI EXISTE EL PILOTO Y DEVUELVA SU REFERENCIA
	// CREAR OTRO METODO QUE RECIBA ESE PILOTO Y VERIFIQUE SI TIENO O NO DESIGNADO
	// UN ROBOT EN EL CASO DE QUE NO LO TENGA SE LE DESIGNA EL ROBOT RECIEN CREADO

	/**
	 * private Robot crearRobot(String nombre, String tipo, String clase, Piloto
	 * piloto , Equipo equipo) { Robot nuevo = null; if(tipo.equals("A")) { nuevo =
	 * new RobotAlien(nombre, clase); }else if(tipo.equals("H")) { nuevo = new
	 * RobotHumano(nombre, piloto, equipo); } return nuevo; }
	 **/

	/**
	 * private Piloto registrarPiloto(String nombre) {
	 * 
	 * } private boolean verificarPilotoExiste(String piloto) { for(Piloto p:
	 * listaPilotos) { if(p.getPiloto().equals(piloto)) { return true; } } return
	 * false; }
	 **/

}
