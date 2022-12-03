package cl.ucn.taller03.logica;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cl.ucn.taller03.dominio.Arma;
import cl.ucn.taller03.dominio.Brazo;
import cl.ucn.taller03.dominio.Cabeza;
import cl.ucn.taller03.dominio.Pierna;
import cl.ucn.taller03.dominio.Pieza;
import cl.ucn.taller03.dominio.Robot;
import cl.ucn.taller03.dominio.RobotAlien;
import cl.ucn.taller03.dominio.RobotHumano;
import cl.ucn.taller03.dominio.Torax;

public class GuardarTxt {

	public void guardarTxtPiezas(List<Pieza> lista) throws IOException {

		List<Pieza> listaPiezas = new ArrayList<Pieza>();

		FileWriter piezas = new FileWriter("src\\cl\\ucn\\taller03\\txt\\piezas.txt");

		for (Pieza p : lista) {
			if (!(p instanceof Arma)) {
				listaPiezas.add(p);
			}
		}

		int ultimaLinea = listaPiezas.size() - 1;

		for (int i = 0; i < listaPiezas.size(); i++) {

			Pieza aux = listaPiezas.get(i);

			if (aux instanceof Cabeza) {
				Cabeza c = (Cabeza) aux;

				String nombre = c.getNombre();
				String rareza = c.getRareza();
				String tipo = "C";
				int velocidad = c.getVelocidad();
				int vida = c.getVida();

				String linea = nombre + "," + rareza + "," + tipo + "," + velocidad + "," + vida;

				if (ultimaLinea == i) {
					piezas.write(linea);
				} else {
					piezas.write(linea + "\n");
				}

			} else if (aux instanceof Pierna) {
				Pierna p = (Pierna) aux;

				String nombre = p.getNombre();
				String rareza = p.getRareza();
				String tipo = "P";
				int velocidad = p.getVelocidad();

				String linea = nombre + "," + rareza + "," + tipo + "," + velocidad;

				if (ultimaLinea == i) {
					piezas.write(linea);
				} else {
					piezas.write(linea + "\n");
				}

			} else if (aux instanceof Brazo) {
				Brazo b = (Brazo) aux;

				String nombre = b.getNombre();
				String rareza = b.getRareza();
				String tipo = "B";
				int ataque = b.getAtaque();

				String linea = nombre + "," + rareza + "," + tipo + "," + ataque;

				if (ultimaLinea == i) {
					piezas.write(linea);
				} else {
					piezas.write(linea + "\n");
				}

			} else if (aux instanceof Torax) {
				Torax t = (Torax) aux;

				String nombre = t.getNombre();
				String rareza = t.getRareza();
				String tipo = "T";
				int vida = t.getVida();

				String linea = nombre + "," + rareza + "," + tipo + "," + vida;

				if (ultimaLinea == i) {
					piezas.write(linea);
				} else {
					piezas.write(linea + "\n");
				}
			}
		}

		piezas.close();

	}

	public void guardarTxtArmas(List<Pieza> listaPiezas) throws IOException {

		List<Pieza> listaArmas = new ArrayList<Pieza>();

		FileWriter armas = new FileWriter("src\\cl\\ucn\\taller03\\txt\\armas.txt");

		for (Pieza p : listaPiezas) {
			if (p instanceof Arma) {
				listaArmas.add(p);
			}
		}

		int ultimaLinea = listaArmas.size() - 1;

		for (int i = 0; i < listaArmas.size(); i++) {

			Arma a = (Arma) listaArmas.get(i);

			String nombre = listaArmas.get(i).getNombre();
			int daño = a.getDaño();
			int velocidadAtaque = a.getVelocidadDeAtaque();

			String linea = nombre + "," + daño + "," + velocidadAtaque;

			if (ultimaLinea == i) {
				armas.write(linea);
			} else {
				armas.write(linea + "\n");
			}
		}

		armas.close();

	}

	public void guardarCombates(List<String> lista) throws IOException {

		int ultimaLinea = lista.size() - 1;

		FileWriter combates = new FileWriter("src\\cl\\ucn\\taller03\\txt\\combates.txt");

		for (int i = 0; i < lista.size(); i++) {

			if (ultimaLinea == i) {
				combates.write(lista.get(i));
			} else {
				combates.write(lista.get(i) + "\n");
			}

		}
		combates.close();
	}

	public void guardarRobots(List<Robot> lista) throws IOException {

		int ultimaLinea = lista.size() - 1;

		FileWriter robots = new FileWriter("src\\cl\\ucn\\taller03\\txt\\robots.txt");

		for (int i = 0; i < lista.size(); i++) {

			Robot r = lista.get(i);

			String nombre = r.getNombre();

			if (r instanceof RobotHumano) {

				RobotHumano rHumano = (RobotHumano) r;

				String piezas = generarPiezas(r);
				String tipo = "H";
				String nombrePiloto = rHumano.getNombrePiloto().getPiloto();
				String equipo = rHumano.getEquipoMantencion().getNombreEquipo();

				String linea = nombre + piezas + "," + tipo + "," + nombrePiloto + "," + equipo;

				if (ultimaLinea == i) {
					robots.write(linea);
				} else {
					robots.write(linea + "\n");
				}

			} else if (r instanceof RobotAlien) {

				RobotAlien rAlien = (RobotAlien) r;

				String piezas = generarPiezas(r);
				String tipo = "A";
				String clase = rAlien.getClase();

				String linea = nombre + piezas + "," + tipo + "," + clase;

				if (ultimaLinea == i) {
					robots.write(linea);
				} else {
					robots.write(linea + "\n");
				}

			}

		}

		robots.close();

	}

	private String generarPiezas(Robot r) {

		String piezas = "";

		for (int i = 0; i < 5; i++) {

			Pieza aux = r.getLista().getIndex(i);

			if (aux == null) {
				piezas += ",null";
			} else {
				piezas += "," + aux.getNombre();
			}
		}

		return piezas;
	}

}
