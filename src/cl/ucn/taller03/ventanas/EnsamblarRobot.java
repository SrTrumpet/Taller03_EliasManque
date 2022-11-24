package cl.ucn.taller03.ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cl.ucn.taller03.logica.Sistema;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class EnsamblarRobot extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private Sistema sist;

	// Texto
	private JTextField textNombreRobot;
	private JTextField textNombrePierna;
	private JTextField textNombreBrazo;
	private JTextField textNombreTorax;
	private JTextField textNombreCabeza;
	private JTextField textNombreArma;

	// Labels
	private JLabel lblNombreRobot;
	private JLabel lblNombrePiernas;
	private JLabel lblNombreCabeza;
	private JLabel lblNombreTorax;
	private JLabel lblNombreBrazo;
	private JLabel lblNombreArma;
	private JLabel lblTipoRobot;

	// Choice
	private Choice choiceAlienHumano;
	private JLabel lblClase;
	private Choice choiceClase;
	private JLabel lblNombrePiloto;
	private JTextField textNombrePiloto;
	private JLabel lblNombreEquipo;
	private JTextField textNombreEquipo;

	// Botones
	private JButton btnAtras;
	private JButton btnEnsamblador;

	/**
	 * Create the frame.
	 */
	public EnsamblarRobot(Sistema sist) {
		this.sist = sist;
		setTitle("Ensamblador");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\iconBarra.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		iniciarText();
		iniciarLabels();
		iniciarChoice();
		iniciarBotones();

		setLocationRelativeTo(null);// Deja centrada la ventana
		setResizable(false);// No deja que se reescale la ventana para que la intefaz no cambie
	}

	private void iniciarLabels() {

		lblNombreRobot = new JLabel("Nombre Robot");
		lblNombreRobot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreRobot.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreRobot.setBounds(38, 41, 159, 32);
		contentPane.add(lblNombreRobot);

		lblNombrePiernas = new JLabel("Pierna");
		lblNombrePiernas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePiernas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombrePiernas.setBounds(38, 107, 159, 32);
		contentPane.add(lblNombrePiernas);

		lblNombreBrazo = new JLabel("Brazo");
		lblNombreBrazo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreBrazo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreBrazo.setBounds(38, 165, 159, 32);
		contentPane.add(lblNombreBrazo);

		lblNombreTorax = new JLabel("Torax");
		lblNombreTorax.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTorax.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreTorax.setBounds(38, 226, 159, 32);
		contentPane.add(lblNombreTorax);

		lblNombreCabeza = new JLabel("Cabeza");
		lblNombreCabeza.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCabeza.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreCabeza.setBounds(38, 288, 159, 32);
		contentPane.add(lblNombreCabeza);

		lblNombreArma = new JLabel("Arma");
		lblNombreArma.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreArma.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreArma.setBounds(38, 354, 159, 32);
		contentPane.add(lblNombreArma);

		lblTipoRobot = new JLabel("Tipo");
		lblTipoRobot.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoRobot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoRobot.setBounds(488, 27, 159, 32);
		contentPane.add(lblTipoRobot);

		lblClase = new JLabel("Clase");
		lblClase.setHorizontalAlignment(SwingConstants.CENTER);
		lblClase.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClase.setBounds(488, 128, 159, 32);
		contentPane.add(lblClase);

		lblNombrePiloto = new JLabel("Piloto");
		lblNombrePiloto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePiloto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombrePiloto.setBounds(506, 207, 159, 32);
		contentPane.add(lblNombrePiloto);

		lblNombreEquipo = new JLabel("Equipo");
		lblNombreEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreEquipo.setBounds(506, 309, 159, 32);
		contentPane.add(lblNombreEquipo);
	}

	private void iniciarBotones() {

		btnEnsamblador = new JButton("Ensamblar");
		btnEnsamblador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnsamblador.setBounds(199, 430, 267, 37);
		btnEnsamblador.addActionListener(this);
		contentPane.add(btnEnsamblador);

		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAtras.setBounds(582, 433, 122, 31);
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);
	}

	private void iniciarText() {

		textNombreRobot = new JTextField();
		textNombreRobot.setBounds(230, 41, 236, 32);
		contentPane.add(textNombreRobot);
		textNombreRobot.setColumns(10);

		textNombrePierna = new JTextField();
		textNombrePierna.setColumns(10);
		textNombrePierna.setBounds(230, 107, 236, 32);
		contentPane.add(textNombrePierna);

		textNombreBrazo = new JTextField();
		textNombreBrazo.setColumns(10);
		textNombreBrazo.setBounds(230, 165, 236, 32);
		contentPane.add(textNombreBrazo);

		textNombreTorax = new JTextField();
		textNombreTorax.setColumns(10);
		textNombreTorax.setBounds(230, 226, 236, 32);
		contentPane.add(textNombreTorax);

		textNombreCabeza = new JTextField();
		textNombreCabeza.setColumns(10);
		textNombreCabeza.setBounds(230, 288, 236, 32);
		contentPane.add(textNombreCabeza);

		textNombreArma = new JTextField();
		textNombreArma.setColumns(10);
		textNombreArma.setBounds(230, 354, 236, 32);
		contentPane.add(textNombreArma);

		textNombrePiloto = new JTextField();
		textNombrePiloto.setBounds(506, 252, 159, 32);
		contentPane.add(textNombrePiloto);
		textNombrePiloto.setColumns(10);

		textNombreEquipo = new JTextField();
		textNombreEquipo.setBounds(506, 354, 159, 32);
		contentPane.add(textNombreEquipo);
		textNombreEquipo.setColumns(10);
	}

	private void iniciarChoice() {

		choiceAlienHumano = new Choice();
		choiceAlienHumano.setBounds(506, 65, 159, 32);
		choiceAlienHumano.add("Robot Humano");
		choiceAlienHumano.add("Robot Alien");
		choiceAlienHumano.addItemListener(this);
		contentPane.add(choiceAlienHumano);

		choiceClase = new Choice();
		choiceClase.setBounds(506, 166, 159, 32);
		choiceClase.add("SS+");
		choiceClase.add("S+");
		choiceClase.add("S");
		choiceClase.add("A");
		choiceClase.add("B");
		choiceClase.setEnabled(false);
		contentPane.add(choiceClase);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(btnAtras == e.getSource()) {
			dispose();
		}
		if(btnEnsamblador == e.getSource()) {
			guardarDatosEnsamblador();
		}
	}
	
	
	
	
	
	private void guardarDatosEnsamblador() {
		
		String todosLosDatos = "";
		
		String nombreRobot = textNombreRobot.getText();
		String nombrePiernas = textNombrePierna.getText();
		String nombreBrazo = textNombreBrazo.getText();
		String nombreTorax = textNombreTorax.getText();
		String nombreCabeza = textNombreCabeza.getText();
		String nombreArma = textNombreArma.getText();
		
		String tipoDeRobot = choiceAlienHumano.getSelectedItem();
		
		if(tipoDeRobot.equals("Robot Alien")) {
			String clase = choiceClase.getSelectedItem();
			
			todosLosDatos = nombreRobot+","+nombrePiernas+","+nombreBrazo+","+nombreTorax+","+nombreCabeza+","+nombreArma+",A,"+clase;
			
			sist.guardarRobot(todosLosDatos);
		}else {
			
			String nombrePiloto = textNombrePiloto.getText();
			String nombreEquipo = textNombreEquipo.getText();
			
			todosLosDatos = nombreRobot+","+nombrePiernas+","+nombreBrazo+","+nombreTorax+","+nombreCabeza+","+nombreArma+",H,"+nombrePiloto+","+nombreEquipo;
			
			sist.guardarRobot(todosLosDatos);
		}
		
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(choiceAlienHumano == e.getSource()) {
			if(choiceAlienHumano.getSelectedItem().equals("Robot Alien")) {
				
				lblNombrePiloto.setText("No Disponilbe");
				textNombrePiloto.setEnabled(false);
				
				lblNombreEquipo.setText("No Disponible");
				textNombreEquipo.setEnabled(false);
				
				lblClase.setText("Clase");
				choiceClase.setEnabled(true);
			}else {
				
				lblClase.setText("No disponible");
				choiceClase.setEnabled(false);
				
				lblNombrePiloto.setText("Piloto");
				textNombrePiloto.setEnabled(true);
				
				lblNombreEquipo.setText("Equipo");
				textNombreEquipo.setEnabled(true);
				
			}
		}
	}
	
	
	
	
	
}
