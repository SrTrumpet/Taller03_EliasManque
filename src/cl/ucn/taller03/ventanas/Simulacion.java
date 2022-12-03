package cl.ucn.taller03.ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cl.ucn.taller03.logica.Sistema;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Simulacion extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textAlien1;
	private JTextField textAlien2;
	private JTextField textAlien3;
	private JTextField textHumano1;
	private JTextField textHumano2;
	private JTextField textHumano3;
	private JButton btnIniciarSimulacion;
	private JButton btnVerificar;
	private JButton btnAtras;
	private JLabel lblRobotAlien;
	private JLabel lblRobotHumano;
	private JLabel lblGanadorDynamic;
	private JLabel lblGanador;

	private Sistema sist;

	/**
	 * Create the frame.
	 */
	public Simulacion(Sistema sist) {
		this.sist = sist;
		setTitle("Simulacion");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\iconBarra.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		iniciarComponentes();

		setLocationRelativeTo(null);// Deja centrada la ventana
		setResizable(false);// No deja que se reescale la ventana para que la intefaz no cambie

	}

	private void iniciarComponentes() {

		textAlien1 = new JTextField();
		textAlien1.setBounds(35, 77, 215, 39);
		contentPane.add(textAlien1);
		textAlien1.setColumns(10);

		textAlien2 = new JTextField();
		textAlien2.setColumns(10);
		textAlien2.setBounds(35, 126, 215, 39);
		contentPane.add(textAlien2);

		textAlien3 = new JTextField();
		textAlien3.setColumns(10);
		textAlien3.setBounds(35, 175, 215, 39);
		contentPane.add(textAlien3);

		textHumano1 = new JTextField();
		textHumano1.setColumns(10);
		textHumano1.setBounds(322, 77, 215, 39);
		contentPane.add(textHumano1);

		textHumano2 = new JTextField();
		textHumano2.setColumns(10);
		textHumano2.setBounds(322, 126, 215, 39);
		contentPane.add(textHumano2);

		textHumano3 = new JTextField();
		textHumano3.setColumns(10);
		textHumano3.setBounds(322, 175, 215, 39);
		contentPane.add(textHumano3);

		lblRobotHumano = new JLabel("Robot Humanos");
		lblRobotHumano.setHorizontalAlignment(SwingConstants.CENTER);
		lblRobotHumano.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRobotHumano.setBounds(322, 28, 215, 39);
		contentPane.add(lblRobotHumano);

		lblRobotAlien = new JLabel("Robot Aliens");
		lblRobotAlien.setHorizontalAlignment(SwingConstants.CENTER);
		lblRobotAlien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRobotAlien.setBounds(35, 28, 215, 39);
		contentPane.add(lblRobotAlien);

		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtras.setBounds(425, 369, 144, 31);
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);

		btnVerificar = new JButton("Verificar Robots");
		btnVerificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVerificar.setBounds(196, 239, 173, 31);
		btnVerificar.addActionListener(this);
		contentPane.add(btnVerificar);

		btnIniciarSimulacion = new JButton("Iniciar Simulacion");
		btnIniciarSimulacion.setEnabled(false);
		btnIniciarSimulacion.setIcon(new ImageIcon(
				"D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\iconBarra.jpg"));
		btnIniciarSimulacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIniciarSimulacion.setBounds(159, 293, 248, 39);
		btnIniciarSimulacion.addActionListener(this);
		contentPane.add(btnIniciarSimulacion);

		lblGanador = new JLabel("Ganador: ");
		lblGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanador.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGanador.setBounds(77, 342, 173, 39);
		contentPane.add(lblGanador);

		lblGanadorDynamic = new JLabel("");
		lblGanadorDynamic.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGanadorDynamic.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanadorDynamic.setBounds(206, 342, 201, 39);
		contentPane.add(lblGanadorDynamic);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String linea = textAlien1.getText() + "," + textAlien2.getText() + "," + textAlien3.getText() + ","
				+ textHumano1.getText() + "," + textHumano2.getText() + "," + textHumano3.getText();
		
		if (btnAtras == e.getSource()) {
			dispose();
		}
		if (btnVerificar == e.getSource()) {

			boolean verificar = false;
			verificar = sist.verificarRobots(linea);

			btnIniciarSimulacion.setEnabled(verificar);

		}
		if (btnIniciarSimulacion == e.getSource()) {
			lblGanadorDynamic.setText(sist.iniciarSimulacion(linea));
		}

	}
}
