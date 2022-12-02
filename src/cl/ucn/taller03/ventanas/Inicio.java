package cl.ucn.taller03.ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cl.ucn.taller03.logica.Sistema;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Inicio extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Sistema sist;
	
	private JButton salir, simulacion, victoriasPorLaHumanidad, robotPorEquipo, mostrarRobotPiloto, mostrarEstadisticas,
			cambiarPiezaRobot, ensamblarRobot, opcionaAddPieza;
	private JButton btnCambiarArma;
	
	

	/**
	 * Create the frame.
	 */
	public Inicio(Sistema sist) {

		this.sist = sist;
		setOpacity(1.0f);
		setForeground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\iconBarra.jpg"));
		setTitle("Menu de Opciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 427);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		iniciarComponentes();

		setLocationRelativeTo(null);// Deja centrada la ventana
		setResizable(false);// No deja que se reescale la ventana para que la intefaz no cambie

	}

	private void iniciarComponentes() {
		// Titulo centrado arriba a la izquierda
		//
		JLabel titulo = new JLabel("Menu");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		titulo.setBounds(8, 8, 94, 32);
		contentPane.add(titulo);

		// Boton para crear un objeto pieza con las entradas que dará el usuario
		opcionaAddPieza = new JButton("Añadir Pieza");
		opcionaAddPieza.setFont(new Font("Tahoma", Font.BOLD, 14));
		opcionaAddPieza.setBounds(57, 112, 236, 32);
		opcionaAddPieza.addActionListener(this);
		contentPane.add(opcionaAddPieza);

		// Se define con las piezas disponibles un nuevo robot
		ensamblarRobot = new JButton("Ensamblar Robot");
		ensamblarRobot.setFont(new Font("Tahoma", Font.BOLD, 14));
		ensamblarRobot.setBounds(361, 112, 233, 32);
		ensamblarRobot.addActionListener(this);
		contentPane.add(ensamblarRobot);

		// Con el nombre de un robot se accede a su lista de piezas para poder cambiar
		// alguna
		cambiarPiezaRobot = new JButton("Cambiar pieza");
		cambiarPiezaRobot.setFont(new Font("Tahoma", Font.BOLD, 14));
		cambiarPiezaRobot.setBounds(57, 179, 236, 32);
		cambiarPiezaRobot.addActionListener(this);
		contentPane.add(cambiarPiezaRobot);

		// Muestra las estadisticas de los robot en general
		mostrarEstadisticas = new JButton("Mostrar Estadisticas");
		mostrarEstadisticas.setFont(new Font("Tahoma", Font.BOLD, 14));
		mostrarEstadisticas.setBounds(361, 310, 233, 32);
		mostrarEstadisticas.addActionListener(this);
		contentPane.add(mostrarEstadisticas);

		//
		mostrarRobotPiloto = new JButton("Buscar piloto y sus Robots");
		mostrarRobotPiloto.setFont(new Font("Tahoma", Font.BOLD, 14));
		mostrarRobotPiloto.setBounds(57, 247, 236, 32);
		mostrarRobotPiloto.addActionListener(this);
		contentPane.add(mostrarRobotPiloto);

		// Se ingresa el nombre del equipo y se muestra por pantalla los robot que estan
		// vinculados a ese equipo
		robotPorEquipo = new JButton("Buscar robot por Equipo");
		robotPorEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		robotPorEquipo.setBounds(361, 247, 233, 32);
		robotPorEquipo.addActionListener(this);
		contentPane.add(robotPorEquipo);

		victoriasPorLaHumanidad = new JButton("%Victorias");
		victoriasPorLaHumanidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		victoriasPorLaHumanidad.setBounds(57, 310, 236, 32);
		victoriasPorLaHumanidad.addActionListener(this);
		contentPane.add(victoriasPorLaHumanidad);

		simulacion = new JButton("Iniciar Simulacion");
		simulacion.setBackground(Color.LIGHT_GRAY);
		simulacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		simulacion.setBounds(157, 33, 326, 53);
		simulacion.addActionListener(this);
		contentPane.add(simulacion);

		// Guardara todos los datos en un txt
		salir = new JButton("Salir");
		salir.setBackground(Color.RED);
		salir.setForeground(Color.DARK_GRAY);
		salir.setFont(new Font("Tahoma", Font.BOLD, 14));
		salir.setBounds(510, 350, 153, 32);
		salir.addActionListener(this);
		contentPane.add(salir);
		
		btnCambiarArma = new JButton("Cambiar Arma");
		btnCambiarArma.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarArma.setBounds(361, 179, 236, 32);
		btnCambiarArma.addActionListener(this);
		contentPane.add(btnCambiarArma);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (salir == e.getSource()) {
			this.dispose();
		}
		if (simulacion == e.getSource()) {

		}
		if(victoriasPorLaHumanidad == e.getSource()) {
			
		}
		if(robotPorEquipo == e.getSource()) {
			BuscarRobotPorEquipo buscadorEquipo = new BuscarRobotPorEquipo(sist);
			buscadorEquipo.setVisible(true);
			
		}
		if(mostrarRobotPiloto == e.getSource()) {
			BuscarRobotPorPiloto buscarPiloto = new BuscarRobotPorPiloto(sist);
			buscarPiloto.setVisible(true);
		}
		if(mostrarEstadisticas == e.getSource()) {
			Estadistica estadistica = new Estadistica(sist);
			estadistica.setVisible(true);
		}
		if(cambiarPiezaRobot == e.getSource()) {
			CambiarPieza cambiarPieza = new CambiarPieza(sist);
			cambiarPieza.setVisible(true);
		}
		if(ensamblarRobot == e.getSource()) {
			EnsamblarRobot ensamblar = new EnsamblarRobot(sist);
			ensamblar.setVisible(true);
		}
		if(opcionaAddPieza == e.getSource()) {
			CrearPieza addPiezas = new CrearPieza(sist);
			addPiezas.setVisible(true);
		}
		if(btnCambiarArma == e.getSource()) {
			CambiarArmas cambiarArma = new CambiarArmas(sist);
			cambiarArma.setVisible(true);
		}

	}
}
