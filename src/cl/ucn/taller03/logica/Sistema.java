package cl.ucn.taller03.logica;

import java.io.IOException;

public interface Sistema {

	/***
	 * Inicia la interfaz grafica del programa
	 * 
	 * @param sist
	 * @pre --
	 * @post --
	 */
	void iniciarApp(Sistema sist);

	/**
	 * Guarda los datos ingresados de una pieza, ademas de discriminar que tipo es
	 * la pieza a guardar
	 * 
	 * @param info
	 * @pre ----
	 * @post Crea y guarda los datos de una pieza en listaPiezas -
	 */
	void guardarPieza(String info);

	/***
	 * Guarda los datos ingresados de un robot, tanto por txt como por interfaz
	 * grafica, ademas discrimina el tipo de robot que se debe instanciar
	 * 
	 * @param linea
	 * @pre ---
	 * @post Crea y guarda los datos del robot en la listaRobots
	 */
	void guardarRobot(String linea);

	/***
	 * Se obtiene la lista de robot que el piloto maneja
	 * 
	 * @param text
	 * 
	 * @pre el piloto debe de estar registrado
	 * @post ---
	 * @return lista de robots
	 */
	String bucarListaRobotsPorPiloto(String text);

	/***
	 * Se obtiene la lista de robot que realizan la mantencion por el equipo
	 * 
	 * @pre el equipo debe de existir en los registros
	 * @post ---
	 * @param text
	 * @return lista de robots
	 */
	String buscarListaRobotPorEquipo(String text);

	/***
	 * Guarda un registro de cada combate simulado
	 * 
	 * @pre ---
	 * @post Guarda y crea un registro para guardarlo en registroCombates
	 * @param linea
	 */
	void guardarCombates(String linea);

	/***
	 * Se obtiene el robot que esta portando el arma
	 * 
	 * @pre el arma debe estar registrada en listaPiezas
	 * @post --
	 * 
	 * @param nombreArma
	 * @return "disponible" si no esta en uso o Null sino la encuentra o devuelve el
	 *         nombre del robot que la esta usando
	 */
	String buscarNombreArma(String nombreArma);

	/***
	 * Se obtiene al robot y el nombre del arma que esta usando
	 * 
	 * @pre el robot debe estar guardado en listaRobots
	 * @post ---
	 * @param nombreRoboString
	 * @return "no encontrado" sino lo encuentra o
	 */
	String buscarRobot(String nombreRoboString);

	/***
	 * Hace un cambio de arma entre robot, o simplemente instala un arma que no
	 * tenga designado un robot
	 * 
	 * @pre El arma y el robot deben de existir, el arma puede estar disponible o
	 *      vinculada a un robot pero nuna debe ser null
	 * @post Cambia las referencias de robot y de arma
	 * @param arma
	 * @param nombreRobot
	 */
	void cambiarArma(String arma, String nombreRobot);

	/***
	 * Obtiene la disponibilidad de la pieza
	 * 
	 * @pre La pieza debe estar guardada y registrada en la listaPiezas
	 * @post
	 * @param nombreArma
	 * @return
	 */
	String buscarNombrePieza(String nombreArma);

	/***
	 * Obtiene la disponibilidad de la Pieza
	 * 
	 * 
	 * @param nombreRoboString
	 * @param pieza
	 * 
	 * @pre La pieza como el robot deben de existir en sus respectivas listas
	 * @post 
	 * @return
	 */

	String buscarRobotPieza(String nombreRoboString, String pieza);

	/***
	 * Obtiene la disponiblidad de poder ingresar una pieza en el robot, en el caso
	 * de que exista una pieza del mismo tipo a agregar seran intercabiadas
	 * 
	 * 
	 * @param pieza
	 * @param nombreRobot
	 * 
	 * @pre La pieza como el robot deben de existir en sus respectivas listas
	 * @post Se cambian las referencias de vinculo entre la pieza y el robot
	 */
	void cabmiarPieza(String pieza, String nombreRobot);

	String obtenerEstadisticas(String nombreRobot);

	String generarPorcentajeVictorias();
	
	boolean verificarRobots(String linea);
	
	String iniciarSimulacion(String linea);
	
	void guardarArchivos() throws IOException;
}
