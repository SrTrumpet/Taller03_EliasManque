package cl.ucn.taller03.ventanas;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cl.ucn.taller03.logica.Sistema;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CambiarPieza extends JFrame implements ActionListener {

	private Sistema sist;

	private JPanel contentPane;
	private JTextField textNombrePieza;
	private JTextField textNombreRobot;
	private JLabel lblRobotEncontrado;
	private JLabel lblNombreRobot;
	private JLabel lblArmaEnUso;
	private JLabel lblTituloBuscar;
	private JButton btnBuscar;
	private JButton btnAtras;
	private JButton btnCambiarArma;

	/**
	 * Create the frame.
	 */
	public CambiarPieza(Sistema sist) {
		this.sist = sist;
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\iconBarra.jpg"));
		setTitle("Cambiar Arma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		iniciarComponentes();

		setLocationRelativeTo(null);// Deja centrada la ventana
		setResizable(false);// No deja que se reescale la ventana para que la intefaz no cambie
	}

	private void iniciarComponentes() {

		lblTituloBuscar = new JLabel("Ingrese la Pieza");
		lblTituloBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloBuscar.setBounds(22, 31, 171, 34);
		contentPane.add(lblTituloBuscar);

		textNombrePieza = new JTextField();
		textNombrePieza.setBounds(22, 75, 171, 34);
		contentPane.add(textNombrePieza);
		textNombrePieza.setColumns(10);

		lblArmaEnUso = new JLabel("");
		lblArmaEnUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblArmaEnUso.setHorizontalAlignment(SwingConstants.CENTER);
		lblArmaEnUso.setBounds(22, 119, 171, 28);
		contentPane.add(lblArmaEnUso);

		lblNombreRobot = new JLabel("Ingrese el Robot");
		lblNombreRobot.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreRobot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreRobot.setBounds(215, 31, 171, 34);
		contentPane.add(lblNombreRobot);

		textNombreRobot = new JTextField();
		textNombreRobot.setColumns(10);
		textNombreRobot.setBounds(215, 75, 171, 34);
		contentPane.add(textNombreRobot);

		lblRobotEncontrado = new JLabel("");
		lblRobotEncontrado.setHorizontalAlignment(SwingConstants.CENTER);
		lblRobotEncontrado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRobotEncontrado.setBounds(215, 119, 171, 28);
		contentPane.add(lblRobotEncontrado);

		btnCambiarArma = new JButton("Cambiar Arma");
		btnCambiarArma.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarArma.setBounds(22, 212, 171, 34);
		btnCambiarArma.addActionListener(this);
		contentPane.add(btnCambiarArma);

		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAtras.setBounds(215, 212, 171, 34);
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(
				"D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\iconBarra.jpg"));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(117, 168, 151, 34);
		btnBuscar.addActionListener(this);
		contentPane.add(btnBuscar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (btnBuscar == e.getSource()) {

			String nombrePieza = textNombrePieza.getText();
			String nombreRoboString = textNombreRobot.getText();

			String enUso = sist.buscarNombrePieza(nombrePieza);
			String buscarRobot = sist.buscarRobotPieza(nombreRoboString, nombrePieza);

			lblArmaEnUso.setText(enUso);
			lblRobotEncontrado.setText(buscarRobot);

		}
		if (btnCambiarArma == e.getSource()) {

			String arma = textNombrePieza.getText();
			String nombreRobot = textNombreRobot.getText();

			String enUso = sist.buscarNombrePieza(arma);
			String buscarRobot = sist.buscarRobotPieza(nombreRobot, textNombrePieza.getText());

			if (enUso.equalsIgnoreCase("disponible") || !enUso.equals("No encontrada")) {
				if (!buscarRobot.equalsIgnoreCase("No encontrado")) {
					sist.cabmiarPieza(arma, nombreRobot);
				}
			}
		}
		if (btnAtras == e.getSource()) {
			dispose();
		}

	}

}
