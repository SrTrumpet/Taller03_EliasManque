package cl.ucn.taller03.ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cl.ucn.taller03.logica.Sistema;
import cl.ucn.taller03.logica.SistemaRobot;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CrearPieza extends JFrame implements ActionListener, ItemListener {

	private Sistema sist;

	// Labels

	private JLabel lblRareza;
	private JLabel lblNombre;
	private JLabel lblTipoPieza;
	private JLabel lblDaño;
	private JLabel lblVelocidadAtaque;

	// TextField
	private JTextField texNombre;
	private JTextField textDaño;
	private JTextField textVelocidadAtaque;

	// Botones
	private JButton btnAtras;
	private JButton btnGuardar;

	// Choice
	private Choice choiceRareza;
	private Choice choiceTipoPieza;

	private JPanel contentPane;
	private JLabel lblDatoEredado;
	private JTextField textDatoExtra;
	private JLabel lblCheck;
	private JLabel lblError;

	/**
	 * Create the frame.
	 */
	public CrearPieza() {
		sist = new SistemaRobot();

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\iconVentana.jpg"));
		setTitle("Añadir Pieza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		iniciarBotones();
		iniciarFields();
		iniciarChoice();
		iniciarLabels();

		setLocationRelativeTo(null);// Deja centrada la ventana
		setResizable(false);// No deja que se reescale la ventana para que la intefaz no cambie
	}

	private void iniciarLabels() {

		lblRareza = new JLabel("Rareza");
		lblRareza.setHorizontalAlignment(SwingConstants.CENTER);
		lblRareza.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRareza.setBounds(31, 113, 178, 31);
		contentPane.add(lblRareza);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(31, 28, 178, 31);
		contentPane.add(lblNombre);

		lblTipoPieza = new JLabel("Tipo Pieza");
		lblTipoPieza.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoPieza.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoPieza.setBounds(217, 112, 178, 31);
		contentPane.add(lblTipoPieza);

		lblDaño = new JLabel("Daño");
		lblDaño.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaño.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDaño.setBounds(31, 189, 178, 31);
		contentPane.add(lblDaño);

		lblVelocidadAtaque = new JLabel("Velocidad Ataque");
		lblVelocidadAtaque.setHorizontalAlignment(SwingConstants.CENTER);
		lblVelocidadAtaque.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVelocidadAtaque.setBounds(217, 189, 178, 31);
		contentPane.add(lblVelocidadAtaque);

		lblDatoEredado = new JLabel("Velocidad");
		lblDatoEredado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatoEredado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatoEredado.setBounds(217, 28, 178, 31);
		contentPane.add(lblDatoEredado);

		lblCheck = new JLabel("");
		lblCheck.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheck.setEnabled(false);
		lblCheck.setIcon(new ImageIcon(
				"D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\iconCheck.png"));
		lblCheck.setBounds(335, 325, 30, 29);
		contentPane.add(lblCheck);

		lblError = new JLabel("");
		lblError.setIcon(new ImageIcon(
				"D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\iconError.png"));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setEnabled(false);
		lblError.setBounds(244, 325, 30, 29);
		contentPane.add(lblError);

	}

	private void iniciarBotones() {

		// BOTON ATRAS
		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAtras.setBounds(31, 286, 178, 31);
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);

		// BOTON GUARDAR
		btnGuardar = new JButton("Añadir");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardar.setBounds(217, 286, 178, 31);
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);
	}

	private void iniciarFields() {

		// CUADRO DE TEXTO "NOMBRE"
		texNombre = new JTextField();
		texNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		texNombre.setBounds(31, 64, 178, 31);
		contentPane.add(texNombre);
		texNombre.setColumns(10);

		// CUADRO DE TEXTO "DAÑO"
		textDaño = new JTextField();
		textDaño.setEnabled(false);
		textDaño.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDaño.setColumns(10);
		textDaño.setBounds(31, 217, 178, 31);
		contentPane.add(textDaño);

		// CUADRO DE TEXTO "VELOCIDAD DE ATAQUE"
		textVelocidadAtaque = new JTextField();
		textVelocidadAtaque.setEnabled(false);
		textVelocidadAtaque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textVelocidadAtaque.setColumns(10);
		textVelocidadAtaque.setBounds(217, 217, 178, 31);
		contentPane.add(textVelocidadAtaque);

		// DATO PARA CREAR LA PIEZA ESPECIFICA
		textDatoExtra = new JTextField();
		textDatoExtra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDatoExtra.setColumns(10);
		textDatoExtra.setBounds(217, 64, 178, 31);
		contentPane.add(textDatoExtra);
	}

	private void iniciarChoice() {

		// Choice Rareza de la pieza
		choiceRareza = new Choice();
		choiceRareza.setBounds(48, 149, 161, 31);
		// Opciones del selector//////////
		choiceRareza.add("Pieza Premium");
		choiceRareza.add("Pieza Estandar");
		choiceRareza.add("Pieza Comun");
		//////////////////////////////////
		contentPane.add(choiceRareza);

		// Choice tipo de Pieza
		choiceTipoPieza = new Choice();
		choiceTipoPieza.setBounds(234, 149, 161, 31);
		// Opcines del selector de tipo de Piezas
		choiceTipoPieza.add("Piernas");
		choiceTipoPieza.add("Brazo");
		choiceTipoPieza.add("Torax");
		choiceTipoPieza.add("Cabeza");
		choiceTipoPieza.add("Arma");
		choiceTipoPieza.addItemListener(this);
		//////////////////////////////////
		contentPane.add(choiceTipoPieza);
	}

	
	private boolean verificarNombreDato() {
		return texNombre.getText().equals("") || textDatoExtra.getText().equals("");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String lineaString = texNombre.getText();
		
		if (btnAtras == e.getSource()) {
			dispose();
		}

		//ACCION DEL BOTON GUARDAR
		if (btnGuardar == e.getSource()) {

			String tipo = choiceTipoPieza.getSelectedItem().toLowerCase();

			if (tipo.equals("arma")) {
				String daño = textDaño.getText();
				String ataqueVelocidad = textVelocidadAtaque.getText();
				
				if(texNombre.getText().equals("")) {
					lblError.setEnabled(true);
					lblCheck.setEnabled(false);
				}else {
					lineaString += ("," + daño + "," + ataqueVelocidad);
					lblCheck.setEnabled(true);
					lblError.setEnabled(false);
					sist.guardarPieza(lineaString);
				}

			}else if(verificarNombreDato()) {
				lblCheck.setEnabled(false);
				lblError.setEnabled(true);
			}
			

		}
	}

	/***
	 * Cambia el estado de la ventana
	 * 
	 * @pre
	 * @post
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {

		String tipo = choiceTipoPieza.getSelectedItem().toLowerCase();

		if (choiceTipoPieza == e.getSource()) {
			if (tipo.equals("arma")) {
				lblDatoEredado.setText("No Disponible");
				textDatoExtra.setEnabled(false);
				choiceRareza.setEnabled(false);
				textVelocidadAtaque.setEnabled(true);
				textDaño.setEnabled(true);
			} else {
				choiceRareza.setEnabled(true);
				textVelocidadAtaque.setEnabled(false);
				textDaño.setEnabled(false);
				textDatoExtra.setEnabled(true);
			}
		}

		if (choiceTipoPieza == e.getSource()) {
			if (tipo.equals("brazo")) {
				lblDatoEredado.setText("Ataque");
			}
		}

		if (choiceTipoPieza == e.getSource()) {
			if (tipo.equals("piernas")) {
				lblDatoEredado.setText("Velocidad");
			}
		}

		if (choiceTipoPieza == e.getSource()) {
			if (tipo.equals("torax")) {
				lblDatoEredado.setText("Vida");
			}
		}

		if (choiceTipoPieza == e.getSource()) {
			if (tipo.equals("cabeza")) {
				lblDatoEredado.setText("Velocidad y Vida");
			}
		}

	}

}
